package id.my.hendisantika.capcay3.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.my.hendisantika.capcay3.dto.GoogleRecaptchaRequest;
import id.my.hendisantika.capcay3.dto.GoogleRecaptchaResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

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

    public GoogleRecaptchaResponse verifyRecaptcha(GoogleRecaptchaRequest request) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("secret", request.getSecret());
            map.add("response", request.getResponse());
            map.add("remoteip", request.getRemoteip());
            HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
            ResponseEntity<GoogleRecaptchaResponse> response = restTemplate.exchange(RECAPTCHA_VERIFY_ADDRESS,
                    HttpMethod.POST,
                    entity,
                    GoogleRecaptchaResponse.class);
            GoogleRecaptchaResponse googleResponse = response.getBody();
            if (Objects.isNull(googleResponse)) {
                throw new RuntimeException("Google response is null");
            }
            if (Objects.nonNull(googleResponse.getScore()) && googleResponse.getScore() < SCORE_THRESHOLD) {
                log.warn("User score is lower than threshold. GoogleResponse :: {}", googleResponse);
                googleResponse.setSuccess(false);
            }
            log.info("Recaptcha verification completed successfully");
            log.info("Recaptcha response: {}", googleResponse);
            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
