package com.mybatis.plus.gwk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author gwk
 * @since 2021-08-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("z_test")
@ApiModel(value="ZTest对象", description="")
public class ZTest implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type= IdType.AUTO)
    private Integer id;

    private String type;

    private String orderNo;

    private String content;


}
