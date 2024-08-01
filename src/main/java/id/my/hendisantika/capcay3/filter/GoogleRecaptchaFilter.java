package id.my.hendisantika.capcay3.filter;

import id.my.hendisantika.capcay3.service.GoogleRecaptchaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-capcay3-nuxtjs3
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/08/24
 * Time: 08.39
 * To change this template use File | Settings | File Templates.
 */
@RequiredArgsConstructor
@Slf4j
public class GoogleRecaptchaFilter extends OncePerRequestFilter {
    private final GoogleRecaptchaService googleRecaptchaService;
    private final HandlerExceptionResolver resolver;
}
