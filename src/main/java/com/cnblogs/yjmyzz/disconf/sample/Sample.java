package com.cnblogs.yjmyzz.disconf.sample;

import com.cnblogs.yjmyzz.disconf.sample.conf.JdbcConfig;
import com.cnblogs.yjmyzz.disconf.sample.conf.MyConfig;
import com.cnblogs.yjmyzz.disconf.sample.util.ApplicationContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

/**
 * Created by yangjunming on 3/28/16.
 * author: yangjunming@huijiame.com
 */
public class Sample {

    public static void main(String[] args) {

        //ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");

        ApplicationContext ctx = ApplicationContextUtil.getInstance().getContext();

        Logger logger = LoggerFactory.getLogger(Sample.class);

        JdbcConfig jdbcConfig = ctx.getBean(JdbcConfig.class);
        logger.warn(jdbcConfig.toString());

        MyConfig myConfig = ctx.getBean(MyConfig.class);
        logger.warn(myConfig.toString());
    }
}
