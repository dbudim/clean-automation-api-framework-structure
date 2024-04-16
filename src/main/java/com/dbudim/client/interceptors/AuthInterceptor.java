package com.dbudim.client.interceptors;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AuthInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request authentificated = chain.request().newBuilder()
                .addHeader("Authorization", "Token rlDD7ard7wTydIrGyWZutbmtcF4ohPtZ:N0aSiird4Dp0K2ZSrwctJGwWt9W2xF9Y")
                .build();
        return chain.proceed(authentificated);
    }
}
