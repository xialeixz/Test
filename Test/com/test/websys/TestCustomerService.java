package com.test.websys;

import cn.my.websys.login.dto.TmCustomer;
import cn.my.websys.login.service.CustomerService;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jasonxxia on 2016/12/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:biz/biz-context-core.xml")
public class TestCustomerService {

    @Autowired
    private CustomerService customerService;

    @Test
    public void test(){
        JSONObject json = new JSONObject();
        json.put("id", 2951200000000001931L);
        TmCustomer customer = customerService.get(json);
        System.out.println(customer);
    }
}