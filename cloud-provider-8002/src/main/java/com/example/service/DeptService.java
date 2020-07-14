package com.example.service;

import com.example.entity.Dept;

import java.util.List;

/**
 * @author xue
 * @date 2020-05-28 14:57
 */
public interface DeptService {
    Boolean addDept(Dept dept);

    Dept getById(Long deptNo);

    List<Dept> getAllDept();
}
