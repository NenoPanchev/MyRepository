package spring.softunimusicdb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import spring.softunimusicdb.service.impl.MusicDBUserService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
    private final MusicDBUserService musicDBUserService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AppSecurityConfig(MusicDBUserService musicDBUserService, PasswordEncoder passwordEncoder) {
        this.musicDBUserService = musicDBUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // allow access to static resources to anyone
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .antMatchers("/img/**").permitAll()
                // allow access to index, user login and reg to anyone
                .antMatchers("/", "/users/login", "/users/register").permitAll()
                // protect all other pages
//        .antMatchers("/**").authenticated()
                .anyRequest().authenticated()
        .and()
                // configure login with HTML form
                .formLogin()
                // our login page will be served by the controller with mapping /users/login
                .loginPage("/user/login")
                // the name of the username input field in OUR login form is username (optional)
                .usernameParameter("username")
                // the name of the password input field in OUR login form is password (optional)
                .passwordParameter("password")
                // on login success redirect here
                .defaultSuccessUrl("/home")
                // on login failure redirect here
                .failureForwardUrl("/users/login-error"); //todo errors
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(musicDBUserService)
                .passwordEncoder(passwordEncoder);
    }
}
