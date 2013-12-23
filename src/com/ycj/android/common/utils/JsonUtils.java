package com.ycj.android.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @ClassName: JsonUtils
 * @Description: TODO(json���ݴ�������)
 * @author yangchj
 * @date 2013-9-15 ����9:18:19
 */
public class JsonUtils {
	/**
	 * @Title: getListMaps
	 * @Description: TODO(��List<Map<String,Object>>�͵����ݵĽ���)
	 * @return List<Map<String,Object>>    ��������
	 * @throws
	 */
	public static List<Map<String,Object>> getListMaps(String key,String jsonStr,JSONObject obj){
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		try {
			org.json.JSONObject jsonObject=obj.getJSONObject("response");
			JSONArray jsonArray=jsonObject.getJSONArray(key);
			for(int i=0;i<jsonArray.length();i++){
				org.json.JSONObject jsonObj=jsonArray.getJSONObject(i);
				Map<String,Object> map=new HashMap<String, Object>();
				Iterator<String> iterator=jsonObj.keys();
				while(iterator.hasNext()){
					String jsonKey=iterator.next();
					Object jsonValue=jsonObj.get(jsonKey);
					if(jsonValue==null){
						jsonValue="";
					}
					map.put(jsonKey, jsonValue);
				}
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * @Title: getListStr
	 * @Description: TODO(��List<String>�͵����ݵĽ���)
	 * @return List<String>    ��������
	 * @throws
	 */
	public static List<String> getListStr(String key,String jsonStr){
		List<String> list=new ArrayList<String>();
		try {
			JSONObject jsonObject=new JSONObject();
			JSONArray jsonArray =jsonObject.getJSONArray(key);
			for(int i=0;i<jsonArray.length();i++){
				String msg=jsonArray.getString(i);
				list.add(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
