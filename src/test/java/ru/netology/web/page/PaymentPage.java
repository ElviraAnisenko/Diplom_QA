package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static ru.netology.web.data.DataGenerator.*;

public class PaymentPage {
    private SelenideElement buttonPay = $(By.xpath("//span[contains(text(),'Купить')]"));
    private SelenideElement buttonPayCredit = $(By.xpath("//span[contains(text(),'Купить в кредит')]"));
    private SelenideElement headingPay = $(By.xpath("//h3[text()='Оплата по карте']"));
    private SelenideElement headingPayCredit = $(By.xpath("//h3[text()='Кредит по данным карты']"));
    private SelenideElement fieldNumber = $(By.xpath("//input[@placeholder='0000 0000 0000 0000']"));
    private SelenideElement fieldMonth = $(By.xpath("//input[@placeholder='08']"));
    private SelenideElement fieldYear = $(By.xpath("//input[@placeholder='22']"));
    private SelenideElement fieldHolder = $$(".form-field").findBy(text("Владелец")).find(".input__control");
    private SelenideElement fieldCVC = $(By.xpath("//input[@placeholder='999']"));
    private SelenideElement buttonContinue = $$(".button__text").findBy(text("Продолжить"));
    private SelenideElement notificationOk = $(".notification_status_ok .notification__content");
    private SelenideElement notificationNOk = $(".notification_status_error .notification__content");
    private SelenideElement fieldError = $(".input__sub");
    private SelenideElement fieldErrorNumber = $(byXpath("//*[@id='root']/div/form/fieldset/div[1]/span/span/span[3]"));
    private SelenideElement fieldErrorMonth = $(byXpath("//*[@id='root']/div/form/fieldset/div[2]/span/span[1]/span/span/span[3]"));
    private SelenideElement fieldErrorYear = $(byXpath("//*[@id='root']/div/form/fieldset/div[2]/span/span[2]/span/span/span[3]"));
    private SelenideElement fieldErrorHolder = $(byXpath("//*[@id='root']/div/form/fieldset/div[3]/span/span[1]/span/span/span[3]"));
    private SelenideElement fieldErrorCVC = $(byXpath("//*[@id='root']/div/form/fieldset/div[3]/span/span[2]/span/span/span[3]"));


    public void openFormToPay() {
        buttonPay.click();
        headingPay.shouldBe(visible);
    }

    public void openFormToPayCredit() {
        buttonPayCredit.click();
        headingPayCredit.shouldBe(visible);
    }

    public void fillFormWithData(String number, String month, String year, String holder, String cvc) {
        fieldNumber.setValue(number);
        fieldMonth.setValue(month);
        fieldYear.setValue(year);
        fieldHolder.setValue(holder);
        fieldCVC.setValue(cvc);
        buttonContinue.click();
    }

    public void fillFormWithValidData(String number, String month, String year, String holder, String cvc, String messageOk) {
        fillFormWithData(number, month, year, holder, cvc);
        notificationOk.shouldBe(visible, Duration.ofSeconds(15)).shouldHave(Condition.text(messageOk));
    }

    public void fillFormWithEmptyOrErrorDataField(String number, String month, String year, String holder, String cvc, String errorOrEmpty) {
        fillFormWithData(number, month, year, holder, cvc);
        fieldError.shouldBe(visible).shouldHave(text(errorOrEmpty));
    }

    public void fillFormWithDeclinedOrNonExistingCard(String number, String month, String year, String holder, String cvc, String messageNOk) {
        fillFormWithData(number, month, year, holder, cvc);
        notificationNOk.shouldBe(visible, Duration.ofSeconds(15)).shouldHave(text(messageNOk));
    }

    public void fillFormWithEmptyAllFieldAndThenValidData(Date dateEmpty, Date dateValid) {
        fillFormWithData(dateEmpty.getNumber(), dateEmpty.getYear(), dateEmpty.getMonth(), dateEmpty.getHolder(), dateEmpty.getCvc());
        fieldErrorNumber.shouldBe(visible);
        fieldErrorMonth.shouldBe(visible);
        fieldErrorYear.shouldBe(visible);
        fieldErrorHolder.shouldBe(visible);
        fieldErrorCVC.shouldBe(visible);
        fillFormWithData(dateValid.getNumber(), dateValid.getYear(), dateValid.getMonth(), dateValid.getHolder(), dateValid.getCvc());
        fieldErrorNumber.shouldNot(visible);
        fieldErrorMonth.shouldNot(visible);
        fieldErrorYear.shouldNot(visible);
        fieldErrorHolder.shouldNot(visible);
        fieldErrorCVC.shouldNot(visible);


    }


}




