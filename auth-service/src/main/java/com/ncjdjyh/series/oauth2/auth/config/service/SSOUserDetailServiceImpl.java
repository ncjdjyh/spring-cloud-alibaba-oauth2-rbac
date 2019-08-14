package com.ncjdjyh.series.oauth2.auth.config.service;

import com.google.common.collect.Lists;
import com.ncjdjyh.series.oauth2.auth.service.AuthService;
import com.ncjdjyh.series.oauth2.auth.util.JwtOperator;
import com.ncjdjyh.series.oauth2.dependencies.constant.DefaultSecurityConstants;
import com.ncjdjyh.series.oauth2.dependencies.entity.TbPermission;
import com.ncjdjyh.series.oauth2.dependencies.entity.TbUser;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: ncjdjyh
 * @FirstInitial: 2019/8/13
 * @Description: ~
 */
@Component("ssoUserDetailService")
public class SSOUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    AuthService authService;
    @Autowired
    JwtOperator jwtOperator;

    @Override
    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
        if (!jwtOperator.validateToken(token)) {
            throw new IllegalArgumentException("Token invalided.");
        }
        Claims claims = jwtOperator.getClaimsFromToken(token);
        String phone = parsePhoneFromClaims(claims);
        TbUser user = authService.getUserByName(phone, DefaultSecurityConstants.FROM_IN);
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        if (user != null) {
            List<TbPermission> userPermission = authService.getAllUserAuth(user.getId(), DefaultSecurityConstants.FROM_IN);
            userPermission.forEach(p -> {
                if (p != null && p.getUrl() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(p.getUrl());
                    grantedAuthorities.add(grantedAuthority);
                }
            });
        }
        return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }

    private String parsePhoneFromClaims(Claims claims) {
        return claims.get(DefaultSecurityConstants.TEL, String.class);
    }
}
