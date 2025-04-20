package com.rs.filter;

import com.alibaba.fastjson.JSON;
import com.rs.domain.LoginUserDetail;
import com.rs.exception.pojo.BizException;
import com.rs.exception.pojo.ExceptionEnum;
import com.rs.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @FileName: JwtAuthonticationFilter
 * @Date: 2024/8/8:13:58
 * @Description:
 * @Author: RWG
 */
@Slf4j
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 获取请求路径
        String uri = request.getRequestURI();

        // 如果是注册或登录请求，直接放行
        if (uri.equals("/reg") || uri.equals("/login") || uri.equals("/foundMe") || uri.equals("/upload") || uri.equals("/webjars/**") || uri.equals("/route")) {
            filterChain.doFilter(request, response);
            return;
        }
        // 放行 Swagger 和 Knife4j 相关路径
        if (isSwaggerOrKnife4jPath(uri)) {
            filterChain.doFilter(request, response);
            return;
        }

        // 从请求头中获取 Authorization 参数
        String authHeader = request.getHeader("Authorization");
        // 检查 Authorization 头是否存在并以 "Bearer " 开头
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.sendError(4001,"token不存在");
            return;
        }
        // 去除 "Bearer " 前缀，得到实际的 token
        String token = authHeader.substring(7);
        LoginUserDetail loginUserDetail;
        try {
            // 解析 token
            Claims claims = JwtUtils.parseJwt(token);
            String loginUserString = claims.getSubject();
            loginUserDetail = JSON.parseObject(loginUserString,LoginUserDetail.class);
        } catch (Exception e) {
            // 为发送HTTP响应
            response.sendError(401,"token解析失败");
            return;
        }
        log.warn("用户名："+loginUserDetail.getEmp().geteName()+"，拥有权限"+loginUserDetail.getAuthorities()+"，当前正访问："+uri);
        // 将验证完的用户信息放入 SecurityContextHolder
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUserDetail, null, loginUserDetail.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        // 继续过滤链
        filterChain.doFilter(request, response);
    }
    /**
     * 判断是否为 Swagger 或 Knife4j 相关路径
     *
     * @param uri 请求路径
     * @return 是否为 Swagger 或 Knife4j 相关路径
     */
    private boolean isSwaggerOrKnife4jPath(String uri) {
        return
                uri.equals("/doc.html") ||
                uri.equals("/favicon.ico") ||
                uri.startsWith("/webjars/") ||
                uri.equals("/swagger-resources") ||
                uri.equals("/v2/api-docs") ||
                uri.equals("/v3/api-docs") ||
                uri.equals("/swagger-ui.html") ;

    }
}
