package com.infor.hnlmnl.genesis.design.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.infor.hnlmnl.genesis.design.dto.Product;
import com.infor.hnlmnl.genesis.design.utility.Common;

public class ProductMapper implements DataMapper {

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> mapRowsFromQuery(List<Map<String, Object>> resultSet) {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<Product>();
		
		for (Map<String, Object> result : resultSet) {
			int productId = (int) result.get(Common.PRODUCT_ID);
			String productName = (String) result.get(Common.PRODUCT_NAME);
			products.add(new Product(productId, productName));
		}
		return (List<T>) products;
	}

}
