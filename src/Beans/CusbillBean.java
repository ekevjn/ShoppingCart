/**
 * 
 */
package Beans;

import java.io.Serializable;
import java.util.List;

import Entities.CartEntity;

/**
 * @author megapunk
 *
 */
public class CusbillBean implements Serializable {
	
	private String id;
	private String cusName;
	private String createdDate;
	private String status;
	private String totalbill;
	private List<CartEntity> cList;
	public CusbillBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CusbillBean(String id, String cusName, String createdDate, String status, String totalbill,
			List<CartEntity> cList) {
		super();
		this.id = id;
		this.cusName = cusName;
		this.createdDate = createdDate;
		this.status = status;
		this.totalbill = totalbill;
		this.cList = cList;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTotalbill() {
		return totalbill;
	}
	public void setTotalbill(String totalbill) {
		this.totalbill = totalbill;
	}
	public List<CartEntity> getcList() {
		return cList;
	}
	public void setcList(List<CartEntity> cList) {
		this.cList = cList;
	}
	@Override
	public String toString() {
		return "CusbillBean [id=" + id + ", cusName=" + cusName + ", createdDate=" + createdDate + ", Status=" + status
				+ ", totalbill=" + totalbill + ", cList=" + cList + "]";
	}
	
	
}
