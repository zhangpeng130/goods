package com.yiren.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiren.dao.GoodsSaleDao;
import com.yiren.entity.GoodsSale;
import com.yiren.service.GoodsSaleService;
import com.yiren.service.PoiService;

@Service
public class GoodsSaleServiceimpl implements GoodsSaleService {
	@Resource
	private GoodsSaleDao goodsSaleDao;
	@Autowired
	private PoiService poiService;

	@Override
	public int addGoodsSale(GoodsSale goodsSale) {
		// TODO 权限校验
		// TODO GoodsSale重新定义vo，防止列暴露
		int insertCount = goodsSaleDao.insertGoodsSale(goodsSale);
		return insertCount;
	}

	@Override
	public List<GoodsSale> findGoodsSale(GoodsSale goodsSale) {
		// TODO Auto-generated method stub
		List<GoodsSale> goodsSaleList = goodsSaleDao.findGoodsSale(null);
		return goodsSaleList;
	}

	@Override
	public boolean importGoodsSale(String path) {
		List list = poiService.getListFromXlsx("GoodsSale", path);
		int insertCount = 0;
		for (int i = 0; i < list.size(); i++) {
			GoodsSale goodsSale = (GoodsSale) list.get(i);
			insertCount += goodsSaleDao.insertGoodsSale(goodsSale);
		}
		System.out.println(insertCount);
		if (insertCount > 0) {
			return true;
		}
		return false;
	}
}
