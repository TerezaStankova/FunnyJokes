package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.example.android.jokelibrary.MyJoker;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {
    /** A simple endpoint method that takes a joke */
    @ApiMethod(name = "sayJoke")
    public MyBean sayJoke(@Named("joke") String joke) {
        String jokeText = MyJoker.getJoke();
        MyBean response = new MyBean();
        response.setData(jokeText);

        return response;
    }
}
