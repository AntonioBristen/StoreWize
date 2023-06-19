package com.cerberobeta.StoreWize.config;

import com.cerberobeta.StoreWize.utils.ConstantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


    @Configuration
    @EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        ConstantsUtil constantsUtil;
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable().authorizeRequests()
                    .antMatchers(constantsUtil.PATH_ACCES).permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .addFilterBefore(new LoginFilter(constantsUtil.PATH_ACCES, authenticationManager()),
                            UsernamePasswordAuthenticationFilter.class)
                    .addFilterBefore(new JwtFilter(),
                            UsernamePasswordAuthenticationFilter.class);
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser(constantsUtil.USER)
                    .password(constantsUtil.PASS)
                    .roles(constantsUtil.ROL_ACCES);
        }

    }
