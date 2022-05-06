package cookie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Collections.singletonList;

public class FortuneCookieFactoryTest {

    private static FortuneCookieFactory fortuneCookieFactory;

    @BeforeEach
    public void beforeEach(){
        fortuneCookieFactory = new FortuneCookieFactory(
                new FortuneConfig(true),
                singletonList("positive"),
                singletonList("negative")
        );
    }
    @Test
    public void shouldIncrementCountByOneAfterOneCookieBaked() {
        fortuneCookieFactory.bakeFortuneCookie();

        Assertions.assertEquals(1, fortuneCookieFactory.getCookiesBaked());
    }

    @Test
    public void shouldIncrementCountByTwoAfterTwoCookiesBaked() {
        fortuneCookieFactory.bakeFortuneCookie();
        fortuneCookieFactory.bakeFortuneCookie();

        Assertions.assertEquals(2, fortuneCookieFactory.getCookiesBaked());
    }

    @Test
    public void shouldSetCounterToZeroAfterResetCookieCreatedCall() {
        fortuneCookieFactory.bakeFortuneCookie();

        Assertions.assertEquals(1, fortuneCookieFactory.getCookiesBaked());

        fortuneCookieFactory.resetCookiesCreated();

        Assertions.assertEquals(0, fortuneCookieFactory.getCookiesBaked());
    }
}