package com.redyhire.application;

import com.redyhire.application.config.ArgumentConfiguration;
import com.redyhire.application.instances.core.ObjectMapperInstance;
import com.redyhire.application.model.appconfig.ApplicationConfiguration;
import com.redyhire.application.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.redyhire.application.config.Arguments.APP_CONFIG;

public class Main {
    public static void main(String[] args) {
        ArgumentConfiguration configuration = new ArgumentConfiguration(args);
        String appConfigPath = configuration.getArgumentValue(APP_CONFIG);
        String fileContent = FileUtils.read(appConfigPath);
        try {
            ApplicationConfiguration applicationConfiguration = ObjectMapperInstance.getInstance().readValue(fileContent, ApplicationConfiguration.class);
            System.out.println(applicationConfiguration.getName());
        } catch (Exception e) {
            System.out.println("Error parsing file");
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}