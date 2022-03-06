package com.mybatis.plus.gwk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mybatis.plus.gwk.entity.ZTest;
import com.mybatis.plus.gwk.vo.OrderTicketResponse;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gwk
 * @since 2021-08-06
 */
public interface ZTestService extends IService<ZTest> {

    /**
     * 查询分页数据
     *
     * @param page      分页参数
     * @param zTest 查询条件
     * @return IPage<ZTest>
     */
     IPage<ZTest> pageZTest(Page<ZTest> page, ZTest zTest);

    /**
     * 新增
     *
     * @param zTest 
     * @return boolean
     */
    boolean saveZTest(ZTest zTest);

    /**
     * 删除
     *
     * @param id 主键
     * @return boolean
     */
    boolean removeZTest(String id);

    /**
     * 批量删除
     *
     * @param ids 主键集合
     * @return boolean
     */
    boolean removeZTestByIds(List<String> ids);

    /**
     * 修改
     *
     * @param zTest 
     * @return boolean
     */
    boolean updateZTest(ZTest zTest);

    /**
     * id查询数据
     *
     * @param id id
     * @return ZTest
     */
    ZTest getZTestById(String id);

    void saveZtest();

    List<ZTest> listZtest();

    ZTest getZtest(String orderNo);

    OrderTicketResponse orderTicket(String requestStr);

    void saveRefundZtest();
}
