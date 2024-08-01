package id.my.hendisantika.capcay3.config;

import id.my.hendisantika.capcay3.service.GoogleRecaptchaService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-capcay3-nuxtjs3
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/08/24
 * Time: 08.41
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@RequiredArgsConstructor
public class AppConfiguration {
    private final GoogleRecaptchaService googleRecaptchaService;
    private final HandlerExceptionResolver handlerExceptionResolver;

}
