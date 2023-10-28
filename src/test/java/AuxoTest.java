import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;


public class AuxoTest {

    HomePage homePage = new HomePage();
    ConnectWithUs connectWithUs = new ConnectWithUs();
    SuccessfulSending successfulSending = new SuccessfulSending();

    @BeforeEach
    void setup() {
        open("https://www.auxo-it.ru/");
    }

    @Test
    void shouldSendMessage() {
        homePage.clickingOnTheContactButton();
        connectWithUs.fillName("test");
        connectWithUs.fillLastName("test");
        connectWithUs.fillPhone("89001112233");
        connectWithUs.fillEmail("test");
        connectWithUs.fillCompany("test");
        connectWithUs.fillJob("test");
        connectWithUs.fillQuestion("test");
        connectWithUs.pressButton();
        successfulSending.checkForSuccessFulSending();
    }
}
