package dev.martynoff.bytebuddy_reproducer;

import net.bytebuddy.asm.Advice;
import net.bytebuddy.build.Plugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.matcher.ElementMatchers;

import java.io.IOException;

public class TestGreeterByteBuddyPlugin implements Plugin, Plugin.Factory {
    @Override
    public DynamicType.Builder<?> apply(
        DynamicType.Builder<?> builder,
        TypeDescription typeDescription,
        ClassFileLocator classFileLocator) {

        return builder
            .method(ElementMatchers.named("greet"))
            .intercept(Advice.to(GreeterInterceptor.class));
    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public Plugin make() {
        return this;
    }

    @Override
    public boolean matches(TypeDescription target) {
        return target.isAssignableFrom(Greeter.class);
    }
}
