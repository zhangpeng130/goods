package com.yiren.service;

import java.util.List;

import com.yiren.entity.GoodsInfo;

public interface GoodsInfoService {
	public int insertGoodsInfo(GoodsInfo goodsInfo );
    public List<GoodsInfo>  findGoodsInfo(GoodsInfo goodsInfo);
}
