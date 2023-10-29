import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class AuxoTest {

    private WebDriver driver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("https://auxo-it.ru/");
    }


    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldSendMessage() {
        driver.findElement(By.cssSelector(".t228__right_buttons_but a")).click();

        //В связи с 3 идентичными формами Связаться с нами использую абсолютный путь
        driver.findElement(By.xpath("/html/body/div/div[17]/div/div/div[2]/div/form/div[2]/div[1]/div/input")).sendKeys("Тест");
        driver.findElement(By.xpath("/html/body/div/div[17]/div/div/div[2]/div/form/div[2]/div[2]/div/input")).sendKeys("Тест");
        driver.findElement(By.xpath("/html/body/div/div[17]/div/div/div[2]/div/form/div[2]/div[3]/div/input")).sendKeys("test@mail.ru");
        driver.findElement(By.xpath("/html/body/div/div[17]/div/div/div[2]/div/form/div[2]/div[4]/div/input")).sendKeys("+79202020000");
        driver.findElement(By.xpath("/html/body/div/div[17]/div/div/div[2]/div/form/div[2]/div[5]/div/input")).sendKeys("Тест");
        driver.findElement(By.xpath("/html/body/div/div[17]/div/div/div[2]/div/form/div[2]/div[6]/div/input")).sendKeys("Менеджер");
        driver.findElement(By.xpath("/html/body/div/div[17]/div/div/div[2]/div/form/div[2]/div[7]/div/textarea")).sendKeys("Тест?");

        // Тут 3 кнопки и они перекрывают друг друга, поэтому нажатие на кнопку Отправить не происходит
        driver.findElement(By.cssSelector("/html/body/div/div[17]/div/div/div[2]/div/form/div[2]/div[10]/button")).click();

        String actual = driver.findElement(By.xpath("//*[@id='form521025490']/div[@class='js-successbox t-form__successbox t-text t-text_md']")).getText();
        Assertions.assertEquals("Спасибо! Данные успешно отправлены.", actual);


      //Код с более грамотными селекторами
//        driver.findElement(By.xpath("//*[@id='input_1495810359387']")).sendKeys("Тест");
//        driver.findElement(By.xpath("//*[@name = 'Name_2']")).sendKeys("Тест");
//        driver.findElement(By.xpath("//*[@id='input_1495810354468']")).sendKeys("test@mail.ru");
//        driver.findElement(By.xpath("//*[@id='input_1669804191159']")).sendKeys("+79202020000");
//        driver.findElement(By.xpath("//*[@id='input_1495810410810']")).sendKeys("Тест");
//        driver.findElement(By.xpath("//*[@id='input_1653564461294']")).sendKeys("Менеджер");
//        driver.findElement(By.xpath("//*[@id='input_1653564485974']")).sendKeys("Тест?");
//        driver.findElement(By.cssSelector(".t-form__submit button")).click();
//
//        String actual = driver.findElement(By.xpath("//*[@id='form521025490']/div[@class='js-successbox t-form__successbox t-text t-text_md']")).getText();
//        Assertions.assertEquals("Спасибо! Данные успешно отправлены.", actual);

    }
}
