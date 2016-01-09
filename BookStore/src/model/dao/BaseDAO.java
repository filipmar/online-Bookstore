package model.dao;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import utils.QueryResultSupport;

public class BaseDAO {
	
	protected InitialContext ic;
	protected DataSource ds;
	protected String tableName;
	protected QueryResultSupport lastQueryResult;
	
	public BaseDAO(){
		this.ic=null;
		this.ds=null;
		this.lastQueryResult=null;
		
		try{
			this.ic = new InitialContext();
			this.ds = (DataSource) ic.lookup("java:comp/env/jdbc/rs1");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public QueryResultSupport getLastQueryResult() {
		return lastQueryResult;
	}

}
