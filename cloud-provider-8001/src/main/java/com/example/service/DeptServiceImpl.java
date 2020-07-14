package com.example.service;

import com.example.entity.Dept;
import com.example.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xue
 * @date 2020-05-28 14:59
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper mapper;

    @Override
    public Boolean addDept(Dept dept) {
        return mapper.addDept(dept);
    }

    @Cacheable(key = "#deptNo",value = "dept")//键：dept::deptNo
    @Override
    public Dept getById(Long deptNo) {
        return mapper.findById(deptNo);
    }

    @Override
    public List<Dept> getAllDept() {
        return mapper.findAll();
    }
}
