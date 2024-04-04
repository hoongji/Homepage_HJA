package edu.web.member;

public interface DBConnection {
	// DB 접속에 필요한 상수 정의
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";
	
	// DB 테이블 컬럼 상수 정의
	public static final String TABLE_NAME = "TEST_MEMBER";
	public static final String COL_USERID = "USERID";
	public static final String COL_PASSWORD = "PASSWORD";
	public static final String COL_EMAIL = "EMAIL";
	public static final String COL_EMAIL_AGREE = "EMAIL_AGREE";
	public static final String SOL_INTEREST = "INTEREST";
	public static final String COL_PHONE = "PHONE";
	public static final String COL_INTRODUCE = "INTRODUCE";
	
	// INSERT INTO TEST_MEMBER VALUES
	//  (?, ?, ?, ?, ?, ?, ?) 
	public static final String SQL_INSERT = "INSERT INTO " + TABLE_NAME 
			+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	//SELECT_ALL
	public static final String SQL_SELECT =	"SELECT * FROM " + TABLE_NAME 
				+ " ORDER BY " + COL_USERID;
	
	// SELECT USERID FROM TEST_MEMBER;
    public static final String SQL_SELECT_USERID = "SELECT " + COL_USERID 
            + " FROM " + TABLE_NAME;
	
 // SELECT PASSWORD FROM TEST_MEMBER;
    public static final String SQL_SELECT_PASSWORD = "SELECT " + COL_PASSWORD 
            + " FROM " + TABLE_NAME;
    
    
}//end DBConnection