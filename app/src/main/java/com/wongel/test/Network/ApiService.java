package com.wongel.test.Network;

import com.wongel.test.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by pranishshrestha on 5/2/17.
 */

public interface ApiService {
    @GET("Books")
    Call<List<Book>> fetchBooks();
}
