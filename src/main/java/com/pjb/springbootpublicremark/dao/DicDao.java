package com.pjb.springbootpublicremark.dao;

import java.util.List;

import com.pjb.springbootpublicremark.bean.Dic;

public interface DicDao {
    List<Dic> select(Dic dic);
}