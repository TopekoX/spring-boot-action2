package com.timposu.latihan.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

/**
 * @author ucup
 * @url http://timposu.com
 * @email ucup.timposu@gmail.com
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private DataSource dataSource;
    
    private static final String SQL_USER_LOGIN = "select username, password, active as enable from s_user "
            + "where username=?";
    
    private static final String SQL_PERMISSION = "select u.username, r.nama as authority from  s_user u  "
            + "join s_user_role ur  on u.id = ur.id_user join s_role r  on "
            + "ur.id_role = r.id where u.username=?";
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(SQL_USER_LOGIN)
                .authoritiesByUsernameQuery(SQL_PERMISSION);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/halo").hasAnyRole("ADMIN","STAF")
                .antMatchers("/person/form").hasRole("ADMIN")
                .antMatchers("/person/delete").hasRole("ADMIN")
                .antMatchers("/person/list").hasAnyRole("ADMIN", "STAF")
                .antMatchers("/halorest").anonymous()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/halo", true)
                .and()
                .logout()
                .permitAll()
                .and()
                .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
                .csrf().csrfTokenRepository(csrfTokenRepository());
    }

    private CsrfTokenRepository csrfTokenRepository() {
      HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
      repository.setHeaderName("X-XSRF-TOKEN");
      return repository;
    }    
    
}
