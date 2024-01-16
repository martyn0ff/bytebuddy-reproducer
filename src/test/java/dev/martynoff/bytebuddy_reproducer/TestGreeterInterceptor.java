package dev.martynoff.bytebuddy_reproducer;

import net.bytebuddy.asm.Advice;

public class TestGreeterInterceptor {
    private TestGreeterInterceptor() {
    }

    @Advice.OnMethodExit
    public static String intercept(@Advice.Return(readOnly = false) String greeting) {
        greeting = greeting + ". This is intercepted only in tests.";
        return null;
    }
}
