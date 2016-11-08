package de.mvitz.spring.thingy;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class ThingyTest {

    @Test
    public void shouldDetectThingies() throws Exception {
        try (AnnotationConfigApplicationContext ctx =
                     new AnnotationConfigApplicationContext(ThingyTest.class.getPackage().getName())) {
            final Thing bean = ctx.getBean(Thing.class);
            assertThat(bean, is(not(nullValue())));
        }
    }

    @Test
    public void shouldUseValueAsName() throws Exception {
        try (AnnotationConfigApplicationContext ctx =
                     new AnnotationConfigApplicationContext(ThingyTest.class.getPackage().getName())) {
            final Thing bean = (Thing) ctx.getBean("MyThingIsThis");
            assertThat(bean, is(not(nullValue())));
        }
    }

    @Thingy("MyThingIsThis")
    public static class Thing {}
}
