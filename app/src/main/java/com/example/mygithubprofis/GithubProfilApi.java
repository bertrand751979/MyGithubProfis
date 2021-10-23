package com.example.mygithubprofis;

import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class GithubProfilApi {
    public interface GithubProfilService{
        //ressources
        @GET("users")

        //partie parametre represente par les query
        Call<List<User>>getUsers();
    }
    private final static String BASE_URL="https://api.github.com/";
    private static GithubProfilApi INSTANCE = null;
    private GithubProfilApi(){}
    public static GithubProfilApi getInstance(){
        if (INSTANCE == null){
            INSTANCE = new GithubProfilApi();
        }
        return INSTANCE;
    }
    public Retrofit getClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }
}
