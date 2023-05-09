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
        while ((line = reader.readLine()) != null) {
            System.out.print(line + "\n");
        }
        proc.waitFor();
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder rndstr = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            rndstr.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        // Printing random integer
        System.out.println(" generatedString: " + rndstr.toString());
        File object = new File(".//Files//generatedString-" + rndstr.toString() + ".txt");
        object.createNewFile();
        // Assert.assertEquals(int1, 1);
        String path = System.getenv("default_directory");
        System.out.println(" system property: " + path);
        String username = System.getenv("LT_USERNAME");
        String accesskey = System.getenv("LT_ACCESS_KEY");
        String envvar = System.getenv("mayur1");
        System.out.println("ENV VAR: " + envvar);
        String scenario = System.getProperty("scenario");
        System.out.println("LT_USER: " + username);
        System.out.println("LT_KEY: " + accesskey);
        System.out.println("PLATFORM: " + System.getenv("HYPEREXECUTE_PLATFORM"));
        System.out.println("HYPEREXECUTE_WORKING_DIR: " + System.getenv("HYPEREXECUTE_WORKING_DIR"));
        String[] files = {
            "Code Arshad Cp Round 2.txt"
        };
        String jobid = System.getenv("JOB_ID");
        System.out.println("JOB_ID: " + jobid);
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
        capability.setCapability("smartUI.project", "HyperExecute-smartUI-project");

        try {
            FileWriter myWriter = new FileWriter(".//Files//generatedString-" + rndstr.toString() + ".txt");
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String gridURL = "https://" + username + ":" + accesskey + "@hub.lambdatest.com/wd/hub";
        System.out.println(gridURL);
        driver = new RemoteWebDriver(new URL(gridURL), capability);
        driver.get("https://lambdatest.github.io/sample-todo-app/");
        ((JavascriptExecutor) driver).executeScript("smartui.takeScreenshot=todo-app");

    }

    @Then("^open url from context json$")
    public void open_url() throws Exception {
        Object obj = new JSONParser().parse(new FileReader("data_context.json"));
        JSONObject jo = (JSONObject) obj;

        String url = (String) jo.get("url");
        System.out.println(url);
        driver.get(url);
    }

    @When("^select First Item$")
    public void select_first_item() {
        driver.findElement(By.name("li1")).click();
        ((JavascriptExecutor) driver).executeScript("smartui.takeScreenshot=first-item");
    }


    @Then("^select second item$")
    public void select_second_item() {
        driver.findElement(By.name("li2")).click();
        ((JavascriptExecutor) driver).executeScript("smartui.takeScreenshot=second-item");
    }

    @Then("^add new item$")
    public void add_new_item() {
        driver.findElement(By.id("sampletodotext")).clear();
        driver.findElement(By.id("sampletodotext")).sendKeys("Yey, Let's add it to list");
        driver.findElement(By.id("addbutton")).click();
        ((JavascriptExecutor) driver).executeScript("smartui.takeScreenshot=add-new-item");
    }

    @Then("^verify added item$")
    public void verify_added_item() {
        String item = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[6]/span")).getText();
        Assert.assertTrue(item.contains("Yey, Let's add it to list"));
        status = "passed";
        driver.get("https://products.groupdocs.app/viewer/txt");
        ((JavascriptExecutor) driver).executeScript("smartui.takeScreenshot=verify-added-item");
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
        ((JavascriptExecutor) driver).executeScript("smartui.takeScreenshot=open-google");
    }

    @When("^I enter \"([^\"]*)\" in search textbox$")
    public void I_enter_in_search_textbox(String additionTerms) {
        //Write term in google textbox
        WebElement googleTextBox = driver.findElement(By.name("q"));
        googleTextBox.sendKeys(additionTerms);
        ((JavascriptExecutor) driver).executeScript("smartui.takeScreenshot=search-textbox");

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
        ((JavascriptExecutor) driver).executeScript("smartui.takeScreenshot=get-results");
        System.out.println("Fetching all compared screenshots data");
        System.out.println(((JavascriptExecutor) driver).executeScript("smartui.fetchScreenshotStatus"));

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
        }
    }

    @Then("^Close the browser$")
    public void close_the_browser() {
        ((JavascriptExecutor) driver).executeScript("lambda-status=passed");
        driver.quit();
    }

}