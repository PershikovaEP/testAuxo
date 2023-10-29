import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Description;

import static com.codeborne.selenide.Condition.visible;


public class ConnectWithUs {
    private SelenideElement name = Selenide.$x("//*[@id='input_1495810359387']");
    private SelenideElement lastName = Selenide.$x("//*[@id='input_1653564351806']");
    private SelenideElement email = Selenide.$x("//*[@id='input_1495810354468']");
    private SelenideElement phone = Selenide.$x("//*[@id='input_1669804191159']");
    private SelenideElement company = Selenide.$x("//*[@id='input_1495810410810']");
    private SelenideElement job = Selenide.$x("//*[@id='input_1653564461294']");
    private SelenideElement question = Selenide.$x("//*[@id='input_1653564485974']");
    private SelenideElement button = Selenide.$(".t-form__submit button");

    //В конструкторе проверяем, что страница открылась
    public ConnectWithUs() {
        lastName.shouldBe(visible);
    }

    @Description("Вводим имя в поле Имя")
    public void fillName(String text) {
        name.setValue(text);
    }

    @Description("Вводим фамилию в поле Фамилия")
    public void fillLastName(String text) {
        lastName.setValue(text);
    }

    @Description("Вводим email в поле email")
    public void fillEmail(String text) {
        email.setValue(text);
    }

    @Description("Вводим телефон в поле Телефон")
    public void fillPhone(String text) {
        phone.setValue(text);
    }

    @Description("Вводим компанию в поле Компания")
    public void fillCompany(String text) {
        company.setValue(text);
    }

    @Description("Вводим должность в поле Должность")
    public void fillJob(String text) {
        job.sendKeys(new CharSequence[]{text});
    }

    @Description("Вводим вопрос в поле Вопрос")
    public void fillQuestion(String text) {
        question.sendKeys(new CharSequence[]{text});
    }

    @Description("Нажимаем на кнопку Отправить - открывается страницы Успешной отправки сообщения")
    public SuccessfulSending pressButton() {
        button.click();
        return new SuccessfulSending();
    }
}

