package com.pjb.springbootpublicremark.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * token缓存，存放token与对应的用户信息（这里存放的是用户手机号）
 */
public class TokenCache {
    private static TokenCache instance;

    private Map<String, Long> tokenMap;

    private TokenCache() {
	tokenMap = new HashMap<>();
    }

    public static synchronized TokenCache getInstance() {
	if (instance == null) {
		    instance = new TokenCache();
	}
	return instance;
    }

    /**
     * 保存token与对应的手机号
     */
    public void save(String token, Long phone) {
	tokenMap.put(token, phone);
    }

    /**
     * 根据token获取用户信息(手机号)
     */
    public Long getPhone(String token) {
	return tokenMap.get(token);
    }
}