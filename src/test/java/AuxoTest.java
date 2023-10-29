import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;

public class AuxoTest {

    @BeforeEach
    void setup() {
        open("https://www.auxo-it.ru/");
    }

    @Test
    void shouldSendMessage() {
        HomePage homePage = new HomePage();
        var connectWithUs = homePage.clickingOnTheContactButton();
        connectWithUs.fillName("test");
        connectWithUs.fillLastName("test");
        connectWithUs.fillPhone("89001112233");
        connectWithUs.fillEmail("test");
        connectWithUs.fillCompany("test");
        connectWithUs.fillJob("test");
        connectWithUs.fillQuestion("test");
        var successfulSending = connectWithUs.pressButton();
        successfulSending.checkForSuccessFulSending();
    }

}
