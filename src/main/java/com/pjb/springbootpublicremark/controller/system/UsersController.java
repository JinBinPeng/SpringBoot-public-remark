package com.pjb.springbootpublicremark.controller.system;

import java.util.List;

import com.pjb.springbootpublicremark.constant.PageCodeEnum;
import com.pjb.springbootpublicremark.dto.PageCodeDto;
import com.pjb.springbootpublicremark.dto.UserDto;
import com.pjb.springbootpublicremark.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户相关
 */
@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UserService userService;

	/**
	 * 获取用户列表
	 */
	@GetMapping
	public List<UserDto> getList() {
		return userService.getList();
	}

	/**
	 * 新增用户
	 */
	@RequestMapping(method = RequestMethod.POST)
	public PageCodeDto add(UserDto userDto) {
		PageCodeDto result;
		if(userService.add(userDto)) {
			result = new PageCodeDto(PageCodeEnum.ADD_SUCCESS);
		} else {
			result = new PageCodeDto(PageCodeEnum.USERNAME_EXISTS);
		}
		return result;
	}
	
	/**
	 * 根据主键获取用户dto
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public UserDto getById(@PathVariable("id") Long id) {
		return userService.getById(id);
	}
	
	/**
	 * 修改用户
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
	public PageCodeDto modify(UserDto userDto) {
		PageCodeDto result;
		if(userService.modify(userDto)) {
			result = new PageCodeDto(PageCodeEnum.MODIFY_SUCCESS);
		} else {
			result = new PageCodeDto(PageCodeEnum.USERNAME_EXISTS);
		}
		return result;
	}
	
	/**
	 * 删除用户
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public PageCodeDto remove(@PathVariable("id")Long id) {
		PageCodeDto result;
		if(userService.remove(id)) {
			result = new PageCodeDto(PageCodeEnum.REMOVE_SUCCESS);
		} else {
			result = new PageCodeDto(PageCodeEnum.REMOVE_FAIL);
		}
		return result;
	}
}