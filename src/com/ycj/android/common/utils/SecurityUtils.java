package com.ycj.android.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import android.util.Base64;

/**
 * ��ȫ�෽���Ĵ�����
 * @author yangchj
 */
public class SecurityUtils {
	/**
	 * ���ַ�������Base64����
	 * 
	 * @param content
	 *            ��Ҫ����ĵ��ַ�
	 * @return ���ر���ɹ�����ַ���
	 */
	public static String base64(String content) {
		try {
			content = Base64.encodeToString(content.getBytes("utf-8"),
					Base64.DEFAULT); // ���ַ�������Base64����
			content = StrEncoder(content, "utf-8"); // ���ַ�������URL����
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace(); // ����쳣��Ϣ
		}
		return content;
	}

	/**
	 * ��URL���ַ������б���
	 * 
	 * @param content
	 *            ��Ҫ������ַ���
	 * @param charset
	 *            ��Ҫ��������� ��:utf-8,gb2312
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
	 * ��URL���ַ������н���
	 * 
	 * @param content
	 *            ��Ҫ������ַ���
	 * @param charset
	 *            ��Ҫ��������� ��:utf-8,gb2312
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
