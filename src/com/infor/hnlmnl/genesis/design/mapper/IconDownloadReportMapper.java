package com.infor.hnlmnl.genesis.design.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.infor.hnlmnl.genesis.design.dto.IconDownloadReport;
import com.infor.hnlmnl.genesis.design.utility.Common;

public class IconDownloadReportMapper implements DataMapper {

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> mapRowsFromQuery(List<Map<String, Object>> resultSet) {
		// TODO Auto-generated method stub
		List<IconDownloadReport> iconDownloads = new ArrayList<IconDownloadReport>();
		
		for (Map<String, Object> result : resultSet) {
			int downloadId = (int) result.get(Common.DOWNLOAD_ID);
			String downloadTime = (String) result.get(Common.DOWNLOAD_TIME);
			String emailAddress = (String) result.get(Common.EMAIL_ADDRESS);
			int productId = (int) result.get(Common.PRODUCT_ID);
			String productName = (String) result.get(Common.PRODUCT_NAME);
			int iconId = (int) result.get(Common.ICON_ID);
			String iconName = (String) result.get(Common.ICON_NAME);
			
			iconDownloads.add(new IconDownloadReport(downloadId, downloadTime, emailAddress, productId, productName, iconId, iconName));
		}
		
		return (List<T>) iconDownloads;
	}

}
