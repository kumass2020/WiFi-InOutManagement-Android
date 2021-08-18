package com.example.inoutmanagement;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConnection {

    OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

    /* Test URL(Loopback or local network) */
//    String URL = "http://172.30.1.23:40012";
//    String URL = "http://192.9.45.211:40012";
//    String URL = "192.168.0.4:40012";
//    String URL = "http://172.30.1.24:40012";
//    String URL = "http://192.9.45.135:40012";
    String URL = "http://221.148.21.221:40012";

    // Server URL(내부)
//    String URL = "http://192.9.45.226:40006/";

//    // Server URL(외부)
//    String URL = "http://210.102.181.156:40006/";

    Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(clientBuilder.build())
            .build();

    RetrofitInterface server = retrofit.create(RetrofitInterface.class);

}

