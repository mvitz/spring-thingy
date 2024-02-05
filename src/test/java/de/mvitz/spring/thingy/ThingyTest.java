package de.mvitz.spring.thingy;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ThingyTest {

    @Test
    void shouldDetectThingies() {
        try (AnnotationConfigApplicationContext ctx =
                     new AnnotationConfigApplicationContext(ThingyTest.class.getPackage().getName())) {
            final Thing bean = ctx.getBean(Thing.class);
            assertThat(bean, is(not(nullValue())));
        }
    }

    @Test
    void shouldUseValueAsName() {
        try (AnnotationConfigApplicationContext ctx =
                     new AnnotationConfigApplicationContext(ThingyTest.class.getPackage().getName())) {
            final Thing bean = (Thing) ctx.getBean("MyThingIsThis");
            assertThat(bean, is(not(nullValue())));
        }
    }

    @Thingy("MyThingIsThis")
    public static class Thing {}
}
