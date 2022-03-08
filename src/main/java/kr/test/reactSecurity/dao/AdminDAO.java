package kr.test.reactSecurity.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.test.reactSecurity.vo.AdminVO;

@Mapper
public interface AdminDAO {
	AdminVO getUser();
}
