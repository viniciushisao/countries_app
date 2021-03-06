package br.com.hisao.countries.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import br.com.hisao.countries.R;
import br.com.hisao.countries.model.Country;
import br.com.hisao.countries.model.ErrorHandle;
import br.com.hisao.countries.model.Language;
import br.com.hisao.countries.tools.Log;
import br.com.hisao.countries.viewmodel.MainViewModel;

public class CountryDetailFragment extends Fragment {
    private static final String COUNTRY_NAME = "country_name";
    private static final String GERMAN = "(de)";

    private TextView txvName;
    private TextView txvNativeName;
    private TextView txvRegion;
    private TextView txvCapital;
    private TextView txvArea;
    private TextView txvLanguagesSpoken;
    private TextView txvTranslationToDE;
    private ImageView imgFlag;
    private ImageView imgLocation;
    private RelativeLayout rllLoading;
    private RelativeLayout rllError;
    private TextView txvErrorMessage;

    private String countryName;

    private OnFragmentInteractionListener mListener;

    public CountryDetailFragment() {
        // Required empty public constructor
    }

    public static CountryDetailFragment newInstance(String countryName) {
        CountryDetailFragment fragment = new CountryDetailFragment();
        Bundle args = new Bundle();
        args.putString(COUNTRY_NAME, countryName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            countryName = getArguments().getString(COUNTRY_NAME);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_country_detail, container, false);
        txvName = view.findViewById(R.id.txvName);
        txvNativeName = view.findViewById(R.id.txvNativeName);
        txvRegion = view.findViewById(R.id.txvRegion);
        txvCapital = view.findViewById(R.id.txvCapital);
        txvArea = view.findViewById(R.id.txvArea);
        txvLanguagesSpoken = view.findViewById(R.id.txvLanguages);
        txvTranslationToDE = view.findViewById(R.id.txvTranslation);
        imgFlag = view.findViewById(R.id.imvFlag);
        imgLocation = view.findViewById(R.id.imvMap);
        rllLoading = view.findViewById(R.id.rllLoading);
        rllError = view.findViewById(R.id.rllError);
        txvErrorMessage = view.findViewById(R.id.txvErrorMessage);
        showLoadingPage();
        MainViewModel model = ViewModelProviders.of(this).get(MainViewModel.class);
        model.getCountry(countryName).observe(this, country -> {
            Log.d("CountryDetailFragment:onCreateView:81 ");
            if (country != null) {
                if (country instanceof ErrorHandle) {
                    ErrorHandle errorHandle = (ErrorHandle) country;
                    showErrorPage(errorHandle.errorMessage);
                } else {
                    showCountryDetails(country);
                }

            }
        });
        return view;
    }

    private void showLoadingPage() {
        hideErrorPage();
        rllLoading.setVisibility(View.VISIBLE);
    }

    private void hideLoadingPage() {
        rllLoading.setVisibility(View.GONE);
    }

    private void showErrorPage(String errorMessage) {

        hideLoadingPage();

        txvErrorMessage.setText(errorMessage);
        rllError.setVisibility(View.VISIBLE);
    }

    private void hideErrorPage() {
        rllError.setVisibility(View.GONE);
    }

    private void showCountryDetails(Country country) {

        hideLoadingPage();
        hideErrorPage();

        txvName.setText(country.name);
        txvNativeName.setText(country.nativeName);
        txvRegion.setText(country.region);
        txvCapital.setText(country.capital);
        txvArea.setText(String.valueOf(country.area));
        StringBuffer aux = new StringBuffer("");
        for (Language language : country.languages) {
            aux.append(language.name + ", ");
        }
        txvLanguagesSpoken.setText(aux.delete(aux.length() - 2, aux.length()));
        aux = new StringBuffer("");
        aux.append(country.translations.de);
        aux.append(" " + GERMAN);
        txvTranslationToDE.setText(aux);
        imgFlag.setImageBitmap(country.bmpFlag);
        imgLocation.setImageBitmap(country.bmpMap);
        hideLoadingPage();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction();
    }
}
