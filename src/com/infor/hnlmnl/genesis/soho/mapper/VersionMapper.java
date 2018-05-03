package com.infor.hnlmnl.genesis.soho.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.infor.hnlmnl.genesis.soho.dto.Version;
import com.infor.hnlmnl.genesis.soho.utility.Common;

public class VersionMapper implements DataMapper {

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> mapRowsFromQuery(List<Map<String, Object>> resultSet) {
		// TODO Auto-generated method stub
		List<Version> versions = new ArrayList<Version>();
		
		for (Map<String, Object> result : resultSet) {
			int versionId = (int) result.get(Common.VERSION_ID);
			String versionName = (String) result.get(Common.VERSION_NAME);
			String versionDateTime = (String) result.get(Common.VERSION_DATE_TIME);
			versions.add(new Version(versionId, versionName, versionDateTime));
		}
		
		return (List<T>) versions;
	}

}
