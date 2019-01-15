package com.pjb.springbootpublicremark.controller.content;

import com.alibaba.fastjson.JSONObject;
import com.pjb.springbootpublicremark.dto.AdDto;
import com.pjb.springbootpublicremark.dto.CommentDto;
import com.pjb.springbootpublicremark.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/comments")
public class CommentsController {
	@Autowired
	private CommentService commentService;
	/**
	 * 查询
	 */
	@GetMapping
	public String search(Model model, CommentDto commentDto) {
		model.addAttribute("list", commentService.searchByPage(commentDto));
		model.addAttribute("searchParam", commentDto);
		return "/content/commentList";
	}
}
