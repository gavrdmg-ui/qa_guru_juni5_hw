import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MReasonMainPageTests extends BaseTest {

    @ValueSource(strings = {"Меню"})
    @ParameterizedTest(name = "При нажатии на кнопку {0} открывается список разделов")
    @Tag("BLOCKER")
    void clickMenuButtonRevealMenuCategories(String buttonName) {
        open("");
        $(byText(buttonName)).click();
        $(".main-menu__wrap").shouldBe(visible);
    }
}
