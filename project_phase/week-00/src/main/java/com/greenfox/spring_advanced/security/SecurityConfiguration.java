package com.greenfox.spring_advanced.security;

import com.greenfox.spring_advanced.services.user.MovieUserService;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  private DataSource dataSource;
  private MovieUserService movieUserService;

  @Autowired
  public SecurityConfiguration(DataSource dataSource, MovieUserService movieUserService) {
    this.dataSource = dataSource;
    this.movieUserService = movieUserService;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    auth.jdbcAuthentication()
//        .dataSource(dataSource)
////        .usersByUsernameQuery("SELECT username, password, enabled "
////            + "FROM users "
////            + "WHERE username = ?")
//        .authoritiesByUsernameQuery("SELECT username, authority "
//            + "FROM users "
//            + "WHERE username = ?");

    auth.userDetailsService(movieUserService);
  }

  @Bean
  public PasswordEncoder getPasswordEncoder() {
    return NoOpPasswordEncoder.getInstance();
//    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }

  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf()
        .disable()
        .authorizeRequests()
        .antMatchers("/authenticate", "/popular/short")
        .permitAll()
        .anyRequest()
        .authenticated();

//    http.authorizeRequests()
//        .antMatchers("/submit", "/submit/", "/downvote/{id}", "/upvote/{id}")
//        .hasAnyAuthority("USER")
//        .antMatchers("/").permitAll()
//        .and().formLogin();
  }
}
