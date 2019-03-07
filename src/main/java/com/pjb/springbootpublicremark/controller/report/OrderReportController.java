package com.pjb.springbootpublicremark.controller.report;

import com.pjb.springbootpublicremark.dto.echarts.Option;
import com.pjb.springbootpublicremark.dto.echarts.Serie;
import com.pjb.springbootpublicremark.service.OrderReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/orderReport")
public class OrderReportController {
	
	@Autowired
	private OrderReportService orderReportService;
	
	@RequestMapping
	public String index() {
		return "/report/orderCount";
	}

	@GetMapping("/count")
	@ResponseBody
	public Option count() throws NoSuchAlgorithmException {
		Option option = orderReportService.count();
		String[] names = new String[]{"电影","结婚","美食"};
		option.getLegend().setData(Arrays.asList(names));
		Random rand = SecureRandom.getInstanceStrong();
		List<Serie> series = new ArrayList<>();
		for(String name : names) {
			Serie serie = new Serie();
			series.add(serie);
			serie.setName(name);
			serie.setType("line");
			for(int i = 0; i < 24; i++) {
				serie.getData().add((long) rand.nextInt(1000));
			}
		}
		option.setSeries(series);
		return option;
	}
}