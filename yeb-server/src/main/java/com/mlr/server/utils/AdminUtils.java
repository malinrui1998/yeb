package com.mlr.server.utils;

import com.mlr.server.pojo.Admin;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * 操作员工具类
 *
 * @author: mlr
 * @date: 2022/4/12 19:10
 * @since: 1.0.0
 */
@Component
public class AdminUtils {
    /**
     * 获取当前登录操作员
     *
     * @return
     */
    public static Admin getCurrentAdmin() {
        return (Admin) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }

}
