package br.com.hisao.countries.data.country;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vinicius on 23/11/17.
 */

public class CountryFactory {

    private final static String BASE_URL = "https://restcountries.eu/rest/v2/";

    public static CountryService create() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(CountryService.class);
    }
}
