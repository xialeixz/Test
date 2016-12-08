package cn.my.websys.login.service;

import cn.my.websys.login.dao.TmCustomerMapper;
import cn.my.websys.login.dto.TmCustomer;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by jasonxxia on 2016/12/7.
 */
@Service
public class CustomerService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TmCustomerMapper customerMapper;

    private Random random = new Random();

    public void add(JSONObject data){
        if(null == data){
            return ;
        }

        TmCustomer customer = new TmCustomer();
        try {
            customer.setCustId(random.nextLong());
            customer.setName(data.getString("name"));
            customer.setOrg("000000001");
            customer.setIdNo(data.getString("idNo"));
            customer.setIdType(data.getString("idType"));
            customer.setTitle(data.getString("title"));
            customer.setGender(data.getString("gender"));
            customer.setBirthday(new SimpleDateFormat("yyyyMMdd").parse(data.getString("birthday")));
        } catch(Exception e){
            logger.error("解析数据异常", e);
            return ;
        }

        customerMapper.insert(customer);
        return ;
    }

    public void update(JSONObject json){
        TmCustomer customer = get(json);
        if(null == customer){
            logger.info("未找到对应客户，无法完成修改操作");
            return ;
        }

        customer.setName(json.getString("name"));
        customer.setIdNo(json.getString("idNo"));
        customer.setLastModifiedDatetime(new Date());
        customerMapper.updateByPrimaryKeySelective(customer);

        return ;
    }

    public TmCustomer get(JSONObject json){
        if(null == json){
            return null;
        }

        TmCustomer customer = customerMapper.selectByPrimaryKey(json.getLong("id"));
        if(null == customer){
            return null;
        }
        return customer;
    }
}