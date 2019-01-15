package com.pjb.springbootpublicremark.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(Include.NON_NULL)
public class Comment extends BaseBean {
	private Long id;
	private String comment;
	private Integer star;
	private Long ordersId;
	private Date createTime;
	private Orders orders;
}
