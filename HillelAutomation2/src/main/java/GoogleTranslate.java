import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTranslate {
    private WebDriver driver;
    @Before
    public void preparationForTest () {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://translate.google.com/");
            }
    @Test
    public void Test1 () throws InterruptedException {
        driver.findElement(By.xpath("/html/body[@class='displaying-homepage']/div[@class='frame']/div[1]/div[@class='homepage-content-wrap']//div[@class='sl-wrap']/div[@role='button']")).click();
        driver.findElement(By.xpath("/html/body/div[@class='frame']//div[@class='language-picker-wrapper']/div[@class='outer-wrap']/div[1]//div[@class='language-list-unfiltered-langs-sl_list']/div[3]/div[68]/div[@class='language_list_item language_list_item_language_name']")).click();
        driver.findElement(By.xpath("/html/body[@class='displaying-homepage']/div[@class='frame']/div[1]/div[@class='homepage-content-wrap']//div[@class='tl-wrap']/div[@role='button']")).click();
        driver.findElement(By.xpath("/html/body/div[@class='frame']//div[@class='language-picker-wrapper']/div[@class='outer-wrap']/div[2]//div[@class='language-list-unfiltered-langs-tl_list']/div[2]/div[5]/div[@class='language_list_item language_list_item_language_name']")).click();
        driver.findElement(By.xpath("/html//textarea[@id='source']")).sendKeys("Это гугл переводчик");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("/html/body[@class='displaying-homepage show-result']/div[@class='frame']/div[1]//div[@class='text-wrap tlid-copy-target']/div[@class='result-shield-container tlid-copy-target']"));
        String foundText = element.getText();
        Assert.assertEquals("This is google translator", foundText);
    }

    @Test
    public void Test2 () throws InterruptedException {
        driver.findElement(By.xpath("/html//header[@id='gb']/div[2]/div[1]/div[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//header[@id='gb']//div[@role='menu']/div[@class='gb_Ec']/ul[2]/li[2]//span[@class='gb_Oc']")).click();
        Thread.sleep(2000);
        Assert.assertNotNull(driver.findElement(By.xpath("//form[@id='search-form']/input[@role='combobox']")));
    }

    @After
    public void afterTest (){
        driver.close();
    }

}
