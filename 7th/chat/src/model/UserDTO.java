package model;

public class UserDTO {

	private String id;
	private String pwd;
	
	public UserDTO(String id, String pwd) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.pwd=pwd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	
}
