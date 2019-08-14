package com.ncjdjyh.series.oauth2.auth.config;

import com.ncjdjyh.series.oauth2.auth.filter.SSOAuthenticationFilter;
import com.ncjdjyh.series.oauth2.auth.handler.SSOAuthenticationSuccessHandler;
import com.ncjdjyh.series.oauth2.auth.provider.SSOAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * @Author: ncjdjyh
 * @FirstInitial: 2019/8/13
 * @Description: ~
 */
@Component
public class SSOAuthenticationSecurityConfiguration extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    @Autowired
    @Qualifier("ssoUserDetailService")
    private UserDetailsService userDetailsService;

    @Override
    public void configure(HttpSecurity builder) {
        SSOAuthenticationFilter ssoAuthenticationFilter = new SSOAuthenticationFilter();
        ssoAuthenticationFilter.setAuthenticationManager(builder.getSharedObject(AuthenticationManager.class));
        ssoAuthenticationFilter.setAuthenticationSuccessHandler(new SSOAuthenticationSuccessHandler());
        SSOAuthenticationProvider ssoAuthenticationProvider = new SSOAuthenticationProvider();
        ssoAuthenticationProvider.setUserDetailsService(userDetailsService);
        builder.authenticationProvider(ssoAuthenticationProvider);
        builder.addFilterBefore(ssoAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
