package br.com.hisao.countries;

import android.app.Application;
import android.content.Context;

import br.com.hisao.countries.data.CountryFactory;
import br.com.hisao.countries.data.CountryService;

/**
 * Created by vinicius on 23/11/17.
 */

public class CountryApplication extends Application {

    private CountryService countryService;

    public CountryService getCountryService() {
        if (countryService == null)
            countryService = CountryFactory.create();
        return countryService;
    }

    private static CountryApplication get(Context context){
        return (CountryApplication) context.getApplicationContext();
    }

    public static CountryApplication create(Context context){
        return CountryApplication.get(context);
    }
}
