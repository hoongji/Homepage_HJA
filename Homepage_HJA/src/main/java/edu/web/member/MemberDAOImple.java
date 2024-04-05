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
	
	
	// conn, pstmt 리소스 해제 함수 
	private void closeResource(Connection conn, PreparedStatement pstmt) {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	private void closeResource(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			pstmt.close();
			conn.close();
			rs.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
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
			closeResource(conn, pstmt);
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

	@Override
	public MemberVO select(String userid) {
		MemberVO vo =null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			System.out.println("오라클 연결 성공");
			
			pstmt = conn.prepareStatement(SQL_SELECT_BY_USERID);
			
			pstmt.setString(1, userid); //  ?로 표시된 첫 번째 매개변수 위치에 userid 값을 넣겠다
			rs = pstmt.executeQuery(); // 설정된 쿼리를 실행하고 그 결과를 ResultSet 객체에 저장
			
			if(rs.next()) {
				// userid = rs.getString(COL_USERID);
				String password = rs.getString(COL_PASSWORD);
				String email = rs.getString(COL_EMAIL);
				String emailAgree = rs.getString(COL_EMAIL_AGREE);
				String[] interest = rs.getString(COL_INTEREST).split(",");
				String phone = rs.getString(COL_PHONE);
				String introduce = rs.getString(COL_INTEREST);
				vo = new MemberVO(userid, password, email, emailAgree, interest, phone, introduce); // 조회된 정보를 vo(객체)에 담는 것
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			closeResource(conn, pstmt, rs);
		}
		
		return vo;
	}

	
	@Override
	public int update(MemberVO vo) {
		  int result = 0;
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      
	      try {
	         DriverManager.registerDriver(new OracleDriver());
	         conn = DriverManager.getConnection(URL, USER, PASSWORD);
	         pstmt = conn.prepareStatement(SQL_UPDATE);
	         
	         pstmt.setString(1, vo.getPassword()); //  ?로 표시된 매개변수 위치에 vo에서 pw 값을 읽어서 넣겠다
	         pstmt.setString(2, vo.getEmail());
	         pstmt.setString(3, vo.getEmailAgree());
	         pstmt.setString(4, vo.getInterestJoin());
	         pstmt.setString(5, vo.getPhone());
	         pstmt.setString(6, vo.getIntroduce());
	         pstmt.setString(7, vo.getUserid());
	         
	         result = pstmt.executeUpdate(); // 설정된 쿼리를 실행하고 그 결과를 ResultSet 객체에 저장
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         closeResource(conn, pstmt);
	      }
	      
	      return result;

	}

	@Override
	public int delete(String userid) {
		 int result = 0;
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      
	      try {
	         DriverManager.registerDriver(new OracleDriver());
	         conn = DriverManager.getConnection(URL, USER, PASSWORD);
	         pstmt = conn.prepareStatement(SQL_DELETE);
	         pstmt.setString(1, userid);
	         
	         result = pstmt.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         closeResource(conn, pstmt);
	      }
	      
	      return result;

	}

	@Override
	public String select(String userid, String password) {
		String confirmUserid = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
	         pstmt = conn.prepareStatement(SQL_SELECT_BY_USERID_PASSWORD);
	         
	         pstmt.setString(1, userid); //  ?로 표시된 매개변수 위치에 입력된 userid값을 넣겠다
	         pstmt.setString(2, password);//  ?로 표시된 매개변수 위치에 입력된 password값을 넣겠다
	         
	         rs = pstmt.executeQuery();// 설정된 쿼리를 실행하고 그 결과를 ResultSet 객체에 저장
	         
	         // rs.next() : 다음 레코드가 존재하면 true를 반환하고, 그렇지 않으면 false를 반환
	         if(rs.next()) { // 다음 레코드가 존재하는지 여부를 확인
	        	 confirmUserid = rs.getString(COL_USERID); // 결과는 null인지 아닌지
	        	 // true 이면 결과는 현재 레코드에서의 사용자 아이디 값만을 가져옴
	         }
	         
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
	         closeResource(conn, pstmt);
	      }
		
		
		return confirmUserid;
	}



}
