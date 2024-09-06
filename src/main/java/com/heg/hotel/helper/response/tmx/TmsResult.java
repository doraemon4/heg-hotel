package com.heg.hotel.helper.response.tmx;

import java.util.List;

/**
*@Description
*@Author jack
*@Date 2024/9/6 11:31
*/
public class TmsResult {
    /**
     * ResponseHeader : {"ResponseTime":"2024-09-06 11:32:56","TransactionID":"6ba7b810-9dad-11d1-80b4-00c04fd430c8"}
     * HotelStaticListResult : {"Hotels":[{"HotelId":"769340","Name":"Hampton Inn Colby","Name_CN":"科尔比希尔顿恒庭酒店","StarRating":"3","Address":"1000 E Willow Dr, 67701","Address_CN":"1000 East Willow Drive","CountryCode":"US","CityCode":"31668","CityName":"Colby","Latitude":"39.36511","Longitude":"-101.03852","Phone":"1-785-460-2333"},{"HotelId":"794985","Name":"Hampton Inn Corbin KY","Name_CN":"肯塔基州科宾欢朋酒店","StarRating":"3","Address":"125 Adams Rd, 40701","Address_CN":"125 ADAMS ROAD","CountryCode":"US","CityCode":"32051","CityName":"Corbin","Latitude":"36.98884","Longitude":"-84.10998","Phone":"16065235696"},{"HotelId":"796454","Name":"Hampton Inn by Hilton Concord/Bow","Name_CN":"康科德鲍河希尔顿欢朋酒店","StarRating":"3","Address":"515 South St, 03304","Address_CN":"515 SOUTH STREET","CountryCode":"US","CityCode":"23034","CityName":"Manchester","Latitude":"43.17024","Longitude":"-71.53430","Phone":"6032245322"},{"HotelId":"800048","Name":"Homewood Suites by Hilton Columbia","Name_CN":"哥伦比亚希尔顿惠庭套房酒店","StarRating":"3","Address":"230 Greystone Blvd, 29210-8005","Address_CN":"230 Greystone Boulevard","CountryCode":"US","CityCode":"31577","CityName":"Sumter","Latitude":"34.02004","Longitude":"-81.07659","Phone":"18032394663"},{"HotelId":"810239","Name":"Hampton Inn Columbia-Downtown Historic District","Name_CN":"哥伦比亚市中心历史区欢朋酒店","StarRating":"3","Address":"822 Gervais St, 29201-3126","Address_CN":"822 Gervais Street","CountryCode":"US","CityCode":"31577","CityName":"Sumter","Latitude":"33.99943","Longitude":"-81.03961","Phone":"18032312000"},{"HotelId":"2770460","Name":"Doubletree by Hilton Chattanooga Hamilton Place","Name_CN":"查塔诺加汉弥尔顿广场希尔顿逸林酒店及度假村","StarRating":"3","Address":"2232 Center Street, 37421","Address_CN":"","CountryCode":"US","CityCode":"770","CityName":"Chattanooga","Latitude":"35.04223","Longitude":"-85.16120","Phone":"28469702371"},{"HotelId":"8612818","Name":"Home2 Suites by Hilton Columbia Harbison","Name_CN":"哥伦比亚哈比森希尔顿惠庭酒店","StarRating":"2","Address":"550 Columbiana Drive","Address_CN":"550 Columbiana Drive","CountryCode":"US","CityCode":"711","CityName":"Columbia","Latitude":"34.08989","Longitude":"-81.16804","Phone":"+1-803-7660600"},{"HotelId":"9656851","Name":"Hampton Inn & Suites Columbia Killian Road","Name_CN":"哥伦布基莉安路欢朋套房酒店","StarRating":"2","Address":"1310 Robert\u2019s Branch Pkwy","Address_CN":"1310 Robert\u2019s Branch Pkwy","CountryCode":"US","CityCode":"31577","CityName":"Sumter","Latitude":"34.138","Longitude":"-80.96053","Phone":"+1-803-999-1800"},{"HotelId":"11407226","Name":"Tru by Hilton Columbia Greystone","Name_CN":"","StarRating":"2","Address":"183 Stoneridge Drive","Address_CN":"183 Stoneridge Drive","CountryCode":"US","CityCode":"711","CityName":"Columbia","Latitude":"34.015369","Longitude":"-81.073739","Phone":"+1-800-4458667"},{"HotelId":"14103502","Name":"Hampton Inn & Suites Lexington Columbia","Name_CN":"Hampton Inn & Suites Lexington Columbia","StarRating":"2","Address":"4751 Sunset Boulevard","Address_CN":"","CountryCode":"US","CityCode":"711","CityName":"Columbia","Latitude":"34.005037","Longitude":"-81.202129","Phone":"18037225800"}],"Pagination":{"PageCount":4531,"TotalCount":45308}}
     */

