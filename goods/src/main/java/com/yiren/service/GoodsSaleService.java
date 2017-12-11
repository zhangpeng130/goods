package com.yiren.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.yiren.entity.GoodsSale;
import com.yiren.vo.GoodsSaleVo;

/**
 * 
 * @author peng
 *
 */
public interface GoodsSaleService {
	public int addGoodsSale(GoodsSaleVo goodsSaleVo);

	public List<GoodsSale> findGoodsSale(GoodsSale goodsSale);

	public boolean importGoodsSale(MultipartFile importfile);
}
