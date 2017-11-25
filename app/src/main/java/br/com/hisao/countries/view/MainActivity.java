package br.com.hisao.countries.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
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

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(android.R.id.list);

        MainViewModel model = ViewModelProviders.of(this).get(MainViewModel.class);
        model.getCountries().observe(this, countries -> {

            for (Country c : countries) {
                Log.d("MainActivity:onCreate:73 " + c.name);
            }

        });

        filterText = findViewById(R.id.edtSearch);
        filterText.addTextChangedListener(filterTextWatcher);
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                Country.CountryNameList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = (String) adapterView.getItemAtPosition(i);
                Log.d("MainActivity:onItemClick:77 " + name);

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(android.R.id.content, CountryDetailFragment.newInstance(null, null));
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
    }

    @Override
    public void onFragmentInteraction() {

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
