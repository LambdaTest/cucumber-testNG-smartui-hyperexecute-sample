package stepDefinitions;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.nio.charset.Charset;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ToDoStepDefinition {

	WebDriver driver;
	public static String status = "Passed";

	@Given("^I launch Session on lambdatest$")
	public void user_already_on_home_page() throws Exception {
		String browser = "chrome"; // System.getProperty("browser"); // "chrome"; //
		String version = "latest"; // System.getProperty("version"); // "latest"; //
		String os = System.getenv("HYPEREXECUTE_PLATFORM");
		String res = "1024x786";


		String command = "cat longlogs.txt";
		Process proc = Runtime.getRuntime().exec(command);
		BufferedReader reader =
					new BufferedReader(new InputStreamReader(proc.getInputStream()));

		String line = "";
		while((line = reader.readLine()) != null) {
				System.out.print(line + "\n");
		}
		proc.waitFor();
		// String command2 = "cat me.html";
		// Process proc2 = Runtime.getRuntime().exec(command2);
		// BufferedReader reader2 =
		// 			new BufferedReader(new InputStreamReader(proc2.getInputStream()));
		//
		// String line2 = "";
		// while((line2 = reader2.readLine()) != null) {
		// 		System.out.print(line2 + "\n");
		// }
		// proc2.waitFor();
		// creating an instance of Random class
		// Generating random integers in range 0 to 9
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&";
		Random rnd = new Random();
		StringBuilder rndstr = new StringBuilder(10);
		for (int i = 0; i < 10; i++)
		{
			rndstr.append(chars.charAt(rnd.nextInt(chars.length())));
		}
		// Printing random integer
		System.out.println(" generatedString: "  + rndstr.toString());
		File object = new File(".//Files//generatedString-"+rndstr.toString()+".txt");
		object.createNewFile();
    // Assert.assertEquals(int1, 1);
		String path = System.getenv("default_directory");
		System.out.println(" system property: "  + path);
		String username = System.getenv("LT_USERNAME");
		String accesskey = System.getenv("LT_ACCESS_KEY");
		String envvar = System.getenv("mayur1");
		System.out.println("ENV VAR: "  + envvar);
    String scenario = System.getProperty("scenario");
		System.out.println("LT_USER: "  + username);
		System.out.println("LT_KEY: "  + accesskey);
		System.out.println("PLATFORM: "  + System.getenv("HYPEREXECUTE_PLATFORM"));
		System.out.println("HYPEREXECUTE_WORKING_DIR: "  + System.getenv("HYPEREXECUTE_WORKING_DIR"));
    String[] files = {"Code Arshad Cp Round 2.txt"};
		String jobid = System.getenv("JOB_ID");
		System.out.println("JOB_ID: "  + jobid);
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability(CapabilityType.BROWSER_NAME, browser);
		capability.setCapability(CapabilityType.VERSION, version);
		capability.setCapability(CapabilityType.PLATFORM, os);
		capability.setCapability("screen_resolution", res);
		capability.setCapability("build", "Cucu-Sel-TestNG-" + jobid);
		capability.setCapability("name", scenario);
		capability.setCapability("network", true);
		capability.setCapability("video", true);
		capability.setCapability("console", true);
		capability.setCapability("visual", true);
		capability.setCapability("smartUI.project", "HyperExecute_SmartUI-12-Apr");
		//capability.setCapability("lambda:userFiles", files);

		try {
		      FileWriter myWriter = new FileWriter(".//Files//generatedString-"+rndstr.toString()+".txt");
		      myWriter.write("Files in Java might be tricky, but it is fun enough!");
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }

		String gridURL = "https://" + username + ":" + accesskey + "@stage-hub.lambdatest.com/wd/hub";
		// String gridURL = "http://" + username + ":" + accesskey + "@127.0.0.1:4449/wd/hub";
		System.out.println(gridURL);
		driver = new RemoteWebDriver(new URL(gridURL), capability);
		// driver.get("http://127.0.0.1:8000/");
		// System.out.println("LocalHost:- " + driver.findElement(By.xpath("//pre")).getText());
		driver.get("https://lambdatest.github.io/sample-todo-app/");
		// byte[] array = new byte[7]; // length is bounded by 7
    // new Random().nextBytes(array);
    // String generatedString = new String(array, Charset.forName("UTF-8"));
		// File object = new File("//Files//"+generatedString+".txt");
    // object.createNewFile( );
		((JavascriptExecutor)driver).executeScript("smartui.takeScreenshot=hyEx");

	}

	@Then("^open url from context json$")
	public void open_url() throws Exception{
    Object obj = new JSONParser().parse(new FileReader("data_context.json"));
    JSONObject jo = (JSONObject) obj;

    String url = (String) jo.get("url");
		System.out.println(url);
		driver.get(url);
	}

	@When("^select First Item$")
	public void select_first_item() {
		driver.findElement(By.name("li1")).click();
		((JavascriptExecutor)driver).executeScript("smartui.takeScreenshot=2");
	}


	@Then("^select second item$")
	public void select_second_item() {
		driver.findElement(By.name("li2")).click();
		((JavascriptExecutor)driver).executeScript("smartui.takeScreenshot=3");
	}

	@Then("^add new item$")
	public void add_new_item() {
		driver.findElement(By.id("sampletodotext")).clear();
		driver.findElement(By.id("sampletodotext")).sendKeys("Yey, Let's add it to list");
		driver.findElement(By.id("addbutton")).click();
		((JavascriptExecutor)driver).executeScript("smartui.takeScreenshot=4");
	}

	@Then("^verify added item$")
	public void verify_added_item() {
		String item = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[6]/span")).getText();
		Assert.assertTrue(item.contains("Yey, Let's add it to list"));
		status = "passed";
		driver.get("https://products.groupdocs.app/viewer/txt");
		((JavascriptExecutor)driver).executeScript("smartui.takeScreenshot=5");
		// WebElement addFile = driver.findElement(By.xpath(".//input[@type='file']"));
    // addFile.sendKeys("C:\\Users\\ltuser\\Downloads\\Code Arshad Cp Round 2.txt");
		// try {
    //   TimeUnit.SECONDS.sleep(10);
    // } catch (InterruptedException e) {
    //   e.printStackTrace();
    // }
	}

	@Then("^Update the result$")
	public void update_result() {
		((JavascriptExecutor) driver).executeScript("lambda-status=passed");
	}

	@Then("^I open google$")
	public void I_open_google() {
		//Set implicit wait of 10 seconds and launch google
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		((JavascriptExecutor)driver).executeScript("smartui.takeScreenshot=6");
	}

	@When("^I enter \"([^\"]*)\" in search textbox$")
	public void I_enter_in_search_textbox(String additionTerms) {
		//Write term in google textbox
		WebElement googleTextBox = driver.findElement(By.name("q"));
		googleTextBox.sendKeys(additionTerms);
		((JavascriptExecutor)driver).executeScript("smartui.takeScreenshot=7");

		//Click on searchButton
		WebElement searchButton = driver.findElement(By.name("btnK"));
		searchButton.click();
	}

	@Then("^I should get result as \"([^\"]*)\"$")
	public void I_should_get_correct_result(String expectedResult) {
		//Get result from calculator
		WebElement calculatorTextBox = driver.findElement(By.id("cwos"));
		String result = calculatorTextBox.getText();
		//
		// //Verify that result of 2+2 is 4
		//
    Assert.assertEquals(result, expectedResult);
		((JavascriptExecutor)driver).executeScript("smartui.takeScreenshot=8");
		System.out.println("***********************");
		System.out.println(((JavascriptExecutor)driver).executeScript("smartui.fetchScreenshotStatus"));

	}

	@Then("^I should get internet speed and sample todo check$")
         public void I_should_get_Internet_speed() {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.fast.com");
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".oc-icon-refresh")));
        for (int i = 0; i < 10; i++) {
          driver.get("https://lambdatest.github.io/sample-todo-app/");
          driver.findElement(By.name("li1")).click();
          driver.findElement(By.name("li2")).click();
          driver.findElement(By.id("sampletodotext")).clear();
          driver.findElement(By.id("sampletodotext")).sendKeys("Yey, Let's add it to list");
          driver.findElement(By.id("addbutton")).click();
          String item = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[6]/span")).getText();
          Assert.assertTrue(item.contains("Yey, Let's add it to list"));
					((JavascriptExecutor)driver).executeScript("smartui.takeScreenshot=9");
          // driver.get("https://lambdatest.github.io/sample-todo-app/");
          // driver.findElement(By.name("li1")).click();
          // driver.findElement(By.name("li2")).click();
          // driver.findElement(By.id("sampletodotext")).clear();
          // driver.findElement(By.id("sampletodotext")).sendKeys("Yey, Let's add it to list");
          // driver.findElement(By.id("addbutton")).click();
          // String item1 = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[6]/span")).getText();
          // Assert.assertTrue(item1.contains("Yey, Let's add it to list"));
        }
				((JavascriptExecutor)driver).executeScript("smartui.takeScreenshot=10");
       }

	@Then("^Close the browser$")
	public void close_the_browser() {
		((JavascriptExecutor) driver).executeScript("lambda-status=passed");
		driver.quit();
	}

}
