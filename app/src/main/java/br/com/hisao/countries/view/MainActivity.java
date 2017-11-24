package br.com.hisao.countries.view;

import android.arch.lifecycle.ViewModelProviders;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import br.com.hisao.countries.CountryApplication;
import br.com.hisao.countries.R;
import br.com.hisao.countries.model.Country;
import br.com.hisao.countries.tools.Log;
import br.com.hisao.countries.viewmodel.MainViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements CountryDetailFragment.OnFragmentInteractionListener {

    private EditText filterText = null;
    ArrayAdapter<String> adapter = null;
    ListView listView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(android.R.id.list);
        Call<List<Country>> allUsers = CountryApplication.create(this).getCountryService().listAll();

        allUsers.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {

                List<Country> countries = response.body();

                StringBuffer s = new StringBuffer("{");

                for (Country country : countries) {

                    s.append(country.name + ",");

                }

                Log.d("MainActivity:onResponse:56 " + s.toString());


            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Log.d("MainActivity:onFailure:43 " + t.getMessage());
            }
        });

        filterText = findViewById(R.id.edtSearch);
        filterText.addTextChangedListener(filterTextWatcher);
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                new String[]{"brazil", "bermuda"});
        listView.setAdapter(adapter);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private TextWatcher filterTextWatcher = new TextWatcher() {

        public void afterTextChanged(Editable s) {
        }

        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            adapter.getFilter().filter(s);
        }

    };
}
