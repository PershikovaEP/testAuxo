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

    void shouldSendMessage()  {
        $(".t228__right_buttons_but a").click();

        //В связи с тройным повтором элементов формы Обратной связи беру абсолютный путь
        $x("/html/body/div/div[17]/div/div/div[2]/div/form/div[2]/div[1]/div/input").setValue("Тест");
        $x("/html/body/div/div[17]/div/div/div[2]/div/form/div[2]/div[2]/div/input").setValue("Тест");
        $x("/html/body/div/div[17]/div/div/div[2]/div/form/div[2]/div[3]/div/input").setValue("test@mail.ru");
        $x("/html/body/div/div[17]/div/div/div[2]/div/form/div[2]/div[4]/div/input").setValue("+79202020000");
        $x("/html/body/div/div[17]/div/div/div[2]/div/form/div[2]/div[5]/div/input").setValue("Тест");
        $x("/html/body/div/div[17]/div/div/div[2]/div/form/div[2]/div[6]/div/input").setValue("Менеджер");
        $x("/html/body/div/div[17]/div/div/div[2]/div/form/div[2]/div[7]/div/textarea").setValue("Тест?");

        //селектор не доступен из-за перекрытия другими элементами
        //Thread.sleep(10000); //задержка и скрол не помогли
        //$("/html/body/div/div[17]/div/div/div[2]/div/form/div[2]/div[10]/button").scrollIntoView(true);
        $("/html/body/div/div[8]/div/div/div[2]/div/form/div[2]/div[10]/button").click();

        $x("//*[@id='form521025490']/div[@class='js-successbox t-form__successbox t-text t-text_md']")
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .shouldBe(Condition.exactText("Спасибо! Данные успешно отправлены."));

        //Код с более грамотными селекторами
//        $x("//*[@id='input_1495810359387']").setValue("Тест");
//        $x("//*[@id='input_1653564351806']").setValue("Тест");
//        $x("//*[@id='input_1495810354468']").setValue("test@mail.ru");
//        $x("//*[@id='input_1669804191159']").setValue("+79202020000");
//        $x("//*[@id='input_1495810410810']").setValue("Тест");
//        $x("//*[@id='input_1653564461294']").setValue("Менеджер");
//        $x("//*[@id='input_1653564485974']").setValue("Тест?");
//        $(".t-form__submit button").click();
//        $x("//*[@id='form521025490']/div[@class='js-successbox t-form__successbox t-text t-text_md']")
//                .shouldBe(Condition.visible, Duration.ofSeconds(10))
//                .shouldBe(Condition.exactText("Спасибо! Данные успешно отправлены."));

    }
}

