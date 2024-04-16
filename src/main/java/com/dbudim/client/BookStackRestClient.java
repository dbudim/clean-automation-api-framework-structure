package com.dbudim.client;

import com.dbudim.client.interceptors.AddUserAgentInterceptor;
import com.dbudim.client.interceptors.AuthInterceptor;
import com.dbudim.client.interceptors.CurlLogInterceptor;
import com.dbudim.client.services.BooksService;
import com.dbudim.client.services.ShelvesService;
import com.dbudim.configuration.Configuration;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookStackRestClient {

    public BooksService booksService;
    public ShelvesService shelvesService;

    private static final String BASE_URL = Configuration.getProjectUrl() + "/api/";

    public BookStackRestClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new AuthInterceptor())
                .addInterceptor(new AddUserAgentInterceptor())
                .addInterceptor(new CurlLogInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        booksService = retrofit.create(BooksService.class);
        shelvesService = retrofit.create(ShelvesService.class);
    }
}
