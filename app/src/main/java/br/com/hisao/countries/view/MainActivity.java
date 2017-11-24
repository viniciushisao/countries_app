package br.com.hisao.countries.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import java.util.List;

import br.com.hisao.countries.CountryApplication;
import br.com.hisao.countries.R;
import br.com.hisao.countries.model.Country;
import br.com.hisao.countries.tools.Log;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Call<List<Country>> allUsers = CountryApplication.create(this).getCountryService().listAll();

        allUsers.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {

                List<Country> countries = response.body();

                for (Country country : countries){

                    Log.d("MainActivity:onResponse:34 " + country.name);
                }


            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Log.d("MainActivity:onFailure:43 " + t.getMessage());
            }
        });
    }
}
