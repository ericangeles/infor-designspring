package com.infor.hnlmnl.genesis.design.mapper;

import java.util.List;
import java.util.Map;

public interface DataMapper {
	public <T> List<T> mapRowsFromQuery(List<Map<String, Object>> resultSet);
}
