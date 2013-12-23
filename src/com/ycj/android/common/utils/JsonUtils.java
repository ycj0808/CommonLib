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
 * @Description: TODO(json数据处理工具类)
 * @author yangchj
 * @date 2013-9-15 下午9:18:19
 */
public class JsonUtils {
	/**
	 * @Title: getListMaps
	 * @Description: TODO(对List<Map<String,Object>>型的数据的解析)
	 * @return List<Map<String,Object>>    返回类型
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
	 * @Description: TODO(对List<String>型的数据的解析)
	 * @return List<String>    返回类型
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
