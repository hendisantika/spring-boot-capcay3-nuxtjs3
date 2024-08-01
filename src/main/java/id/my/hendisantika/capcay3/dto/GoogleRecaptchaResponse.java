package id.my.hendisantika.capcay3.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-capcay3-nuxtjs3
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/08/24
 * Time: 08.37
 * To change this template use File | Settings | File Templates.
 */
@Data
@ToString
public class GoogleRecaptchaResponse {
    private boolean success;
    private String challenge_ts;
    private String hostname;
    @JsonProperty("error-codes")
    private String[] errorCodes;
    private Double score;
    private String action;
}