    private ResponseHeaderBean ResponseHeader;
    private HotelStaticListResultBean HotelStaticListResult;

    public ResponseHeaderBean getResponseHeader() {
        return ResponseHeader;
    }

    public void setResponseHeader(ResponseHeaderBean ResponseHeader) {
        this.ResponseHeader = ResponseHeader;
    }

    public HotelStaticListResultBean getHotelStaticListResult() {
        return HotelStaticListResult;
    }

    public void setHotelStaticListResult(HotelStaticListResultBean HotelStaticListResult) {
        this.HotelStaticListResult = HotelStaticListResult;
    }

    public static class ResponseHeaderBean {
        /**
         * ResponseTime : 2024-09-06 11:32:56
         * TransactionID : 6ba7b810-9dad-11d1-80b4-00c04fd430c8
         */

        private String ResponseTime;
        private String TransactionID;

        public String getResponseTime() {
            return ResponseTime;
        }

        public void setResponseTime(String ResponseTime) {
            this.ResponseTime = ResponseTime;
        }

        public String getTransactionID() {
            return TransactionID;
        }

        public void setTransactionID(String TransactionID) {
            this.TransactionID = TransactionID;
        }
    }

    public static class HotelStaticListResultBean {
        /**
         * Hotels : [{"HotelId":"769340","Name":"Hampton Inn Colby","Name_CN":"科尔比希尔顿恒庭酒店","StarRating":"3","Address":"1000 E Willow Dr, 67701","Address_CN":"1000 East Willow Drive","CountryCode":"US","CityCode":"31668","CityName":"Colby","Latitude":"39.36511","Longitude":"-101.03852","Phone":"1-785-460-2333"},{"HotelId":"794985","Name":"Hampton Inn Corbin KY","Name_CN":"肯塔基州科宾欢朋酒店","StarRating":"3","Address":"125 Adams Rd, 40701","Address_CN":"125 ADAMS ROAD","CountryCode":"US","CityCode":"32051","CityName":"Corbin","Latitude":"36.98884","Longitude":"-84.10998","Phone":"16065235696"},{"HotelId":"796454","Name":"Hampton Inn by Hilton Concord/Bow","Name_CN":"康科德鲍河希尔顿欢朋酒店","StarRating":"3","Address":"515 South St, 03304","Address_CN":"515 SOUTH STREET","CountryCode":"US","CityCode":"23034","CityName":"Manchester","Latitude":"43.17024","Longitude":"-71.53430","Phone":"6032245322"},{"HotelId":"800048","Name":"Homewood Suites by Hilton Columbia","Name_CN":"哥伦比亚希尔顿惠庭套房酒店","StarRating":"3","Address":"230 Greystone Blvd, 29210-8005","Address_CN":"230 Greystone Boulevard","CountryCode":"US","CityCode":"31577","CityName":"Sumter","Latitude":"34.02004","Longitude":"-81.07659","Phone":"18032394663"},{"HotelId":"810239","Name":"Hampton Inn Columbia-Downtown Historic District","Name_CN":"哥伦比亚市中心历史区欢朋酒店","StarRating":"3","Address":"822 Gervais St, 29201-3126","Address_CN":"822 Gervais Street","CountryCode":"US","CityCode":"31577","CityName":"Sumter","Latitude":"33.99943","Longitude":"-81.03961","Phone":"18032312000"},{"HotelId":"2770460","Name":"Doubletree by Hilton Chattanooga Hamilton Place","Name_CN":"查塔诺加汉弥尔顿广场希尔顿逸林酒店及度假村","StarRating":"3","Address":"2232 Center Street, 37421","Address_CN":"","CountryCode":"US","CityCode":"770","CityName":"Chattanooga","Latitude":"35.04223","Longitude":"-85.16120","Phone":"28469702371"},{"HotelId":"8612818","Name":"Home2 Suites by Hilton Columbia Harbison","Name_CN":"哥伦比亚哈比森希尔顿惠庭酒店","StarRating":"2","Address":"550 Columbiana Drive","Address_CN":"550 Columbiana Drive","CountryCode":"US","CityCode":"711","CityName":"Columbia","Latitude":"34.08989","Longitude":"-81.16804","Phone":"+1-803-7660600"},{"HotelId":"9656851","Name":"Hampton Inn & Suites Columbia Killian Road","Name_CN":"哥伦布基莉安路欢朋套房酒店","StarRating":"2","Address":"1310 Robert\u2019s Branch Pkwy","Address_CN":"1310 Robert\u2019s Branch Pkwy","CountryCode":"US","CityCode":"31577","CityName":"Sumter","Latitude":"34.138","Longitude":"-80.96053","Phone":"+1-803-999-1800"},{"HotelId":"11407226","Name":"Tru by Hilton Columbia Greystone","Name_CN":"","StarRating":"2","Address":"183 Stoneridge Drive","Address_CN":"183 Stoneridge Drive","CountryCode":"US","CityCode":"711","CityName":"Columbia","Latitude":"34.015369","Longitude":"-81.073739","Phone":"+1-800-4458667"},{"HotelId":"14103502","Name":"Hampton Inn & Suites Lexington Columbia","Name_CN":"Hampton Inn & Suites Lexington Columbia","StarRating":"2","Address":"4751 Sunset Boulevard","Address_CN":"","CountryCode":"US","CityCode":"711","CityName":"Columbia","Latitude":"34.005037","Longitude":"-81.202129","Phone":"18037225800"}]
         * Pagination : {"PageCount":4531,"TotalCount":45308}
         */

