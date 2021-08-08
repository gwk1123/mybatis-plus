package com.mybatis.plus.gwk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatis.plus.gwk.entity.ZTest;
import com.mybatis.plus.gwk.mapper.ZTestMapper;
import com.mybatis.plus.gwk.service.ZTestService;
import com.mybatis.plus.gwk.transform.JsonTransform;
import com.mybatis.plus.utils.CreateOrderNo;
import com.mybatis.plus.utils.HttpRequestUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gwk
 * @since 2021-08-06
 */
@Service
public class ZTestServiceImpl extends ServiceImpl<ZTestMapper, ZTest> implements ZTestService {

    @Override
    public IPage<ZTest> pageZTest(Page<ZTest> page, ZTest zTest){

        page = Optional.ofNullable(page).orElse(new Page<>());
        QueryWrapper<ZTest> queryWrapper = new QueryWrapper<>();

        return  this.page(page, queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveZTest(ZTest zTest){
        Assert.notNull(zTest, "为空");
        return this.save(zTest);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeZTest(String id){
        Assert.hasText(id, "主键为空");
        return this.removeById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeZTestByIds(List<String> ids){
        Assert.isTrue(!CollectionUtils.isEmpty(ids), "主键集合为空");
        return this.removeByIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateZTest(ZTest zTest){
        Assert.notNull(zTest, "为空");
        return this.updateById(zTest);
    }

    @Override
    public ZTest getZTestById(String id){
        return  this.getById(id);
    }

    @Override
    public List<ZTest> listZtest(){

        System.out.println("开始时间:"+ LocalDateTime.now());
        List<ZTest> zTests =new ArrayList<>();
        QueryWrapper<ZTest> zTestQueryWrapper =new QueryWrapper<>();
        zTestQueryWrapper.lambda().select(ZTest::getOrderNo);
        zTests = this.list(zTestQueryWrapper);
        System.out.println("结束时间:"+ LocalDateTime.now());
        return zTests;
    }
    @Override
    public ZTest getZtest(String orderNo){
        QueryWrapper<ZTest> zTestQueryWrapper =new QueryWrapper<>();
        zTestQueryWrapper.lambda().eq(ZTest::getOrderNo,orderNo);
        return this.getOne(zTestQueryWrapper);
    }


    @Override
    public void saveZtest() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        String no = CreateOrderNo.create();
//        IntStream.range(0, 100000).forEach(i -> {
        for(int i =1;i<100001;i++) {
            String finalI = CreateOrderNo.create();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CompletableFuture.runAsync(() -> {
                ZTest zTest = new ZTest();
                zTest.setOrderNo(String.valueOf(finalI));
                String s = JsonTransform.jsonOrderDetail(finalI);
                zTest.setContent(s);
                System.out.println("---->" + finalI);
                this.save(zTest);
            }, executorService);
        }
//        });
    }



}
