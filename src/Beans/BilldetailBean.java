package Beans;

public class BilldetailBean {
	private String id;
	private String bid;
	private String pname;
	private String quanlity;
	private String total;
	public BilldetailBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BilldetailBean(String id, String pname, String quanlity, String total) {
		super();
		this.id = id;
		this.pname = pname;
		this.quanlity = quanlity;
		this.total = total;
		this.bid = bid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getQuanlity() {
		return quanlity;
	}
	public void setQuanlity(String quanlity) {
		this.quanlity = quanlity;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "BilldetailBean [id=" + id + ", bid=" + bid + ", pname=" + pname + ", quanlity=" + quanlity + ", total="
				+ total + "]";
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	
}
