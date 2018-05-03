package com.infor.hnlmnl.genesis.soho.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.infor.hnlmnl.genesis.soho.dto.IconType;
import com.infor.hnlmnl.genesis.soho.utility.Common;

public class IconTypeMapper implements DataMapper {

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> mapRowsFromQuery(List<Map<String, Object>> resultSet) {
		// TODO Auto-generated method stub
		List<IconType> iconTypes = new ArrayList<IconType>();
		
		iconTypes.add(new IconType(9, Common.ALL, 0, 0, Common.STRING_EMPTY));
		for (Map<String, Object> result : resultSet) {
			int typeId = (int) result.get(Common.TYPE_ID);
			String typeName = (String) result.get(Common.TYPE_NAME);
			int typeClass = (int) result.get(Common.TYPE_CLASS);
			long typeCount = (long) result.get(Common.TYPE_COUNT);
			String typeSize = (String) result.get(Common.TYPE_SIZE);
			
			iconTypes.add(new IconType(typeId, typeName, typeClass, typeCount, typeSize));
		}
		
		return (List<T>) iconTypes;
	}

}
