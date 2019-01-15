package com.pjb.springbootpublicremark.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Group {
	private Long id;
	private String name;
	private List<Menu> menuList;
	private List<Action> actionList;
}