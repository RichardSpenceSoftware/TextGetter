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
import org.openqa.selenium.interactions.Actions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class CVS3 {
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
        Actions actions = new Actions(driver);
        driver.get("https://play.google.com/store/apps/details?id=app.spidy.spidy&gl=GB&showAllReviews=true");
        driver.manage().window().setSize(new Dimension(1050, 660));
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list4 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        List<String> list5 = new ArrayList<>();

            List<WebElement> reviews = driver.findElements(By.xpath("//div[@class='UD7Dzf']"));
            for (WebElement webElement : reviews) {
                String review = webElement.getText();
                System.out.println(review);
                list.add(review);
            }

            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            List<WebElement> reviews3 = driver.findElements(By.xpath("//*[@class=\"pf5lIe\"]/div"));
            for (WebElement webElement : reviews3) {
                String review = webElement.getAttribute("aria-label");
                System.out.println(review);
                list3.add(review);
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            List<WebElement> reviews4 = driver.findElements(By.xpath("//span[@class='p2TkOb']"));
            for (WebElement webElement : reviews4) {
                String review = webElement.getText();
                System.out.println(review);
                list4.add(review);
            }

        List<String> list6 = new ArrayList<>();
        for(String longelement : list){
            if(longelement.length() > 100 ){
                String inputString = longelement.substring(0, 100);
                list6.add(inputString);
            }
        }

        for (int i=0;i<(list6.size()) ;i++){
            String hing = list6.get(i);
            list2.add(hing);
            String thing = list3.get(i);
            String thing2 = list4.get(i);
            list2.add(thing);
            list2.add(thing2);
        }

        for (String webElement : list2) {
            String webElement2 = webElement.replaceAll(",", "");
            list5.add(webElement2);
        }
        for(int i=0;i<list5.size();i++){
            System.out.println(list5.get(i));
        }
        File file = new File("test3.csv");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("User Review,Star Rating,Date");
        bw.newLine();
        for(int i=0;i<(list5.size()/3);i++)
        {
            bw.write(list5.get(3*i)+","+list5.get(3*i +1)+","+list5.get(3*i +2));
            bw.newLine();
        }
        bw.close();
        fw.close();
    }
}