        private PaginationBean Pagination;
        private List<HotelsBean> Hotels;

        public PaginationBean getPagination() {
            return Pagination;
        }

        public void setPagination(PaginationBean Pagination) {
            this.Pagination = Pagination;
        }

        public List<HotelsBean> getHotels() {
            return Hotels;
        }

        public void setHotels(List<HotelsBean> Hotels) {
            this.Hotels = Hotels;
        }

        public static class PaginationBean {
            /**
             * PageCount : 4531
             * TotalCount : 45308
             */

            private int PageCount;
            private int TotalCount;

            public int getPageCount() {
                return PageCount;
            }

            public void setPageCount(int PageCount) {
                this.PageCount = PageCount;
            }

            public int getTotalCount() {
                return TotalCount;
            }

            public void setTotalCount(int TotalCount) {
                this.TotalCount = TotalCount;
            }
        }

        public static class HotelsBean {
            /**
             * HotelId : 769340
             * Name : Hampton Inn Colby
             * Name_CN : 科尔比希尔顿恒庭酒店
             * StarRating : 3
             * Address : 1000 E Willow Dr, 67701
             * Address_CN : 1000 East Willow Drive
             * CountryCode : US
             * CityCode : 31668
             * CityName : Colby
             * Latitude : 39.36511
             * Longitude : -101.03852
             * Phone : 1-785-460-2333
             */

            private String HotelId;
            private String Name;
            private String Name_CN;
            private String StarRating;
            private String Address;
            private String Address_CN;
            private String CountryCode;
            private String CityCode;
            private String CityName;
            private String Latitude;
            private String Longitude;
            private String Phone;

            public String getHotelId() {
                return HotelId;
            }

            public void setHotelId(String HotelId) {
                this.HotelId = HotelId;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getName_CN() {
                return Name_CN;
            }

            public void setName_CN(String Name_CN) {
                this.Name_CN = Name_CN;
            }

            public String getStarRating() {
                return StarRating;
            }

            public void setStarRating(String StarRating) {
                this.StarRating = StarRating;
            }

            public String getAddress() {
                return Address;
            }

            public void setAddress(String Address) {
                this.Address = Address;
            }

            public String getAddress_CN() {
                return Address_CN;
            }

            public void setAddress_CN(String Address_CN) {
                this.Address_CN = Address_CN;
            }

            public String getCountryCode() {
                return CountryCode;
            }

            public void setCountryCode(String CountryCode) {
                this.CountryCode = CountryCode;
            }

            public String getCityCode() {
                return CityCode;
            }

            public void setCityCode(String CityCode) {
                this.CityCode = CityCode;
            }

            public String getCityName() {
                return CityName;
            }

            public void setCityName(String CityName) {
                this.CityName = CityName;
            }

            public String getLatitude() {
                return Latitude;
            }

            public void setLatitude(String Latitude) {
                this.Latitude = Latitude;
            }

            public String getLongitude() {
                return Longitude;
            }

            public void setLongitude(String Longitude) {
                this.Longitude = Longitude;
            }

            public String getPhone() {
                return Phone;
            }

            public void setPhone(String Phone) {
                this.Phone = Phone;
            }
        }
    }
}
