package com.mybatis.plus.gwk.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class OrderTicketResponse  implements Serializable {

    /**
     * true	返回操作成功失败信息
     */
    private Boolean is_success;

    /**
     * 返回回填票号操作成功失败信息
     */
    private Boolean is_ticket_success;

    /**
     * 返回接口调用完成后，整个订单是否成功
     */
    private Boolean is_order_success;

}
