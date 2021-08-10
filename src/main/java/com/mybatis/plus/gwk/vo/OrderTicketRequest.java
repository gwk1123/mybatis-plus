package com.mybatis.plus.gwk.vo;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderTicketRequest implements Serializable {

    /**
     * true	123	淘宝系统订单id
     */
    private String order_id;


    /**
     * String[]	true	订单中航班号1;旧乘机人姓名1;新乘机人姓名1;票号1,订单中航班号2;旧乘机人姓名2;新乘机人姓名2;票号2	成功订单参数：列表元素结构为——
     *             1.航班号（注：是订单里的航班号，非实际承运航班号）;
     * 2.旧乘机人姓名;
     * 3.新乘机人姓名;
     * 4.票号 （乘机人、航段对应的票号）
     *     说明：
     *             1.往返订单，2段航班对应1个票号的，需要2条success_info记录，分别对应去程、回程；
     *             2.有时用户输入的乘机人姓名输入错误或者有生僻字，代理商必须输入新的名字以保证验真通过；即旧乘机人姓名和新乘机人姓名不需要变化时可以相同
     */
    private List<String> success_info;

}
