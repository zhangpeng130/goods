package com.yiren.service;

import java.util.List;

import com.yiren.entity.GoodsSale;
/**
 * 
 * @author peng
 *
 */
public interface GoodsSaleService {
	public int addGoodsSale(GoodsSale goodsSale);
    public List<GoodsSale>  findGoodsSale(GoodsSale goodsSale);
}
