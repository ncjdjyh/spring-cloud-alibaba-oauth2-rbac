package com.ncjdjyh.series.oauth2.auth.token;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @Author: ncjdjyh
 * @FirstInitial: 2019/8/13
 * @Description: ~
 */
public class SSOAuthenticationToken extends AbstractAuthenticationToken {
    private  Object principal;

    public SSOAuthenticationToken(String token) {
        super(null);
        this.principal = token;
        setAuthenticated(false);
    }

    public SSOAuthenticationToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }
}
