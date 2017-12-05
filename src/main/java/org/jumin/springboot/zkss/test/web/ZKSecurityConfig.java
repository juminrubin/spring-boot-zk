package org.jumin.springboot.zkss.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ZKSecurityConfig extends WebSecurityConfigurerAdapter {
    
    public static final String DEFAULT_APP_URL = "/index.zul";
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionFixation().none();
		
		http.authorizeRequests()
			.antMatchers(
					"/zkau*", "/zkau/**",	// <--- for zk ajax (internal)
                    "/zkau/web/**/*.wcs", "/zkau/web/**/*.wpd",   // <--- for zk ajax (internal)
					"/login*", "/logout",	// <--- for login/logout
					"/login.zul", 
					"/js/**", 	// <--- static resources...
					"/css/**", 
					"/bootstrap/**", 
					"/img/**", 
					"/static/**"
					)
			.permitAll().anyRequest().authenticated().and()
			.headers().frameOptions().disable().and()
//			.formLogin().permitAll()
            .formLogin().loginPage("/login.zul").permitAll()
            .defaultSuccessUrl(DEFAULT_APP_URL, false)
            .failureUrl("/login.zul?fail=true")
			.and() // this redirect always to testVM.zul page
			.logout()
//			.logoutSuccessUrl("/login.zul?logoutSuccess=true")
			.permitAll().and()
			.csrf().disable();
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// testing login user uuu / ppp
        auth.inMemoryAuthentication().withUser("user@org").password("pass1234").roles("USER");
    }

}
