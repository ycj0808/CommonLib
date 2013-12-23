package com.ycj.android.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import android.util.Base64;

/**
 * 安全类方法的处理方法
 * @author yangchj
 */
public class SecurityUtils {
	/**
	 * 对字符串进行Base64编码
	 * 
	 * @param content
	 *            需要编码的的字符
	 * @return 返回编码成功后的字符串
	 */
	public static String base64(String content) {
		try {
			content = Base64.encodeToString(content.getBytes("utf-8"),
					Base64.DEFAULT); // 对字符串进行Base64编码
			content = StrEncoder(content, "utf-8"); // 对字符串进行URL编码
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace(); // 输出异常信息
		}
		return content;
	}

	/**
	 * 对URL的字符串进行编码
	 * 
	 * @param content
	 *            需要编码的字符串
	 * @param charset
	 *            需要编码的类型 如:utf-8,gb2312
	 * @return
	 */
	public static String StrEncoder(String str, String charset) {
		String Result = str;
		try {
			Result = URLEncoder.encode(str, charset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return Result;
	}

	/**
	 * 对URL的字符串进行解码
	 * 
	 * @param content
	 *            需要解码的字符串
	 * @param charset
	 *            需要编码的类型 如:utf-8,gb2312
	 * @return
	 */
	public static String StrDecoder(String str, String charset) {
		String Result = str;
		try {
			Result = URLDecoder.decode(str, charset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return Result;
	}
}
