package com.greenfox.endpoint_snippets.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  /*
   The `dataSource` is defined in the `application.properties`' first line
   spring.datasource.url=jdbc:mysql://localhost/DATABASE_NAME?serverTimezone=UTC
   */
  @Autowired
  DataSource dataSource;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication()
        .dataSource(dataSource)
//        .usersByUsernameQuery("SELECT username, password, enabled "
//            + "FROM users "
//            + "WHERE username = ?")
        .authoritiesByUsernameQuery("SELECT username, authority "
            + "FROM users "
            + "WHERE username = ?");
  }

  /**
   * This function is used to setup the password encoding.
   */
  @Bean
  public PasswordEncoder getPasswordEncoder() {
    return NoOpPasswordEncoder.getInstance();
//    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }

  /**
   * This function is used to setup the permissions needed to load the specific endpoints.
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/submit", "/submit/", "/downvote/{id}", "/upvote/{id}")
        .hasAnyAuthority("USER")
        .antMatchers("/").permitAll()
        .and()
        .formLogin();
  }
}
