package com.yiren.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yiren.dao.GoodsSaleDao;
import com.yiren.entity.GoodsInfo;
import com.yiren.entity.GoodsSale;
import com.yiren.service.GoodsSaleService;
@Service
public class GoodsSaleServiceimpl implements GoodsSaleService{
@Resource
	private GoodsSaleDao goodsSaleDao;

@Override
public int addGoodsSale(GoodsSale goodsSale) {
	//TODO 权限校验
	//TODO GoodsSale重新定义vo，防止列暴露
	int insertCount=goodsSaleDao.insertGoodsSale(goodsSale);
	return insertCount;
}

@Override
public List<GoodsInfo> findGoodsSale(GoodsInfo goodsInfo) {
	// TODO Auto-generated method stub
	return null;
}

	

}
