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
    void shouldSendMessage() throws InterruptedException {
        driver.findElement(By.cssSelector(".t228__right_buttons_but a")).click();

        //3 элемента этой формы! Ни одно поле не заполнилось и кнопка отправить не нажимается
        //Через скрипт попробовала заполнить поле инпут
        WebElement name = driver.findElement(By.xpath("//*[@id='input_1495810359387']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].value = '';", name);
        name.sendKeys("тест");

        //Внесение значения в поле инпут после очистки поля c помощью Backspace
        driver.findElement(By.xpath("//*[@name = 'Name_2']")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.xpath("//*[@name = 'Name_2']")).sendKeys("Тест");

        //Внесение значения в поле инпут после очистки  ctrl+a и backspace
        driver.findElement(By.xpath("//*[@id='input_1495810354468']")).sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
        driver.findElement(By.xpath("//*[@id='input_1495810354468']")).sendKeys("test@mail.ru");

        //Внесение значения в поле инпут после очистки поля методом clear
        driver.findElement(By.xpath("//*[@id='input_1495810354468']")).clear();
        driver.findElement(By.xpath("//*[@id='input_1495810354468']")).sendKeys("test@mail.ru");

        //Внесение значения в поле инпут после очистки  ctrl+a и delete
        driver.findElement(By.xpath("//*[@id='input_1669804191159']")).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        driver.findElement(By.xpath("//*[@id='input_1669804191159']")).sendKeys("+79202020000");

        driver.findElement(By.xpath("//*[@id='input_1495810410810']")).sendKeys("Тест");

        driver.findElement(By.xpath("//*[@id='input_1653564461294']")).sendKeys("Менеджер");

        driver.findElement(By.xpath("//*[@id='input_1653564485974']")).sendKeys("Тест?");

        //Не находит элемент, ставлю задержку через java или через средства selenium - не проходит, таких 3 элемента, они перекрывают друг друга
        //Thread.sleep(10000);
        //driver.findElement(By.cssSelector(".t-form__submit button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".t-form__submit button"))).click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".t-form__submit button"))).Click();

        String actual = driver.findElement(By.xpath("//*[@id='form521025490']/div[@class='js-successbox t-form__successbox t-text t-text_md']")).getText();
        Assertions.assertEquals("Спасибо! Данные успешно отправлены.", actual);

    }
}
