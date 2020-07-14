package com.example.service;

import com.example.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xue
 * @date 2020-05-30 21:21
 */
@Component
public class DeptClientServicesFallBackFactory implements FallbackFactory<DeptClientServices> {
    @Override
    public DeptClientServices create(Throwable throwable) {
        return new DeptClientServices() {
            @Override
            public Boolean addDept(Dept dept) {
                return null;
            }

            @Override
            public Dept get(Long id) {
                Dept dept = new Dept();
                dept.setDeptNo(id);
                dept.setDeptName("服务端provider已经down掉了，但是我们做了服务降级处理，让该客户端在调用服务端不可用时也会获得相应信息，不至于挂起并耗死服务器");
                dept.setDb_source("no this database in MySQL");
                return dept;
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
