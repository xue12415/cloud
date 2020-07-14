package com.example.mapper;

import com.example.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xue
 * @date 2020-05-28 14:43
 */
@Mapper
public interface DeptMapper {
    Boolean addDept(Dept dept);

    Dept findById(Long deptNo);

    List<Dept> findAll();
}
