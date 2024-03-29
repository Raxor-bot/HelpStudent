package com.example.helpstudent.security;

import com.example.helpstudent.Service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final StudentService studentService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurityConfig(StudentService studentService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.studentService = studentService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/Login/**").permitAll()
                .antMatchers("/**").permitAll()
                .anyRequest()
                .authenticated().and()
                .formLogin()
                .loginPage("/Login")
                .failureUrl("/Login?error=true")
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/Index.html", true)
                .usernameParameter("mail")
                .and()
                //logout
                .logout()
                .logoutUrl("/perform_logout")
                .deleteCookies("JSESSIONID")
                 ;

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth){
        auth.authenticationProvider(daoAuthenticationProvider());
    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(studentService);
        return provider;
    }
}
