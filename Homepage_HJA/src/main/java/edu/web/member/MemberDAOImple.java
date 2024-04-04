package edu.web.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.OracleDriver;



public class MemberDAOImple implements MemberDAO, DBConnection{
	
	private static MemberDAOImple instance = null;
	
	private MemberDAOImple() {}
	
	public static MemberDAOImple getInstance() {
		if(instance == null) {
			instance = new MemberDAOImple();
		}
		return instance;
	}
	
	
	private ArrayList<MemberVO> list = new ArrayList<>(); 
	
	
	@Override
	public int insert(MemberVO vo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
		DriverManager.registerDriver(new OracleDriver());
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getEmailAgree());
			pstmt.setString(5, vo.getInterestJoin());
			pstmt.setString(6, vo.getPhone());
			pstmt.setString(7, vo.getIntroduce());
			System.out.println("SQL_INSERT 성공");
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
				e.printStackTrace();
			}
		}
		
				
		return result;
	}

	@Override
	public String getId(String id) {
		String userId = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		DriverManager.registerDriver(new OracleDriver());
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		System.out.println("getId 연결 성공");
			pstmt = conn.prepareStatement(SQL_SELECT_USERID);
	        
	        rs = pstmt.executeQuery(); 
	        
	        if (rs.next()) {
	        	userId = rs.getString(DBConnection.COL_USERID);
	        }
	        
	        System.out.println("SQL_SELECT_USERID 성공");
	        
	    } catch (SQLException e) {
	        System.out.println(e.toString());
	        e.printStackTrace();
	    } finally {
	        try {
	           rs.close();
	           pstmt.close();
	           conn.close();
	        } catch (SQLException e) {
	            System.out.println(e.toString());
	            e.printStackTrace();
	        }
	    }
		return userId;
	}

	@Override
	public String getPw(String pw) {
		String password = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		DriverManager.registerDriver(new OracleDriver());
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		System.out.println("getId 연결 성공");
			pstmt = conn.prepareStatement(SQL_SELECT_PASSWORD);
	        
	        rs = pstmt.executeQuery(); 
	        
	        if (rs.next()) {
	        	password = rs.getString(DBConnection.COL_PASSWORD);
	        }
	        
	        System.out.println("SQL_SELECT_PASSWORD 성공");
	        
	    } catch (SQLException e) {
	        System.out.println(e.toString());
	        e.printStackTrace();
	    } finally {
	        try {
	           rs.close();
	           pstmt.close();
	           conn.close();
	        } catch (SQLException e) {
	            System.out.println(e.toString());
	            e.printStackTrace();
	        }
	    }
		return password;
	}

	@Override
	public ArrayList<MemberVO> select() {
		ArrayList<MemberVO> list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		DriverManager.registerDriver(new OracleDriver());
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		System.out.println("getId 연결 성공");
			pstmt = conn.prepareStatement(SQL_SELECT);
	        
	        rs = pstmt.executeQuery(); 
	        
	        list = new ArrayList<>();
	        
	        while(rs.next()) { 
				String userId = rs.getString(1); // USERID 컬럼
				String pw = rs.getString(2); // PASSWORD 컬럼
				String email = rs.getString(3); // EMAIL 컬럼
				String emailAgree = rs.getString(4);	// EMAIL_AGREE 컬럼
				String interest = rs.getString(5); // INTEREST 컬럼
				String introduce = rs.getString(6); // INTRODUCE 컬럼
				
				MemberVO vo = new MemberVO(userId, pw, email, emailAgree, null, interest, introduce);
				list.add(vo);
			}
	        
	        
	        System.out.println("SQL_SELECT 성공");
	        
	    } catch (SQLException e) {
	        System.out.println(e.toString());
	        e.printStackTrace();
	    } finally {
	        try {
	           rs.close();
	           pstmt.close();
	           conn.close();
	        } catch (SQLException e) {
	            System.out.println(e.toString());
	            e.printStackTrace();
	        }
	    }
		
		return list;
	}

	
	

}
