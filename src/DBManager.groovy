import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet


class DBManager {

	ServerConnection sc
	Connection conn = null
	
	public DBManager(ServerConnection sc){
		
		this.sc = sc
	}
	
	public void setConnection(ServerConnection sc){
		if(conn == null){
			this.sc = sc
		}else{
			println 'All set!'
		}
		
	}
	
	public void openConnection() throws Exception{
		conn = sc.getConnection()
	}
	
	public List<TableData> getTableDataList() throws Exception{
		List<TableData> listTableData = new ArrayList<TableData>()
		String sql = "SELECT * FROM tbldata"
		PreparedStatement pst = conn.prepareStatement(sql)
		ResultSet rs = pst.executeQuery()
		while(rs.next()){
			listTableData.add(new TableData(
				id:rs.getInt('id') ,
				dataName:rs.getString('dataname'),
				data1:rs.getInt('data1'),
				data2:rs.getInt('data2'),
				status:rs.getString('status')))	
			
		}
		rs.close()
		return listTableData
	}	
	
	public int getCount(){
		String sql = "SELECT count(*) AS count FROM tbldata"
		PreparedStatement pst = conn.prepareStatement(sql)
		ResultSet rs = pst.executeQuery()
		rs.next()
		int count = rs.getInt("count")
		rs.close()
		return count
	}
	
	public void addData(TableData tableData){
		String sql = "INSERT INTO tbldata(id ,dataname , data1 , data2 , status) VALUES(? ,? ,? ,? ,?)"
		PreparedStatement pst = conn.prepareStatement(sql)
		pst.setInt(1 , tableData.id)
		pst.setString(2 , tableData.dataName)
		pst.setInt(3 , tableData.data1)
		pst.setInt(4 , tableData.data2)
		pst.setString(5 , tableData.status)
		pst.executeUpdate()
	}
	
	public void deleteData(int id){
		String sql = "DELETE FROM tbldata WHERE id = ?"
		PreparedStatement pst = conn.prepareStatement(sql)
		pst.setInt(1 , id)
		pst.executeUpdate()
	}
	
	public void updateData(TableData tableData , int id){
		String sql = "UPDATE tbldata SET WHERE id = ?"
		PreparedStatement pst = conn.prepareStatement(sql)
		pst.setInt(1 , id)
		pst.executeUpdate()
	}
}
