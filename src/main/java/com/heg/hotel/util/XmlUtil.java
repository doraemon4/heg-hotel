package com.heg.hotel.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamDriver;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.security.NoTypePermission;

import java.io.Writer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: xml与对象互相转换
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/25 12:40
 */
public final class XmlUtil {
    private final static Map<Class<?>, XStream> XSTREAM_HOLDER = new ConcurrentHashMap<>();

    private final static HierarchicalStreamDriver DRIVER = new XppDriver() {
        @Override
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new EscapeCharWriter(out);
        }
    };

    /**
     * 一般用法，直接生成对象信息
     *
     * @param cls
     * @return
     */
    private static XStream getXstream(Class<?> cls) {
        return XSTREAM_HOLDER.computeIfAbsent(cls, t -> {
            XStream xstream = new XStream(DRIVER);
            xstream.processAnnotations(t);
            xstream.autodetectAnnotations(true);
            xstream.allowTypes(new Class[]{t});
            xstream.ignoreUnknownElements();
            xstream.addPermission(NoTypePermission.NONE);
            xstream.addPermission(AnyTypePermission.ANY);
            return xstream;
        });
    }

    /**
     * 对象中存在泛型时候调用的方法
     *
     * @param cls                      父类
     * @param subClasses               子类
     * @param classContainsGenericType 包含泛型类的类
     * @return
     */
    private static XStream getXstream(Class<?> cls, Class[] subClasses, Class<?> classContainsGenericType) {
        return XSTREAM_HOLDER.computeIfAbsent(cls, t -> {
            XStream xstream = new XStream(DRIVER);
            xstream.processAnnotations(t);
            xstream.processAnnotations(subClasses);
            for (Class subClass : subClasses) {
                try {
                    xstream.addDefaultImplementation(subClass, classContainsGenericType.getDeclaredField("t").getType
                            ());
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                    break;
                }
            }
            xstream.allowTypes(new Class[]{t});
            xstream.allowTypes(subClasses);
            xstream.ignoreUnknownElements();
            return xstream;
        });
    }


    /**
     * 将java object对象转换为xml串，不包含xml头字符串
     *
     * @param obj
     * @return
     */
    public static String objectToXml(Object obj) {
        return getXstream(obj.getClass()).toXML(obj);
    }

    /**
     * 将java object对象转换为xml串，不包含xml头字符串
     * 此方法用于转换对象中存在泛型的情况处理
     *
     * @param obj
     * @return
     */
    public static String objectToXml(Object obj, Class[] subClasses, Class classContainsGenericType) {
        return getXstream(obj.getClass(), subClasses, classContainsGenericType).toXML(obj);
    }

    /**
     * 将java object对象转换为xml串，包含xml头字符串,并指定xml编码
     *
     * @param obj
     * @param charSet
     * @return
     */
    public static String objectToXml(Object obj, String charSet, Class[] subClasses, Class classContainsGenericType) {
        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version=\"1.0\" encoding=\"")
                .append(charSet.toUpperCase())
                .append("\"?>\n").append(objectToXml(obj, subClasses, classContainsGenericType));
        return sb.toString();
    }

    /**
     * 将java object对象转换为xml串，包含xml头字符串,并指定xml编码
     * 此方法用于转换对象中存在泛型的情况处理
     *
     * @param obj
     * @param charSet
     * @return
     */
    public static String objectToXml(Object obj, String charSet) {
        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version=\"1.0\" encoding=\"")
                .append(charSet.toUpperCase())
                .append("\"?>\n").append(objectToXml(obj));
        return sb.toString();
    }

    /**
     * 将给定的xml串转换为对应的class类
     *
     * @param xml
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T xmlToObject(String xml, Class<T> cls) {
        return (T) getXstream(cls).fromXML(xml);
    }


    /**
     * Xstream 转换器帮助类，过滤写入xml串内的所有特殊字符，
     * 默认的 PrettyPrintWriter中会对特殊字符进行转义处理
     *
     * @author 花花大脸猫
     * @date
     */
    static class EscapeCharWriter extends PrettyPrintWriter {
        public EscapeCharWriter(Writer writer) {
            super(writer);
        }

        /**
         * 不对节点标签中存在的特殊字符进行转换，避免出现“双下划线”
         *
         * @param name
         * @return
         */
        @Override
        public String encodeNode(String name) {
            return name;
        }

        @Override
        protected void writeText(QuickWriter writer, String text) {
            if (text.indexOf('<') < 0) {
                writer.write(text);
            } else {
                writer.write("<[CDATA[");
                writer.write(text);
                writer.write("]]>");
            }
        }
    }
}
