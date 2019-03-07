package com.pjb.springbootpublicremark.controller.system;

import java.util.List;

import com.pjb.springbootpublicremark.constant.PageCodeEnum;
import com.pjb.springbootpublicremark.dto.GroupDto;
import com.pjb.springbootpublicremark.dto.PageCodeDto;
import com.pjb.springbootpublicremark.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户组相关
 */
@RestController
@RequestMapping("/groups")
public class GroupsController {

	@Autowired
	private GroupService groupService;

	/**
	 * 获取用户组列表
	 */
	@GetMapping
	public List<GroupDto> getList() {
		return groupService.getList();
	}

	/**
	 * 新增用户组
	 */
	@PostMapping
	public PageCodeDto add(GroupDto groupDto) {
		PageCodeDto result;
		if(groupService.add(groupDto)) {
			result = new PageCodeDto(PageCodeEnum.ADD_SUCCESS);
		} else {
			result = new PageCodeDto(PageCodeEnum.GROUPNAME_EXISTS);
		}
		return result;
	}
	
	/**
	 * 根据主键获取用户组dto
	 */
	@GetMapping("/{id}")
	public GroupDto getGroupById(@PathVariable("id") Long id) {
		return groupService.getById(id);
	}
	
	/**
	 * 修改用户组
	 */
	@PutMapping("/{id}")
	public PageCodeDto modify(GroupDto groupDto) {
		PageCodeDto result;
		if(groupService.modify(groupDto)) {
			result = new PageCodeDto(PageCodeEnum.MODIFY_SUCCESS);
		} else {
			result = new PageCodeDto(PageCodeEnum.GROUPNAME_EXISTS);
		}
		return result;
	}
	
	/**
	 * 删除用户组
	 */
	@DeleteMapping("/{id}")
	public PageCodeDto modify(@PathVariable("id")Long id) {
		PageCodeDto result;
		if(groupService.remove(id)) {
			result = new PageCodeDto(PageCodeEnum.REMOVE_SUCCESS);
		} else {
			result = new PageCodeDto(PageCodeEnum.REMOVE_FAIL);
		}
		return result;
	}
	
	/**
	 * 获取用户组对应可以访问的菜单和动作
	 */
	@GetMapping("/{id}/menus")
	public GroupDto getMenuList(@PathVariable("id")Long id) {
		return groupService.getByIdWithMenuAction(id);
	}
	
	/**
	 * 为用户组分配可以访问的菜单
	 */
	@PostMapping("/{id}/menus")
	public PageCodeDto assignMenu(GroupDto groupDto) {
		PageCodeDto result;
		if(groupService.assignMenu(groupDto)) {
			result = new PageCodeDto(PageCodeEnum.ASSIGN_SUCCESS);
		} else {
			result = new PageCodeDto(PageCodeEnum.ASSIGN_FAIL);
		}
		return result;
	}
}