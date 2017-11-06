package com.example.admin.adminmarathistatus.Retrofit;

import com.example.admin.adminmarathistatus.BuildConfig;
import com.example.admin.adminmarathistatus.Constant.StringConverter;

import retrofit.RestAdapter;

/**
 * Created by Admin on 06-11-2017.
 */

public class RestClient {

        private static WebServices webServices = null;
        private static WebServices googleWebServices = null;

        public static final String BASE_URL = "http://api.themoviedb.org/3/";

        /**
         * Empty Constructor
         * not called
         */
        private RestClient() {
    }

        /**
         * Gets web services.
         *
         * @return the web services
         */
    public static WebServices getWebServices() {
        if (webServices == null) {
            webServices = new RestAdapter.Builder()
                    .setEndpoint(BASE_URL)
                    .setConverter(new StringConverter())
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .build()
                    .create(WebServices.class);

        }
        return webServices;
    }




}
