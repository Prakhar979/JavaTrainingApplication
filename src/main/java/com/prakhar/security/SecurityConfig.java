package com.prakhar.security;

import com.mysql.cj.jdbc.MysqlDataSource;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT NAME,PASSWORD,'TRUE' AS ENABLED FROM EMPLOYEE WHERE NAME= ?")
                .authoritiesByUsernameQuery("SELECT NAME,AUTHORITY FROM EMPLOYEE WHERE NAME= ?");




        /*auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("admin").password("password").roles("ADMIN");

         */
    }



    @Override
    protected void configure(HttpSecurity security) throws Exception {
        //security.csrf().disable();
        security.authorizeRequests().antMatchers(HttpMethod.POST,"/emp").hasAuthority("admin");
        security.authorizeRequests().antMatchers(HttpMethod.GET,"/emp").hasAnyAuthority("admin","user")
                .antMatchers("/").permitAll()
                .and().formLogin();

    }



    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
