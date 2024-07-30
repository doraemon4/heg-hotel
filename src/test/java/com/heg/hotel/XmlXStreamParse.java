package com.heg.hotel;

import com.heg.hotel.helper.request.Restel.QueryHotelDetailReq;
import com.heg.hotel.helper.response.Restel.QueryCountryResp;
import com.heg.hotel.util.XmlUtil;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/25 11:19
 */
public class XmlXStreamParse {
    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<respuesta>\n" +
                "   <tipo>5</tipo>\n" +
                "   <nombre>Servicio de países</nombre>\n" +
                "   <agencia>AGENCIA PRUEBAS</agencia>\n" +
                "   <parametros>\n" +
                "      <paises>\n" +
                "         <pais>\n" +
                "            <codigo_pais>ES</codigo_pais>\n" +
                "            <nombre_pais>ESPAÑA</nombre_pais>\n" +
                "         </pais>\n" +
                "         <pais>\n" +
                "            <codigo_pais>EB</codigo_pais>\n" +
                "            <nombre_pais>ESPAÑA</nombre_pais>\n" +
                "         </pais>\n" +
                "      </paises>\n" +
                "      <id>7a500624-55a5-4f0c-9008-c26f8aac1a5b</id>\n" +
                "   </parametros>\n" +
                "</respuesta>";
        QueryCountryResp resp = XmlUtil.xmlToObject(xml, QueryCountryResp.class);
        System.out.println(resp);

        //testReq();
    }

    public static void testReq(){
        QueryHotelDetailReq req = new QueryHotelDetailReq();
        req.setType("11");
        req.setName("test");
        req.setOrganization("absd");
        QueryHotelDetailReq.QueryHotelDetailParam param = new QueryHotelDetailReq.QueryHotelDetailParam();

        param.setLanguage("EN");
        param.setHotelCode("23232");
        req.setQueryHotelDetailParam(param);

        String xml = XmlUtil.objectToXml(req);
        System.out.println(xml);
    }
}
