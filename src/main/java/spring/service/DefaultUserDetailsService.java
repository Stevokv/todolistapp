package spring.service;

import java.util.ArrayList;
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
		String userPass = "pass";
		List<String> userList = new ArrayList<>();
		if(!userList.contains(username)) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		UserDetails user;
		switch(username) {
		case "developer":
			user = User.withDefaultPasswordEncoder()
			.username(username)
			.password(userPass)
			.authorities("ROLE_USER")
			.build();
			break;
		case "admin":
			user = User.withDefaultPasswordEncoder()
			.username(username)
			.password(userPass)
			.authorities("ROLE_ADMIN")
			.build();
			break;
		default:
			user = null;
			break;
		}	
		return user;
	}
	
//	private List<SimpleGrantedAuthority> getAuthority(){
//		return Collections.emptyList();
//	}
}
