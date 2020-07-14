package com.example.controller;

import com.example.entity.Dept;
import com.example.service.DeptClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xue
 * @date 2020-05-28 15:38
 */
@RestController
public class DeptControllerConsumer {

    @Autowired
    private DeptClientServices deptClientService;

    @RequestMapping(value = "/consumer/dept/add")
    public Boolean addDept(Dept dept) {
        return deptClientService.addDept(dept);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id){
        return deptClientService.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list(){
        return  deptClientService.list();
    }
}
