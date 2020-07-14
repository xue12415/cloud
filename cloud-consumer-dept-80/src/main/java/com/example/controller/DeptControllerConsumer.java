package com.example.controller;

import com.example.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author xue
 * @date 2020-05-28 15:38
 */
@RestController
public class DeptControllerConsumer {
    /**
     * 使用RestTemplate调用rest接口
     * （url,requestMap,responseBean.class）
     * （http访问地址，请求参数，响应的数据类型）
     */

    @Autowired
    private RestTemplate restTemplate;

   // public static final String REST_URL_PREFIX = "http://localhost:8001";
   public static final String REST_URL_PREFIX = "http://CLOUD-PROVIDER";//从eureka上调用服务
    @RequestMapping(value = "/consumer/dept/add")
    public Boolean addDept(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list(){
        return  restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }
}
