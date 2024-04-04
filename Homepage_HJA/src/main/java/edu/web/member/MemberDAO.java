package edu.web.member;

import java.util.ArrayList;

public interface MemberDAO {
	
	public abstract int insert(MemberVO vo);
	
	public abstract ArrayList<MemberVO> select();
	
	public abstract String getId(String id);
	
	public abstract String getPw(String pw);
}