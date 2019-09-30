package com.example.demoWebflux.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestTestServiceTest {

    @Autowired
    private RestTestService restTestService;

    @Test
    public void handleTest() {
        restTestService.handle();
    }

}