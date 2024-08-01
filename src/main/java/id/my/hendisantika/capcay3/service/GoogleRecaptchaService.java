package id.my.hendisantika.capcay3.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-capcay3-nuxtjs3
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/08/24
 * Time: 08.38
 * To change this template use File | Settings | File Templates.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class GoogleRecaptchaService {
    private static final double SCORE_THRESHOLD = 0.5;
    private static final String RECAPTCHA_VERIFY_ADDRESS = "https://www.google.com/recaptcha/api/siteverify";

    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;

}
