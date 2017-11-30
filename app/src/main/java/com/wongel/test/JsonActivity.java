package com.wongel.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wongel.test.Network.ApiService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.Body;

public class JsonActivity extends AppCompatActivity {
    //master

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

 
        //this is master
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fakerestapi.azurewebsites.net/api/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();

        ApiService service = retrofit.create(ApiService.class);

        Call<List<Book>> call = service.fetchBooks();

        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {


                for (Book book:response.body())
                    Log.d("Ar",book.getTitle());
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Log.d("Ar", "Errto" + t.getMessage());
            }
        });
    }
}
