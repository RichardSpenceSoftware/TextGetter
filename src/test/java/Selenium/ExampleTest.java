package Selenium;// Generated by Selenium IDE
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
public class ExampleTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void example() throws IOException {
    driver.get("https://www.amazon.com/Software-Test-Automation-Mark-Fewster/product-reviews/0201331403/ref=cm_cr_getr_d_paging_btm_prev_1?ie=UTF8&reviewerType=all_reviews&pageNumber=1");
    driver.manage().window().setSize(new Dimension(1050, 660));
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    String test = driver.findElement(By.xpath("//*[text()='Next page']/..")).getAttribute("class");
    List<String> fileContent = new ArrayList<>();

    while (test.equals("a-last")) {
      String strUrl = driver.getCurrentUrl();
      driver.get(strUrl);
      String reviewText, starRating, date;

      List<WebElement> reviews = driver.findElements(By.xpath("//div[@data-hook=\"review\"]"));
      for (WebElement review : reviews) {
        String reviewId = review.getAttribute("id");
        String foreign = driver.findElement(By.xpath(("//*[@id=\"" + reviewId + "\" and @data-hook=\"review\"]/div/div\n"))).getAttribute("id");
        if (!foreign.contains("foreign")) {
          String reviewIdXPath = "//*[@id=\"customer_review-" + reviewId + "\"]";
          reviewText = driver.findElement(By.xpath(reviewIdXPath + "/div[4]\n")).getText();
          starRating = driver.findElement(By.xpath(reviewIdXPath + "/div[2]/a[1]/i/span\n")).getAttribute("innerHTML");
          date = driver.findElement(By.xpath(reviewIdXPath + "/span\n")).getText();
        }else{
          reviewText = driver.findElement(By.xpath("//*[@id=\"customer_review_foreign-" + reviewId + "\"]/div[4]")).getText();
          starRating = driver.findElement(By.xpath("//*[@id=\"customer_review_foreign-" + reviewId + "\"]/div[2]/i/span\n")).getAttribute("innerHTML");
          date = driver.findElement(By.xpath("//*[@id=\"customer_review_foreign-" + reviewId + "\"]/span\n")).getText();
        }
        fileContent.add("\"" + reviewText + "\"" + "," + "\"" + starRating + "\"" + "," + "\"" + date + "\"");
      }

      test = driver.findElement(By.xpath("//*[text()='Next page']/..")).getAttribute("class");
      if (test.equals("a-last")) {
        driver.findElement(By.xpath("//li/*[text()='Next page']")).click();
      }
      driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    File file = new File("test.csv");
    FileWriter fw = new FileWriter(file);
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write("Review,Star,Date");
    bw.newLine();
    for (String s : fileContent) {
      bw.write(s);
      bw.newLine();
    }
    bw.close();
    fw.close();
  }
}