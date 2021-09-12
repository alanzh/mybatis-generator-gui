package com.alanzh.portal.generator.executor;

import com.alanzh.portal.generator.constant.Constants;
import com.alanzh.portal.generator.utils.GeneratorPropertiesUtil;
import com.alanzh.portal.generator.utils.GeneratorUtil;
import com.zzg.mybatis.generator.model.GeneratorConfig;
import freemarker.template.Template;
import java.io.IOException;
import java.util.Map;

public class ControllerCodeGenerator {
	public static void generatorCode(GeneratorConfig generatorConfig) throws IOException, Exception {
		
		ControllerCodeGenerator baseCodeGenerator = new ControllerCodeGenerator();

		baseCodeGenerator.generate(generatorConfig, Constants.PATH_CONTROLLER, Constants.NAME_CONTROLLER, Constants.TYPE_CONTROLLER);
	}

	private void generate(GeneratorConfig generatorConfig, String templateDirPath, String typeName, String domainName) throws Exception {
		Map<String, Object> root = GeneratorPropertiesUtil.getDataModel(generatorConfig);

		String entityName = generatorConfig.getDomainObjectName();

		String fileDir = root.get("fileDir") + domainName + "/";

		String fileName = fileDir + entityName + typeName + ".java";

		Template template = GeneratorUtil.getTemplate(templateDirPath, typeName);

		GeneratorUtil.generate(root, template, fileDir, fileName);

		System.out.println(fileName + "生成成功！");
	}

}
