package com.infor.hnlmnl.genesis.soho.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.infor.hnlmnl.genesis.soho.dto.IconTag;
import com.infor.hnlmnl.genesis.soho.utility.Common;

public class IconTagMapper implements DataMapper {

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> mapRowsFromQuery(List<Map<String, Object>> resultSet) {
		// TODO Auto-generated method stub
		List<IconTag> iconTags = new ArrayList<IconTag>();
		
		for (Map<String, Object> result : resultSet) {
			int tagId = (int) result.get(Common.TAG_ID);
			String tagName = (String) result.get(Common.TAG_NAME);
			
			iconTags.add(new IconTag(tagId, tagName));
		}
		
		return (List<T>) iconTags;
	}

}
