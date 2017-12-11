package com.yiren.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yiren.constant.ConstantPoi;
import com.yiren.dao.GoodsSaleDao;
import com.yiren.entity.GoodsSale;
import com.yiren.service.GoodsSaleService;
import com.yiren.service.PoiService;
import com.yiren.utils.UploadUtils;

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
	public boolean importGoodsSale(MultipartFile importfile) {
		String fileUrl = UploadUtils.uploadFile(importfile,
				ConstantPoi.POI_UPLOAD_PATH
						+ ConstantPoi.POI_UPLOAD_MODULE_SALE);// 上传文件
		boolean importResult = importFileDataGoodsSale(fileUrl);// 导入文件数据
		return importResult;
	}

	/**
	 * 导入上传的文件数据
	 * 
	 * @param fileUrl
	 * @return
	 */
	private boolean importFileDataGoodsSale(String fileUrl) {
		List list = poiService.getListFromXlsx("GoodsSale", fileUrl);
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
