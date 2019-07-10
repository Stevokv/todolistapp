package spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@EnableResourceServer
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
	
	private static final String RESOURCE_ID = "resource_id";
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId(RESOURCE_ID).stateless(false);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
        .antMatchers(HttpMethod.GET,"/**").permitAll()  //.antMatchers(HttpMethod.GET,"/todoitems/**", "/swagger-ui.html").permitAll()
        .and()
        .authorizeRequests()
        .antMatchers("/oauth/token").permitAll()
        .and()
        .authorizeRequests().antMatchers(HttpMethod.DELETE, "/todoitems/**").hasRole("ADMIN")
        .anyRequest().authenticated();
	      
		
//		http
//			.anonymous().disable()
//			.authorizeRequests().antMatchers(HttpMethod.GET, "/todoitems/**").permitAll()
//		    .and()
//			.requestMatchers().antMatchers(HttpMethod.POST, "/todoitems/**").antMatchers(HttpMethod.PUT, "/todoitems/**")
//			.and()
//			.authorizeRequests().antMatchers(HttpMethod.POST, "/todoitems/**").access("hasRole('ROLE_USER')")
//			.and()
//			.authorizeRequests().antMatchers(HttpMethod.PUT, "/todoitems/**").access("hasRole('ROLE_USER')")
//			.and()
//			.requestMatchers().antMatchers(HttpMethod.DELETE, "/todoitems/**")
//			.and()
//			.authorizeRequests().antMatchers(HttpMethod.DELETE, "/todoitems/**").access("hasRole('ROLE_ADMIN')");	
//		http
//			.authorizeRequests()
//			.antMatchers("/todoitems/**")
//			.authenticated()
//			.and()
//			.exceptionHandling()
//			.accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}
}
