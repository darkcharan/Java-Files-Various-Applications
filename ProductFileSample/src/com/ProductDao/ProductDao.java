package com.ProductDao;

import java.util.List;

import com.ProductBean.ProductBean;

public interface ProductDao {
	void addProduct();
	List<ProductBean>viewProduct();
	void viewSpecificProduct(int pno);
	void UpdateProduct(int pno);
	void DeleteProduct(int pno);

}
