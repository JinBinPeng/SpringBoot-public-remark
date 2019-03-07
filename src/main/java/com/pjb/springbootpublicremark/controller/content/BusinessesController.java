package com.pjb.springbootpublicremark.controller.content;

import com.pjb.springbootpublicremark.constant.DicTypeConst;
import com.pjb.springbootpublicremark.constant.PageCodeEnum;
import com.pjb.springbootpublicremark.dto.BusinessDto;
import com.pjb.springbootpublicremark.service.BusinessService;
import com.pjb.springbootpublicremark.service.DicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

@Controller
@RequestMapping("/businesses")
public class BusinessesController {

	@Resource
	private DicService dicService;

	@Resource
	private BusinessService businessService;

	/**
	 * 商户列表
	 */
	@GetMapping
	public String search(Model model, BusinessDto dto) {
		model.addAttribute("list", businessService.searchByPage(dto));
		model.addAttribute("searchParam", dto);
		return "/content/businessList";
	}
	/**
	 * 删除商户
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String remove(@PathVariable("id") Long id) {
		return "redirect:/businesses";
	}

	/**
	 * 商户新增页初始化
	 */
	@RequestMapping(value = "/addPage", method = RequestMethod.GET)
	public String addInit(Model model) {
		model.addAttribute("cityList", dicService.getListByType(DicTypeConst.CITY));
		model.addAttribute("categoryList", dicService.getListByType(DicTypeConst.CATEGORY));
		return "/content/businessAdd";
	}

	/**
	 * 商户新增
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String add(BusinessDto dto,RedirectAttributes attr) {
		if(businessService.add(dto)) {
			attr.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_SUCCESS);
			return "redirect:/businesses";
		} else {
			attr.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_FAIL);
			return "redirect:/businesses/addPage";
		}
	}

	/**
	 * 商户修改页初始化
	 */
	@GetMapping("/{id}")
	public String modifyInit(Model model, @PathVariable("id") Long id) {
		model.addAttribute("cityList", dicService.getListByType(DicTypeConst.CITY));
		model.addAttribute("categoryList", dicService.getListByType(DicTypeConst.CATEGORY));
		model.addAttribute("modifyObj", businessService.getById(id));
		return "/content/businessModify";
	}

	/**
	 * 商户修改
	 */
	@PutMapping("/{id}")
	public String modify(@PathVariable("id") Long id) {
		return "/content/businessModify";
	}
}