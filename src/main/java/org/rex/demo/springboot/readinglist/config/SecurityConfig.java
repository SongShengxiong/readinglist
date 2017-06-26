package org.rex.demo.springboot.readinglist.config;

import org.rex.demo.springboot.readinglist.dao.ReaderRepository;
import org.rex.demo.springboot.readinglist.entity.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by RexSong on 2017/6/24.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ReaderRepository readerRepository;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> {
            Reader reader = readerRepository.findOne(username);
            if (reader == null) {
                reader = new Reader();
                reader.setUsername("rexsong");
                reader.setPassword("123");
                readerRepository.save(reader);
            }
            return reader;
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/rl/**").hasRole("READER")
                .antMatchers("/whatever/**").hasRole("ADMIN")
                .antMatchers("/**").permitAll()
                .and().formLogin().loginPage("/login").failureUrl("/login?error=true")
                .and().csrf().disable();
    }
}
