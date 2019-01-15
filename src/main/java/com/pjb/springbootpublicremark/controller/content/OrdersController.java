package com.pjb.springbootpublicremark.controller.content;

import com.pjb.springbootpublicremark.dto.AdDto;
import com.pjb.springbootpublicremark.dto.OrdersDto;
import com.pjb.springbootpublicremark.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/orders")
public class OrdersController {
	@Autowired
	OrdersService ordersService;
	@RequestMapping
	public String init(Model model, HttpServletRequest request) {
		OrdersDto ordersDto=new OrdersDto();
		model.addAttribute("list", ordersService.searchByPage(ordersDto));
		model.addAttribute("searchParam", ordersDto);
		return "/content/orderList";
	}
	/**
	 * 查询
	 */
	@RequestMapping("/search")
	public String search(Model model, OrdersDto ordersDto) {
		model.addAttribute("list", ordersService.searchByPage(ordersDto));
		model.addAttribute("searchParam", ordersDto);
		return "/content/orderList";
	}
}