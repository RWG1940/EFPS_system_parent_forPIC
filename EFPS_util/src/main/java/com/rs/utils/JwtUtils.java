package com.rs.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.rs.exception.pojo.BizException;
import com.rs.exception.pojo.ExceptionEnum;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * @FileName: JwtUtils
 * @Date: 2024/7/27:21:46
 * @Description: JWT令牌生成与解析
 * @Author: RWG
 */
public class JwtUtils {
    private static final String SIGN_KEY = "loveSJM";
    private static final long DEFAULT_EXPIRE = 43200000L; // 12小时

    public static String generateJwt(Map<String, Object> claims, Long expire) {
        if (expire == null) {
            expire = DEFAULT_EXPIRE;
        }
        String jwt = Jwts.builder()
                .setSubject(JSON.toJSONString(claims))
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, SIGN_KEY)
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .compact();
        return jwt;
    }

    public static Claims parseJwt(String jwt) {
        Claims claims = Jwts.parser()
                .setSigningKey(SIGN_KEY)
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }

    public static boolean validateToken(String jwt) {
        try {
            Claims claims = parseJwt(jwt);
            return !isTokenExpired(claims);
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isTokenExpired(Claims claims) {
        Date expiration = claims.getExpiration();
        return expiration.before(new Date());
    }

    /**
     * 从JSON字符串生成JWT令牌。
     *
     * @param jsonString JSON字符串
     * @param expire 过期时间（毫秒），如果为null则使用默认值
     * @return 生成的JWT令牌
     */
    public static String generateJwtFromJson(String jsonString, Long expire) {
        Map<String, Object> claims = JSON.parseObject(jsonString, new TypeReference<Map<String, Object>>(){});
        long actualExpire = (expire != null) ? expire : DEFAULT_EXPIRE;
        return generateJwt(claims, actualExpire);
    }

    public static String getUsernameFromToken(String token) {
        try {
            Claims claims = parseJwt(token);
            return claims.get("username", String.class);
        } catch (Exception e) {
            throw new BizException(ExceptionEnum.NOT_FOUND);
        }
    }
}
