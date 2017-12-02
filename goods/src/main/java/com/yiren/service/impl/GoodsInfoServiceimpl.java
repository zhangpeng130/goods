package com.yiren.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.yiren.dao.GoodsInfoDao;
import com.yiren.entity.GoodsInfo;
import com.yiren.service.GoodsInfoService;
@Service
public class GoodsInfoServiceimpl implements GoodsInfoService{
@Resource
	private GoodsInfoDao goodsInfoDao;

	public GoodsInfoDao getGoodsInfoDao() {
		return goodsInfoDao;
	}


	public void setGoodsInfoDao(GoodsInfoDao goodsInfoDao) {
		this.goodsInfoDao = goodsInfoDao;
	}


	@Override
	public int insertGoodsInfo(GoodsInfo goodsInfo) {
	
		return goodsInfoDao.insertGoodsInfo(goodsInfo);
	}


	@Override
	public List<GoodsInfo> findGoodsInfo(GoodsInfo goodsInfo) {
		
		return goodsInfoDao.findGoodsInfo(goodsInfo);
	}

}
