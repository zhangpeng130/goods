package com.yiren.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.yiren.entity.GoodsSale;
import com.yiren.service.PoiService;

@Service
public class PoiServiceimpl implements PoiService {
	/**
	 * 从xlxs文件中,获取实体类List
	 * 
	 * @param entityMark
	 * @param path
	 *            PS "D:/study/poi/POI模板.xlsx"
	 * 
	 * @return
	 */
	public List getListFromXlsx(String entityMark, String path) {
		// String path = "D:/study/poi/POI模板.xlsx";
		return listToEntityList(entityMark, path);
	}

	/**
	 * (Object)List 转(具体实体类)List
	 * 
	 * @param entityMark
	 * @return
	 */
	public List listToEntityList(String entityMark, String path) {
		List rowlist = xlsxFileToList(path);
		List list = new ArrayList();
		if (rowlist != null && rowlist.size() > 0) {
			for (int i = 0; i < rowlist.size(); i++) {
				Map rowMap = (Map) rowlist.get(i);
				Set rowMapSet = rowMap.keySet();
				Iterator keySetIterator = rowMapSet.iterator();
				GoodsSale goodsSale = null;
				if ("GoodsSale".equals(entityMark)) {
					goodsSale = new GoodsSale();
				}
				while (keySetIterator.hasNext()) {
					Object key = keySetIterator.next();
					Object value = rowMap.get(key);
					if ("GoodsSale".equals(entityMark)) {
						mapToGoodsSale(key, value, goodsSale);
					}
				}
				if ("GoodsSale".equals(entityMark)) {
					list.add(goodsSale);
				}
			}
		}
		return list;
	}

	/**
	 * xlsx文件内容转为(Object)List
	 * 
	 * @param path
	 * @return
	 */
	public List xlsxFileToList(String path) {
		XSSFWorkbook xssFWorkbook = null;
		try {
			xssFWorkbook = new XSSFWorkbook(path);
			XSSFSheet sheet = xssFWorkbook.getSheetAt(0);
			Iterator<Row> rowIt = sheet.iterator();
			List rowList = new ArrayList();
			while (rowIt.hasNext()) {
				Row row = rowIt.next();
				if (row.getRowNum() == 0) {
					continue;
				}
				Iterator<Cell> cellIt = row.cellIterator();
				Map rowMap = new HashMap();
				while (cellIt.hasNext()) {
					Cell cell = cellIt.next();
					if (cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
						rowMap.put(cell.getColumnIndex(),
								cell.getNumericCellValue());
					} else if (cell.CELL_TYPE_STRING == cell.getCellType()) {
						rowMap.put(cell.getColumnIndex(),
								cell.getStringCellValue());
					}
				}
				rowList.add(rowMap);
			}
			return rowList;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (xssFWorkbook != null) {
				try {
					xssFWorkbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	/**
	 * 实体属性与xlsx文件Cell的位置映射
	 * 
	 * @param key
	 * @param value
	 * @param goodsSale
	 */
	public void mapToGoodsSale(Object key, Object value, GoodsSale goodsSale) {
		Map routeMap = new HashMap();
		routeMap.put(0, "buyer");
		routeMap.put(1, "goodsName");
		routeMap.put(2, "address");
		routeMap.put(3, "phone");
		routeMap.put(4, "price");
		routeMap.put(5, "debt");
		routeMap.put(6, "repay");
		routeMap.put(7, "remark");
		routeMap.put(8, "buyTime");
		String tempKey = routeMap.get(key) != null ? routeMap.get(key)
				.toString() : null;
		if (tempKey != null) {
			if ("buyer".equals(tempKey)) {
				goodsSale.setBuyer(value.toString());
			}
			if ("goodsName".equals(tempKey)) {
				goodsSale.setGoodsName(value.toString());
			}
			if ("address".equals(tempKey)) {
				goodsSale.setAddress(value.toString());
			}
			if ("phone".equals(tempKey)) {
				goodsSale.setPhone(value.toString());
			}
			if (value instanceof Double) {
				if ("price".equals(tempKey)) {
					goodsSale.setPrice(new BigDecimal((Double) value));
				}
				if ("debt".equals(tempKey)) {
					goodsSale.setDebt(new BigDecimal((Double) value));
				}
				if ("repay".equals(tempKey)) {
					goodsSale.setRepay(new BigDecimal((Double) value));
				}
				if ("buyTime".equals(tempKey)) {
					goodsSale.setBuyTime(DateUtil.getJavaDate((Double) value));
				}
			}
			if ("remark".equals(tempKey)) {
				goodsSale.setRemark(value.toString());
			}
		}
	}
}
