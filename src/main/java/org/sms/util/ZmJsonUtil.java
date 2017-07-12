package org.sms.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

/**
 * JSON服务扩展类
 * @author 吴宗苗
 *
 */
public class ZmJsonUtil {

	public static <T extends Object> String json2string(T o){
		
		return JSONArray.toJSONString(o);
	}
	
	/**
	 * 将 json格式的数据转换成指定类型的tagClass 对象 ，并返回，json个数必须是" [{},{},....] "
	 * @param <T>
	 * @param tagClass
	 * @param jsonStr
	 * @return
	 */
	public static <T extends Object>  List<T> jsonString2Object(Class<T> tagClass,String jsonStr){
		if(jsonStr == null || "".equals(jsonStr.trim())){
			return null;
		}
		try{
			List<T> reslist = new ArrayList<T>();
			reslist = JSON.parseArray(jsonStr, tagClass);
			return reslist;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		}
	
		public static Map<String,String> jsonString2Map(String jsonStr){
			if(jsonStr == null || "".equals(jsonStr.trim())){
				return null;
			}
			Map<String,String> map = JSONObject.parseObject(jsonStr,new TypeReference<Map<String, String>>(){});
			return map;
			
		}
	}