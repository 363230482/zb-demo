package com.mybatis.test.cassandra.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @author zhangbo
 * @date 2020/6/18
 */
@Data
public class CustomerQuery extends BasePageQuery {

    private Integer id;
    private String name;
    private Integer age;
    private String tags;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;
}
