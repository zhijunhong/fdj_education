package com.fudaojun.frame_retrofit2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fudaojun.frame_retrofit2.entity.Contributor;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import utils.LibUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();



        Retrofit retrofit = new Retrofit.Builder()
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.github.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();


        GitHubApi repo = retrofit.create(GitHubApi.class);
        Call<List<Contributor>> call = repo.contributorsByAddConverterGetCall("square", "retrofit");
        call.enqueue(new Callback<List<Contributor>>() {
            @Override
            public void onResponse(Call<List<Contributor>> call, Response<List<Contributor>> response) {
                List<Contributor> contributorList = response.body();
                for (Contributor contributor : contributorList) {
                    LibUtils.myLog("login", contributor.getLogin());
                    LibUtils.myLog("contributions", contributor.getContributions() + "");
                }
            }

            @Override
            public void onFailure(Call<List<Contributor>> call, Throwable t) {

            }
        });


//        GitHubApi repo = retrofit.create(GitHubApi.class);
//        Call<ResponseBody> call = repo.contributorsBySimpleGetCall("square", "retrofit");
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                try {
//                    //response
//                    LibUtils.myLog(response.body().string());
//                    Gson gson = new Gson();
//                    ArrayList<Contributor> contributorsList = gson.fromJson(response.body().string(), new TypeToken<List<Contributor>>() {
//                    }.getType());
//                    for (Contributor contributor : contributorsList) {
//                        Log.d("login", contributor.getLogin());
//                        Log.d("contributions", contributor.getContributions() + "");
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//            }
//        });

    }
}
