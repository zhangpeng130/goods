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

public class PoiDemo {
	public static void main(String[] args) {
		try {
			parseToEntity();
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void parseToEntity() throws InvalidFormatException,
			IOException {
		List rowlist = poiTest1();
		for (int i = 0; i < rowlist.size(); i++) {
			Map rowMap = (Map) rowlist.get(i);
			Set rowMapSet = rowMap.keySet();
			Iterator keySetIterator = rowMapSet.iterator();
			while (keySetIterator.hasNext()) {
				// System.out.print(keySetIterator.next());
				Object key = keySetIterator.next();
				Object value = rowMap.get(key);
				System.out.print(key + "(" + rowMap.get(key) + ")");
			}
			System.out.println();
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
