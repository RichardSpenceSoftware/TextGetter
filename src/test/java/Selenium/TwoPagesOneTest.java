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
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class TwoPagesOneTest {
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
        List<WebElement> reviews = driver.findElements(By.xpath("//div[@class='a-row a-spacing-small review-data']"));
        List<String> list = new ArrayList<>();
        for (WebElement webElement : reviews) {
            String review = webElement.getText();
            System.out.println(review);
            list.add(review);
        }


        FileWriter writer = new FileWriter("output30.txt");
        for (String str : list) {
            writer.write(str + System.lineSeparator() + System.lineSeparator());
        }
        writer.close();

        driver.get("https://www.amazon.com/Software-Test-Automation-Mark-Fewster/product-reviews/0201331403/ref=cm_cr_getr_d_paging_btm_prev_1?ie=UTF8&reviewerType=all_reviews&pageNumber=2");
        driver.manage().window().setSize(new Dimension(1050, 660));
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        List<WebElement> reviews2 = driver.findElements(By.xpath("//div[@class='a-row a-spacing-small review-data']"));
        List<String> list2 = new ArrayList<>();
        for (WebElement webElement : reviews2) {
            String review = webElement.getText();
            System.out.println(review);
            list2.add(review);
        }


        FileWriter writer2 = new FileWriter("output30.txt", true);
        for (String str : list2) {
            writer2.write(str + System.lineSeparator() + System.lineSeparator());
        }
        writer2.close();

        driver.get("https://www.amazon.com/Software-Test-Automation-Mark-Fewster/product-reviews/0201331403/ref=cm_cr_getr_d_paging_btm_prev_1?ie=UTF8&reviewerType=all_reviews&pageNumber=1");
        driver.manage().window().setSize(new Dimension(1050, 660));
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        List<WebElement> reviews3 = driver.findElements(By.xpath("//*[@data-hook=\"review-star-rating\"]/span"));
        List<String> list3 = new ArrayList<>();
        for (WebElement webElement : reviews3) {
            String review = webElement.getAttribute("innerHTML");
            System.out.println(review);
            list3.add(review);
        }
        FileWriter writer3 = new FileWriter("output31.txt");
        for (String str : list3) {
            writer3.write(str + System.lineSeparator() + System.lineSeparator());
        }
        writer3.close();
        driver.get("https://www.amazon.com/Software-Test-Automation-Mark-Fewster/product-reviews/0201331403/ref=cm_cr_getr_d_paging_btm_prev_1?ie=UTF8&reviewerType=all_reviews&pageNumber=1");
        driver.manage().window().setSize(new Dimension(1050, 660));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> reviews4 = driver.findElements(By.xpath("//span[@class='a-size-base a-color-secondary review-date']"));
        List<String> list4 = new ArrayList<>();
        for (WebElement webElement : reviews4) {
            String review = webElement.getAttribute("innerHTML");
            System.out.println(review);
            list4.add(review);
        }
        FileWriter writer4 = new FileWriter("output32.txt");
        for(String str: list4) {
            writer4.write(str + System.lineSeparator() + System.lineSeparator());
        }
        writer4.close();
    }
}