/**
 *
 */
package com.alanzh.portal.generator.utils;

import com.zzg.mybatis.generator.model.GeneratorConfig;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author alan.yang.zhang
 *
 */
public class GeneratorPropertiesUtil {

    static Map<String, String> propertiesMap = new HashMap<>();

    static String authorName;

    static String copyright;

    static {
        BufferedReader bufferedReader;

        try {
            bufferedReader = new BufferedReader(
                    new FileReader("src/main/resources/generator.properties"));

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                if (ValidateUtils.isNotBlank(line) && line.indexOf("=") != -1) {
                    propertiesMap.put(line.split("=")[0], line.split("=")[1]);
                }
            }

            authorName = GeneratorPropertiesUtil.getProperties("user.name");
            copyright = GeneratorUtil.getFileContent("src/main/resources/template/copyright.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperties(String key) {
        return propertiesMap.get(key);
    }

    public static Map<String, Object> getDataModel(GeneratorConfig generatorConfig) {
        Map<String, Object> dataModel = new HashMap<String, Object>();

        String projectTargetProject = generatorConfig.getProjectTargetProject();
        String entityPackage = generatorConfig.getModelPackage();
        String entityName = generatorConfig.getDomainObjectName();
        String simpleEntityName = GeneratorUtil.toLowerInitial(entityName);
        String fileDir = generatorConfig.getProjectFolder() + "/" + projectTargetProject + "/" + generatorConfig
                .getProjectPackage().replace(".", "/") + "/";

        dataModel.put("modulePackage", projectTargetProject);
        dataModel.put("domainPackage", entityPackage);
        dataModel.put("simpleEntityName", simpleEntityName);
        dataModel.put("entityName", entityName);
        dataModel.put("moduleName", entityName);
        dataModel.put("authName", authorName);
        dataModel.put("copyright", copyright);
        dataModel.put("fileDir", fileDir);

        return dataModel;
    }
}
