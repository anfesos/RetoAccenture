package com.accenture.ejemploSerenityCucumber;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/NinjaStore.feature")

//glue: para la dirección y nombre de clase estan los pasos que se van a ejecutar glue= {"src/test/java/steps/DefinitionSteps"}

public class DefinitionTestSuite {}
