
class Main {

	static main(args) throws Exception{
	
		Scanner scanner = new Scanner(System.in)
		ServerConnection sc = new PostgreSQL(dbname:'sampledb')
		DBManager manager = new DBManager(sc)
		manager.openConnection()
		
		manager.deleteData(1)
		manager.deleteData(2)
		manager.deleteData(3)
		manager.deleteData(4)
		
		println "current table: ${sc.dbname}"
		println "current table size: ${manager.getCount()}"
		
		manager.addData(new TableData(id:1 ,dataName:'test', data1:2 , data2:2 , status:'in progress'))
		manager.addData(new TableData(id:2 ,dataName:'test5', data1:3 , data2:6 , status:'in progress'))
		manager.addData(new TableData(id:3 ,dataName:'test6', data1:2 , data2:3 , status:'in progress'))
		manager.addData(new TableData(id:4 ,dataName:'test5', data1:3 , data2:5 , status:'in progress'))
		
		println "current table size: ${manager.getCount()}\n"
		
		println 'id\tdataname\tdata1\tdata2\tstatus'
		println '---------------------------------------------------'
		manager.getTableDataList().each{
			println "${it.id}\t${it.dataName}\t\t ${it.data1}\t ${it.data2}\t${it.status}"
			
		}
		
		
	}

}
