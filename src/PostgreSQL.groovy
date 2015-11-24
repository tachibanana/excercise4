import java.sql.*;

class PostgreSQL extends DBUser implements ServerConnection {

	private String status
	
	@Override
	public Connection getConnection(){
		try{
			Class.forName(dbclass)
			Connection conn = DriverManager.getConnection(getConnectionURL())
			status = "Success"
			return conn;
		}catch(Exp){
			status = "Error"
			return null
		}
	}

	@Override
	public String getConnectionURL() {
		
		"${dburl}${dbname}?username=${dbuser}&password=${dbpass}"
	}

	@Override
	public String getConnectionStatus() {
		return status
	}

	
	

}
