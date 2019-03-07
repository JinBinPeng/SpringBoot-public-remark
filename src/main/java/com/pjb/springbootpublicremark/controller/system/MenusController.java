package com.pjb.springbootpublicremark.controller.system;

import java.util.List;

import com.pjb.springbootpublicremark.constant.PageCodeEnum;
import com.pjb.springbootpublicremark.dto.MenuDto;
import com.pjb.springbootpublicremark.dto.MenuForMoveDto;
import com.pjb.springbootpublicremark.dto.MenuForZtreeDto;
import com.pjb.springbootpublicremark.dto.PageCodeDto;
import com.pjb.springbootpublicremark.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 菜单相关
 */
@RestController
@RequestMapping("/menus")
public class MenusController {
	
	@Autowired
	private MenuService menuService;
	
	/**
	 * 获取菜单列表
	 */
	@GetMapping
	public List<MenuForZtreeDto> getList() {
		return menuService.getZtreeList();
	}
	
	/**
	 * 新增菜单
	 */
	@PostMapping
	public PageCodeDto add(MenuDto menuDto) {
		PageCodeDto result;
		if(menuService.add(menuDto)) {
			result = new PageCodeDto(PageCodeEnum.ADD_SUCCESS);
		} else {
			result = new PageCodeDto(PageCodeEnum.ADD_FAIL);
		}
		return result;
	}
	
	/**
	 * 菜单排序
	 */
	@RequestMapping(value="/{dropNodeId}/{targetNodeId}/{moveType}",method = RequestMethod.PUT)
	public PageCodeDto order(MenuForMoveDto menuForMoveDto) {
		PageCodeDto result;
		if(menuService.order(menuForMoveDto)) {
			result = new PageCodeDto(PageCodeEnum.ORDER_SUCCESS);
		} else {
			result = new PageCodeDto(PageCodeEnum.ORDER_FAIL);
		}
		return result;
	}
	
	/**
	 * 根据主键获取菜单dto
	 */
	@GetMapping("/{id}")
	public MenuDto getById(@PathVariable("id") Long id) {
		return menuService.getById(id);
	}
	
	/**
	 * 修改菜单
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
	public PageCodeDto modify(MenuDto menuDto) {
		PageCodeDto result;
		if(menuService.modify(menuDto)) {
			result = new PageCodeDto(PageCodeEnum.MODIFY_SUCCESS);
		} else {
			result = new PageCodeDto(PageCodeEnum.MODIFY_FAIL);
		}
		return result;
	}
	
	/**
	 * 删除菜单
	 */
	@DeleteMapping("/{id}")
	public PageCodeDto remove(@PathVariable("id")Long id) {
		PageCodeDto result;
		MenuDto menuDto = new MenuDto();
		menuDto.setParentId(id);
		List<MenuDto> list = menuService.getList(menuDto);
		if(!list.isEmpty()) {
			result = new PageCodeDto(PageCodeEnum.SUB_MENU_EXISTS);
		} else {
			if(menuService.remove(id)) {
				result = new PageCodeDto(PageCodeEnum.REMOVE_SUCCESS);
			} else {
				result = new PageCodeDto(PageCodeEnum.REMOVE_FAIL);
			}
		}
		return result;
	}
}