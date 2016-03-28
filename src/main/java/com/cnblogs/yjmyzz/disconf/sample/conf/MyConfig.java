package com.cnblogs.yjmyzz.disconf.sample.conf;

import com.baidu.disconf.client.common.annotations.DisconfItem;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by yangjunming on 3/28/16.
 * author: yangjunming@huijiame.com
 */
@ToString
@Setter
public class MyConfig {

    private String key;

    @DisconfItem(key = "mykey")
    public String getKey() {
        return key;
    }
}
