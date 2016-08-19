/**
 * 
 */
package Entities;

/**
 * @author megapunk
 *
 */
public class CartEntity {
	private String pId;
	private String pName;
	private Integer quanlity;
	private Float price;
	private Float total;
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Integer getQuanlity() {
		return quanlity;
	}
	public void setQuanlity(Integer quanlity) {
		this.quanlity = quanlity;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public CartEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartEntity(String pId, String pName, Integer quanlity, Float price, Float total) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.quanlity = quanlity;
		this.price = price;
		this.total = total;
	}
	@Override
	public String toString() {
		return "CartBean [pId=" + pId + ", pName=" + pName + ", quanlity=" + quanlity + ", price=" + price + ", total="
				+ total + "]";
	}
}
