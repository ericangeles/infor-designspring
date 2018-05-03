package com.infor.hnlmnl.genesis.soho.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.infor.hnlmnl.genesis.soho.dto.BaseIcon;
import com.infor.hnlmnl.genesis.soho.dto.IconType;

public class BaseIconMapper implements DataMapper {

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> mapRowsFromQuery(List<Map<String, Object>> resultSet) {
		// TODO Auto-generated method stub
		List<BaseIcon> baseIcons = new ArrayList<BaseIcon>();
		
		for (Map<String, Object> result : resultSet) {
			int iconId = (int) result.get("iconId");
			String iconName = (String) result.get("iconName");
			int iconCounter = (int) result.get("iconCounter");
			String iconStatus = (String) result.get("iconStatus");
			int typeId = (int) result.get("typeId");
			String typeName = (String) result.get("typeName");
			int typeClass = (int) result.get("typeClass");
			
			baseIcons.add(new BaseIcon(iconId, iconName, iconCounter, iconStatus, new IconType(typeId, typeName, typeClass, 0)));
		}
		
		return (List<T>) baseIcons;
	}

}
