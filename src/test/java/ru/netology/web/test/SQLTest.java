package ru.netology.web.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import ru.netology.web.data.DataGenerator;
import ru.netology.web.page.SQLHelper;

import ru.netology.web.page.PaymentPage;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SQLTest {

    @RegisterExtension
    static SoftAssertsExtension softAsserts = new SoftAssertsExtension();

    PaymentPage paymentPage = new PaymentPage();
    DataGenerator dataGenerator = new DataGenerator();

    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    @AfterEach
    void cleanDB() {
        SQLHelper.cleanDatabase();
    }

    @Test
    @DisplayName("Сценарий 1.3 Отправка запроса на покупку тура при заполнении полей форм карты валидными данными (переход к форме через кнопку 'Купить') и получение ответа из базы SQL")
    void shouldRecordRequestWithValidDataToDBTablePayment() {
        Configuration.assertionMode = SOFT;
        paymentPage.openFormToPay();
        var number = dataGenerator.getApprovednumberCard();
        var month = DataGenerator.getMonthCard(DataGenerator.generateValidDateCard());
        var year = DataGenerator.getYearCard(DataGenerator.generateValidDateCard());
        var holder = DataGenerator.generateNameOfHolderCard();
        var cvc = DataGenerator.generateValidCVC();
        var messageOk = dataGenerator.getMessageOk();
        paymentPage.fillFormWithValidData(number, month, year, holder, cvc, messageOk);
        String actual = SQLHelper.getStatusFromPayment();
        String expected = dataGenerator.getApproved();
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Сценарий 1.3 Отправка запроса на покупку тура при заполнении полей форм карты валидными данными (переход к форме через кнопку 'Купить в кредит') и получение ответа из базы SQL")
    void shouldRecordRequestWithValidDataToDBTablePaymentCredit() {
        Configuration.assertionMode = SOFT;
        paymentPage.openFormToPayCredit();
        var number = dataGenerator.getApprovednumberCard();
        var month = DataGenerator.getMonthCard(DataGenerator.generateValidDateCard());
        var year = DataGenerator.getYearCard(DataGenerator.generateValidDateCard());
        var holder = DataGenerator.generateNameOfHolderCard();
        var cvc = DataGenerator.generateValidCVC();
        var messageOk = dataGenerator.getMessageOk();
        paymentPage.fillFormWithValidData(number, month, year, holder, cvc, messageOk);
        String actual = SQLHelper.getStatusFromPaymentCredit();
        String expected = dataGenerator.getApproved();
        assertEquals(expected, actual);


    }

    @Test
    @DisplayName("Сценарий 1.9 Ввод карты со статусом 'DECLINED' в поле 'Номер карты' при запросе покупки тура (переход к форме через кнопку 'Купить') и получение ответа из базы SQL")
    void shouldNotRecordRequestWithDeclinedCardToDBTablePayment() {
        Configuration.assertionMode = SOFT;
        paymentPage.openFormToPay();
        var number = dataGenerator.getDeclinednumberCard();
        var month = DataGenerator.getMonthCard(DataGenerator.generateValidDateCard());
        var year = DataGenerator.getYearCard(DataGenerator.generateValidDateCard());
        var holder = DataGenerator.generateNameOfHolderCard();
        var cvc = DataGenerator.generateValidCVC();
        var messageNOk = dataGenerator.getMessageNOk();
        paymentPage.fillFormWithDeclinedOrNonExistingCard(number, month, year, holder, cvc, messageNOk);
        Long actual = SQLHelper.getNumberRowsFromDBTablePayment();
        assertEquals(0, actual);

    }

    @Test
    @DisplayName("Сценарий 1.9 Ввод карты со статусом 'DECLINED' в поле 'Номер карты' при запросе покупки тура (переход к форме через кнопку 'Купить в кредит') и получение ответа из базы SQL")
    void shouldNotRecordRequestWithDeclinedCardToDBTableCreditPayment() {
        Configuration.assertionMode = SOFT;
        paymentPage.openFormToPayCredit();
        var number = dataGenerator.getDeclinednumberCard();
        var month = DataGenerator.getMonthCard(DataGenerator.generateValidDateCard());
        var year = DataGenerator.getYearCard(DataGenerator.generateValidDateCard());
        var holder = DataGenerator.generateNameOfHolderCard();
        var cvc = DataGenerator.generateValidCVC();
        var messageNOk = dataGenerator.getMessageNOk();
        paymentPage.fillFormWithDeclinedOrNonExistingCard(number, month, year, holder, cvc, messageNOk);
        Long actual = SQLHelper.getNumberRowsFromDBTablePaymentCredit();
        assertEquals(0, actual);

    }

    @Test
    @DisplayName("Сценарий 1.25 Ввод рандомного 16-значного номера карты в поле 'Номер карты' при запросе покупки тура (переход к форме через кнопку 'Купить') и получение ответа из базы SQL")
    void shouldNotRecordRequestWithRandomCardToDBTablePayment() {
        Configuration.assertionMode = SOFT;
        paymentPage.openFormToPay();
        var number = DataGenerator.generateCardWith16Symbol();
        var month = DataGenerator.getMonthCard(DataGenerator.generateValidDateCard());
        var year = DataGenerator.getYearCard(DataGenerator.generateValidDateCard());
        var holder = DataGenerator.generateNameOfHolderCard();
        var cvc = DataGenerator.generateValidCVC();
        var messageNOk = dataGenerator.getMessageNOk();
        paymentPage.fillFormWithDeclinedOrNonExistingCard(number, month, year, holder, cvc, messageNOk);
        Long actual = SQLHelper.getNumberRowsFromDBTablePayment();
        assertEquals(0, actual);

    }

    @Test
    @DisplayName("Сценарий 1.25 Ввод рандомного 16-значного номера карты в поле 'Номер карты' при запросе покупки тура (переход к форме через кнопку 'Купить в кредит') и получение ответа из базы SQL")
    void shouldNotRecordRequestWithRandomCardToDBTableCreditPayment() {
        Configuration.assertionMode = SOFT;
        paymentPage.openFormToPayCredit();
        var number = DataGenerator.generateCardWith16Symbol();
        var month = DataGenerator.getMonthCard(DataGenerator.generateValidDateCard());
        var year = DataGenerator.getYearCard(DataGenerator.generateValidDateCard());
        var holder = DataGenerator.generateNameOfHolderCard();
        var cvc = DataGenerator.generateValidCVC();
        var messageNOk = dataGenerator.getMessageNOk();
        paymentPage.fillFormWithDeclinedOrNonExistingCard(number, month, year, holder, cvc, messageNOk);
        Long actual = SQLHelper.getNumberRowsFromDBTablePaymentCredit();
        assertEquals(0, actual);

    }

}
