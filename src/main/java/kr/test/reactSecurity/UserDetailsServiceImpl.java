package kr.test.reactSecurity;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.test.reactSecurity.dao.AdminDAO;
import kr.test.reactSecurity.vo.AdminVO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AdminDAO adminDAO;
	
	@Autowired
	public UserDetailsServiceImpl(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AdminVO user = adminDAO.getUser();
		
		return new org.springframework.security.core.userdetails.User(user.getAdmin_id(), user.getAdmin_password(), Arrays.asList(new SimpleGrantedAuthority(user.getAdmin_roleGroup())));
	}

}
