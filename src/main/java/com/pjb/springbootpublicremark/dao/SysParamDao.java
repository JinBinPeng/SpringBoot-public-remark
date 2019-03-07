package com.pjb.springbootpublicremark.dao;

import com.pjb.springbootpublicremark.bean.SysParam;
import org.springframework.stereotype.Component;

@Component
public interface SysParamDao {
	
	/**
	 * 根据KEY获取对应的系统参数值
	 * @return 系统参数值
	 */
	SysParam selectByKey(String key);
	
	/**
	 * 根据KEY修改对应的系统参数值
	 * @return 影响行数
	 */
	int updateByKey(SysParam sysParam);
}