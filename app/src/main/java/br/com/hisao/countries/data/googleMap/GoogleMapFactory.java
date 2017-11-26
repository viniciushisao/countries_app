package br.com.hisao.countries.data.googleMap;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vinicius on 26/11/17.
 */


//https://maps.googleapis.com/maps/api/staticmap?center=Brooklyn+Bridge,New+York,NY&zoom=13&size=600x300&maptype=roadmap%20&markers=color:blue%7Clabel:S%7C40.702147,-74.015794&markers=color:green%7Clabel:G%7C40.711614,-74.012318%20&markers=color:red%7Clabel:C%7C40.718217,-73.998284%20&key=AIzaSyC4AcGx3CAqJhy-LPIlNyHPssTInhwUrHI
//https://maps.googleapis.com/maps/api/staticmap?zoom=13&size=600x300&key=AIzaSyC4AcGx3CAqJhy-LPIlNyHPssTInhwUrHI&center=40.714728,-73.998672

public class GoogleMapFactory {

//
//    private final static String STATICAMP = "staticmap?";
//    private final static String ZOOM = "zoom=13";
//    private final static String SIZE = "&size=600x300";
//    private final static String API_KEY = "&key=AIzaSyC4AcGx3CAqJhy-LPIlNyHPssTInhwUrHI";

    private final static String BASE_URL = "https://maps.googleapis.com/maps/api/";

    public static GoogleMapService create() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())

                .build();

        return retrofit.create(GoogleMapService.class);
    }
}