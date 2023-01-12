package com.mybatis.plus.gwk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatis.plus.gwk.entity.ZTest;
import com.mybatis.plus.gwk.service.ZTestService;
import com.mybatis.plus.gwk.vo.OrderTicketResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gwk
 * @since 2021-08-06
 */
@Api(tags = {""})
@RestController
@RequestMapping("/z-test")
public class ZTestController {

    private final ZTestService testService;

    public ZTestController(ZTestService testService) {
        this.testService = testService;
    }

    @ApiOperation(value = "新增")
    @PostMapping("/zTest")
    public boolean saveZTest(@RequestBody ZTest zTest) {
        return testService.saveZTest(zTest);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/zTest/{id}")
    public boolean removeZTest(@PathVariable("id") String id) {
        return testService.removeZTest(id);
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/zTests")
    public boolean removeZTestByIds(@RequestBody List<String> ids) {
        return testService.removeZTestByIds(ids);
    }


    @ApiOperation(value = "更新")
    @PutMapping("/zTest")
    public boolean updateZTest(@RequestBody ZTest zTest) {
        return testService.updateZTest(zTest);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页参数"),
            @ApiImplicitParam(name = "zTest", value = "查询条件")
    })
    @GetMapping("/zTest/page")
    public IPage<ZTest> pageZTest(Page<ZTest> page, ZTest zTest) {
        return testService.pageZTest(page, zTest);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("/ticket/{id}")
    public ZTest getTicketById(@PathVariable String id) {
        return testService.getTicketById(id);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("/zTest/{id}")
    public ZTest getZTestById(@PathVariable String id) {
        return testService.getZTestById(id);
    }


    @RequestMapping("/zTest/order/add")
    public void saveOrderZtest() {
        testService.saveZtest();
    }

    @RequestMapping("/zTest/list")
    public List<String> listZtest() {
        return testService.listZtest().stream().map(m -> m.getOrderNo()).collect(Collectors.toList());
    }

    @RequestMapping("/zTest/get")
    public String getZtest(@RequestBody String orderNo) {
        return testService.getZtest(orderNo).getContent();
    }

    /**
     * 测试飞猪票号回填
     *
     * @param requestStr
     * @return
     */
    @RequestMapping("/order/ticket")
    public OrderTicketResponse orderTicket(String requestStr) {
        return testService.orderTicket(requestStr);
    }


    @RequestMapping("/zTest/refund/add")
    public void saveRefundZtest() {
        testService.saveRefundZtest();
    }


    @RequestMapping("/zTest/refund/list")
    public List<String> listRefundZtest() {
        return testService.listRefundZtest().stream().map(m -> m.getOrderNo()).collect(Collectors.toList());
    }

    @RequestMapping("/zTest/refund/get")
    public String getRefundZtest(@RequestBody String orderNo) {
        return testService.getRefundZtest(orderNo).getContent();
    }

    @RequestMapping("/zTest/change/add")
    public void saveChange() {
        testService.saveChange();
    }

    @RequestMapping("/zTest/change/get")
    public String getChange(@RequestBody String orderNo) {
        return testService.getChange(orderNo).getContent();
    }

}