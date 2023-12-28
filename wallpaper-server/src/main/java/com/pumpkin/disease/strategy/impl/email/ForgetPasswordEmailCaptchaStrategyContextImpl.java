package com.pumpkin.disease.strategy.impl.email;

import com.pumpkin.disease.enums.email.EmailEnum;
import com.pumpkin.disease.request.security.email.EmailCaptchaRequest;
import com.pumpkin.disease.request.security.email.EmailRequest;
import com.pumpkin.disease.service.EmailService;
import com.pumpkin.disease.strategy.EmailStrategy;
import com.pumpkin.disease.utils.redis.RedisCache;
import com.pumpkin.disease.utils.uuid.UUIDUtil;
import com.pumpkin.disease.utils.vaild.AssertUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

import static com.pumpkin.disease.constant.BusinessErrorConstant.EmailCaptchaError.EMAIL_CAPTCHA_ERROR;
import static com.pumpkin.disease.constant.RedisPrefixConstant.EmailCaptchaPrefix.FORGET_PASSWORD_CAPTCHA;
import static com.pumpkin.disease.constant.StrategyServiceConstant.EmailCaptcha.FORGET_PASSWORD_EMAIL_CAPTCHA_SERVICE_NAME;

/**
 * @author: Pumpkin
 * @description: 忘记密码邮箱验证码策略实现类
 * @since : 2023/4/23 14:21
 */
@RequiredArgsConstructor
@Service(value = FORGET_PASSWORD_EMAIL_CAPTCHA_SERVICE_NAME)
public class ForgetPasswordEmailCaptchaStrategyContextImpl implements EmailStrategy {

    private final RedisCache redisCache;
    private final EmailService emailService;

    @Override
    public void sendEmailToUser(EmailRequest emailRequest) {
        // 生成验证码
        String emailCaptcha = UUIDUtil.createEmailCaptcha(6);
        // 存储验证码
        redisCache.setCacheObject(FORGET_PASSWORD_CAPTCHA + emailRequest.getReceiverEmail(), emailCaptcha, 15, TimeUnit.MINUTES);
        // 发送邮箱
        emailService.sendEmailToUserByEmailTemplate(emailRequest.getReceiverEmail(),
                EmailEnum.FORGET_PASSWORD_EMAIL_CAPTCHA.getEmailMessage(),
                EmailEnum.FORGET_PASSWORD_EMAIL_CAPTCHA.getEmailMessage(),
                "email/EmailCaptcha", emailCaptcha);
    }

    @Override
    public void checkEmailCaptcha(EmailCaptchaRequest emailCaptchaRequest) {
        String registerCaptcha = redisCache.getCacheObject(FORGET_PASSWORD_CAPTCHA + emailCaptchaRequest.getReceiverEmail());
        AssertUtil.assertIsNotPass(!emailCaptchaRequest.getEmailCaptcha().equals(registerCaptcha), EMAIL_CAPTCHA_ERROR);
        redisCache.deleteObject(FORGET_PASSWORD_CAPTCHA + emailCaptchaRequest.getReceiverEmail());
    }
}
