package com.yiren.controller;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import com.alibaba.fastjson.JSONArray;
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
	return "/sale/findSaleRecord";
		
	}
@RequestMapping(value="/FindSaleRecord")
@ResponseBody
public   JSONArray    FindSaleRecord(GoodsSale goodsSale){	
	List<GoodsSale> goodsSaleList=goodsSaleService.findGoodsSale(goodsSale);	
	String json=JSONArray.toJSONString(goodsSaleList);
	JSONArray userList1 = JSONArray.parseArray(json);//
	return userList1;
	
		
	}
}
