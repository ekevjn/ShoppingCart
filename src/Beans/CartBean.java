package Beans;

import java.util.ArrayList;
import java.util.List;

import Entities.CartEntity;

public class CartBean {
	private List<CartEntity> cList;
	private float totalprice;
	
	public List<CartEntity> getcList() {
		return cList;
	}
	public void setcList(List<CartEntity> cList) {
		this.cList = cList;
	}
	public float getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}
	@Override
	public String toString() {
		return "CartBean [cList=" + cList + ", totalprice=" + totalprice + "]";
	}
	public CartBean(List<CartEntity> cList, float totalprice) {
		super();
		this.cList = cList;
		this.totalprice = totalprice;
	}
	public CartBean() {
		this.cList = new ArrayList<CartEntity>();
	}
	
	public void removeEn(CartEntity entity){
		this.cList.remove(entity);
		this.setcList(cList);
	}
	
}
