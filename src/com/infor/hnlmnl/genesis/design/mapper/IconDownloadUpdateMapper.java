package com.infor.hnlmnl.genesis.design.mapper;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import com.infor.hnlmnl.genesis.design.dto.Icon;
import com.infor.hnlmnl.genesis.design.dto.IconDownloadUpdate;
import com.infor.hnlmnl.genesis.design.dto.IconProperty;
import com.infor.hnlmnl.genesis.design.dto.IconTag;
import com.infor.hnlmnl.genesis.design.dto.IconType;
import com.infor.hnlmnl.genesis.design.dto.Product;
import com.infor.hnlmnl.genesis.design.utility.Common;

public class IconDownloadUpdateMapper implements DataMapper {

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> mapRowsFromQuery(List<Map<String, Object>> resultSet) {
		// TODO Auto-generated method stub
		List<IconDownloadUpdate> iconDownloadUpdateList = new ArrayList<IconDownloadUpdate>();
		
		List<Icon> icons = new ArrayList<Icon>();
		
		for (Map<String, Object> result : resultSet) {
			int iconId = (int) result.get(Common.ICON_ID);
			
			try {
				Predicate<Icon> itemPredicator = iconPredicated-> iconPredicated.getIconId() == iconId;
				Icon iconResult = icons.stream().filter(itemPredicator).findFirst().get();
				
				icons.remove(iconResult);
				
				int tagId = (int) result.get(Common.TAG_ID);
				String tagName = (String) result.get(Common.TAG_NAME);
				
				iconResult.getTags().add(new IconTag(tagId, tagName));
				icons.add(iconResult);
			} catch (Exception e) {
				String iconName = (String) result.get(Common.ICON_NAME);
				int iconCounter = (int) result.get(Common.ICON_COUNTER);
				String iconStatus = (String) result.get(Common.ICON_STATUS);
				int typeId = (int) result.get(Common.TYPE_ID);
				String typeName = (String) result.get(Common.TYPE_NAME);
				int typeClass = (int) result.get(Common.TYPE_CLASS);
				String typeSize = (String) result.get(Common.TYPE_SIZE);
				
				List<IconTag> tags = new ArrayList<IconTag>();
				
				int tagId = (int) result.get(Common.TAG_ID);
				String tagName = (String) result.get(Common.TAG_NAME);
				tags.add(new IconTag(tagId, tagName));
				
				List<IconProperty> properties = new ArrayList<IconProperty>();
				List<Product> products = new ArrayList<Product>();
				
				Icon icon = new Icon(iconId, iconName, iconCounter, iconStatus, 
						new IconType(typeId, typeName, typeClass, 0, typeSize), tags, properties, products);
				icons.add(icon);
			}
		}
		
		IconDownloadUpdate iconDownloadUpdate = new IconDownloadUpdate(icons, null);
		
		iconDownloadUpdateList.add(iconDownloadUpdate);
		
		return (List<T>) iconDownloadUpdateList;
	}
}
