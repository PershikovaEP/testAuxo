import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


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

//        //scrollIntoView(false);
        driver.findElement(By.cssSelector(".t-form__submit button")).click();

        String actual = driver.findElement(By.xpath("//*[@id='form521025490']/div[@class='js-successbox t-form__successbox t-text t-text_md']")).getText();
        Assertions.assertEquals("Спасибо! Данные успешно отправлены.", actual);


    }
}
