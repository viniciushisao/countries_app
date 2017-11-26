package br.com.hisao.countries;

import android.app.Application;
import android.content.Context;

import br.com.hisao.countries.data.CountryFactory;
import br.com.hisao.countries.data.CountryService;
import br.com.hisao.countries.data.GoogleMapFactory;
import br.com.hisao.countries.data.GoogleMapService;

/**
 * Created by vinicius on 23/11/17.
 */

public class CountryApplication extends Application {

    private CountryService countryService;
    private GoogleMapService googleMapService;

    public CountryService getCountryService() {
        if (countryService == null)
            countryService = CountryFactory.create();
        return countryService;
    }


    public GoogleMapService getGoogleMapService() {
        if (googleMapService == null)
            googleMapService = GoogleMapFactory.create();
        return googleMapService;
    }

    private static CountryApplication get(Context context){
        return (CountryApplication) context.getApplicationContext();
    }

    public static CountryApplication create(Context context){
        return CountryApplication.get(context);
    }
}
