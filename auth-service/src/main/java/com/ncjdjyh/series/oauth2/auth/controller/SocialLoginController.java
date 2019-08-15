package com.ncjdjyh.series.oauth2.auth.controller;

import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ncjdjyh
 * @FirstInitial: 2019/8/12
 * @Description: ~
 */
@RestController
public class SocialLoginController {
//    private static String GITHUB_CLIENT_ID = "d29e313c82b3ea9819d1";
//    private static String GITHUB_CLIENT_SECRET = "6b0e1c338062d2910d72982222258f3e740a1584";
//    private static String GITHUB_REDIRECT_URL = "http://localhost:5099/auth/github/callback";
//    private ThreadLocal randLocal = new ThreadLocal();
//
//    @RequestMapping("/github/callback")
//    public void githubCallback(String code, String state, HttpServletResponse response) throws Exception {
//        if (!StringUtils.equalsIgnoreCase(state, randLocal.get().toString())) {
//            throw new IllegalArgumentException("状态错误");
//        }
//        String url = "https://github.com/login/oauth/access_token";
//        String param = "grant_type=authorization_code&code=" + code + "&redirect_uri=" +
//                GITHUB_REDIRECT_URL + "&client_id=" + GITHUB_CLIENT_ID + "&client_secret=" + GITHUB_CLIENT_SECRET;
//        String result = HttpUtil.post(url, param);
//        Map<String, String> resultMap = HttpUtil.decodeParamMap(result, "utf-8");
//        if (resultMap.containsKey("error")) {
//            throw new Exception(resultMap.get("error_description"));
//        }
//
//        if (!resultMap.containsKey("access_token")) {
//            throw new Exception("获取token失败");
//        }
//        String accessToken = resultMap.get("access_token");
//        String tokenType = resultMap.get("token_type");
//        String userUrl = "https://api.github.com/user";
//        String userParam = "?access_token=" + accessToken + "&token_type=" + tokenType;
//        String userResult = HttpUtil.get(userUrl + userParam);
//        response.setContentType("text/html;charset=utf-8");
//        response.getWriter().write(userResult);
//    }
//
//    @RequestMapping("/login/github")
//    public void githubLogin(HttpServletResponse response) throws Exception {
//        String state = RandomUtil.randomString(4);
//        randLocal.set(state);
//        String url = "https://github.com/login/oauth/authorize";
//        String param = "response_type=code&" + "client_id=" + GITHUB_CLIENT_ID + "&state=" + state
//                + "&redirect_uri=" + GITHUB_REDIRECT_URL;
//        response.sendRedirect(url + "?" + param);
//    }
}
