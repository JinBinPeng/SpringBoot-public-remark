package com.pjb.springbootpublicremark.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Action {
	private Long id;
	private String name;
	private String url;
	private Long menuId;
	private String method;
}
