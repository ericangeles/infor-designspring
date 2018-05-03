package com.infor.hnlmnl.genesis.soho.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.infor.hnlmnl.genesis.soho.dto.Product;
import com.infor.hnlmnl.genesis.soho.mapper.ProductMapper;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public ProductMapper getProductMapper() {
		return new ProductMapper();
	}
	
	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		String sql = "SELECT productId, productName FROM tbl_soho_product ORDER BY productName";
		List<Product> products = getProductMapper().mapRows(jdbcTemplate.queryForList(sql));
		return products;
	}

}
