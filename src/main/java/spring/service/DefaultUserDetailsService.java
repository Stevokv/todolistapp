package spring.service;

import java.util.Collections;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserDetailsService implements UserDetailsService{
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return mockUser(username);
	}
	
	private UserDetails mockUser(String username) {
		String userName = "stevodev";
		String userPass = "pass";
		
		if(!userName.equals(username)) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		
		UserDetails user = User.withDefaultPasswordEncoder()
				.username(username)
				.password(userPass)
				.authorities(getAuthority())
				.build();
		return user;
	}
	
	private List<SimpleGrantedAuthority> getAuthority(){
		return Collections.emptyList();
	}
}
