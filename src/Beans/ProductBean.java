package Beans;

import java.util.List;

import Entities.ProductEntity;

public class ProductBean {
	private List<ProductEntity> pList;

	public ProductBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductBean(List<ProductEntity> pList) {
		super();
		this.pList = pList;
	}

	public List<ProductEntity> getpList() {
		return pList;
	}

	public void setpList(List<ProductEntity> pList) {
		this.pList = pList;
	}

	@Override
	public String toString() {
		return "ProductBean [pList=" + pList + "]";
	}
}
