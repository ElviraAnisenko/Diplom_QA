package ru.netology.web.data;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Value;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class DataGenerator {
    public DataGenerator() {
    }

    @Getter
    private final String approvednumberCard = "4444444444444441";
    @Getter
    private String declinednumberCard = "4444444444444442";
    @Getter
    private final String approved = "APPROVED";
    private String declined = "DECLINED";
    @Getter
    private String month00 = "00";
    @Getter
    private String empty = "";
    @Getter
    private String messageOk = "Операция одобрена Банком.";
    @Getter
    private String messageNOk = "Ошибка! Банк отказал в проведении операции.";
    @Getter
    private String errorEmpty = "Неверный формат";
    @Getter
    private String errorEmptyHolder = "Поле обязательно для заполнения";
    @Getter
    private String errorMonth = "Неверно указан срок действия карты";
    @Getter
    private String errorExpiredYear = "Истёк срок действия карты";
    @Getter
    private String errorNotExistYear = "Неверно указан срок действия карты";


    // генерация значений для поля "Номер карты".

    public static String generateCardWith16Symbol() {
        int first = new Random().ints(1_000, 9999).findFirst().getAsInt();
        int second = new Random().ints(1_000, 9999).findFirst().getAsInt();
        int third = new Random().ints(1_000, 9999).findFirst().getAsInt();
        int fourth = new Random().ints(1_000, 9999).findFirst().getAsInt();
        String card16Symbol = String.valueOf(first) + String.valueOf(second) + String.valueOf(third) + String.valueOf(fourth);
        return card16Symbol;
        //return new Faker().finance().creditCard(CreditCardType.VISA);
    }

    public static String generateCardWith17SymbolAtBeginning(String approvednumberCard) {
        String firstSymbol = String.valueOf(new Random().nextInt(10));
        String cardNumber17SymbolAtBeginning = firstSymbol + approvednumberCard;
        return cardNumber17SymbolAtBeginning;
    }

    public static String generateCardWith17SymbolInEnd(String approvednumberCard) {
        String lastSymbol = String.valueOf(new Random().nextInt(10));
        String cardNumber17SymbolInEnd = approvednumberCard + lastSymbol;
        return cardNumber17SymbolInEnd;
    }

    public static List<String> generateStringWithInvalidSymbol() {
        String letters = "abcdefghijklmnopqrstuvwxyzабвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        String specialSymbols = "$&@?<>~!%#";
        String allSymbols = specialSymbols + letters;
        String[] arraySymbols = allSymbols.split("");
        List<String> list = new ArrayList<>(List.of(arraySymbols));
        Collections.shuffle(list);
        return list;
    }

    public static String generateCardWith16InvalidSymbol(List<String> list) {
        String cardInvalidSymbol = (String.join("", list)).substring(0, 16);
        return cardInvalidSymbol;

    }


    public static String generateCardLess16Symbol() {
        String cardNumber16Symbol = new Faker().finance().creditCard(CreditCardType.VISA);
        int lenghtCard = new Random().nextInt(14) + 1;
        String cardNumberLess16Symbol = cardNumber16Symbol.substring(0, lenghtCard);
        return cardNumberLess16Symbol;
    }


    // генерация значений для полей "Месяц" и "Год".

    public static String generateValidDateCard() {
        int plusMonths = new Random().nextInt(72);
        String validDate = LocalDateTime.now().plusMonths(plusMonths).format(DateTimeFormatter.ofPattern("MM.yy"));
        return validDate;
    }

    public static String generateDateExpiredCard() {
        int minusMonths = new Random().nextInt(100) + 1;
        String expiredDate = LocalDateTime.now().minusMonths(minusMonths).format(DateTimeFormatter.ofPattern("MM.yy"));
        return expiredDate;
    }

    public static String generateCardWithNotExistDate() {
        int months = new Random().ints(73, 900).findFirst().getAsInt();
        String notExistDate = LocalDateTime.now().plusMonths(months).format(DateTimeFormatter.ofPattern("MM.yy"));
        return notExistDate;
    }

    public static String getMonthCard(String date) {
        String monthCard = date.substring(0, 2);
        return monthCard;
    }

    public static String getYearCard(String date) {
        String yearCard = date.substring(3, 5);
        return yearCard;
    }

    public static String generateYearCard4Symbol() {
        String yearCard = String.valueOf(LocalDateTime.now().plusMonths(12).format(DateTimeFormatter.ofPattern("MM.yyyy")));
        String yearCard4Symbol = yearCard.substring(3, 7);
        return yearCard4Symbol;
    }

    public static String generateMonthOrYear1Symbol() {
        String monthOrYear1Symbol = String.valueOf(new Random().nextInt(9) + 1);
        return monthOrYear1Symbol;
    }

    public static String generateMonthMore13() {
        String monthMore13 = String.valueOf(new Random().ints(13, 100));
        return monthMore13;
    }

    public static String generateMonthOrYearWithInvalidSymbol(List<String> list) {
        String yearOrMonthInvalidSymbol = (String.join("", list)).substring(0, 2);
        return yearOrMonthInvalidSymbol;
    }


    // генерация значений для поля "Владелец".

    public static String generateNameOfHolderCard() {
        String name = new Faker().name().fullName();
        String symbol = String.valueOf(new Random().nextInt(1000));
        String nameSymbol = name + " " + symbol;
        return nameSymbol;
    }

    // генерация значений для поля "CVC/CVV".

    public static String generateValidCVC() {
        return String.valueOf(new Random().nextInt(900) + 100);
    }

    public static String generateCVCWith2Symbol() {
        return String.valueOf(new Random().nextInt(100));
    }

    public static String generateCVCWithInvalidSymbol(List<String> list) {
        String cvcInvalidSymbol = (String.join("", list)).substring(0, 3);
        return cvcInvalidSymbol;
    }

    @Value
    public static class Date {
        String number;
        String year;
        String month;
        String holder;
        String cvc;
    }

    public static Date generateAllEmptyField() {
        return new Date("", "", "", "", "");
    }

    public static Date generateValidField(String approvednumberCard) {
        return new Date(approvednumberCard, getYearCard(generateValidDateCard()), getMonthCard(generateValidDateCard()), generateNameOfHolderCard(), generateValidCVC());
    }


}


