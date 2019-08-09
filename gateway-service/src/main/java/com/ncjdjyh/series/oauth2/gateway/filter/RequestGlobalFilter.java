package com.ncjdjyh.series.oauth2.gateway.filter;

import com.ncjdjyh.series.oauth2.dependencies.constant.DefaultSecurityConstants;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author: ncjdjyh
 * @FirstInitial: 2019/8/7
 * @Description: ~
 */
@Component
public class RequestGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 清洗请求头中from 参数, 防止伪造内部调用
        ServerHttpRequest request = exchange.getRequest().mutate()
                .headers(httpHeaders -> httpHeaders.remove(DefaultSecurityConstants.FROM))
                .build();

        return chain.filter(exchange.mutate()
                .request(request)
                .build());
    }

    @Override
    public int getOrder() {
        return -1000;
    }
}
