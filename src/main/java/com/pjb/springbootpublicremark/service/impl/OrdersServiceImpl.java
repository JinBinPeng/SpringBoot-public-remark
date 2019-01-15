package com.pjb.springbootpublicremark.service.impl;

import com.pjb.springbootpublicremark.bean.Orders;
import com.pjb.springbootpublicremark.constant.CommentStateConst;
import com.pjb.springbootpublicremark.dao.OrdersDao;
import com.pjb.springbootpublicremark.dto.OrdersDto;
import com.pjb.springbootpublicremark.service.OrdersService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

	@Resource
	private OrdersDao ordersDao;
	
	@Value("${businessImage.url}")
    private String businessImageUrl;

	@Override
	public boolean add(OrdersDto ordersDto) {
		Orders orders = new Orders();
		BeanUtils.copyProperties(ordersDto, orders);
		orders.setCommentState(CommentStateConst.NOT_COMMENT);
		ordersDao.insert(orders);
		return true;
	}

	@Override
	public OrdersDto getById(Long id) {
		OrdersDto result = new OrdersDto();
		Orders orders = ordersDao.selectById(id);
		BeanUtils.copyProperties(orders, result);
		return result;
	}

	@Override
	public List<OrdersDto> getListByMemberId(Long memberId) {
		List<OrdersDto> result = new ArrayList<>();
		Orders ordersForSelect = new Orders();
		ordersForSelect.setMemberId(memberId);
		List<Orders>  ordersList = ordersDao.select(ordersForSelect);
		for(Orders orders : ordersList) {
			OrdersDto ordersDto = new OrdersDto();
			result.add(ordersDto);
			BeanUtils.copyProperties(orders, ordersDto);
			ordersDto.setImg(businessImageUrl + orders.getBusiness().getImgFileName());
			ordersDto.setTitle(orders.getBusiness().getTitle());
			ordersDto.setCount(orders.getBusiness().getNumber());
		}
		return result;
	}

	@Override
	public List<OrdersDto> searchByPage(OrdersDto ordersDto) {
		List<OrdersDto> result = new ArrayList<>();
		Orders condition = new Orders();
		BeanUtils.copyProperties(ordersDto, condition);
		List<Orders> ordersList = ordersDao.selectByPage(condition);
		for (Orders orders : ordersList) {
			OrdersDto ordersDtoTemp = new OrdersDto();
			result.add(ordersDtoTemp);
			BeanUtils.copyProperties(orders, ordersDtoTemp);
		}
		return result;
	}
}