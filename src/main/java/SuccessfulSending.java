import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import jdk.jfr.Description;

import static com.codeborne.selenide.Condition.visible;


public class SuccessfulSending {
    private SelenideElement text = Selenide.$x("//*[@id='form521025490']/div[@class='js-successbox t-form__successbox t-text t-text_md']");

    //В конструкторе проверяем, что страница открылась
    public SuccessfulSending() {
        text.shouldBe(visible);
    }

    @Description("Проверка успешной отправки сообщения")
    public void checkForSuccessFulSending() {
        text.shouldBe(visible, Duration.ofSeconds(10L)).shouldBe(new Condition[]{Condition.text("Спасибо! Данные успешно отправлены.")});
    }
}
