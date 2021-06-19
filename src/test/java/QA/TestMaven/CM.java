package QA.TestMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CM {
	
/**
	private WebDriver driver;		
	@Test
	public void testEasy() {	
		driver.get("http://demo.guru99.com/test/guru99home/");  
		
		
		
	/*	String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("Demo Guru99 Page")); 		*/
/***	}	
	@BeforeTest
	public void beforeTest() {	
	  //  driver = new FirefoxDriver();  
		
		 System.setProperty("webdriver.chrome.driver", "C://Users//Dell//Documents//Chrome//chromedriver.exe");
		 
		    WebDriver driver=new ChromeDriver();  
		    
		//    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   // driver.get("http://demo.guru99.com/test/guru99home/");  
		    
		  //  driver.get("http://demo.guru99.com/test/guru99home/");  
	}		
	/***@AfterTest
	public void afterTest() {
		//driver.quit();
		driver.close();		
	}		***/
	
	
	@Test
	 public void GetWeatherDetails()
	 {   
	 // Specify the base URL to the RESTful web service
	 RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";
	 
	 // Get the RequestSpecification of the request that you want to sent
	 // to the server. The server is specified by the BaseURI that we have
	 // specified in the above step.
	 RequestSpecification httpRequest = RestAssured.given();
	 
	 // Make a request to the server by specifying the method Type and the method URL.
	 // This will return the Response from the server. Store the response in a variable.
	 Response response = httpRequest.request(Method.GET, "/Hyderabad");
	 
	 // Now let us print the body of the message to see what response
	 // we have recieved from the server
	 String responseBody = response.getBody().asString();
	 System.out.println("Response Body is =>  " + responseBody);
	 
	 }


}
