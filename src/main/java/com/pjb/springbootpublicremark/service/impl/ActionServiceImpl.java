package com.pjb.springbootpublicremark.service.impl;

import com.pjb.springbootpublicremark.bean.Action;
import com.pjb.springbootpublicremark.dao.ActionDao;
import com.pjb.springbootpublicremark.dto.ActionDto;
import com.pjb.springbootpublicremark.service.ActionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ActionServiceImpl implements ActionService {
	
	@Autowired
	private ActionDao actionDao;
	
	@Override
	public boolean add(ActionDto dto) {
		return actionDao.insert(dto) == 1;
	}

	@Override
	public boolean remove(Long id) {
		return actionDao.deleteById(id) == 1;
	}

	@Override
	public boolean modify(ActionDto dto) {
		Action action = new Action();
		BeanUtils.copyProperties(dto,action);
		return actionDao.update(action) == 1;
	}

	@Override
	public ActionDto getById(Long id) {
		ActionDto result = new ActionDto();
		Action action = actionDao.selectById(id);
		BeanUtils.copyProperties(action, result);
		return result;
	}
}
