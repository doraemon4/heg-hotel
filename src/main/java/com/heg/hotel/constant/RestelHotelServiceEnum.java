package com.heg.hotel.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description:
 * @Version: 1.8
 * @Author: jack
 * @Created: 2024/7/25 16:35
 */
@Getter
@AllArgsConstructor
public enum RestelHotelServiceEnum {
    ACCESSIBLE_ACCOMMODATION(1,"Accessible accommodation"), //无障碍住宿
    AIR_CONDITIONED(2,"Air Conditioned"), //空调
    HEATING(3,"Heating"), //加热
    CHAPEL(4,"Chapel"),  //教堂
    FAX(5,"Fax"),
    KAYAK(6,"Kayak"),  //皮划艇
    CASINO(7,"Casino"),  //赌场
    BINGO(8,"Bingo"),  //宾果游戏
    DISCOTHEQUE(9,"Discotheque"),  //迪斯科舞厅
    BIKE_RENTAL(10,"Bike Rental"),//自行车租赁
    RENT_CAR(11,"Rent A Car"),//租车
    ENTERTAINMENT(12,"Entertainment"),  //娱乐
    GYM(13,"Gym"), //健身房
    HEALTH_RESORT(14,"Health Resort"),//疗养地
    TURKISH_BATH(15,"Turkish Bath"),//土耳其浴
    SAUNA(16,"Sauna"),//桑拿
    PADDLE(17,"Paddle"),
    TENNIS(18,"Tennis"),  //网球
    HORSE_RIDING(19,"Horse riding"),//骑马
    JACUZZI(20,"Jacuzzi"),//按摩浴缸
    GOLF(21,"Golf"), //高尔夫
    MINI_GOLF(22,"Mini-Golf"),
    ADVENTURE_SPORTS(23,"Adventure Sports"), //冒险运动
    BELL_BOY(24,"Bell Boy"),
    SAFE_BOX(25,"Safe Box"), //保险箱
    ELEVATOR(26,"Elevator"), //电梯
    GARAGE(27,"Garage"),  //车库
    OUTDOOR_PARKING(28,"Outdoor Parking"),  //室外停车场
    COACH_PARKING(29,"Coach Parking"), //长途汽车停车场
    FREE_PARKING(30,"Free Parking"),  //免费停车
    PAY_PARKING(31,"Pay Parking"),   //付费停车
    BAR_COFFEE_24(32,"Bar/CafÃ© (24h)"),//酒吧/咖啡馆© （24小时）
    BAR_COFFEE_SNACK(33,"Bar/Snack/CafÃ©"),//酒店/小吃/咖啡馆
    PIANO_BAR(34,"Piano Bar"),  //钢琴酒吧
    RESTAURANT(35,"Restaurant"), //饭店
    PARTIAL_ROOM_SERVICE(36,"Partial Room Service"), //部分客房服务
    ROOM_SERVICE_24(37,"Room Service (24h)"), //客房服务（24小时）
    SOCIAL_MEETING_ROOMS(38,"Social Meeting Rooms"),//社会会议室
    TV(39,"TV SalÃ³n"),
    VIDEO_CLUB_SERVICE(40,"Video-Club Service"),  //视频俱乐部服务
    SHOPPING(41,"Shopping"),  //购物
    CURRENCY_EXCHANGE(42,"Currency Exchange"),  //货币兑换
    BUSINESS_CENTRE(43,"Business Centre"),//商务中心
    BUSINESS_FLOOR(44,"Business Floor"), //商务楼层
    GARDEN_AREA(45,"Garden Area"), //花园区
    INDOOR_SWIMMING_POOL(46,"Indoor Swimming pool"),
    OUTDOOR_SWIMMING_POOL(47,"Outdoor Swimming pool"),
    CHILDREN_SWIMMING_POOL(48,"Children Swimming pool"),//儿童泳池
    SECURITY_24(49,"24h Security"),//24小时安保
    SHOPS(50,"Shops"), //商店
    NEWS_STAND(51,"News Stand"), //报摊
    FLOWER_SHOP(52,"Flower Shop"),//花店
    BABY_SITTING(53,"Baby Sitting"),//保姆
    HAIRDRESSER(54,"Hairdresser"), //理发师
    DOCTOR_SERVICE(55,"Doctor Service"),
    LAUNDRY_SERVICE(56,"Laundry Service"),//洗衣服务
    FREE_SHUTTLE_SERVICE(57,"Free Shuttle Service"),//免费班车服务
    PAY_SHUTTLE_SERVICE(58,"Pay Shuttle Service"),//付费班车服务
    CONTINTENTAL_BREAKFAST(59,"Contintental Breakfast"),
    BUFFET_BREAKFAST(60,"Buffet Breakfast"),//自助早餐
    ADAPTED_ROOMS(61,"Adapted rooms"), //适应房间
    WI_FI(62,"Wi-Fi"),
    SPA(63,"Spa"),  //水疗中心
    FREE_WI_FI(64,"Free Wi-Fi"),//免费WI-FI
    RECEPTION_24(65,"24H RECEPTION*"),//24小时接待
    SWIMMING_POOL(66,"SWIMMING POOL"),//游泳池
    ELECTRIC_VEHICLE_CHARGER(67,"Electric vehicle charger"); //电动汽车充电器
    ;

    private Integer code;
    private String description;
}
