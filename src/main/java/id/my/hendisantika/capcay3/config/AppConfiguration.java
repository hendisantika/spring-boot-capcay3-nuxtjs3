package id.my.hendisantika.capcay3.config;

import id.my.hendisantika.capcay3.filter.GoogleRecaptchaFilter;
import id.my.hendisantika.capcay3.service.GoogleRecaptchaService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.time.Duration;
import java.util.List;

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

    @Bean
    public GoogleRecaptchaFilter googleRecaptchaFilter() {
        return new GoogleRecaptchaFilter(googleRecaptchaService, handlerExceptionResolver);
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(List.of("*"));
        corsConfiguration.setAllowedOrigins(List.of("*"));
        corsConfiguration.setAllowedMethods(List.of("*")); // add this line with appropriate methods for your case
        corsConfiguration.setMaxAge(Duration.ofMinutes(10));
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }

    /**
     * WARNING: Do not use this configuration as it is!!!
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors();
        http.csrf().disable();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeHttpRequests()
                .requestMatchers("/**").permitAll();

        return http.build();
    }
}
