package edu.web.member;

import java.util.ArrayList;

public interface MemberDAO {
	
	public abstract int insert(MemberVO vo);
	
	// 추가 코드 
	
	public abstract MemberVO select(String userid);
	
	public abstract int update(MemberVO vo);
	
	public abstract int delete(String userid);
	
	public abstract String select(String userid, String password);
	
	// 내 코드
	public abstract ArrayList<MemberVO> select();
	
	public abstract String getId(String id);
	
	public abstract String getPw(String pw);
}