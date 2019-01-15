package com.pjb.springbootpublicremark.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Menu {
	private Long id;
	private String name;
	private String url;
	private Long parentId;
	private Integer orderNum;
	private List<Action> actionList;
}