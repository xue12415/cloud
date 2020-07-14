package com.example.service;

import com.example.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author xue
 * @date 2020-05-30 9:31
 */

/**
 * feign是注解+接口实现
 * ribbon是用RestTemplate+自定义方法
 */
@Repository

//@FeignClient(value = "CLOUD-PROVIDER")
@FeignClient(value = "CLOUD-PROVIDER",fallbackFactory = DeptClientServicesFallBackFactory.class)
public interface DeptClientServices {
    @PostMapping(value = "/dept/add")
    public Boolean addDept(Dept dept);

    @GetMapping(value = "/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id);

    @GetMapping(value = "/dept/list")
    public List<Dept> list();
}
