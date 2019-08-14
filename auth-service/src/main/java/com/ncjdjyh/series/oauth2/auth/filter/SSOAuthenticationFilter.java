package com.ncjdjyh.series.oauth2.auth.filter;

import com.ncjdjyh.series.oauth2.auth.token.SSOAuthenticationToken;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: ncjdjyh
 * @FirstInitial: 2019/8/13
 * @Description: ~
 */
public class SSOAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    // ~ Static fields/initializers
    // =====================================================================================

    public static final String SPRING_SECURITY_FORM_USERNAME_KEY = "token";

    private String tokenParameter = SPRING_SECURITY_FORM_USERNAME_KEY;
    private boolean postOnly = true;

    // ~ Constructors
    // ===================================================================================================

    public SSOAuthenticationFilter() {
        super(new AntPathRequestMatcher("/login/social", "POST"));
    }

    // ~ Methods
    // ========================================================================================================

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        if (postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }

        String token = obtainToken(request);

        if (token == null) {
            token = "";
        }

        token = token.trim();

        SSOAuthenticationToken authRequest = new SSOAuthenticationToken(token);

        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }

    /**
     * Enables subclasses to override the composition of the username, such as by
     * including additional values and a separator.
     *
     * @param request so that request attributes can be retrieved
     * @return the username that will be presented in the <code>Authentication</code>
     * request token to the <code>AuthenticationManager</code>
     */
    protected String obtainToken(HttpServletRequest request) {
        return request.getHeader(tokenParameter);
    }

    /**
     * Provided so that subclasses may configure what is put into the authentication
     * request's details property.
     *
     * @param request     that an authentication request is being created for
     * @param authRequest the authentication request object that should have its details
     *                    set
     */
    protected void setDetails(HttpServletRequest request,
                              SSOAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }

    /**
     * Sets the parameter name which will be used to obtain the username from the login
     * request.
     *
     * @param tokenParameter the parameter name. Defaults to "username".
     */
    public void setTokenParameter(String tokenParameter) {
        Assert.hasText(tokenParameter, "Username parameter must not be empty or null");
        this.tokenParameter = tokenParameter;
    }

    /**
     * Defines whether only HTTP POST requests will be allowed by this filter. If set to
     * true, and an authentication request is received which is not a POST request, an
     * exception will be raised immediately and authentication will not be attempted. The
     * <tt>unsuccessfulAuthentication()</tt> method will be called as if handling a failed
     * authentication.
     * <p>
     * Defaults to <tt>true</tt> but may be overridden by subclasses.
     */
    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }

    public final String getTokenParameter() {
        return tokenParameter;
    }
}
