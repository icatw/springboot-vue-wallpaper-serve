package com.pumpkin.disease.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Pumpkin
 * @description 时间信息自动注入
 */
@Component
public class MetaObjectHandlerImpl implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("gmtCreate", LocalDateTime.now(), metaObject);
        this.setFieldValByName("gmtUpdate", LocalDateTime.now(), metaObject);
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        //this.setFieldValByName("isDeleted", Boolean.TRUE, metaObject);
        this.setFieldValByName("lastLoginTime", LocalDateTime.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("gmtUpdate", LocalDateTime.now(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
