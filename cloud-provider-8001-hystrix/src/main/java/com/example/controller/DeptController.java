package com.example.controller;

import com.example.entity.Dept;
import com.example.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xue
 * @date 2020-05-28 15:03
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    //当调用服务方法失败后会自动调用fallbackMethod = "processHystrix_Get"方法
    public Dept get(@PathVariable("id") Long id) {
        Dept dept=deptService.getById(id);
        if (dept==null){
            throw new RuntimeException("该Id" + id + "没有对应的信息，null--@HystrixCommand");
        }
        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id) {
        Dept dept = new Dept();
        dept.setDeptNo(id);
        dept.setDeptName("该Id" + id + "没有对应的信息，null--@HystrixCommand");
        dept.setDb_source("no this database in MySQL");
        return dept;
    }
}
