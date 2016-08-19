/**
 * 
 */
package Beans;

import java.io.Serializable;

/**
 * @author megapunk
 *
 */
public class LoginBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6452936709663551347L;
	private String userName;
	private String password;
	private String fullname;
	private String rollnumber;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getRollnumber() {
		return rollnumber;
	}
	public void setRollnumber(String rollnumber) {
		this.rollnumber = rollnumber;
	}
	public LoginBean(String userName, String password, String fullname, String rollnumber) {
		super();
		this.userName = userName;
		this.password = password;
		this.fullname = fullname;
		this.rollnumber = rollnumber;
	}
	public LoginBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LoginBean [userName=" + userName + ", password=" + password + ", fullname=" + fullname + ", rollnumber="
				+ rollnumber + "]";
	}
	
	

}
