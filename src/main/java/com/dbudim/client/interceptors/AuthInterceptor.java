package com.dbudim.client.interceptors;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AuthInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request authentificated = chain.request().newBuilder()
                .addHeader("Authorization", "Token qe8847gtDi8vNyLLBzZSsyKe9hpsqDh5:7JYqDHpQ0KN69vl1WpThMMfZQqcVADiO")
                .build();
        return chain.proceed(authentificated);
    }
}
