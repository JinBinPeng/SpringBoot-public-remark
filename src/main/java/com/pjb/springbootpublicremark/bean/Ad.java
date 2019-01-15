package com.pjb.springbootpublicremark.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(Include.NON_NULL)
public class Ad extends BaseBean {
    private Long id;
    private String title;
    private String imgFileName;
    private String link;
    private Long weight;
}