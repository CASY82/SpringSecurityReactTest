package kr.test.reactSecurity.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.test.reactSecurity.dao.AdminDAO;
import kr.test.reactSecurity.vo.AdminVO;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private AdminDAO adminDAO;

	// DB 연결 전
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		if("admin".equals(username)) {
//			return new User("admin", "$2a$10$m/enYHaLsCwH2dKMUAtQp.ksGOA6lq7Fd2pnMb4L.yT4GyeAPRPyS", new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("사용자를 찾을 수 없습니다 : " + username);
//		}
//	}
	
	// DB 연결 후
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AdminVO adminVO = adminDAO.getUser();
		
		if(adminVO.getAdmin_id().equals(username)) {
			return new User(adminVO.getAdmin_id(), "$2a$10$m/enYHaLsCwH2dKMUAtQp.ksGOA6lq7Fd2pnMb4L.yT4GyeAPRPyS", new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("사용자를 찾을 수 없습니다 : " + username);
		}
	}

}
