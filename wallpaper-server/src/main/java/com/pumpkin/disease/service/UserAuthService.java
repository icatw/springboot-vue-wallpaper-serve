package com.pumpkin.disease.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pumpkin.disease.entity.UserAuth;
import com.pumpkin.disease.request.security.user.PasswordRequest;

/**
 * <p>
 * 用户权限表 服务类
 * </p>
 *
 * @author Pumpkin
 * @since 2022-11-30 10:18:24
 */
public interface UserAuthService extends IService<UserAuth> {

    /**
     * 获取对应用户信息
     *
     * @return {@link  UserAuth} 用户权限信息
     */
    UserAuth getUserInfo();

    /**
     * 更新用户密码
     *
     * @param passwordRequest 用户请求入参
     */
    void updateUserPassword(PasswordRequest passwordRequest);

    /**
     * 检查用户名
     *
     * @param username 用户名
     * @return 存在返回true，不存在返回false
     */
    boolean checkUsername(String username);

    boolean checkByOpenId(String openId, String source);
}
