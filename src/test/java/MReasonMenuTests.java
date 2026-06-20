import data.ClothesCategory;
import data.ClothesSubCategories;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MReasonMenuTests extends BaseTest {

    static Stream<Arguments> categoriesFromMenuConsistSubCategories() {
        return Stream.of(
                Arguments.of(
                        ClothesCategory.OUTERWEAR.description,
                        List.of(ClothesSubCategories.JACKETS.description,
                                ClothesSubCategories.COAT.description,
                                ClothesSubCategories.CLOAKS.description,
                                ClothesSubCategories.FUR_COATS.description)
                ),
                Arguments.of(
                        ClothesCategory.PANTS.description,
                        List.of(ClothesSubCategories.PANTS.description,
                                ClothesSubCategories.CULOTTES.description)
                ),
                Arguments.of(
                        ClothesCategory.KNITTED.description,
                        List.of(ClothesSubCategories.CARDIGANS.description)
                ),
                Arguments.of(
                        ClothesCategory.TOPS.description,
                        List.of(ClothesSubCategories.LONGSLEEVES.description,
                                ClothesSubCategories.TOPS.description,
                                ClothesSubCategories.T_SHIRTS.description,
                                ClothesSubCategories.HOODIES_SWEATSHIRTS.description,
                                ClothesSubCategories.BLOUSES_SHIRTS.description,
                                ClothesSubCategories.TURTLENECKS.description)
                ), Arguments.of(
                        ClothesCategory.ACCESSORIES.description,
                        List.of(ClothesSubCategories.BAGS.description,
                                ClothesSubCategories.BELTS.description,
                                ClothesSubCategories.SCARVES_SHAWLS.description,
                                ClothesSubCategories.BIJOUTERIE.description)
                )
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Категория меню {0} содержит подкатегории {1}")
    @Tag("BLOCKER")
    void categoriesFromMenuConsistSubCategories(String categoryName, List<String> subCategories) {
        open("");
        $(byText("Меню")).click();
        $(byText(categoryName)).click();
        $$(".main-menu__accordion-list li").filter(visible).shouldHave(texts(subCategories));

    }

    @CsvFileSource(resources = "/test_data/redirectToPageCollectionFromMenu.csv")
    @ParameterizedTest(name = "При клике на коллекцию \"{0}\" в разделе меню открывается страница с ссылкой {1} и заголовком \"{0}\"")
    @Tag("BLOCKER")
    void redirectToPageCollectionFromMenu(String collectionName, String expectedUrl) {
        open("");
        $(byText("Меню")).click();
        $(byText(collectionName)).click();
        webdriver().shouldHave(url(expectedUrl));
        $(".catalog-title").shouldHave(text(collectionName));
    }
}
