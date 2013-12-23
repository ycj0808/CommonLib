package com.ycj.android.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class CryptUtils {

	/** Ĭ���ַ�����UTF-8�� */
	public static final String DEFAULT_ENCODING = "UTF-8";
	/** ���ܷ�����MD5 */
	public static final String MD5 = "MD5";
	/** ���ܷ�����SHA */
	public static final String SHA = "SHA";
	
	/** 
	 * byte[] -> ʮ�������ַ��� (Сд) 
	 * @param bytes
	 * @return
	 */
	public final static String bytes2HexStr(byte[] bytes) {
		return bytes2HexStr(bytes, false);
	}

	/** 
	 * byte[] -> ʮ�������ַ��� 
	 * @param bytes
	 * @param capital
	 * @return
	 */
	public final static String bytes2HexStr(byte[] bytes, boolean capital) {
		StringBuilder sb = new StringBuilder();

		for (byte b : bytes)
			sb.append(byte2Hex(b, capital));

		return sb.toString();
	}
	
	/**
	 *  byte -> ʮ������˫�ַ� (Сд)
	 * @param b
	 * @return
	 */
	public final static char[] byte2Hex(byte b) {
		return byte2Hex(b, false);
	}

	/** 
	 * byte -> ʮ������˫�ַ� 
	 * @param b
	 * @param capital
	 * @return
	 */
	public final static char[] byte2Hex(byte b, boolean capital) {
		byte bh = (byte) (b >>> 4 & 0xF);
		byte bl = (byte) (b & 0xF);

		return new char[] { halfByte2Hex(bh, capital),
				halfByte2Hex(bl, capital) };
	}

	/** 
	 * �� byte -> ʮ�����Ƶ��ַ� (Сд) 
	 * @param b
	 * @return
	 */
	public final static char halfByte2Hex(byte b) {
		return halfByte2Hex(b, false);
	}

	/** 
	 * �� byte -> ʮ�����Ƶ��ַ� 
	 * @param b
	 * @param capital
	 * @return
	 */
	public final static char halfByte2Hex(byte b, boolean capital) {
		return (char) (b <= 9 ? b + '0' : (capital ? b + 'A' - 0xA
				: b + 'a' - 0xA));
	}

	/** 
	 * ʮ�������ַ��� -> byte[]
	 * @param str
	 * @return
	 */
	public final static byte[] hexStr2Bytes(String str) {
		int length = str.length();

		if (length % 2 != 0) {
			str = "0" + str;
			length = str.length();
		}

		byte[] bytes = new byte[length / 2];

		for (int i = 0; i < bytes.length; i++)
			bytes[i] = hex2Byte(str.charAt(2 * i), str.charAt(2 * i + 1));

		return bytes;
	}

	/** 
	 * ʮ������˫�ַ� -> byte
	 * @param ch
	 * @param cl
	 * @return
	 */
	public final static byte hex2Byte(char ch, char cl) {
		byte bh = hex2HalfByte(ch);
		byte bl = hex2HalfByte(cl);

		return (byte) ((bh << 4) + bl);
	}

	/** 
	 * ʮ�����Ƶ��ַ� -> �� byte 
	 * @param c
	 * @return
	 */
	public final static byte hex2HalfByte(char c) {
		return (byte) (c <= '9' ? c - '0' : (c <= 'F' ? c - 'A' + 0xA
				: c - 'a' + 0xA));
	}
	
	/** 
	 * ʹ��Ĭ���ַ������ַ���������ٽ��� MD5 ���� 
	 * @param input
	 * @return
	 */
	public final static String md5(String input) {
		return md5(input, null);
	}

	/** 
	 * ʹ��ָ���ַ������ַ���������ٽ��� MD5 ���� 
	 * @param input
	 * @param charset
	 * @return
	 */
	public final static String md5(String input, String charset) {
		return encode(getMd5Digest(), input, charset);
	}

	/** 
	 * MD5 ���� 
	 * @param input
	 * @return
	 */
	public final static byte[] md5(byte[] input) {
		MessageDigest algorithm = getMd5Digest();
		return encode(algorithm, input);
	}
	
	/** 
	 * ��ȡ MD5 ����ժҪ���� 
	 * @return
	 */
	public final static MessageDigest getMd5Digest() {
		return getDigest(MD5);
	}
	
	/** 
	 * ��ȡ SHA ����ժҪ���� 
	 * @return
	 */
	public final static MessageDigest getShaDigest() {
		return getDigest(SHA);
	}

	/** 
	 * ��ȡ SHA-{X} ����ժҪ�������� {X} �� version ����ָ�� 
	 * @param version
	 * @return
	 */
	public final static MessageDigest getShaDigest(int version) {
		String algorithm = String.format("%s-%d", SHA, version);
		return getDigest(algorithm);
	}
	/** 
	 * ���ݼ��ܷ������ƻ�ȡ����ժҪ���� 
	 * @param algorithm
	 * @return
	 */
	public final static MessageDigest getDigest(String algorithm) {
		try {
			return MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	/** 
	 * ���ݼ��ܷ������ƺ��ṩ�߻�ȡ����ժҪ���� 
	 * @param algorithm
	 * @param provider
	 * @return
	 */
	public final static MessageDigest getDigest(String algorithm,
			String provider) {
		try {
			return MessageDigest.getInstance(algorithm, provider);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		} catch (NoSuchProviderException e) {
			throw new RuntimeException(e);
		}
	}
	
	/** 
	 * ʹ��ָ���㷨���ַ������� 
	 * @param algorithm
	 * @param input
	 * @return
	 */
	public final static String encode(MessageDigest algorithm, String input) {
		return encode(algorithm, input, null);
	}

	/** 
	 * ʹ��ָ���ַ������ַ���������ٽ��� SHA-{X} ���ܣ��ַ����ı����� charset ����ָ�� 
	 * @param algorithm
	 * @param input
	 * @param charset
	 * @return
	 */
	public final static String encode(MessageDigest algorithm, String input,
			String charset) {
		try {
			byte[] bytes = input.getBytes(safeCharset(charset));
			byte[] output = encode(algorithm, bytes);

			return bytes2HexStr(output);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	/** ʹ��ָ���㷨�� byte[] ���� */
	public final static byte[] encode(MessageDigest algorithm, byte[] input) {
		return algorithm.digest(input);
	}
	
	private final static String safeCharset(String charset) {
		if (isStrEmpty(charset))
			charset = DEFAULT_ENCODING;
		return charset;
	}
	public final static String safeString(String str) {
		return (str == null)?"":str;
	}
	
	public final static boolean isStrEmpty(String str) {
		return !(str != null && str.length() != 0);
	}

}
