package com.heg.hotel.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/25 15:42
 */
@Getter
@AllArgsConstructor
public enum RestelRoomServiceEnum {
    AIR_CONDITIONING(1,"Air Conditioning"),//空调
    HEATING(2,"Heating"),//暖气
    AMENITIES(3,"Amenities"),//便利设施
    ELECTRONIC_KEY_CARD(4,"Electronic Key Card"),//电子钥匙卡
    ADAPTED_ROOMS(5,"Adapted rooms"),
    ALLERGY_FRIENDLY_ROOMS(6,"Allergy-friendly Rooms"),//过敏友好型客房
    DOGS_ALLOWED(7,"Dogs Allowed"),
    OTHER_ANIMALS_ALLOWED(8,"Other Animals Allowed"),
    TV(9,"TV"),
    PAY_TV(10,"Pay TV"),
    SATELLITE_TV(11,"Satellite TV"),//卫星电视
    PRIVATE_TV_CHANNELS(12,"Private TV Channels"),//私人电视频道
    INTERACTIVE_TV(13,"Interactive TV"),//互动电视
    VIDEO_DVD(14,"Video / DVD"),
    TELEPHONE(15,"Telephone"),
    TELEPHONE_IN_BATHROOM(16,"Telephone in Bathroom"),
    BABYCOT(17,"Babycot"),
    CONNECTING_ROOMS(18,"Connecting Rooms"),
    OTHER_SERVICES(19,"Other Services"),
    FIREPLACE(20,"Fireplace"),//壁炉
    KITCHENETTE(21,"Kitchenette"), //小厨房
    HAIRDRYER(22,"Hairdryer"),  //吹风机
    MINI_BAR(23,"Mini-bar"),  //迷你吧
    MUSIC_CHANNELS(24,"Music Channels"),
    RADIO(25,"Radio"),
    SAFETY_BOX(26,"Safety Box"), //保险箱
    HI_FI(27,"Hi-Fi"),
    SOUNDPROOFED_ROOMS(28,"Soundproofed Rooms"), //隔音客房
    FAX_OUTLET(29,"Fax Outlet"),
    ADSL(30,"ADSL"),
    TWO_PC_CONNECTION(31,"2 PC-Connection"),
    STANDARD_PHONE_LINE(32,"Standard Phone Line"),
    VOICE_MAIL(33,"Voice Mail"), //语音邮件
    DAILY_NEWSPAPER(34,"Daily Newspaper"),//日报
    DESK(35,"Desk"),
    TEA_AND_COFFEE_MACHINE(36,"Tea and Coffee Machine"),
    VOLTAGE(37,"Voltage"),
    WEB_TV(38,"Web TV"),
    FREE_MINI_BAR(39,"Free Mini-bar"),
    WI_FI(40,"Wi-Fi"),
    CABLE_TELEVISION(41,"CABLE TELEVISION"),//有线电视
    CONCIERGE(42,"CONCIERGE"), //门房
    TERRACE(43,"TERRACE"),
    FRIDGE(44,"FRIDGE"),//冰箱
    KITCHEN(45,"KITCHEN"), //厨房
    IRONING_BOARD(46,"IRONING BOARD"),//熨衣板
    BALCONY(47,"BALCONY"),  //阳台
    DVD_PLAYER(48,"DVD PLAYER"),
    SEA_VIEWS(49,"SEA VIEWS"),
    WASHING_MACHINE(50,"WASHING MACHINE"),//洗衣机
    IRON(51,"IRON"),
    MICROWAVE(52,"MICROWAVE"), //微波炉
    TOILET(53,"TOILET"),
    FREE_WIFI(54,"Free Wifi"),
    ;
    private Integer code;
    private String description;

}
