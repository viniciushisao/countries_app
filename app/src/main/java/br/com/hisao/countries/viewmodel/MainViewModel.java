package br.com.hisao.countries.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;

import br.com.hisao.countries.CountryApplication;
import br.com.hisao.countries.model.Country;
import br.com.hisao.countries.tools.Log;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vinicius on 23/11/17.
 */

public class MainViewModel extends AndroidViewModel {
    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    private void loadCountries() {
        Call<List<Country>> allUsers = CountryApplication.create(
                getApplication().getApplicationContext()).getCountryService().listAll();
        allUsers.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                countries.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Log.d("MainActivity:onFailure:43 " + t.getMessage());
            }
        });
    }


    private MutableLiveData<List<Country>> countries;

    public LiveData<List<Country>> getCountries() {
        if (countries == null) {
            countries = new MutableLiveData<>();
            loadCountries();

        }
        return countries;
    }

}
