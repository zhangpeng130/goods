package com.yiren.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yiren.entity.GoodsSale;
import com.yiren.service.GoodsSaleService;


@Controller
@RequestMapping("/Sale")
public class SaleController {
@Autowired
private GoodsSaleService goodsSaleService;
@RequestMapping(value="/SaleInput")
public String SaleInput(GoodsSale goodsSale){	
	goodsSaleService.addGoodsSale(goodsSale);
	return null;
		
	}
}
