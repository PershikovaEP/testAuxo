import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Description;

public class HomePage {
    private SelenideElement button = Selenide.$(".t228__right_buttons_but a");

    public HomePage() {
    }

    @Description("Кликаем на кнопку свзяаться с нами - открывается страница Связаться с Нами")
    public ConnectWithUs clickingOnTheContactButton() {
        button.click();
        return new ConnectWithUs();
    }
}
