package dev.martynoff.bytebuddy_reproducer;

import net.bytebuddy.asm.Advice;

public class GreeterInterceptor {
    private GreeterInterceptor() {
    }

    @Advice.OnMethodExit
    public static String intercept(@Advice.Return(readOnly = false) String greeting) {
        greeting = greeting + ". ByteBuddy was here.";
        return null;
    }
}
