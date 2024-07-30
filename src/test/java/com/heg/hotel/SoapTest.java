package com.heg.hotel;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.heg.hotel.helper.request.Kinki.PosInfo;
import com.heg.hotel.helper.request.Kinki.RatePlanAllotEnvelope;
import com.heg.hotel.helper.response.Kinki.RatePlanAllotRespEnvelope;
import org.simpleframework.xml.core.Persister;

import java.io.File;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/26 16:00
 */
public class SoapTest {
    public static void main(String[] args) throws Exception {
        String xml="<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "   <soap:Body class=\"com.heg.hotel.helper.request.Kinki.RatePlanAllotEnvelope\">\n" +
                "      <RatePlanAllotRQ xmlns=\"http://gv.knt.co.jp/\">\n" +
                "         <POS>\n" +
                "            <Source>\n" +
                "               <RequestorID Type=\"5\" ID=\"5\" MessagePassword=\"123456\"/>\n" +
                "            </Source>\n" +
                "         </POS>\n" +
                "         <AllotRequestSegments>\n" +
                "            <AllotRequestSegment Number=\"1\">\n" +
                "               <SearchDateRange Start=\"2020-01-01\" End=\"2020-01-31\"/>\n" +
                "               <HotelRef RatePlanCode=\"2610104\" HotelCode=\"000403002610104017\"/>\n" +
                "            </AllotRequestSegment>\n" +
                "         </AllotRequestSegments>\n" +
                "      </RatePlanAllotRQ>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";

        Persister persister = new Persister();//实例化一个Persister
        //Envelope envelope = persister.read(Envelope.class,xml);
        //System.out.println(envelope);

        RatePlanAllotEnvelope.HotelRef hotelRef = new RatePlanAllotEnvelope.HotelRef();
        hotelRef.setHotelCode("000403002610104017");
        hotelRef.setRatePlanCode("2610104");
        RatePlanAllotEnvelope.SearchDateRange searchDateRange = new RatePlanAllotEnvelope.SearchDateRange();
        searchDateRange.setStart("2020-01-01");
        searchDateRange.setEnd("2020-01-31");
        RatePlanAllotEnvelope.AllotRequestSegment allotRequestSegment = new RatePlanAllotEnvelope.AllotRequestSegment();
        allotRequestSegment.setHotelRef(hotelRef);
        allotRequestSegment.setSearchDateRange(searchDateRange);
        allotRequestSegment.setNumber("1");
        RatePlanAllotEnvelope.AllotRequestSegmentInfo allotRequestSegmentInfo= new RatePlanAllotEnvelope.AllotRequestSegmentInfo();
        allotRequestSegmentInfo.setAllotRequestSegments(Lists.newArrayList(allotRequestSegment));
        RatePlanAllotEnvelope.RatePlanAllotReq ratePlanAllotReq = new RatePlanAllotEnvelope.RatePlanAllotReq();
        ratePlanAllotReq.setAllotRequestSegmentInfo(allotRequestSegmentInfo);
        PosInfo posInfo = new PosInfo();
        PosInfo.SourceInfo sourceInfo = new PosInfo.SourceInfo();
        sourceInfo.setRequestorID(PosInfo.RequestorID.builder().ID("5").type("5").password("123456").build());
        posInfo.setSourceInfo(sourceInfo);
        ratePlanAllotReq.setPosInfo(posInfo);
        RatePlanAllotEnvelope envelope = new RatePlanAllotEnvelope();
        RatePlanAllotEnvelope.RatePlanAllotBody body = new RatePlanAllotEnvelope.RatePlanAllotBody();
        body.setRatePlanAllotReq(ratePlanAllotReq);
        envelope.setBody(body);
        persister.write(envelope, new File("C:\\Users\\jack\\Desktop\\test.xml"));

        xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><soap:Body><RatePlanAllotRS xmlns=\"http://gv.knt.co.jp/\"><Errors><Error Message=\"Rate unavailable\" Code=\"437\" /></Errors></RatePlanAllotRS></soap:Body></soap:Envelope>";
        RatePlanAllotRespEnvelope ratePlanAllotRespEnvelope = persister.read(RatePlanAllotRespEnvelope.class,xml);
        System.out.println(JSON.toJSON(ratePlanAllotRespEnvelope));

        xml = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n" +
                "   <soap:Body>\n" +
                "      <RatePlanAllotRS xmlns=\"http://gv.knt.co.jp/\">\n" +
                "         <Success/>\n" +
                "         <AllotReposeSegments>\n" +
                "            <AllotReposeSegment Number=\"1\">\n" +
                "               <RatePlan RatePlanCode=\"000111010010018051\" HotelCode=\"10018\">\n" +
                "                  <SearchDateRange Start=\"2024-08-01\" End=\"2024-08-30\"/>\n" +
                "                  <AllotmentRange>\n" +
                "                     <Allotment>\n" +
                "                        <Text>4,4,4,4,4,4,4,4,4,3,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4</Text>\n" +
                "                     </Allotment>\n" +
                "                  </AllotmentRange>\n" +
                "               </RatePlan>\n" +
                "            </AllotReposeSegment>\n" +
                "         </AllotReposeSegments>\n" +
                "      </RatePlanAllotRS>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";
        ratePlanAllotRespEnvelope =  persister.read(RatePlanAllotRespEnvelope.class,xml);
        System.out.println(JSON.toJSON(ratePlanAllotRespEnvelope));

    }
}
