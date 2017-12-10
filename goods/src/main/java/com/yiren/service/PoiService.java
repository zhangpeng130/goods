package com.yiren.service;

import java.util.List;

/**
 * 
 * @author peng
 *
 */
public interface PoiService {
	/**
	 * 从xlxs文件中,获取实体类List
	 * 
	 * @param entityMark
	 * @param path
	 * @return
	 */
	public List getListFromXlsx(String entityMark, String path);
}
