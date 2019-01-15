package com.pjb.springbootpublicremark.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(Include.NON_NULL)
public class Orders extends BaseBean{
	private Long id;
	private Long memberId;
	private Long businessId;
	private Integer num;
	private Integer commentState;
	private Double price;
	private Business business;
	private Member member;
}