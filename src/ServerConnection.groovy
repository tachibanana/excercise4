import java.sql.Connection


interface ServerConnection {

	public Connection getConnection()
	public String getConnectionURL()
	public String getConnectionStatus()
}
