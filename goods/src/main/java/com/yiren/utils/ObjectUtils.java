package com.yiren.utils;

import java.lang.reflect.Field;

public class ObjectUtils {
	/**
	 * 判断已实例化的对象属性值是否全部为空
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean checkObjFieldIsNotNull(Object obj) {
		try {
			Field[] fields = obj.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true);
				if (!"class java.lang.String".equals(fields[i].getType()
						.toString())) {// 还是有bug
					continue;
				}
				if (fields[i].get(obj) != null) {
					return true;
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return false;
	}
}
