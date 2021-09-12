${copyright}

package com.accenture.digital.common.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * @author alan.yang.zhang
 *
 */
public class IMessage<T> {

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public JSONObject getExtendMessage() {
		return extendMessage;
	}

	public void setExtendMessage(JSONObject extendMessage) {
		this.extendMessage = extendMessage;
	}

	public void remove(String key) {
		this.extendMessage.remove(key);
	}

	public void put(String key, String value) {
		this.extendMessage.put(key, value);
	}

	private T data;

	/*
	 * 返回代码
	 */
	private int code = 200;

	/*
	 * 消息
	 */
	private String message = "";

	private JSONObject extendMessage = new JSONObject();

	/*
	 * 成功失败
	 */
	private boolean success = true;
	
}
