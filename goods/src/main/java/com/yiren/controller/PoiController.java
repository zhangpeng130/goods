package com.yiren.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Deprecated
@Controller
@RequestMapping("/Poi")
public class PoiController {

	// @RequestMapping(value = "/GoodsSaleImport")
	// public String GoodsSaleImport() {
	//
	// return "/sale/findSaleRecord";
	//
	// }

	// @RequestMapping(value = "/FindSaleRecord")
	// @ResponseBody
	// public JSONArray FindSaleRecord(GoodsSale goodsSale) {
	// List<GoodsSale> goodsSaleList = goodsSaleService
	// .findGoodsSale(goodsSale);
	// String json = JSONArray.toJSONString(goodsSaleList);
	// JSONArray userList1 = JSONArray.parseArray(json);//
	// return userList1;
	//
	// }
}
