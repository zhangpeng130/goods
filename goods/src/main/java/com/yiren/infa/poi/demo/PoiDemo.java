package com.yiren.infa.poi.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.alibaba.fastjson.JSON;
import com.yiren.entity.GoodsSale;

public class PoiDemo {
	public static void main(String[] args) {
		try {
			sysoutList();
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void sysoutList() throws InvalidFormatException, IOException {
		List list = parseToEntity();
		for (int i = 0; i < list.size(); i++) {
			GoodsSale gs = (GoodsSale) list.get(i);
			System.out.println(JSON.toJSONString(gs));
		}
	}

	public static List parseToEntity() throws InvalidFormatException,
			IOException {
		List rowlist = poiTest1();
		List goodsSaleList = new ArrayList();
		for (int i = 0; i < rowlist.size(); i++) {
			Map rowMap = (Map) rowlist.get(i);
			Set rowMapSet = rowMap.keySet();
			Iterator keySetIterator = rowMapSet.iterator();
			GoodsSale goodsSale = new GoodsSale();
			while (keySetIterator.hasNext()) {
				// System.out.print(keySetIterator.next());
				Object key = keySetIterator.next();
				Object value = rowMap.get(key);
				// System.out.print(key + "(" + rowMap.get(key) + ")");
				mapToEntity(key, value, goodsSale);
			}
			// System.out.println();
			goodsSaleList.add(goodsSale);
		}
		return goodsSaleList;
	}

	public static void mapToEntity(Object key, Object value, GoodsSale goodsSale) {
		Map tempMap = new HashMap();
		tempMap.put(0, "buyer");
		tempMap.put(1, "goodsName");
		tempMap.put(2, "address");
		tempMap.put(3, "phone");
		String tempKey = tempMap.get(key) != null ? tempMap.get(key).toString()
				: null;
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
		}
	}

	public static List poiTest1() throws InvalidFormatException, IOException {
		XSSFWorkbook xssFWorkbook = new XSSFWorkbook("D:/study/poi/POI模板.xlsx");
		XSSFSheet sheet = xssFWorkbook.getSheetAt(0);
		Iterator<Row> rowIt = sheet.iterator();
		List rowList = new ArrayList();
		while (rowIt.hasNext()) {
			Row row = rowIt.next();
			Iterator<Cell> cellIt = row.cellIterator();
			Map rowMap = new HashMap();
			while (cellIt.hasNext()) {
				Cell cell = cellIt.next();
				if (cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
					// System.out.print(cell.getNumericCellValue() + "("
					// + cell.getColumnIndex() + ")-");
					rowMap.put(cell.getColumnIndex(),
							cell.getNumericCellValue());
				} else if (cell.CELL_TYPE_STRING == cell.getCellType()) {
					// System.out.print(cell.getStringCellValue() + "("
					// + cell.getColumnIndex() + ")-");
					rowMap.put(cell.getColumnIndex(), cell.getStringCellValue());
				}
			}
			System.out.println();
			rowList.add(rowMap);
		}
		return rowList;
	}

	public static void poiTest0() throws InvalidFormatException, IOException {
		XSSFWorkbook xssFWorkbook = new XSSFWorkbook("D:/study/poi/POI模板.xlsx");
		XSSFSheet sheet = xssFWorkbook.getSheetAt(0);
		Iterator<Row> rowIt = sheet.iterator();
		List rowList = new ArrayList();
		while (rowIt.hasNext()) {
			Row row = rowIt.next();
			Iterator<Cell> cellIt = row.cellIterator();
			Map rowMap = new HashMap();
			while (cellIt.hasNext()) {
				Cell cell = cellIt.next();
				if (cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
					System.out.print(cell.getNumericCellValue() + "("
							+ cell.getColumnIndex() + ")-");
					rowMap.put(cell.getColumnIndex(),
							cell.getNumericCellValue());
				} else if (cell.CELL_TYPE_STRING == cell.getCellType()) {
					System.out.print(cell.getStringCellValue() + "("
							+ cell.getColumnIndex() + ")-");
					rowMap.put(cell.getColumnIndex(), cell.getStringCellValue());
				}
			}
			System.out.println();
			rowList.add(rowMap);
		}
	}
	/*
	 * public static void poiTest() throws InvalidFormatException, IOException {
	 * XSSFWorkbook xssFWorkbook = new XSSFWorkbook("D:/study/poi/POI模板.xlsx");
	 * XSSFSheet sheet = xssFWorkbook.getSheetAt(0); // XSSFSheet sheet =
	 * xssFWorkbook.getSheet("Sheet1"); // /XSSFComment comment =
	 * sheet.getCellComment(1, 1); // System.out.println(comment.getString());
	 * // Row Row = sheet.iterator(); Iterator<Row> rowIt = sheet.iterator();
	 * while (rowIt.hasNext()) { Row row = rowIt.next(); Iterator<Cell> cellIt =
	 * row.cellIterator(); Map cellMap = new HashMap(); while (cellIt.hasNext())
	 * { Cell cell = cellIt.next(); if (cell.CELL_TYPE_NUMERIC ==
	 * cell.getCellType()) { System.out.print(cell.getNumericCellValue() + "(" +
	 * cell.getColumnIndex() + ")-"); cellMap.put(cell.getColumnIndex(),
	 * cell.getNumericCellValue()); } else if (cell.CELL_TYPE_STRING ==
	 * cell.getCellType()) { System.out.print(cell.getStringCellValue() + "(" +
	 * cell.getColumnIndex() + ")-"); cellMap.put(cell.getColumnIndex(),
	 * cell.getStringCellValue()); } } System.out.println(); }
	 * 
	 * // XSSFRow row = sheet.getRow(4); // XSSFCell xSSFCell = row.getCell(2);
	 * 
	 * }
	 */
}
