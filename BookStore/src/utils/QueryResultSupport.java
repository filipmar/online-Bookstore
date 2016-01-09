package utils;

public class QueryResultSupport {
	Boolean success;
	String errorMsg;
	Integer generatedId;
	
	public QueryResultSupport(){
		this.success = false;
		this.errorMsg="";
		this.generatedId=null;
	}
	
	
	public QueryResultSupport(Boolean success, String errorMsg,
			Integer generatedId) {
		super();
		this.success = success;
		this.errorMsg = errorMsg;
		this.generatedId = generatedId;
	}


	public Boolean getSuccess() {
		return success;
	}


	public void setSuccess(Boolean success) {
		this.success = success;
	}


	public String getErrorMsg() {
		return errorMsg;
	}


	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}


	public Integer getGeneratedId() {
		return generatedId;
	}


	public void setGeneratedId(Integer generatedId) {
		this.generatedId = generatedId;
	}
	
}
