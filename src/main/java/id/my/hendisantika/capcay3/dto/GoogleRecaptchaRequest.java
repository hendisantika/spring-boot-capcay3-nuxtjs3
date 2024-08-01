package id.my.hendisantika.capcay3.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-capcay3-nuxtjs3
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/08/24
 * Time: 08.36
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
public class GoogleRecaptchaRequest {
    private String secret;
    private String response;
    private String remoteip;

    public GoogleRecaptchaRequest() {
        this.secret = "secret key";
    }
}
