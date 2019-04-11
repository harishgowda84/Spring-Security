package com.harishgowda84.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;

	/*@Bean
	@Override
	protected UserDetailsService userDetailsService() {

		List<UserDetails> users = new ArrayList<>();

		List<GrantedAuthority> grantedAuths = AuthorityUtils.commaSeparatedStringToAuthorityList("user");

		User user = new User("harish", "1234", grantedAuths);

		users.add(user);
		// users.add(User.withDefaultPasswordEncoder().username("jim").password("1234").roles("manager").build());

		return new InMemoryUserDetailsManager(users);
	}*/
	
	
	
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		  .authorizeRequests()
		  .antMatchers("/manager").hasRole("manager")
		  .antMatchers("/actuator/**").permitAll()
		   .anyRequest().authenticated()
		   .and()
		  .formLogin()
		  .loginPage("/login").permitAll()
		   .and()
		   .logout().invalidateHttpSession(true)
		   .clearAuthentication(true)
		   .logoutUrl("/logout").permitAll();
		  
	}

	@Bean
	protected AuthenticationProvider authProvider() throws Exception {
		
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());		
		return daoAuthenticationProvider;
	}
	
	
	
	
	
	

}
