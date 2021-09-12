package com.alanzh.portal.generator.executor;

import com.alanzh.portal.generator.constant.Constants;
import com.alanzh.portal.generator.utils.GeneratorPropertiesUtil;
import com.alanzh.portal.generator.utils.GeneratorUtil;
import com.zzg.mybatis.generator.model.GeneratorConfig;
import freemarker.template.Template;
import java.util.Map;

public class BaseCodeGenerator {

    public static Boolean generatorCode(GeneratorConfig generatorConfig) throws Exception {

        BaseCodeGenerator baseCodeGenerator = new BaseCodeGenerator();

        baseCodeGenerator.generate(generatorConfig, Constants.PATH_DAO, Constants.NAME_BASE_MAPPER, Constants.TYPE_DAO);

        baseCodeGenerator
                .generate(generatorConfig, Constants.PATH_SERVICE, Constants.NAME_BASE_SERVICE, Constants.TYPE_SERVICE);

        baseCodeGenerator
                .generate(generatorConfig, Constants.PATH_UTILS, Constants.NAME_SEARCH_CONDITION, Constants.TYPE_UTILS);

        baseCodeGenerator.generate(generatorConfig, Constants.PATH_CONSTANT, Constants.NAME_BASE_CONSTANTS,
                Constants.TYPE_CONSTANT);

        return true;
    }

    private void generate(GeneratorConfig generatorConfig, String templateDirPath, String typeName, String domainName)
            throws Exception {
        Map<String, Object> root = GeneratorPropertiesUtil.getDataModel(generatorConfig);

        String fileDir = root.get("fileDir") + domainName + "/";

        String fileName = fileDir + typeName + ".java";

        Template template = GeneratorUtil.getTemplate(templateDirPath, typeName);

        GeneratorUtil.generate(root, template, fileDir, fileName);

        System.out.println(fileName + "生成成功！");
    }

}
