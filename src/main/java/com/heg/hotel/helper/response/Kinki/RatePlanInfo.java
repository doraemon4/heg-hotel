package com.heg.hotel.helper.response.Kinki;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description: 价格计划
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/23 19:10
 */
@Data
public class RatePlanInfo {
    private String cultureName;
    private String ratePlanCode;
    private String hotelID;
    private String planName;
    private String roomType;
    private String equipmentType;
    private String start;
    private String end;
    private Integer minOccupancy;
    private Integer maxOccupancy;
    private String description;
    private String saleStartDate;
    private String saleEndDate;
    private Integer liquidationDayNum;
    private Integer sexType;
    private BigDecimal generalMinCharge;
    private Integer limitStayFlag;
    private Integer minStayNum;
    private Integer maxStayNum;
    private Integer minMemberNum;
    private Integer roomCapacity;
    private Boolean childAFlag;
    private Boolean childBFlag;
    private Boolean childCFlag;
    private Integer childAAge;
    private Integer childBAge;
    private Integer childCAge;
    private Integer childANum;
    private Integer childBNum;
    private Integer childCNum;
    private Integer cancelChargeID;
    private Integer planStatusType;
    private Integer discountType;
    private String createOperatorCD;
    private String createTime;
    private String updateOperatorCD;
    private String updateTime;
    private Integer updateCount;
    private Integer deleteFlag;
}
