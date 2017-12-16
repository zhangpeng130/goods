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
		if ("inputfile".equals(importfile.getName())) {// 避免攻击者恶意上传文件（不知道效果如何）
			if (importfile.getSize() > 0) {// 空文件
				String filenameSource = importfile.getOriginalFilename();// 源文件名称
				if (!"xlsx".equals(filenameSource.substring(filenameSource
						.lastIndexOf(".") + 1))) {// 非xlsx后缀 禁止上传
					return null;
				}
				String filenameNew = System.currentTimeMillis() + "_"
						+ filenameSource; // 重新命名_防止覆盖
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
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filenameSource = "123.234.5.xlsx";

		System.out.println(filenameSource.substring(filenameSource
				.lastIndexOf(".") + 1));
	}
}
