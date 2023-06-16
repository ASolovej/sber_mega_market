package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

@Tag("UI")
public class SearchTests extends BaseTest {

    @Test
    public void check() {
        new MainPage().setTextSearchString("Сахар");
    }
}
