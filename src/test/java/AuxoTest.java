import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class AuxoTest {

    @BeforeEach
    void setup() {
        open("https://www.auxo-it.ru/");
    }

    @Test
    void shouldSendMessage() throws InterruptedException {
        $(".t228__right_buttons_but a").click();

        //Элементы повторятся трижды
        //Внесение в поле инпут значения после очистки ctrl + a и backspace с помощью sendKeys
        $x("//*[@id='input_1495810359387']").sendKeys(Keys.CONTROL + "a");
        $x("//*[@id='input_1495810359387']").sendKeys(Keys.BACK_SPACE);
        $x("//*[@id='input_1495810359387']").sendKeys("Тест");

        //Внесение в поле инпут значения после очистки двойным кликом и backspace с помощью sendKeys
        $x("//*[@id='input_1653564351806']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $x("//*[@id='input_1653564351806']").sendKeys("Тест");

        //Внесение в поле инпут значения после двойного клики, очистки ctrl + a и backspace с помощью setValue
        $x("//*[@id='input_1495810354468']").doubleClick().sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE );
        $x("//*[@id='input_1495810354468']").setValue("test@mail.ru");

        //Внесение в поле инпут значения после очистки двойным кликом и clear
        $x("//*[@id='input_1495810354468']").doubleClick().clear();
        $x("//*[@id='input_1495810354468']").setValue("test@mail.ru");

        //Внесение в поле инпут значения после двойного клики, очистки ctrl + a и delete с помощью setValue
        $x("//*[@id='input_1669804191159']").doubleClick().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        $x("//*[@id='input_1669804191159']").setValue("+79202020000");

        $x("//*[@id='input_1495810410810']").setValue("Тест");

        $x("//*[@id='input_1653564461294']").setValue("Менеджер");

        $x("//*[@id='input_1653564485974']").doubleClick().setValue("Тест?");

        //задержка средствами java - не работает, элемента 3, они перекрывают друг друга
        Thread.sleep(10000);
        $(".t-form__submit button").click();

        $x("//*[@id='form521025490']/div[@class='js-successbox t-form__successbox t-text t-text_md']")
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .shouldBe(Condition.text("Спасибо! Данные успешно отправлены."));

    }
}

