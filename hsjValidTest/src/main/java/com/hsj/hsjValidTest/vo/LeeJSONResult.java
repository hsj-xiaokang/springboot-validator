package com.hsj.hsjValidTest.vo;

import java.util.Map;

/**
 * 值对象返回
 * 
 * @Description:TODO
 * @author:hsj qq:2356899074
 * @time:2017年11月14日 上午10:28:35
 */
public class LeeJSONResult {
	public final static String MESSAGE_OK = "成功！";
	public final static String MESSAGE_ERROR = "失败！";
	public final static int RESCODE_ERR = 0;
	public final static int RESCODE_OK = 1;
	
	private String message;
	private Object object;
	private int resCode = RESCODE_OK;
	
	public String getMessage() {
		return message;
	}

	public Object getObject() {
		return object;
	}

	public int getResCode() {
		return resCode;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public void setResCode(int resCode) {
		this.resCode = resCode;
	}

	private LeeJSONResult() {
		super();
	}

	private LeeJSONResult(String message, Map<String, String> map,int resCode) {
		super();
		this.message = message;
		this.object = map;
		this.resCode = resCode;
	}

	private LeeJSONResult(String message, Object object,int resCode) {
		super();
		this.message = message;
		this.object = object;
		this.resCode = resCode;
	}

	private LeeJSONResult(Map<String, String> map,int resCode) {
		super();
		this.object = map;
		this.resCode = resCode;
	}

	private LeeJSONResult(Object object,int resCode) {
		super();
		this.object = object;
		this.resCode = resCode;
	}

	private LeeJSONResult(String message,int resCode) {
		super();
		this.message = message;
		this.resCode = resCode;
		this.object = null;
	}

	public static LeeJSONResult error() {
		return new LeeJSONResult(MESSAGE_ERROR,RESCODE_ERR);
	}

	public static LeeJSONResult errorWithMap(Map<String, String> map,int resCode) {
		return new LeeJSONResult(map,resCode);
	}

	public static LeeJSONResult errorWithMessage(String message,int resCode) {
		return new LeeJSONResult(message,resCode);
	}

	public static LeeJSONResult errorWithMessageAndMap(String message, Map<String, String> map,int resCode) {
		return new LeeJSONResult(message, map,resCode);
	}

	public static LeeJSONResult ok() {
		return new LeeJSONResult(MESSAGE_OK,RESCODE_OK);
	}

	public static LeeJSONResult okWithMessage(String message,int resCode) {
		return new LeeJSONResult(message,resCode);
	}

	public static LeeJSONResult okWithObject(Object object,int resCode) {
		return new LeeJSONResult(object,resCode);
	}

	public static LeeJSONResult errorWithMessageAndObject(String message, Object object,int resCode) {
		return new LeeJSONResult(message, object,resCode);
	}

}
