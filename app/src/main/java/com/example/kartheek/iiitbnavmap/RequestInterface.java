package com.example.kartheek.iiitbnavmap;

import com.example.kartheek.iiitbnavmap.ServerRequest;
import com.example.kartheek.iiitbnavmap.ServerResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RequestInterface {

    @POST("android/")
    Call<ServerResponse> operation(@Body ServerRequest request);

}
