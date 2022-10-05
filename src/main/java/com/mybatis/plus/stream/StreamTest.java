package com.mybatis.plus.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class StreamTest {

    @Autowired
    private ProductionStream productionStream;

    @RequestMapping("/stream")
    public void a() {
        productionStream.a();
    }

}
