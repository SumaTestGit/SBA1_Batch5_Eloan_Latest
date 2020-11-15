package com.wellsfargo.evaluation.eloan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wellsfargo.evaluation.eloan.model.LoanInfo;

public class ConnectionDao {

	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	
	static final String FETCH_USER_CRED = "select username, password from User where username=? and password=?";
		
	static final String FETCH_USER_INFO = "select * from userinfo where username='%s'";
	
	static final String FETCH_LOAN_INFO = "select * from loan where mobile='%s'";
	
	static final String FETCH_LOAN_INFO_BY_ID = "select status from loan where applno='%s'";
	
	static final String FETCH_LOAN_ALLINFO_BY_ID = "select * from loan where applno=%s";	

	static final String FETCH_ALL_LOAN_INFO = "select * from loan";
	
	static final String UPDATE_LOAN_INFO_BY_ID = "UPDATE loan SET USER_NAME='%s',purpose='%s',amtrequest=%s,bstructure='%s',bindicator='%s',address='%s',email='%s',mobile='%s' where applno='%s' and status='Submitted'";
	
	static final String UPDATE_LOAN_STATUS_BY_ID = "UPDATE loan SET status='%s' WHERE applno ='%s'";
		
	public static final String INS_LOANINFO_QRY=
			"INSERT INTO loan(USER_NAME,purpose,amtrequest,doa,bstructure,bindicator,address,email,mobile,status) VALUES(?,?,?,?,?,?,?,?,?,?)";
	
	public static final String INS_LOANSANCTION_QRY=
			"INSERT INTO ApprovedLoan(applno,AmountSanctioned,LoanTerm,PaymentStartDate,LoanClosureDate,InterestRate,TermPaymentAmount,MonthlyPayment) VALUES(?,?,?,?,?,?,?,?)";
		
	public static final String INS_USERCRED_QRY =
			"INSERT INTO User(username,password) VALUES(?,?)";
	
	public static final String INS_USERINFO_QRY=
			"INSERT INTO UserInfo(USER_NAME,USER_FIRSTNAME,USER_LASTNAME,MOBILE,EMAIL,CITY,STATE,COUNTRY,ZIPCODE,CUSTOMER_ADDRESS,DOB) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	

	public ConnectionDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}

	public Connection connect() throws SQLException {
		
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
		return jdbcConnection;
	}

	public void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}

	// put the relevant DAO methods here..
	
	public static boolean validateUser(String userName, String password, Connection con) {
		
		PreparedStatement ps;
		
		try {
			
			ps = con.prepareStatement(FETCH_USER_CRED);
			ps.setString(1, userName);
			ps.setString(1, password);
			
			ResultSet rs = ps.executeQuery();			
			return rs.next();
			
		} catch (SQLException exp) {
			exp.printStackTrace();
			return false;
		}		
	}
	
	public void createUser(String userName, String password, Connection con) {
		
		PreparedStatement ps;
		
		try {
			
			ps = con.prepareStatement(INS_USERCRED_QRY);
			ps.setString(1, userName);
			ps.setString(1, password);
			ps.executeQuery();	
			
		} catch (SQLException exp) {
			exp.printStackTrace();
		}
	}
	
	public String selectStatusByApplicationNumber(String applicationNumber, Connection con) {
		
		LoanInfo loanInfo = new LoanInfo();
		PreparedStatement ps;
		
		try {
			
			ps = con.prepareStatement(FETCH_LOAN_INFO_BY_ID);
			ps.setString(1, applicationNumber);
			
			ResultSet rs = ps.executeQuery();	
			
			if(rs.next()) {
				return rs.getString(loanInfo.getStatus());
			} else {
				return "";
			}			
			
		} catch (SQLException exp) {
			exp.printStackTrace();
			return "";
		}
	}
	
	
	
}
