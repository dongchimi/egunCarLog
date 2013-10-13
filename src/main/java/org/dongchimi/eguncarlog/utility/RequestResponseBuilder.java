package org.dongchimi.eguncarlog.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestResponseBuilder {
	
	private static final String SUCCESS = "success";
	
	public static JSonResponse getSuccessResponse(String resultName, Object resultObject) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(resultName, resultObject);
		List<Map<String,Object>> list =  new ArrayList<Map<String,Object>>();
		list.add(map);
		
		JSonResponse response = new JSonResponse();
		response.setStatus(RequestResponseBuilder.SUCCESS);
		response.setData(list);
		return response;
	}
	
	public static JSonResponse getSuccessResponse(Map<String, Object> resultMap) {
		List<Map<String,Object>> list =  new ArrayList<Map<String,Object>>();
		list.add(resultMap);
		
		JSonResponse response = new JSonResponse();
		response.setStatus(RequestResponseBuilder.SUCCESS);
		response.setData(list);
		return response;
	}
}
