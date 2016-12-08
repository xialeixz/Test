package cn.my.websys.login.controller;

import cn.my.websys.login.dto.TmCustomer;
import cn.my.websys.login.service.CustomerService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jasonxxia on 2016/10/22.
 */
@Controller
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "interface", method = RequestMethod.POST)
    @ResponseBody
    public String onMessage(@RequestBody String param){

        logger.info("接收消息:", param);
        String desc = "受理成功";

        try{
            JSONObject json = JSONObject.parseObject(param);
            if(null == json){
                throw new RuntimeException("接收参数异常");
            }

            String interfaces = json.getString("INTERFACE");
            if("add".equals(interfaces)){
                customerService.add(json);
            }else if("modify".equals(interfaces)){
                customerService.update(json);
            }else if("get".equals(interfaces)){
                TmCustomer customer = customerService.get(json);
                if(null == customer){
                    desc = "未找到用户";
                }else {
                    desc = customer.toString();
                }
            }else {
                return "无法定位接口";
            }
        } catch(Exception ex){
            desc = ex.getMessage();
        }

        return desc;
    }
}