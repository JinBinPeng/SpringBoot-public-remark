package com.pjb.springbootpublicremark.dao;

import java.util.List;

import com.pjb.springbootpublicremark.bean.Dic;
import org.springframework.stereotype.Component;

@Component
public interface DicDao {
    List<Dic> select(Dic dic);
}