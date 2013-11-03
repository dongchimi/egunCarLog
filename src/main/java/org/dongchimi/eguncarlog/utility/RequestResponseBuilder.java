package org.dongchimi.eguncarlog.utility;

import java.util.HashMap;
import java.util.Map;

public class RequestResponseBuilder {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	public static JSonResponse getSuccessResponse(String resultName, Object resultObject) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(resultName, resultObject);
		
		JSonResponse response = new JSonResponse(RequestResponseBuilder.SUCCESS);
		response.setData(map);
		return response;
	}
	
	public static JSonResponse getSuccessResponse(Map<String, Object> resultMap) {
		JSonResponse response = new JSonResponse(RequestResponseBuilder.SUCCESS);
		response.setData(resultMap);
		return response;
	}
	
	public static JSonResponse getSuccessResponse() {
		return new JSonResponse(RequestResponseBuilder.SUCCESS);
	}

	public static JSonResponse getFailResponse(EgunCarlogException ex) {
		JSonResponse response = new JSonResponse(RequestResponseBuilder.FAIL);
		response.setMessage(ex.getMessage());
		for(StackTraceElement element :ex.getStackTrace()) {
			response.addFailStackMessage( element.getFileName() + "." +element.getMethodName() );
		}
		return response;
	}
}
