package com.example.controller;

import com.example.entity.Dept;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xue
 * @date 2020-05-28 15:03
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public Boolean addDept(@RequestBody Dept dept){
     return deptService.addDept(dept);
    }
    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id){
        return deptService.getById(id);
    }
    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> addDept(){
        return deptService.getAllDept();
    }
}
