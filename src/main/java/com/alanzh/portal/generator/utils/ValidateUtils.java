package com.alanzh.portal.generator.utils;

/**
 * 验证工具类
 * @author 
 *
 */
public class ValidateUtils {
	/**
	 * 验证是否是空，包含空字符串
	 * @param a
	 */
	public static Boolean isBlank(String a){
		return a == null || "".equals(a.replace(" ", ""));
	}
	
	/**
	 * 验证是否不为空
	 * @param a
	 */
	public static Boolean isNotBlank(String a){
		return !isBlank(a);
	}
	
	/**
	 * 验证是否是空
	 * @param a
	 */
	public static Boolean isEmpty(String a){
		return a == null;
	}
	
	/**
	 * 验证是否不为空
	 * @param a
	 */
	public static Boolean isNotEmpty(String a){
		return !isEmpty(a);
	}
	/**
	 * 验证是否所有的都为空,包含字符串
	 * @param as
	 * @return
	 */
	public static Boolean isAllBlank(String ... as){
		Boolean isBlank = true;
		for (String a : as) {
			if(isNotBlank(a)){
				return false;
			}
		}
		return isBlank;
	}
	/**
	 * 验证是否所有的都不为空,包含空字符串
	 * @param as
	 * @return
	 */
	public static Boolean isAllNoBlank(String ... as){
		Boolean isNotBlank = true;
		for (String a : as) {
			if(isBlank(a)){
				return false;
			}
		}
		return isNotBlank;
	}
	/**
	 * 验证是否所有的都为空
	 * @param as
	 * @return
	 */
	public static Boolean isAllEmpty(String ... as){
		Boolean isBlank = true;
		for (String a : as) {
			if(isNotEmpty(a)){
				return false;
			}
		}
		return isBlank;
	}
	
}
