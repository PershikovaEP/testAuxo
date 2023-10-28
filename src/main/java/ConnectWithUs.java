import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Description;


public class ConnectWithUs {
    private SelenideElement name = Selenide.$x("//*[@id='input_1495810359387']");
    private SelenideElement lastName = Selenide.$x("//*[@id='input_1653564351806']");
    private SelenideElement email = Selenide.$x("//*[@id='input_1495810354468']");
    private SelenideElement phone = Selenide.$x("//*[@id='input_1669804191159']");
    private SelenideElement company = Selenide.$x("//*[@id='input_1495810410810']");
    private SelenideElement job = Selenide.$x("//*[@id='input_1653564461294']");
    private SelenideElement question = Selenide.$x("//*[@id='input_1653564485974']");
    private SelenideElement button = Selenide.$(".t-form__submit button");

    public ConnectWithUs() {
        this.name.shouldBe(new Condition[]{Condition.visible});
    }

    @Description("Вводим имя в поле Имя")
    public void fillName(String text) {
        this.name.setValue(text);
    }

    @Description("Вводим фамилию в поле Фамилия")
    public void fillLastName(String text) {
        this.lastName.setValue(text);
    }

    @Description("Вводим email в поле email")
    public void fillEmail(String text) {
        this.email.setValue(text);
    }

    @Description("Вводим телефон в поле Телефон")
    public void fillPhone(String text) {
        this.phone.setValue(text);
    }

    @Description("Вводим компанию в поле Компания")
    public void fillCompany(String text) {
        this.company.setValue(text);
    }

    @Description("Вводим должность в поле Должность")
    public void fillJob(String text) {
        this.job.sendKeys(new CharSequence[]{text});
    }

    @Description("Вводим вопрос в поле Вопрос")
    public void fillQuestion(String text) {
        this.question.sendKeys(new CharSequence[]{text});
    }

    @Description("Нажимаем на кнопку Отправить - открывается страницы Успешной отправки сообщения")
    public SuccessfulSending pressButton() {
        this.button.click();
        return new SuccessfulSending();
    }
}

