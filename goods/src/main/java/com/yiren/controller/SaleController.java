package com.yiren.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
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
	private static final Logger logger = Logger.getLogger(SaleController.class);
	@Autowired
	private GoodsSaleService goodsSaleService;
	@Autowired
	private PoiService poiService;

	@RequestMapping(value = "/SaleInput", method = { RequestMethod.POST })
	public String SaleInput(GoodsSaleVo goodsSaleVo, HttpServletRequest request) {
		String remoteAddr = request.getHeader("X-FORWARDED-FOR");
		remoteAddr = request.getRemoteAddr();
		System.out.println(remoteAddr);
		logger.info("正在录入:" + remoteAddr);
		logger.info(JSON.toJSONString(goodsSaleVo));
		if (ObjectUtils.checkObjFieldIsNotNull(goodsSaleVo)) {// 对象作为参数,是个大bug
			goodsSaleService.addGoodsSale(goodsSaleVo);
		}
		logger.info("录入结束:");
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
		logger.info("正在导入:" + importfile.getOriginalFilename());
		goodsSaleService.importGoodsSale(importfile);
		logger.info("导入结束:");
		return "/sale/findSaleRecord";

	}
}
