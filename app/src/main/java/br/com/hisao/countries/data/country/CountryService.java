package br.com.hisao.countries.data.country;

import java.util.List;

import br.com.hisao.countries.model.Country;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by vinicius on 23/11/17.
 */

public interface CountryService {
    @GET("all")
    Call<List<Country>> listAll();

    @GET("name/{name}")
    Call<List<Country>>  retrieveCountry(@Path("name") String countryName);
}
