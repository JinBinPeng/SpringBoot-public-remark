package com.pjb.springbootpublicremark.service.impl;

import java.util.List;
import javax.annotation.Resource;
import com.pjb.springbootpublicremark.bean.Dic;
import com.pjb.springbootpublicremark.dao.DicDao;
import com.pjb.springbootpublicremark.service.DicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DicServiceImpl implements DicService {
    
    @Resource
    private DicDao dicDao;
    
    @Override
    public List<Dic> getListByType(String type) {
	Dic dic = new Dic();
	dic.setType(type);
	return dicDao.select(dic);
    }
}
