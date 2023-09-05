package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int product_id;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_code")
	private String productCode;

	@Column(name = "product_category")
	private String productCategory;

	@Column(name = "product_metatype")
	private String productMetatype;
	
	@Column(name = "json_column", columnDefinition = "JSON")
	private String jsonColumn;
	
	@Lob
	private String product_image;

	public String getJsonColumn() {
		return jsonColumn;
	}

	public void setJsonColumn(String jsonColumn) {
		this.jsonColumn = jsonColumn;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductMetatype() {
		return productMetatype;
	}

	public void setProductMetatype(String productMetatype) {
		this.productMetatype = productMetatype;
	}
	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
}
