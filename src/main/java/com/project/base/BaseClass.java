package com.project.base;

import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.project.CommonModules.ObjectInitializer;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.path.json.JsonPath;

public class BaseClass {
	private static final Logger logger;

	public static JsonPath policyDefinitionList;
	public static HashMap<String, HashMap<String, HashMap<String, List<HashMap<String, String>>>>> inventoryFieldsMap;

	@Before
	public void beforeMethod(Scenario scenario) {
		logger.info("Initializing Objects...............");
		new ObjectInitializer();

	}

	static {
		logger = LogManager.getLogger(BaseClass.class);
	}
}
