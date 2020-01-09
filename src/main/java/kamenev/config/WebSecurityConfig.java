package kamenev.config;

import kamenev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf()
                .disable()
                .authorizeRequests()
                //доступ только для незарегистрированных пользователей
        .antMatchers("/signup").not().fullyAuthenticated()
                .antMatchers("/users/**").hasRole("ADMIN")  //только для админов
        .antMatchers("/posts/**").hasRole("USER")
                .anyRequest().authenticated()  // Все остальные страницы требуют аутентификации
                .and() //настройка для входа в систему
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/posts") //редирект на стр. после успешного входа
        .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login");
    }
}
