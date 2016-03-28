package com.cnblogs.yjmyzz.disconf.sample.util;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.sql.DataSource;
import java.io.File;
import java.sql.SQLException;

/**
 * {type your description }
 *
 * @since: 15/11/16.
 * @author: yangjunming
 */
public class ApplicationContextUtil {

    private static ConfigurableApplicationContext context = null;

    private static ApplicationContextUtil instance = null;

    public static ApplicationContextUtil getInstance() {
        if (instance == null) {
            synchronized (ApplicationContextUtil.class) {
                if (instance == null) {
                    instance = new ApplicationContextUtil();
                }
            }
        }
        return instance;
    }

    public ConfigurableApplicationContext getContext() {
        return context;
    }

    private ApplicationContextUtil() {

    }


    static {

        //加载log4j2.xml
        String configLocation = "resources/log4j2.xml";
        File configFile = new File(configLocation);
        if (!configFile.exists()) {
            System.err.println("log4j2 config file:" + configFile.getAbsolutePath() + " not exist");
            System.exit(0);
        }
        System.out.println("log4j2 config file:" + configFile.getAbsolutePath());

        try {
            //注:这一句必须放在整个应用第一次LoggerFactory.getLogger(XXX.class)前执行
            System.setProperty("log4j.configurationFile", configFile.getAbsolutePath());
        } catch (Exception e) {
            System.err.println("log4j2 initialize error:" + e.getLocalizedMessage());
            System.exit(0);
        }

        //加载spring配置文件
        configLocation = "resources/spring-context.xml";
        configFile = new File(configLocation);

        if (!configFile.exists()) {
            System.err.println("spring config file:" + configFile.getAbsolutePath() + " not exist");
            System.exit(0);
        }

        //System.out.println("spring config file:" + configFile.getAbsolutePath());

        if (context == null) {
            context = new FileSystemXmlApplicationContext(configLocation);
            //context = new ClassPathXmlApplicationContext("spring-context.xml");
            if (context.containsBean("dataSource")) {
                DataSource dataSource = context.getBean("dataSource", DataSource.class);
                if (dataSource != null) {
                    java.sql.Connection connection;
                    try {
                        connection = dataSource.getConnection();
                        connection.close();
                    } catch (SQLException e) {
                        System.err.println("spring initialize error:" + e.getLocalizedMessage());
                        System.exit(0);
                    }
                }
            }
        }

    }

//    public static void main(String[] args) {
//        getInstance();
//    }
}
