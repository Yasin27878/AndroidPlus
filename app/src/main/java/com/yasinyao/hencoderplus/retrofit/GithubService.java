package com.yasinyao.hencoderplus.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService {
    @GET("users/{user}/repos")
    Call<ResponseBody> getRepo(@Path("user") String user);
}
