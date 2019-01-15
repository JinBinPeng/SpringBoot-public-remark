package com.pjb.springbootpublicremark.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Member {
	private Long id;
    private Long phone;
    private String name;
    private String password;
}
