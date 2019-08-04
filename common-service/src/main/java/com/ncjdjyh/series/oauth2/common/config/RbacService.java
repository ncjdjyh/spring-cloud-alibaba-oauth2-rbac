package com.ncjdjyh.series.oauth2.common.config;

import cn.hutool.core.util.StrUtil;
import com.ncjdjyh.series.oauth2.common.constant.SecurityConstants;
import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author: ncjdjyh
 * @FirstInitial: 2019/7/23
 * @Description: ~
 */
public class RbacService {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    public boolean hasPermission(HttpServletRequest request, Authentication auth) {
        return validateInnerProviderCall(request) || validateAuth(auth.getAuthorities(), request.getRequestURI());
    }

    private boolean validateInnerProviderCall(HttpServletRequest request) {
        String header = request.getHeader(SecurityConstants.FROM);
        return StrUtil.equals(SecurityConstants.FROM_IN, header);
    }

    private boolean validateAuth(Collection<? extends GrantedAuthority> collection, String url) {
        AtomicBoolean isPass = new AtomicBoolean(false);

        collection.stream()
                .map(GrantedAuthority::getAuthority)
                .forEach(e -> {
                    if (antPathMatcher.match(e, url)) {
                       isPass.set(true);
                    }
                });

        return isPass.get();
    }
}
