package com.yiren.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.yiren.entity.GoodsSale;
import com.yiren.service.GoodsSaleService;
import com.yiren.service.PoiService;

@Controller
@RequestMapping("/Sale")
public class SaleController {
	@Autowired
	private GoodsSaleService goodsSaleService;
	@Autowired
	private PoiService poiService;

	@RequestMapping(value = "/SaleInput")
	public String SaleInput(GoodsSale goodsSale) {
		goodsSaleService.addGoodsSale(goodsSale);
		return "/sale/findSaleRecord";

	}

	@RequestMapping(value = "/FindSaleRecord")
	@ResponseBody
	public JSONArray FindSaleRecord(GoodsSale goodsSale) {
		List<GoodsSale> goodsSaleList = goodsSaleService
				.findGoodsSale(goodsSale);
		String json = JSONArray.toJSONString(goodsSaleList);
		JSONArray userList1 = JSONArray.parseArray(json);// bootStrap支持array
		return userList1;

	}

	@RequestMapping(value = "/GoodsSaleImport")
	public String GoodsSaleImport(
			@RequestParam(value = "inputfile") MultipartFile importfile) {
		goodsSaleService.importGoodsSale(importfile);
		return "/sale/findSaleRecord";

	}
}
