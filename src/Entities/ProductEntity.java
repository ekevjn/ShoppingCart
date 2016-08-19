/**
 * 
 */
package Entities;

/**
 * @author megapunk
 *
 */
public class ProductEntity {
	private String id;
	private String pname;
	private String price;
	private String cname;
	private String description;
	
	public ProductEntity() {
		super();
	}
	
	public ProductEntity(String id, String pname, String price, String cname, String description) {
		super();
		this.id = id;
		this.pname = pname;
		this.price = price;
		this.cname = cname;
		this.description = description;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", pname=" + pname + ", price=" + price + ", cname=" + cname
				+ ", description=" + description + "]";
	}
}
