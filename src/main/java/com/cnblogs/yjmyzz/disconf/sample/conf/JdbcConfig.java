package com.cnblogs.yjmyzz.disconf.sample.conf;

import lombok.Data;

/**
 * Created by yangjunming on 3/28/16.
 * author: yangjunming@huijiame.com
 */
@Data
public class JdbcConfig {

    private String jdbcDriver;

    private String jdbcUrl;

    private String jdbcUser;

    private String jdbcPassword;
}
