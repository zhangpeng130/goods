package com.yiren.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 字符串加密
 * 
 * @author peng
 *
 */
public class EncoderStrUtil {

	/**
	 * old_将字符串加密
	 * 
	 * @param rawPassword
	 * @return
	 */
	// public static String encodedPasswordOld(String rawPassword) {
	// org.springframework.security.authentication.encoding.PasswordEncoder Enc
	// = new BCryptPasswordEncoder();
	// String encodedPassword = Enc.encode(rawPassword);
	// return encodedPassword;
	// }

	/**
	 * new_将字符串加密
	 * 
	 * @param rawPassword
	 * @return
	 */
	public static String encodedPassword(String rawPassword) {
		PasswordEncoder Enc = new BCryptPasswordEncoder();
		String encodedPassword = Enc.encode(rawPassword);
		return encodedPassword;
	}

	/**
	 * new_ 比对加密字符
	 * 
	 * @param rawPassword
	 * @param encodedPassword
	 * @return
	 */
	public static boolean matches(String rawPassword, String encodedPassword) {
		PasswordEncoder enc = new BCryptPasswordEncoder();
		boolean bo = enc.matches(rawPassword, encodedPassword);
		return bo;
	}

	public static void main(String[] args) {
		// System.out.println(EncoderStrUtil.encodedPassword("123"));
		// System.out.println(EncoderStrUtil.encodedPassword("123"));
		// System.out.println(EncoderStrUtil.encodedPassword("123"));

		// $2a$10$oiwkKO9DU6z55iH9fxy/le91Sr9jfu3m7Z9Vw/hePslSE4ajbUcyS
		// $2a$10$loGtZ4ZGvXZ8ONjnBxErHuufKCBVa8BiSUhxS/Ps4lhrwXfavLRse
		// $2a$10$SP1v2PztJYWfQGcq2WeFKOhB1ou2OsOyTfLhyzcMGSVaha06C.4Ou

		System.out
				.println(EncoderStrUtil
						.matches("123",
								"$2a$10$oiwkKO9DU6z55iH9fxy/le91Sr9jfu3m7Z9Vw/hePslSE4ajbUcyS"));
		System.out
				.println(EncoderStrUtil
						.matches("123",
								"$2a$10$loGtZ4ZGvXZ8ONjnBxErHuufKCBVa8BiSUhxS/Ps4lhrwXfavLRse"));
		System.out
				.println(EncoderStrUtil
						.matches("123",
								"$2a$10$SP1v2PztJYWfQGcq2WeFKOhB1ou2OsOyTfLhyzcMGSVaha06C.4Ou"));
	}
}
