package id.my.hendisantika.capcay3.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-capcay3-nuxtjs3
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Link : s.id/hendisantika
 * Date: 09/11/26
 * Time: 06.23
 */
@ConfigurationProperties(prefix = "google.recaptcha")
public record GoogleRecaptchaProperties(
        /**
         * Google reCAPTCHA v3 secret key, read from the GOOGLE_RECAPTCHA_SECRET environment variable.
         */
        String secret) {
}
