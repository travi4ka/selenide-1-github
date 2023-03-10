import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
public class GithubPlusDragAndDrop {
    @Test
    void softAssertionsIsOnTheWikiPage(){
//        - Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");
//        - Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
//        - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(byText("Show 2 more pages…")).click();
        $(".wiki-pages-box button").click();
        $(".wiki-pages-box").shouldHave(text("SoftAssertions"));
//        - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(".wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").parent().shouldHave(text("JUnit5"))
                .sibling(0).$("pre").shouldBe(visible);
    }
}
