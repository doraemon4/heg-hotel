package com.heg.hotel.model;

import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/17 16:02
 */
@Data
public class HotelReview {
    private String title;  //标题
    private String date;   //评论时间
    private String checkInDate;  //入住日期
    private String rating; //评分
    private String reviewerName;  //点评人姓名
    private String tripReason;    //旅游原因
    private String content;    //点评信息
    private List<HotelReply> hotelReplies;  //酒店回复

    @Data
    public static class HotelReply{
        private String content;   //回复内容
        private String date;      //回复时间
    }
}
