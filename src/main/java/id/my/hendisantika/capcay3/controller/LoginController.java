package id.my.hendisantika.capcay3.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-capcay3-nuxtjs3
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/08/24
 * Time: 08.44
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class LoginController {

    @PostMapping(value = "/api/login")
    public String doLogin() {
        return "Login method has been called";
    }
}
