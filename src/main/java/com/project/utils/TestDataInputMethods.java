package com.project.utils;

import java.util.List;

import com.project.CommonModules.ObjectInitializer;
import com.tavant.util.DataInputMethods;

public class TestDataInputMethods extends DataInputMethods {
	public static List<Object> getData(String jsonPath) {
		return DataInputMethods.getListOfData(jsonPath);
	}

	public static String getTestData(String jsonPath) {
		return DataInputMethods.getTestData(jsonPath);
	}

	public static String getTestData(String jsonPathParameter1, String jsonPathParameter2) {
		return DataInputMethods.getTestData(ObjectInitializer.commonMethods.get().getTestDataIndex(),
				jsonPathParameter1, jsonPathParameter2);
	}

	public static String getTestData(String jsonPathParameter1, String jsonPathParameter2, String jsonPathParameter3) {
		return DataInputMethods.getTestData(ObjectInitializer.commonMethods.get().getTestDataIndex(),
				jsonPathParameter1, jsonPathParameter2, jsonPathParameter3);
	}

	public static String getTestData(String jsonPathParameter1, String jsonPathParameter2, String jsonPathParameter3,
			String jsonPathParameter4) {
		return DataInputMethods.getTestData(ObjectInitializer.commonMethods.get().getTestDataIndex(),
				jsonPathParameter1, jsonPathParameter2, jsonPathParameter3, jsonPathParameter4);
	}
}
