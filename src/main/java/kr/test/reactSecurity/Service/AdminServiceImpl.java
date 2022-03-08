package kr.test.reactSecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.test.reactSecurity.dao.AdminDAO;
import kr.test.reactSecurity.vo.AdminVO;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDAO adminDAO;

	@Override
	public AdminVO getUser() {
		return adminDAO.getUser();
	}
}
