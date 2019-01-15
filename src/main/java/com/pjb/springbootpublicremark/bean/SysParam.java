package com.pjb.springbootpublicremark.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class SysParam {
	private String paramKey;
	private Date paramValue;
	private String paramDesc;
}