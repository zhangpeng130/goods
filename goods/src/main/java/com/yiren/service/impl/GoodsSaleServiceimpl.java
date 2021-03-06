package com.yiren.service.impl;

import java.util.Date;
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
import com.yiren.vo.GoodsSaleVo;

@Service
public class GoodsSaleServiceimpl implements GoodsSaleService {
	@Resource
	private GoodsSaleDao goodsSaleDao;
	@Autowired
	private PoiService poiService;

	@Override
	public int addGoodsSale(GoodsSaleVo goodsSaleVo) {
		// TODO 权限校验
		// TODO GoodsSale重新定义vo，防止列暴露
		GoodsSale goodsSale = new GoodsSale();
		goodsSale.setBuyer(goodsSaleVo.getBuyer());
		goodsSale.setGoodsName(goodsSaleVo.getGoodsName());
		goodsSale.setAddress(goodsSaleVo.getAddress());
		goodsSale.setPhone(goodsSaleVo.getPhone());
		goodsSale.setPrice(goodsSaleVo.getPrice());
		goodsSale.setDebt(goodsSaleVo.getDebt());
		goodsSale.setRemark(goodsSaleVo.getRemark());

		goodsSale.setSeller("登录者");
		goodsSale.setBuyTime(new Date());// 后期支持手动修改
		goodsSale.setCreateTime(new Date());

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
		boolean importResult = false;
		try {
			String fileUrl = UploadUtils.uploadFile(importfile,
					ConstantPoi.POI_UPLOAD_PATH
							+ ConstantPoi.POI_UPLOAD_MODULE_SALE + "/");// 上传文件
			if (fileUrl != null) {
				importResult = importFileDataGoodsSale(fileUrl);// 导入文件数据
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				GoodsSale goodsSale = (GoodsSale) list.get(i);
				goodsSale.setSeller("登录者");
				insertCount += goodsSaleDao.insertGoodsSale(goodsSale);
			}
		}
		System.out.println(insertCount);
		if (insertCount > 0) {
			return true;
		}
		return false;
	}
}
