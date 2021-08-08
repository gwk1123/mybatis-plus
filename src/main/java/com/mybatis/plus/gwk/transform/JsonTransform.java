package com.mybatis.plus.gwk.transform;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JsonTransform {




    public String jsonOrderSearch() {

        String s = "{\n" +
                "    \"jipiao_agent_order_search_response\":{\n" +
                "        \"is_success\":true,\n" +
                "        \"error_message\":\"系统异常\",\n" +
                "        \"search_result\":{\n" +
                "\t\t\"order_ids\": [1234],\n" +
                "\t\t\"page_size\": 1000,\n" +
                "\t\t\"has_next\": false\n" +
                "        }\n" +
                "    }\n" +
                "}";
        return s;
    }


    public static String jsonOrderDetail(String order_id) {

        System.out.println(order_id);
        String time_fm = "2021-09-01 00:10:00";
        String a1 = randomAirlineCode();
        String airline1 = "\"" + a1 + "\"";
        String fligNumber1 = "\"" + a1 + randomNmu(1000, 10000) + "\"";
        String airlineOpen1 = "\"" + randomAirlineCode() + randomNmu(1000, 10000) + "\"";

        String a2 = a1;
        String airline2 = "\"" + a2 + "\"";
        String fligNumber2 = "\"" + a2 + randomNmu(1000, 10000) + "\"";
        String airlineOpen2 = "\"" + randomAirlineCode() + randomNmu(1000, 10000) + "\"";

        String dep1 = "\"" + randomAirport() + "\"";
        String arr1 = "\"" + randomAirport() + "\"";
        String dep2 = "\"" + randomAirport() + "\"";
        String arr2 = "\"" + randomAirport() + "\"";

        String name1 = randomName();
        String name2 = randomName();
        String no1 = "\"" + randomNmu(100000000, 1000000000) + "\"";
        String no2 = "\"" + randomNmu(100000000, 1000000000) + "\"";
        String s = "{" +
                "\"jipiao_agent_order_detail_response\": {" +
                "\"is_success\": true," +
                "\"orders\": {" +
                "\"trip_order\": [" +
                "{" +
                "\"base_info\": {" +
                "\"order_id\": " + "\"" + order_id + "\"" + "," +
                "\"trip_type\": 0," +
                "\"status\": 2," +
                "\"pay_status\": 1," +
                "\"create_time\": " + "\"" + randomLocalDateTime(time_fm, 0) + "\"" + "," +
                "\"modify_time\": " + "\"" + randomLocalDateTime(time_fm, 3 * 60) + "\"" + "," +
                "\"pay_latest_time\": " + "\"" + randomLocalDateTime(time_fm, -3 * 24 * 60) + "\"" + "," +
                "\"total_price\": " + randomNmu(1000, 10000) + "," +
                "\"commission\": " + randomNmu(100, 500) + "," +
                "\"relation_name\": " + "\"" + name1 + "\"" + "," +
                "\"relation_mobile\": \"13800138000\"," +
                "\"relation_phone_bak\": \"138001381111\"," +
                "\"relation_email\": \"xxx@taobao.com\"," +
                "\"extra\": \"\"," +
                "\"alipay_trade_no\": " + randomNmu(10000000, 100000000) + "," +
                "\"insure_promotion\": true," +
                "\"force_insure\": true" +
                "}," +
                "\"flight_infos\": {" +
                "\"trip_flight_info\": [" +
                "{" +
                "\"flight_id\": " + randomNmu(100, 1000) + "," +
                "\"segment_type\": 0," +
                "\"segment_number\": 0," +
                "\"airline_code\": " + airline1 + "," +
                "\"flight_no\": " + fligNumber1 + "," +
                "\"carrier\": " + airlineOpen1 + "," +
                "\"flight_type\": \"320\"," +
                "\"dep_city_code\": " + dep1 + "," +
                "\"arr_city_code\": " + arr1 + "," +
                "\"dep_airport_code\": " + dep1 + "," +
                "\"arr_airport_code\": " + arr1 + "," +
                "\"dep_time\": " + "\"" + randomLocalDateTime(time_fm, 20 * 24 * 60) + "\"" + "," +
                "\"arr_time\": " + "\"" + randomLocalDateTime(time_fm, 20 * 24 * 60 + 3 * 60) + "\"" + "," +
                "\"ticket_price\": " + randomNmu(10000, 20000) + "," +
                "\"extra\": \"\"," +
                "\"special_rule\": \"\"," +
                "\"passengers\": [" +
                "{" +
                "\"name\": " + "\"" + name1 + "\"" + "," +
                "\"cert_type\": 0," +
                "\"cert_no\": " + no1 + "," +
                "\"passenger_type\": 0," +
                "\"birthday\": \"1982-01-01\"," +
                "\"trip_card_no\": \"\"," +
                "\"pnr\": \"HGY2RX\"," +
                "\"ticket_no\": " + "\"867-" + randomNmu(100000000, 1000000000) + "\"" + "," +
                "\"extra\": \"\"," +
                "\"policy_id\": \"\"," +
                "\"policy_type\": 0," +
                "\"memo\": \"\"," +
                "\"price\": " + randomNmu(10000, 100000) + "," +
                "\"fee\": " + randomNmu(1000, 10000) + "," +
                "\"tax\": " + randomNmu(10000, 20000) + "," +
                "\"cabin_code\": \"M\"," +
                "\"cabin_class\": 2," +
                "\"tuigaiqian\": \"退改签\"," +
                "\"ei\": \"ei项\"," +
                "\"insure_promotion_price\": " + randomNmu(1000, 2000) + "," +
                "\"force_insure_price\": " + randomNmu(5000, 10000) +
                "}," +
                "{" +
                "\"name\": " + "\"" + name2 + "\"" + "," +
                "\"cert_type\": 0," +
                "\"cert_no\": " + no2 + "," +
                "\"passenger_type\": 0," +
                "\"birthday\": \"2002-12-01\"," +
                "\"trip_card_no\": \"\"," +
                "\"pnr\": \"HGY2RX\"," +
                "\"ticket_no\": " + "\"456-" + randomNmu(100000000, 1000000000) + "\"" + "," +
                "\"extra\": \"\"," +
                "\"policy_id\": \"\"," +
                "\"policy_type\": 0," +
                "\"memo\": \"\"," +
                "\"price\": " + randomNmu(10000, 100000) + "," +
                "\"fee\": " + randomNmu(1000, 10000) + "," +
                "\"tax\": " + randomNmu(10000, 20000) + "," +
                "\"cabin_code\": \"M\"," +
                "\"cabin_class\": 2," +
                "\"tuigaiqian\": \"退改签\"," +
                "\"ei\": \"ei项\"," +
                "\"insure_promotion_price\":  " + randomNmu(1000, 2000) + "," +
                "\"force_insure_price\": " + randomNmu(5000, 10000) +
                "}" +
                "]" +
                "}," +
                "{" +
                "\"flight_id\": " + randomNmu(100, 1000) + "," +
                "\"segment_type\": 0," +
                "\"segment_number\": 1," +
                "\"airline_code\": " + airline2 + "," +
                "\"flight_no\": " + fligNumber2 + "," +
                "\"carrier\": " + airlineOpen2 + "," +
                "\"flight_type\": \"320\"," +
                "\"dep_city_code\": " + arr1 + "," +
                "\"arr_city_code\": " + arr2 + "," +
                "\"dep_airport_code\": " + arr1 + "," +
                "\"arr_airport_code\": " + arr2 + "," +
                "\"dep_time\": " + "\"" + randomLocalDateTime(time_fm, 20 * 24 * 60 + 5 * 60) + "\"" + "," +
                "\"arr_time\": " + "\"" + randomLocalDateTime(time_fm, 20 * 24 * 60 + 7 * 60) + "\"" + "," +
                "\"ticket_price\": " + randomNmu(10000, 20000) + "," +
                "\"extra\": \"\"," +
                "\"special_rule\": \"\"," +
                "\"passengers\": [" +
                "{" +
                "\"name\": " + "\"" + name1 + "\"" + "," +
                "\"cert_type\": 0," +
                "\"cert_no\": " + no1 + "," +
                "\"passenger_type\": 0," +
                "\"birthday\": \"1982-01-01\"," +
                "\"trip_card_no\": \"\"," +
                "\"pnr\": \"HGY2RX\"," +
                "\"ticket_no\": " + "\"867-" + randomNmu(100000000, 1000000000) + "\"" + "," +
                "\"extra\": \"\"," +
                "\"policy_id\": \"\"," +
                "\"policy_type\": 0," +
                "\"memo\": \"\"," +
                "\"price\": " + randomNmu(10000, 100000) + "," +
                "\"fee\": " + randomNmu(1000, 10000) + "," +
                "\"tax\": " + randomNmu(10000, 20000) + "," +
                "\"cabin_code\": \"Y\"," +
                "\"cabin_class\": 2," +
                "\"tuigaiqian\": \"退改签\"," +
                "\"insure_promotion_price\": " + randomNmu(1000, 2000) + "," +
                "\"force_insure_price\": " + randomNmu(5000, 10000) +
                "}," +
                "{" +
                "\"name\": " + "\"" + name2 + "\"" + "," +
                "\"cert_type\": 0," +
                "\"cert_no\": " + no2 + "," +
                "\"passenger_type\": 0," +
                "\"birthday\": \"2002-12-01\"," +
                "\"trip_card_no\": \"\"," +
                "\"pnr\": \"HGY2RX\"," +
                "\"ticket_no\": " + "\"456-" + randomNmu(100000000, 1000000000) + "\"" + "," +
                "\"extra\": \"\"," +
                "\"policy_id\": \"\"," +
                "\"policy_type\": 0," +
                "\"memo\": \"\"," +
                "\"price\": " + randomNmu(10000, 100000) + "," +
                "\"fee\": " + randomNmu(1000, 10000) + "," +
                "\"tax\": " + randomNmu(10000, 20000) + "," +
                "\"cabin_code\": \"Y\"," +
                "\"cabin_class\": 2," +
                "\"tuigaiqian\": \"退改签\"," +
                "\"ei\": \"ei项\"," +
                "\"insure_promotion_price\": " + randomNmu(1000, 2000) + "," +
                "\"force_insure_price\": " + randomNmu(5000, 10000) +
                "}" +
                "]" +
                "}" +
                "]" +
                "}," +
                "\"itinerary\": {" +
                "\"type\": 6," +
                "\"name\": " + "\"" + name2 + "\"" + "," +
                "\"mobile\": " + randomNmu(100000000, 1000000000) + "," +
                "\"mobile_bak\": " + randomNmu(100000000, 1000000000) + "," +
                "\"address\": \"小麻小儿郎\"," +
                "\"price\": " + randomNmu(100, 1000) + "," +
                "\"company_code\": \"SF001\"," +
                "\"express_code\": \"S902894520\"," +
                "\"itinerary_no\": \"899DA031\"," +
                "\"send_date\": \"2021-07-01 12:30:37\"," +
                "\"status\": 0," +
                "\"extra\": \"\"," +
                "\"alipay_trade_no\": \"8908884289045\"," +
                "\"id\": 23" +
                "}," +
                "\"corp_info\": {}," +
                "\"extra\": \"扩展字段\"" +
                "}" +
                "]" +
                "}" +
                "}" +
                "}";
        return s;
    }


    /**
     * 随机生成指定范围内的数[from,to]
     */
    public static Integer randomNmu(Integer from, Integer to) {
        //生成64-128内的随机数
        Random random = new Random();
        return random.nextInt(to - from + 1) + from;
    }

    /**
     * 随机生成航司
     */
    public static String randomAirlineCode() {
        String[] codes = new String[]{"CZ", "MU", "MF", "HU", "ZH", "SC", "GS", "8L", "PN", "CA", "FM", "3U", "JD", "EU", "BK", "KN", "G5", "KY", "0Q", "JR", "9C"};
        Integer i = randomNmu(0, codes.length - 1);
        return codes[i];
    }

    /**
     * 随机生成机场码
     *
     * @return
     */
    public static String randomAirport() {
        Integer i = randomNmu(0, list.size() - 1);
        return list.get(i);
    }

    /**
     * 随机生成姓名
     *
     * @return
     */
    public static String randomName() {
        String[] list = new String[]{"冯", "陈", "诸", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许", "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎", "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷", "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时", "傅", "皮", "卡", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和", "穆", "萧", "尹"};
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            int index = randomNmu(1, 90);
            sb.append(list[index]);
        }
        return sb.toString();
    }

    /**
     * 生成指定日期时间  多少分钟
     */
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String randomLocalDateTime(String time_fm, Integer m) {
        LocalDateTime localDateTime = LocalDateTime.parse(time_fm, formatter);
        LocalDateTime l1 = localDateTime.plusMinutes(m);
        String l2 = l1.format(formatter);
        return l2;
    }


    /**
     * 初始化春秋航空城市名称
     *
     * @throws IOException
     * @throws InterruptedException
     */
    static List<String> list = new ArrayList<>();

    static {

        String initCQCityNameHtml = "<div class=\"u-cityassort-body inter-body\">" +
                "<div class=\"u-cityassort-cont\"><div class=\"u-cityassort-line \"><div class=\"u-cityassort-sort\">国内：</div>" +
                "<div class=\"u-cityassort-list\"><a href=\"javascript:;\" class=\"\" data-code=\"SHA\" data-omni=\"\" data-events=\"event50\">上海</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"SJW\" data-omni=\"\" data-events=\"event50\">石家庄</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"LHW\" data-omni=\"\" data-events=\"event50\">兰州</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"CAN\" data-omni=\"\" data-events=\"event50\" style=\"display: none;\">广州</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"SHE\" data-omni=\"\" data-events=\"event50\">沈阳</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"CKG\" data-omni=\"\" data-events=\"event50\">重庆</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"SZX\" data-omni=\"\" data-events=\"event50\">深圳</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"HRB\" data-omni=\"\" data-events=\"event50\">哈尔滨</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"XMN\" data-omni=\"\" data-events=\"event50\">厦门</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"SIA\" data-omni=\"\" data-events=\"event50\">西安</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"NGB\" data-omni=\"\" data-events=\"event50\">宁波</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"CTU\" data-omni=\"\" data-events=\"event50\">成都</a><a href=\"javascript:;\" class=\"\" data-code=\"KMG\" data-omni=\"\" data-events=\"event50\">昆明</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"WUH\" data-omni=\"\" data-events=\"event50\">武汉</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"YTY\" data-omni=\"\" data-events=\"event50\">扬州(泰州)</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"SWA\" data-omni=\"\" data-events=\"event50\">揭阳(潮汕)</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"CGQ\" data-omni=\"\" data-events=\"event50\">长春</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"HGH\" data-omni=\"\" data-events=\"event50\">杭州</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"TSN\" data-omni=\"\" data-events=\"event50\">天津</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"MIG\" data-omni=\"\" data-events=\"event50\">绵阳</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"DLC\" data-omni=\"\" data-events=\"event50\">大连</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"JJN\" data-omni=\"\" data-events=\"event50\">泉州(晋江)</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"LJG\" data-omni=\"\" data-events=\"event50\">丽江</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"SQJ\" data-omni=\"\" data-events=\"event50\">三明</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"WEF\" data-omni=\"\" data-events=\"event50\">潍坊</a>                                                                                                        </div>                                </div>                                                                <div class=\"u-cityassort-line \">                                  <div class=\"u-cityassort-sort\">国际及地区航线：</div>                                  <div class=\"u-cityassort-list\">                                                                                                          <a href=\"javascript:;\" class=\"\" data-code=\"CJU\" data-omni=\"\" data-events=\"event51\">济州岛</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"PNH\" data-omni=\"\" data-events=\"event51\">金边</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"BKK\" data-omni=\"\" data-events=\"event51\">曼谷</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"OSA\" data-omni=\"\" data-events=\"event51\">大阪</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"NRT\" data-omni=\"\" data-events=\"event51\">东京(成田)</a>                                                                                                                                              <a href=\"javascript:;\" class=\"double-width\" data-code=\"HKG\" data-omni=\"\" data-events=\"event51\">香港(中国香港)</a>                                                                                                                                              <a href=\"javascript:;\" class=\"double-width\" data-code=\"MFM\" data-omni=\"\" data-events=\"event51\">澳门(中国澳门)</a>                                                                                                                                              <a href=\"javascript:;\" class=\"double-width\" data-code=\"TPE\" data-omni=\"\" data-events=\"event51\">台北(中国台湾)</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"SEL\" data-omni=\"\" data-events=\"event51\">首尔</a>                                                                                                                                              <a href=\"javascript:;\" class=\"\" data-code=\"FUK\" data-omni=\"\" data-events=\"event51\" style=\"display: none;\">佐贺(近福冈)</a>                                                                                                        </div>                                </div>                                                                <div class=\"u-cityassort-line \">                                  <div class=\"u-cityassort-sort\">联运服务：</div>                                  <div class=\"u-cityassort-list\">                                                                                                          <a href=\"javascript:;\" class=\"trainitem \" data-code=\"PEK\" data-omni=\"\" data-events=\"event52\"><i class=\"iconfont\">\uE663</i>北京</a>                                                                                                                                              <a href=\"javascript:;\" class=\"trainitem \" data-code=\"HGH\" data-omni=\"\" data-events=\"event52\"><i class=\"iconfont\">\uE663</i>杭州</a>                                                                                                                                              <a href=\"javascript:;\" class=\"trainitem \" data-code=\"NKG\" data-omni=\"\" data-events=\"event52\"><i class=\"iconfont\">\uE663</i>南京</a>                                                                                                                                              <a href=\"javascript:;\" class=\"trainitem \" data-code=\"KUS\" data-omni=\"\" data-events=\"event52\"><i class=\"iconfont\">\uE663</i>昆山</a>                                                                                                                                              <a href=\"javascript:;\" class=\"trainitem \" data-code=\"WUX\" data-omni=\"\" data-events=\"event52\"><i class=\"iconfont\">\uE663</i>无锡</a>                                                                                                                                              <a href=\"javascript:;\" class=\"trainitem \" data-code=\"YIW\" data-omni=\"\" data-events=\"event52\"><i class=\"iconfont\">\uE663</i>义乌</a>                                                                                                                                              <a href=\"javascript:;\" class=\"trainitem \" data-code=\"CZX\" data-omni=\"\" data-events=\"event52\"><i class=\"iconfont\">\uE663</i>常州</a>                                                                                                                                              <a href=\"javascript:;\" class=\"trainitem \" data-code=\"DYA\" data-omni=\"\" data-events=\"event52\"><i class=\"iconfont\">\uE663</i>丹阳</a>                                                                                                                                              <a href=\"javascript:;\" class=\"trainitem \" data-code=\"HFE\" data-omni=\"\" data-events=\"event52\"><i class=\"iconfont\">\uE663</i>合肥</a>                                                                                                                                              <a href=\"javascript:;\" class=\"trainitem \" data-code=\"JIX\" data-omni=\"\" data-events=\"event52\"><i class=\"iconfont\">\uE663</i>嘉兴</a>                                                                                                        </div>                                </div>                                                              </div>                          <div class=\"u-cityassort-cont\" style=\"display: none;\"><div class=\"u-cityassort-line\"><div class=\"u-cityassort-list u-cityassort-sortlist f-cb\"><div class=\"f-cb sort-items\"><span class=\"title\">A</span><a href=\"javascript:;\" data-code=\"AVA\" data-citycode=\"AVA\" data-name=\"安顺\" class=\"\">安顺</a><a href=\"javascript:;\" data-code=\"MFM\" data-citycode=\"MFM\" data-name=\"澳门(中国澳门)\" class=\"\">澳门(中国澳门)</a></div><div class=\"f-cb sort-items\"><span class=\"title\">B</span><a href=\"javascript:;\" data-code=\"BAS\" data-citycode=\"BAS\" data-name=\"白山\" class=\"\">白山</a><a href=\"javascript:;\" data-code=\"BAD\" data-citycode=\"BAD\" data-name=\"保定\" class=\"\">保定</a><a href=\"javascript:;\" data-code=\"BAV\" data-citycode=\"BAV\" data-name=\"包头\" class=\"\">包头</a><a href=\"javascript:;\" data-code=\"BHY\" data-citycode=\"BHY\" data-name=\"北海\" class=\"\">北海</a><a href=\"javascript:;\" data-code=\"PEK\" data-citycode=\"PEK\" data-name=\"北京\" class=\"\">北京</a><a href=\"javascript:;\" data-code=\"BFJ\" data-citycode=\"BFJ\" data-name=\"毕节\" class=\"\">毕节</a></div><div class=\"f-cb sort-items\"><span class=\"title\">C</span><a href=\"javascript:;\" data-code=\"CGQ\" data-citycode=\"CGQ\" data-name=\"长春\" class=\"\">长春</a><a href=\"javascript:;\" data-code=\"CSX\" data-citycode=\"CSX\" data-name=\"长沙\" class=\"\">长沙</a><a href=\"javascript:;\" data-code=\"CGD\" data-citycode=\"CGD\" data-name=\"常德\" class=\"\">常德</a><a href=\"javascript:;\" data-code=\"CZX\" data-citycode=\"CZX\" data-name=\"常州\" class=\"\">常州</a><a href=\"javascript:;\" data-code=\"CDE\" data-citycode=\"CDE\" data-name=\"承德\" class=\"\">承德</a><a href=\"javascript:;\" data-code=\"CTU\" data-citycode=\"CTU\" data-name=\"成都\" class=\"\">成都</a><a href=\"javascript:;\" data-code=\"CKG\" data-citycode=\"CKG\" data-name=\"重庆\" class=\"\">重庆</a><a href=\"javascript:;\" data-code=\"TYO\" data-citycode=\"TYO\" data-name=\"茨城(近东京)\" class=\"\">茨城(近东京)</a></div><div class=\"f-cb sort-items\"><span class=\"title\">D</span><a href=\"javascript:;\" data-code=\"OSA\" data-citycode=\"OSA\" data-name=\"大阪\" class=\"\">大阪</a><a href=\"javascript:;\" data-code=\"DLC\" data-citycode=\"DLC\" data-name=\"大连\" class=\"\">大连</a><a href=\"javascript:;\" data-code=\"DYA\" data-citycode=\"DYA\" data-name=\"丹阳\" class=\"\">丹阳</a><a href=\"javascript:;\" data-code=\"DZS\" data-citycode=\"DZS\" data-name=\"定州\" class=\"\">定州</a><a href=\"javascript:;\" data-code=\"HND\" data-citycode=\"HND\" data-name=\"东京(羽田)\" class=\"\">东京(羽田)</a><a href=\"javascript:;\" data-code=\"NRT\" data-citycode=\"NRT\" data-name=\"东京(成田)\" class=\"\">东京(成田)</a><a href=\"javascript:;\" data-code=\"DOY\" data-citycode=\"DOY\" data-name=\"东营\" class=\"\">东营</a><a href=\"javascript:;\" data-code=\"DNH\" data-citycode=\"DNH\" data-name=\"敦煌\" class=\"\">敦煌</a></div><div class=\"f-cb sort-items\"><span class=\"title\">E</span><a href=\"javascript:;\" data-code=\"ENH\" data-citycode=\"ENH\" data-name=\"恩施\" class=\"\">恩施</a></div><div class=\"f-cb sort-items\"><span class=\"title\">F</span><a href=\"javascript:;\" data-code=\"FOC\" data-citycode=\"FOC\" data-name=\"福州\" class=\"\">福州</a><a href=\"javascript:;\" data-code=\"FUG\" data-citycode=\"FUG\" data-name=\"阜阳\" class=\"\">阜阳</a></div></div></div></div><div class=\"u-cityassort-cont\" style=\"display: none;\"><div class=\"u-cityassort-line\"><div class=\"u-cityassort-list u-cityassort-sortlist f-cb\"><div class=\"f-cb sort-items\"><span class=\"title\">G</span><a href=\"javascript:;\" data-code=\"KOW\" data-citycode=\"KOW\" data-name=\"赣州\" class=\"\">赣州</a><a href=\"javascript:;\" data-code=\"TAK\" data-citycode=\"TAK\" data-name=\"高松\" class=\"\">高松</a><a href=\"javascript:;\" data-code=\"KHH\" data-citycode=\"KHH\" data-name=\"高雄(中国台湾)\" class=\"\">高雄(中国台湾)</a><a href=\"javascript:;\" data-code=\"HIJ\" data-citycode=\"HIJ\" data-name=\"广岛\" class=\"\">广岛</a><a href=\"javascript:;\" data-code=\"GYS\" data-citycode=\"GYS\" data-name=\"广元\" class=\"\">广元</a><a href=\"javascript:;\" data-code=\"CAN\" data-citycode=\"CAN\" data-name=\"广州\" class=\"\" style=\"display: none;\">广州</a><a href=\"javascript:;\" data-code=\"KWL\" data-citycode=\"KWL\" data-name=\"桂林\" class=\"\">桂林</a><a href=\"javascript:;\" data-code=\"KWE\" data-citycode=\"KWE\" data-name=\"贵阳\" class=\"\">贵阳</a></div><div class=\"f-cb sort-items\"><span class=\"title\">H</span><a href=\"javascript:;\" data-code=\"HAK\" data-citycode=\"HAK\" data-name=\"海口\" class=\"\">海口</a><a href=\"javascript:;\" data-code=\"HDG\" data-citycode=\"HDG\" data-name=\"邯郸\" class=\"\">邯郸</a><a href=\"javascript:;\" data-code=\"HGH\" data-citycode=\"HGH\" data-name=\"杭州\" class=\"\">杭州</a><a href=\"javascript:;\" data-code=\"HRB\" data-citycode=\"HRB\" data-name=\"哈尔滨\" class=\"\">哈尔滨</a><a href=\"javascript:;\" data-code=\"HFE\" data-citycode=\"HFE\" data-name=\"合肥\" class=\"\">合肥</a><a href=\"javascript:;\" data-code=\"HSU\" data-citycode=\"HSU\" data-name=\"衡水\" class=\"\">衡水</a><a href=\"javascript:;\" data-code=\"HET\" data-citycode=\"HET\" data-name=\"呼和浩特\" class=\"\">呼和浩特</a><a href=\"javascript:;\" data-code=\"SGN\" data-citycode=\"SGN\" data-name=\"胡志明市\" class=\"\">胡志明市</a><a href=\"javascript:;\" data-code=\"HUN\" data-citycode=\"HUN\" data-name=\"花莲(中国台湾)\" class=\"\">花莲(中国台湾)</a><a href=\"javascript:;\" data-code=\"HIA\" data-citycode=\"HIA\" data-name=\"淮安\" class=\"\">淮安</a><a href=\"javascript:;\" data-code=\"HJJ\" data-citycode=\"HJJ\" data-name=\"怀化\" class=\"\">怀化</a></div><div class=\"f-cb sort-items\"><span class=\"title\">J</span><a href=\"javascript:;\" data-code=\"CJU\" data-citycode=\"CJU\" data-name=\"济州岛\" class=\"\">济州岛</a><a href=\"javascript:;\" data-code=\"KBV\" data-citycode=\"KBV\" data-name=\"甲米\" class=\"\">甲米</a><a href=\"javascript:;\" data-code=\"JIX\" data-citycode=\"JIX\" data-name=\"嘉兴\" class=\"\">嘉兴</a><a href=\"javascript:;\" data-code=\"JGN\" data-citycode=\"JGN\" data-name=\"嘉峪关\" class=\"\">嘉峪关</a><a href=\"javascript:;\" data-code=\"SWA\" data-citycode=\"SWA\" data-name=\"揭阳(潮汕)\" class=\"\">揭阳(潮汕)</a><a href=\"javascript:;\" data-code=\"PNH\" data-citycode=\"PNH\" data-name=\"金边\" class=\"\">金边</a><a href=\"javascript:;\" data-code=\"TNA\" data-citycode=\"TNA\" data-name=\"济南\" class=\"\">济南</a><a href=\"javascript:;\" data-code=\"JGS\" data-citycode=\"JGS\" data-name=\"井冈山\" class=\"\">井冈山</a></div></div></div></div><div class=\"u-cityassort-cont\" style=\"display: none;\"><div class=\"u-cityassort-line\"><div class=\"u-cityassort-list u-cityassort-sortlist f-cb\"><div class=\"f-cb sort-items\"><span class=\"title\">K</span><a href=\"javascript:;\" data-code=\"KJH\" data-citycode=\"KJH\" data-name=\"凯里\" class=\"\">凯里</a><a href=\"javascript:;\" data-code=\"KHG\" data-citycode=\"KHG\" data-name=\"喀什\" class=\"\">喀什</a><a href=\"javascript:;\" data-code=\"KRY\" data-citycode=\"KRY\" data-name=\"克拉玛依\" class=\"\">克拉玛依</a><a href=\"javascript:;\" data-code=\"KMG\" data-citycode=\"KMG\" data-name=\"昆明\" class=\"\">昆明</a><a href=\"javascript:;\" data-code=\"KUS\" data-citycode=\"KUS\" data-name=\"昆山\" class=\"\">昆山</a></div><div class=\"f-cb sort-items\"><span class=\"title\">L</span><a href=\"javascript:;\" data-code=\"LHW\" data-citycode=\"LHW\" data-name=\"兰州\" class=\"\">兰州</a><a href=\"javascript:;\" data-code=\"LJG\" data-citycode=\"LJG\" data-name=\"丽江\" class=\"\">丽江</a><a href=\"javascript:;\" data-code=\"LYG\" data-citycode=\"LYG\" data-name=\"连云港\" class=\"\">连云港</a><a href=\"javascript:;\" data-code=\"LHZ\" data-citycode=\"LHZ\" data-name=\"临海\" class=\"\">临海</a><a href=\"javascript:;\" data-code=\"LYI\" data-citycode=\"LYI\" data-name=\"临沂\" class=\"\">临沂</a><a href=\"javascript:;\" data-code=\"LZH\" data-citycode=\"LZH\" data-name=\"柳州\" class=\"\">柳州</a><a href=\"javascript:;\" data-code=\"LYA\" data-citycode=\"LYA\" data-name=\"洛阳\" class=\"\">洛阳</a></div><div class=\"f-cb sort-items\"><span class=\"title\">M</span><a href=\"javascript:;\" data-code=\"MAD\" data-citycode=\"MAD\" data-name=\"马德里\" class=\"\">马德里</a><a href=\"javascript:;\" data-code=\"BKK\" data-citycode=\"BKK\" data-name=\"曼谷\" class=\"\">曼谷</a><a href=\"javascript:;\" data-code=\"NZH\" data-citycode=\"NZH\" data-name=\"满洲里\" class=\"\">满洲里</a><a href=\"javascript:;\" data-code=\"MIG\" data-citycode=\"MIG\" data-name=\"绵阳\" class=\"\">绵阳</a><a href=\"javascript:;\" data-code=\"NGO\" data-citycode=\"NGO\" data-name=\"名古屋\" class=\"\">名古屋</a><a href=\"javascript:;\" data-code=\"OHE\" data-citycode=\"OHE\" data-name=\"漠河\" class=\"\">漠河</a></div><div class=\"f-cb sort-items\"><span class=\"title\">N</span><a href=\"javascript:;\" data-code=\"NKG\" data-citycode=\"NKG\" data-name=\"南京\" class=\"\">南京</a><a href=\"javascript:;\" data-code=\"NNG\" data-citycode=\"NNG\" data-name=\"南宁\" class=\"\">南宁</a><a href=\"javascript:;\" data-code=\"NNY\" data-citycode=\"NNY\" data-name=\"南阳\" class=\"\">南阳</a><a href=\"javascript:;\" data-code=\"KHN\" data-citycode=\"KHN\" data-name=\"南昌\" class=\"\">南昌</a><a href=\"javascript:;\" data-code=\"NAO\" data-citycode=\"NAO\" data-name=\"南充\" class=\"\">南充</a><a href=\"javascript:;\" data-code=\"NTG\" data-citycode=\"NTG\" data-name=\"南通\" class=\"\">南通</a><a href=\"javascript:;\" data-code=\"NGB\" data-citycode=\"NGB\" data-name=\"宁波\" class=\"\">宁波</a></div></div></div></div><div class=\"u-cityassort-cont\" style=\"display: none;\"><div class=\"u-cityassort-line\"><div class=\"u-cityassort-list u-cityassort-sortlist f-cb\"><div class=\"f-cb sort-items\"><span class=\"title\">P</span><a href=\"javascript:;\" data-code=\"HKT\" data-citycode=\"HKT\" data-name=\"普吉\" class=\"\">普吉</a></div><div class=\"f-cb sort-items\"><span class=\"title\">Q</span><a href=\"javascript:;\" data-code=\"JIQ\" data-citycode=\"JIQ\" data-name=\"黔江(重庆)\" class=\"\">黔江(重庆)</a><a href=\"javascript:;\" data-code=\"TAO\" data-citycode=\"TAO\" data-name=\"青岛\" class=\"\">青岛</a><a href=\"javascript:;\" data-code=\"CNX\" data-citycode=\"CNX\" data-name=\"清迈\" class=\"\">清迈</a><a href=\"javascript:;\" data-code=\"IQN\" data-citycode=\"IQN\" data-name=\"庆阳\" class=\"\">庆阳</a><a href=\"javascript:;\" data-code=\"JJN\" data-citycode=\"JJN\" data-name=\"泉州(晋江)\" class=\"\">泉州(晋江)</a></div><div class=\"f-cb sort-items\"><span class=\"title\">R</span><a href=\"javascript:;\" data-code=\"RIZ\" data-citycode=\"RIZ\" data-name=\"日照\" class=\"\">日照</a></div><div class=\"f-cb sort-items\"><span class=\"title\">S</span><a href=\"javascript:;\" data-code=\"SYX\" data-citycode=\"SYX\" data-name=\"三亚\" class=\"\">三亚</a><a href=\"javascript:;\" data-code=\"SQJ\" data-citycode=\"SQJ\" data-name=\"三明\" class=\"\">三明</a><a href=\"javascript:;\" data-code=\"SEL\" data-citycode=\"SEL\" data-name=\"首尔\" class=\"\">首尔</a><a href=\"javascript:;\" data-code=\"QSZ\" data-citycode=\"QSZ\" data-name=\"莎车\" class=\"\">莎车</a><a href=\"javascript:;\" data-code=\"SHA\" data-citycode=\"SHA\" data-name=\"上海\" class=\"\">上海</a><a href=\"javascript:;\" data-code=\"SQD\" data-citycode=\"SQD\" data-name=\"上饶\" class=\"\">上饶</a><a href=\"javascript:;\" data-code=\"SHX\" data-citycode=\"SHX\" data-name=\"绍兴\" class=\"\">绍兴</a><a href=\"javascript:;\" data-code=\"WGN\" data-citycode=\"WGN\" data-name=\"邵阳\" class=\"\">邵阳</a><a href=\"javascript:;\" data-code=\"SZX\" data-citycode=\"SZX\" data-name=\"深圳\" class=\"\">深圳</a><a href=\"javascript:;\" data-code=\"SHE\" data-citycode=\"SHE\" data-name=\"沈阳\" class=\"\">沈阳</a><a href=\"javascript:;\" data-code=\"SJW\" data-citycode=\"SJW\" data-name=\"石家庄\" class=\"\">石家庄</a><a href=\"javascript:;\" data-code=\"SHF\" data-citycode=\"SHF\" data-name=\"石河子\" class=\"\">石河子</a><a href=\"javascript:;\" data-code=\"WDS\" data-citycode=\"WDS\" data-name=\"十堰(武当山)\" class=\"\">十堰(武当山)</a><a href=\"javascript:;\" data-code=\"YSQ\" data-citycode=\"YSQ\" data-name=\"松原\" class=\"\">松原</a><a href=\"javascript:;\" data-code=\"URT\" data-citycode=\"URT\" data-name=\"素叻他尼(近苏梅岛)\" class=\"double-width\">素叻他尼(近苏梅岛)</a><a href=\"javascript:;\" data-code=\"SZV\" data-citycode=\"SZV\" data-name=\"苏州\" class=\"\">苏州</a></div><div class=\"f-cb sort-items\"><span class=\"title\">T</span><a href=\"javascript:;\" data-code=\"TPE\" data-citycode=\"TPE\" data-name=\"台北(中国台湾)\" class=\"\">台北(中国台湾)</a><a href=\"javascript:;\" data-code=\"TYN\" data-citycode=\"TYN\" data-name=\"太原\" class=\"\">太原</a><a href=\"javascript:;\" data-code=\"HYN\" data-citycode=\"HYN\" data-name=\"台州\" class=\"\">台州</a><a href=\"javascript:;\" data-code=\"TVS\" data-citycode=\"TVS\" data-name=\"唐山\" class=\"\">唐山</a><a href=\"javascript:;\" data-code=\"TSN\" data-citycode=\"TSN\" data-name=\"天津\" class=\"\">天津</a><a href=\"javascript:;\" data-code=\"TGO\" data-citycode=\"TGO\" data-name=\"通辽\" class=\"\">通辽</a><a href=\"javascript:;\" data-code=\"TEN\" data-citycode=\"TEN\" data-name=\"铜仁\" class=\"\">铜仁</a><a href=\"javascript:;\" data-code=\"TOX\" data-citycode=\"TOX\" data-name=\"桐乡\" class=\"\">桐乡</a></div></div></div></div><div class=\"u-cityassort-cont\" style=\"display: none;\"><div class=\"u-cityassort-line\"><div class=\"u-cityassort-list u-cityassort-sortlist f-cb\"><div class=\"f-cb sort-items\"><span class=\"title\">W</span><a href=\"javascript:;\" data-code=\"WEH\" data-citycode=\"WEH\" data-name=\"威海\" class=\"\">威海</a><a href=\"javascript:;\" data-code=\"WEF\" data-citycode=\"WEF\" data-name=\"潍坊\" class=\"\">潍坊</a><a href=\"javascript:;\" data-code=\"WNZ\" data-citycode=\"WNZ\" data-name=\"温州\" class=\"\">温州</a><a href=\"javascript:;\" data-code=\"URC\" data-citycode=\"URC\" data-name=\"乌鲁木齐\" class=\"\">乌鲁木齐</a><a href=\"javascript:;\" data-code=\"WUH\" data-citycode=\"WUH\" data-name=\"武汉\" class=\"\">武汉</a><a href=\"javascript:;\" data-code=\"WUX\" data-citycode=\"WUX\" data-name=\"无锡\" class=\"\">无锡</a></div><div class=\"f-cb sort-items\"><span class=\"title\">X</span><a href=\"javascript:;\" data-code=\"SIA\" data-citycode=\"SIA\" data-name=\"西安\" class=\"\">西安</a><a href=\"javascript:;\" data-code=\"XMN\" data-citycode=\"XMN\" data-name=\"厦门\" class=\"\">厦门</a><a href=\"javascript:;\" data-code=\"DAD\" data-citycode=\"DAD\" data-name=\"岘港\" class=\"\">岘港</a><a href=\"javascript:;\" data-code=\"REP\" data-citycode=\"REP\" data-name=\"暹粒\" class=\"\">暹粒</a><a href=\"javascript:;\" data-code=\"HKG\" data-citycode=\"HKG\" data-name=\"香港(中国香港)\" class=\"\">香港(中国香港)</a><a href=\"javascript:;\" data-code=\"XJS\" data-citycode=\"XJS\" data-name=\"辛集\" class=\"\">辛集</a><a href=\"javascript:;\" data-code=\"SIN\" data-citycode=\"SIN\" data-name=\"新加坡\" class=\"\">新加坡</a><a href=\"javascript:;\" data-code=\"JHB\" data-citycode=\"JHB\" data-name=\"新山\" class=\"\">新山</a><a href=\"javascript:;\" data-code=\"XNT\" data-citycode=\"XNT\" data-name=\"邢台\" class=\"\">邢台</a><a href=\"javascript:;\" data-code=\"XNN\" data-citycode=\"XNN\" data-name=\"西宁\" class=\"\">西宁</a><a href=\"javascript:;\" data-code=\"JHG\" data-citycode=\"JHG\" data-name=\"西双版纳\" class=\"\">西双版纳</a><a href=\"javascript:;\" data-code=\"AKJ\" data-citycode=\"AKJ\" data-name=\"旭川\" class=\"\">旭川</a><a href=\"javascript:;\" data-code=\"XUZ\" data-citycode=\"XUZ\" data-name=\"徐州\" class=\"\">徐州</a></div><div class=\"f-cb sort-items\"><span class=\"title\">Y</span><a href=\"javascript:;\" data-code=\"BKI\" data-citycode=\"BKI\" data-name=\"亚庇(哥打基纳巴卢)\" class=\"double-width\">亚庇(哥打基纳巴卢)</a><a href=\"javascript:;\" data-code=\"ENY\" data-citycode=\"ENY\" data-name=\"延安\" class=\"\">延安</a><a href=\"javascript:;\" data-code=\"YNZ\" data-citycode=\"YNZ\" data-name=\"盐城\" class=\"\">盐城</a><a href=\"javascript:;\" data-code=\"RGN\" data-citycode=\"RGN\" data-name=\"仰光\" class=\"\">仰光</a><a href=\"javascript:;\" data-code=\"YTY\" data-citycode=\"YTY\" data-name=\"扬州(泰州)\" class=\"\">扬州(泰州)</a><a href=\"javascript:;\" data-code=\"YNJ\" data-citycode=\"YNJ\" data-name=\"延吉\" class=\"\">延吉</a><a href=\"javascript:;\" data-code=\"YNT\" data-citycode=\"YNT\" data-name=\"烟台\" class=\"\">烟台</a><a href=\"javascript:;\" data-code=\"YBP\" data-citycode=\"YBP\" data-name=\"宜宾\" class=\"\">宜宾</a><a href=\"javascript:;\" data-code=\"YIH\" data-citycode=\"YIH\" data-name=\"宜昌\" class=\"\">宜昌</a><a href=\"javascript:;\" data-code=\"INC\" data-citycode=\"INC\" data-name=\"银川\" class=\"\">银川</a><a href=\"javascript:;\" data-code=\"YIW\" data-citycode=\"YIW\" data-name=\"义乌\" class=\"\">义乌</a><a href=\"javascript:;\" data-code=\"YYA\" data-citycode=\"YYA\" data-name=\"岳阳\" class=\"\">岳阳</a><a href=\"javascript:;\" data-code=\"UYN\" data-citycode=\"UYN\" data-name=\"榆林\" class=\"\">榆林</a></div><div class=\"f-cb sort-items\"><span class=\"title\">Z</span><a href=\"javascript:;\" data-code=\"SPK\" data-citycode=\"SPK\" data-name=\"札幌\" class=\"\">札幌</a><a href=\"javascript:;\" data-code=\"ZHA\" data-citycode=\"ZHA\" data-name=\"湛江\" class=\"\">湛江</a><a href=\"javascript:;\" data-code=\"DYG\" data-citycode=\"DYG\" data-name=\"张家界\" class=\"\">张家界</a><a href=\"javascript:;\" data-code=\"YZY\" data-citycode=\"YZY\" data-name=\"张掖\" class=\"\">张掖</a><a href=\"javascript:;\" data-code=\"ZQZ\" data-citycode=\"ZQZ\" data-name=\"张家口\" class=\"\">张家口</a><a href=\"javascript:;\" data-code=\"CGO\" data-citycode=\"CGO\" data-name=\"郑州\" class=\"\">郑州</a><a href=\"javascript:;\" data-code=\"ZJA\" data-citycode=\"ZJA\" data-name=\"镇江\" class=\"\">镇江</a><a href=\"javascript:;\" data-code=\"ZHY\" data-citycode=\"ZHY\" data-name=\"中卫\" class=\"\">中卫</a><a href=\"javascript:;\" data-code=\"HSN\" data-citycode=\"HSN\" data-name=\"舟山\" class=\"\">舟山</a><a href=\"javascript:;\" data-code=\"ZUH\" data-citycode=\"ZUH\" data-name=\"珠海\" class=\"\">珠海</a><a href=\"javascript:;\" data-code=\"ZYI\" data-citycode=\"ZYI\" data-name=\"遵义\" class=\"\">遵义</a><a href=\"javascript:;\" data-code=\"HSG\" data-citycode=\"HSG\" data-name=\"佐贺(近福冈)\" class=\"\">佐贺(近福冈)</a></div></div></div></div></div>";

        Document document = Jsoup.parse(initCQCityNameHtml);
        Elements links = document.select("a[href]");
        for (Element link : links) {
            String citycode = link.attr("data-citycode");
            String linkText = link.text();
//            logger.info("linkText:{},data-citycode:{}",linkText,citycode);
            if (StringUtils.isNotBlank(citycode)) {
                list.add(citycode);
            }
        }

    }


}
