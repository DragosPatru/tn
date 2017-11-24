//package com.tuneride.server.configuration;
//
//import javax.inject.Inject;
//
//import org.springframework.cache.Cache;
//import org.springframework.cache.CacheManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.cache.SpringCacheBasedUserCache;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
//
//import javax.sql.DataSource;
//
//@Configuration
////@EnableWebSecurity
//@ComponentScan("com.tuneride.server.configuration")
//public class TunerideSecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	@Inject
//	private DataSource dataSource;
//	@Inject
//	private CacheManager cacheManager;
//	
//	/**
//	 * For Spring Security to access the db tables it should be able to access
//	 * the database, so it needs a datasource for db connection
//	 * 
//	 * It makes use of password encoder to automatically encrypt the user passwords
//	 * */
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
//		 auth.jdbcAuthentication().userCache(userCache())
//		 						//.passwordEncoder(passwordEncoder())
//		 						.dataSource(dataSource);
//		 
//		 /*
//		  * 
//		  * 
//		  *  auth.inMemoryAuthentication()
//          .withUser("temporary").password("temporary").roles("ADMIN")
//          .and()
//          .withUser("user").password("userPass").roles("USER");*/
//		 
//	}
//	
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//	        http.authorizeRequests()
//	                .antMatchers("/events*").hasAnyRole("USER", "ADMIN");
//	        
//	        /*http
//        .csrf().disable()
//        .exceptionHandling()
//        .authenticationEntryPoint(restAuthenticationEntryPoint)
//        .and()
//        .authorizeRequests()
//        .antMatchers("/api/foos").authenticated()
//        .and()
//        .formLogin()
//        .successHandler(authenticationSuccessHandler)
//        .failureHandler(new SimpleUrlAuthenticationFailureHandler())
//        .and()
//        .logout();*/
//	}
//	
//	 @Bean
//	    public AuthenticationRequestHandler mySuccessHandler(){
//	        return new AuthenticationRequestHandler();
//	    }
//	    @Bean
//	    public SimpleUrlAuthenticationFailureHandler myFailureHandler(){
//	        return new SimpleUrlAuthenticationFailureHandler();
//	    }
//	
//	/**
//	 * Encrypt passwords to store in database
//	 * */
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	/**
//	 * Adding caching for user data
//	 * */
//	@Bean
//	public SpringCacheBasedUserCache userCache() throws Exception {
//	        Cache cache = cacheManager.getCache("userCache");
//	        return new SpringCacheBasedUserCache(cache); 
//	}
//	
//}
