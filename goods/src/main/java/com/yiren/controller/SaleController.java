package com.yiren.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yiren.entity.GoodsSale;
import com.yiren.service.GoodsSaleService;
import com.yiren.service.PoiService;
import com.yiren.utils.ObjectUtils;
import com.yiren.vo.GoodsSaleVo;

@Controller
@RequestMapping("/Sale")
public class SaleController {
	@Autowired
	private GoodsSaleService goodsSaleService;
	@Autowired
	private PoiService poiService;

	@RequestMapping(value = "/SaleInput", method = { RequestMethod.POST })
	public String SaleInput(GoodsSaleVo goodsSaleVo) {
		if (ObjectUtils.checkObjFieldIsNotNull(goodsSaleVo)) {// 对象作为参数,是个大bug
			goodsSaleService.addGoodsSale(goodsSaleVo);
		}
		return "/sale/findSaleRecord";

	}

	@RequestMapping(value = "/FindSaleRecord")
	@ResponseBody
	public JSONArray FindSaleRecord(GoodsSale goodsSale) {
		List<GoodsSale> goodsSaleList = goodsSaleService
				.findGoodsSale(goodsSale);

		// String json = JSONArray.toJSONString(goodsSaleList);
		String json = JSONArray.toJSONString(goodsSaleList,
				SerializerFeature.WriteDateUseDateFormat);
		JSONArray userList1 = JSONArray.parseArray(json);// bootStrap只支持array
		return userList1;

	}

	@RequestMapping(value = "/GoodsSaleImport")
	public String GoodsSaleImport(
			@RequestParam(value = "inputfile") MultipartFile importfile) {
		goodsSaleService.importGoodsSale(importfile);
		return "/sale/findSaleRecord";

	}
}
