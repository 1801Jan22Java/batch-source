package com.revature.driver;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Driver {

	@Test
	public void test_NumberOfCircuitsFor2017Season_ShouldBe20() {
	        
	    given().
	    when().
	        get("https://pokeapi.co/api/v2/pokemon/1/").
	    then().
	        assertThat().
	        body("forms.name", equalTo("bulbasaur"));
	}
	
}
