package com.yiren.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class UploadUtils {
	/**
	 * 
	 * @param importfile
	 * @param path
	 *            =path+module
	 * @return url=path+fileName
	 */
	public static String uploadFile(MultipartFile importfile, String path) {
		String filenameSource = importfile.getOriginalFilename();// 源文件名称
		String filenameNew = System.currentTimeMillis() + "_" + filenameSource; // 重新命名_防止覆盖
		File targetFile = new File(path, filenameNew);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		try {
			importfile.transferTo(targetFile);// 开始上传
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		String url = path + filenameNew;
		return url;
	}
}
