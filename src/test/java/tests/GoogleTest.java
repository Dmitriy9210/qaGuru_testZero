package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class GoogleTest {
    @Test
    void selenideSearchTest() {
        // Открыть google
        open("https://google.com");
        // Ввести Selenide в поиск
        $(byName("q")).setValue("Selenide").pressEnter();
        // Проверить, что Selenide появился в результатах поиска
        $("html").shouldHave(text("ru.selenide.org"));
    }

    @Test
    void selenideSearchAndOpenTest() {
        // Открыть google
        open("https://google.com");
        // Ввести Selenide в поиск
        $(byName("q")).setValue("Selenide").pressEnter();
        // Проверить, что Selenide появился в результатах поиска
        $("html").shouldHave(text("ru.selenide.org"));

        // открыть сайт selenide
        $(byText("ru.selenide.org")).click();
        $("html").shouldHave(text("ЧТО ТАКОЕ SELENIDE?"));
    }

    @Test
    void selenideSearchMailRuTest() {
        open("https://google.com");
        $(byName("q")).setValue("mail ru").pressEnter();
        $("html").shouldHave(text("mail.ru"));
    }

    @Test
    void selenideSearchYandexTest() {
        open("https://yandex.ru/");
        $(byCssSelector(".input__control.input__input")).setValue("Selenide").pressEnter();
        $("html").shouldHave(text("ru.selenide.org"));
    }

}
