package com.prakhar;

import net.bytebuddy.asm.Advice;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("admin").password("password").roles("ADMIN");
    }



    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.csrf().disable();
        security.authorizeRequests().antMatchers("/add").hasRole("ADMIN");
        security.authorizeRequests().antMatchers("/emp").hasAnyRole("ADMIN","USER")
                .antMatchers("/").permitAll()
                .and().formLogin();

    }
}
