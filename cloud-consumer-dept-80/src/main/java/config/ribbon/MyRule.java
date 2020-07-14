package config.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author xue
 * @date 2020-05-29 17:51
 */
@Configuration
public class MyRule extends AbstractLoadBalancerRule {
    /*现有3台服务器，使用轮询方式每台服务器访问5此后，再访问下一个*/
    Integer total = 0;
    Integer currentIndex = 0;

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            //负载均衡来获得可用实例列表upList和allList
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }

            //随机来获取一个随机数
            // int index = chooseRandomInt(serverCount);
            //随机数作为upList的索引值来返回具体实例

            if (total < 5) {
                server = upList.get(currentIndex);
                total++;
            } else {
                total = 0;
                currentIndex++;
                if (currentIndex >= allList.size()) {
                    currentIndex = 0;
                }
            }


            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }
        //正常情况下，每次都应该可以选择一个服务实例
        return server;

    }


    //接口中的choose委托给该类中的choose(getLoadBalancer(), key)方法
    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }
}

