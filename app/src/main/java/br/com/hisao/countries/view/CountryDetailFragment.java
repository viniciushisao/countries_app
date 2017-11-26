package br.com.hisao.countries.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.hisao.countries.R;
import br.com.hisao.countries.model.Country;
import br.com.hisao.countries.model.Language;
import br.com.hisao.countries.tools.Log;
import br.com.hisao.countries.viewmodel.MainViewModel;

public class CountryDetailFragment extends Fragment {
    private static final String COUNTRY_NAME = "country_namee";
    private static final String ARG_PARAM2 = "param2";
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

    // TODO: Rename and change types of parameters
    private String countryName;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CountryDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param countryName Parameter 1.
     * @param param2      Parameter 2.
     * @return A new instance of fragment CountryDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CountryDetailFragment newInstance(String countryName, String param2) {
        CountryDetailFragment fragment = new CountryDetailFragment();
        Bundle args = new Bundle();
        args.putString(COUNTRY_NAME, countryName);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            countryName = getArguments().getString(COUNTRY_NAME);
            mParam2 = getArguments().getString(ARG_PARAM2);
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

        Log.d("CountryDetailFragment:onCreateView:86 " + countryName);
        MainViewModel model = ViewModelProviders.of(this).get(MainViewModel.class);
        model.getCountry(countryName).observe(this, country -> {
            showCountryDetails(country);
        });
        return view;
    }

    private void showCountryDetails(Country country) {
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
        txvTranslationToDE.setText(country.name);
        imgFlag.setImageBitmap(country.bmpFlag);
        imgLocation.setImageBitmap(country.bmpMap);
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction();
    }
}
