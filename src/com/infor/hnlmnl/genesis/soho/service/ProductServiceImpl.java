package com.infor.hnlmnl.genesis.soho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infor.hnlmnl.genesis.soho.dao.ProductDao;
import com.infor.hnlmnl.genesis.soho.dto.Product;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		List<Product> products = productDao.getProducts();
		return products;
	}

}
