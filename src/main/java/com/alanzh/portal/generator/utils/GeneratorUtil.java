package com.alanzh.portal.generator.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.io.FileUtils;

public class GeneratorUtil {

	/**
	 * 将指定字符的首字母小写
	 * 
	 * @param str 需要转换的字符
	 */
	public static String toLowerInitial(String str) {
		char ch[];
		ch = str.toCharArray();
		if (ch[0] >= 'A' && ch[0] <= 'Z') {
			ch[0] = (char) (ch[0] + 32);
		}
		return new String(ch);
	}

	public static String toUpperInitial(String str) {
		char ch[];
		ch = str.toCharArray();

		if (ch[0] >= 'a' && ch[0] <= 'z') {
			ch[0] = (char) (ch[0] - 32);
		}

		return new String(ch);
	}

	/**
	 * 处理表名变为驼峰，首字母大写
	 * 
	 * @param entityNameStr
	 * @return
	 */
	public static String handleEntityName(String entityNameStr) {
		String[] entityNameStrs = entityNameStr.split("_");
		StringBuilder sb = new StringBuilder();

		int i = 0;

		for (String entityName : entityNameStrs) {
			if (i != 0) {
				sb.append(toUpperInitial(entityName));
			}

			i++;
		}

		return sb.toString();
	}

	
	public static boolean generate(Map<String, Object> root,Template template, String fileDir, String fileName) {
		try {
			File dir = new File(fileDir);

			FileUtils.forceMkdir(dir);

			Writer out = new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8");

			template.process(root, out);

			out.close();

			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public static String getFileContent(String fileName) {
		String content = "";

		File file = new File(fileName);

		Long filelength = file.length();

		byte[] filecontent = new byte[filelength.intValue()];

		try {
			FileInputStream in = new FileInputStream(file);
			in.read(filecontent);
			in.close();

			content =  new String(filecontent, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return content;
	}

	public static Template getTemplate(String templateDirPath, String templatePath) throws Exception {
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_22);

		configuration.setClassForTemplateLoading(GeneratorUtil.class.getClass(), templateDirPath);
		configuration.setLocale(Locale.CHINA);
		configuration.setDefaultEncoding("UTF-8");

		Template template = configuration.getTemplate(templatePath + ".ftl");

		return template;
	}
}