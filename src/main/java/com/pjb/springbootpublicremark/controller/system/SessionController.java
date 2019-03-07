package com.pjb.springbootpublicremark.controller.system;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.pjb.springbootpublicremark.constant.SessionKeyConst;
import com.pjb.springbootpublicremark.dto.MenuDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * session相关，从session中获取存放的资源
 */
@Controller
@RequestMapping("/session")
public class SessionController {
	@Autowired
	private HttpSession session;

	@GetMapping("/menus")
	@ResponseBody
	public List<MenuDto> getUserMenuList() {
		return (List<MenuDto>)session.getAttribute(SessionKeyConst.MENU_INFO);
	}

	/**
	 * 退出系统
	 */
	@DeleteMapping
	public String signOut() {
		session.invalidate();
		return "redirect:/login";
	}
}