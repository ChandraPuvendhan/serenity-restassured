package starter.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import starter.status.BDDStyledUtils;
import cucumber.api.java.en.And;


public class APITestsStepDefinitions {


	@Given("I perform POST operation for Google Maps API")
    public void iPerformPOSTOperationForGoogleMapsAPI() {
		BDDStyledUtils.AddPlaceInGoogleMap();
    }
	
	@Then("I perform GET operation for Google Maps API")
    public void iPerformGETForGoogleMapsAPI() {
		BDDStyledUtils.DisplayPlaceInGoogleMap();
    }
	
	@Then("I perform PUT operation for Google Maps API")
    public void iPerformPUTForGoogleMapsAPI() {
		BDDStyledUtils.UpdatePlaceInGoogleMap();
    }
	@And("I perform DELETE operation for Google Maps API")
    public void iPerformDELETEForGoogleMapsAPI() {
		BDDStyledUtils.DeletePlaceInGoogleMap();
    }
}