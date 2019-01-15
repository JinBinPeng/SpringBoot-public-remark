package com.pjb.springbootpublicremark.controller.system;

import com.pjb.springbootpublicremark.constant.PageCodeEnum;
import com.pjb.springbootpublicremark.dto.ActionDto;
import com.pjb.springbootpublicremark.dto.PageCodeDto;
import com.pjb.springbootpublicremark.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 动作相关
 */
@RestController
@RequestMapping("/actions")
public class ActionsController {
	
	@Autowired
	private ActionService actionService;
	
	/**
	 * 新增动作
	 */
	@PostMapping
	public PageCodeDto add(ActionDto actionDto) {
		PageCodeDto result;
		if(actionService.add(actionDto)) {
			result = new PageCodeDto(PageCodeEnum.ADD_SUCCESS);
		} else {
			result = new PageCodeDto(PageCodeEnum.ADD_FAIL);
		}
		return result;
	}
	
	/**
	 * 删除动作
	 */
	@DeleteMapping("/{id}")
	public PageCodeDto remove(@PathVariable("id")Long id) {
		PageCodeDto result;
		if(actionService.remove(id)) {
			result = new PageCodeDto(PageCodeEnum.REMOVE_SUCCESS);
		} else {
			result = new PageCodeDto(PageCodeEnum.REMOVE_FAIL);
		}
		return result;
	}

	/**
	 * 修改动作
	 */
	@PutMapping("/{id}")
	public PageCodeDto modify(ActionDto actionDto) {
		PageCodeDto result;
		if(actionService.modify(actionDto)) {
			result = new PageCodeDto(PageCodeEnum.MODIFY_SUCCESS);
		} else {
			result = new PageCodeDto(PageCodeEnum.MODIFY_FAIL);
		}
		return result;
	}
	
	/**
	 * 根据主键获取动作dto
	 */
	@GetMapping("/{id}")
	public ActionDto getById(@PathVariable("id") Long id) {
		return actionService.getById(id);
	}
}