package br.com.hisao.countries.data.googleMap;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vinicius on 26/11/17.
 */
public class GoogleMapFactory {

    private final static String BASE_URL = "https://maps.googleapis.com/maps/api/";

    public static GoogleMapService create() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())

                .build();

        return retrofit.create(GoogleMapService.class);
    }
}