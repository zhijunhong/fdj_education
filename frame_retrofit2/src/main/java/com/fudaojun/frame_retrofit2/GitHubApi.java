package com.fudaojun.frame_retrofit2;

import com.fudaojun.frame_retrofit2.entity.Contributor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubApi {

    @GET("repos/{owner}/{repo}/contributors")
    Call<List<Contributor>> contributorsByAddConverterGetCall(@Path("owner") String owner, @Path("repo") String repo);
}