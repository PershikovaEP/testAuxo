import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import jdk.jfr.Description;


public class SuccessfulSending {
    private SelenideElement text = Selenide.$x("//*[@id='form521025490']/div[@class='js-successbox t-form__successbox t-text t-text_md']");

    public SuccessfulSending() {
        this.text.shouldBe(new Condition[]{Condition.visible});
    }

    @Description("Проверка успешной отправки сообщения")
    public void checkForSuccessFulSending() {
        this.text.shouldBe(Condition.visible, Duration.ofSeconds(10L)).shouldBe(new Condition[]{Condition.text("Спасибо! Данные успешно отправлены.")});
    }
}
