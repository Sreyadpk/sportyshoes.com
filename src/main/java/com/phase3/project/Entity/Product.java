package com.phase3.project.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private int productid;
	private String productname;
	private String productbrand;
	private Double productprice;
	private String productseller;
	private int productcount;

	public Product() {

	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductbrand() {
		return productbrand;
	}

	public void setProductbrand(String productbrand) {
		this.productbrand = productbrand;
	}

	public Double getProductprice() {
		return productprice;
	}

	public void setProductprice(Double productprice) {
		this.productprice = productprice;
	}

	public String getProductseller() {
		return productseller;
	}

	public void setProductseller(String productseller) {
		this.productseller = productseller;
	}

	public int getProductcount() {
		return productcount;
	}

	public void setProductcount(int productcount) {
		this.productcount = productcount;
	}

}
