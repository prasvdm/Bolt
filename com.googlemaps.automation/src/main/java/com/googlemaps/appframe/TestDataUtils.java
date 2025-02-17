package com.googlemaps.appframe;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class TestDataUtils {
	public Map<String, String> initData() throws IOException {

		Properties prop = new Properties();
		InputStream input = null;
		Map<String, String> dataTable = new HashMap<String, String>();

			String directory = System.getProperty("user.dir") +"/src/test/resources/TestData/searchData.properties";
			input = new FileInputStream(directory);
			prop.load(input);
			dataTable.putAll(prop.entrySet().stream()
					.collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.getValue().toString())));
		

		return dataTable;

	}
}
