package cookie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static java.util.Collections.singletonList;

public class FortuneCookieControllerTest {

    private static FortuneСookieController goodFactoryController;
    private static FortuneСookieController badFactoryController;

    @BeforeAll
    public static void beforeAll(){
        goodFactoryController = new FortuneСookieController(new FortuneCookieFactory(
                new FortuneConfig(true),
                singletonList("positive"),
                singletonList("negative")
        ));

        badFactoryController = new FortuneСookieController(new FortuneCookieFactory(
                new FortuneConfig(false),
                singletonList("positive"),
                singletonList("negative")
        ));
    }

    @Test
    //должен проверять, что фабрика может испечь печеньку с хорошим предсказанием.
    public void shouldReturnPositiveFortune() {
        String cookieText = goodFactoryController.tellFortune().getFortuneText();
        Assertions.assertEquals("positive", cookieText);
    }

    @Test
    //проверит, что фабрика также умеет печь печеньки с негативными предсказаниями.
    public void shouldReturnNegativeFortune() {
        String cookieText = badFactoryController.tellFortune().getFortuneText();
        Assertions.assertEquals("negative", cookieText);
    }
}
