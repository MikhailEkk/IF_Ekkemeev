package ru.iFellow;

import io.cucumber.junit.platform.engine.Constants.*;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("src/main/java/ru/iFellow/steps") //steps location
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/resources/features") //feature location
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
//@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "src.main.java.ru.iFellow.steps")
//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@ifellow")
//@ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
public class CucumberRunnerTest {

}
