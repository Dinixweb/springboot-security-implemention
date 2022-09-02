package io.dinixweb.Springboot.Security.security;

import io.dinixweb.Springboot.Security.filters.JwtFilter;
import io.dinixweb.Springboot.Security.middleware.JwtEntryPoint;
import io.dinixweb.Springboot.Security.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;


@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    AuthUserService authUserService;

    @Autowired
    JwtEntryPoint jwtEntryPoint;

    @Autowired
    JwtFilter jwtFilter;


    @Override
    protected  void configure(AuthenticationManagerBuilder auth) throws  Exception{
        auth.userDetailsService(authUserService).passwordEncoder(getPasswordEncoder());

    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
    return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean ()throws Exception{
        return super.authenticationManagerBean();
    }

    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //add a filter to intercept/validate every request
        httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

    }
}
