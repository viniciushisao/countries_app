package br.com.hisao.countries.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.caverock.androidsvg.SVG;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import br.com.hisao.countries.CountryApplication;
import br.com.hisao.countries.data.googleMap.GoogleMapService;
import br.com.hisao.countries.model.Country;
import br.com.hisao.countries.model.ErrorHandle;
import br.com.hisao.countries.tools.Log;
import okhttp3.ResponseBody;
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

    private MutableLiveData<List<Country>> countries;
    private MutableLiveData<Country> country;


    private void loadCountry(String countryName) {
        Call<List<Country>> listCall = CountryApplication.create(
                getApplication().getApplicationContext()).getCountryService().retrieveCountry(countryName);
        listCall.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                country.setValue(response.body().get(0));
                loadFlagImage(country.getValue().flag);
                Double lat = country.getValue().latlng.get(0);
                Double lon = country.getValue().latlng.get(1);
                loadMapImage(lat, lon);
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                ErrorHandle errorHandle = new ErrorHandle();
                errorHandle.errorMessage = t.getMessage();
                country.setValue(errorHandle);
            }
        });
    }


    public LiveData<Country> getCountry(String countryName) {
        if (country == null) {
            country = new MutableLiveData<>();
            loadCountry(countryName);
        }
        return country;
    }

    private void loadMapImage(Double lat, Double lon) {

        String latlon = lat + "," + lon;

        Call<ResponseBody> listCall = CountryApplication.create(
                getApplication().getApplicationContext()).getGoogleMapService().
                retrieveMapImage(GoogleMapService.ZOOM, GoogleMapService.SIZE, GoogleMapService.API_KEY, latlon);
        listCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.body() != null) {
                    InputStream is = response.body().byteStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    country.getValue().bmpMap = bitmap;
                    country.postValue(country.getValue());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                //TODO
                Log.d("MainActivity:onFailure:43 " + t.getMessage());
            }
        });

    }

    private void loadFlagImage(String url) {
        class HttpImageRequestTask extends AsyncTask<String, Void, Bitmap> {
            @Override
            protected Bitmap doInBackground(String... params) {
                try {
                    final URL url = new URL(params[0]);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = urlConnection.getInputStream();
                    SVG image = SVG.getFromInputStream(inputStream);
                    Bitmap newBM = Bitmap.createBitmap((int) Math.ceil(image.getDocumentWidth()),
                            (int) Math.ceil(image.getDocumentHeight()),
                            Bitmap.Config.ARGB_8888);
                    Canvas bmcanvas = new Canvas(newBM);
                    bmcanvas.drawRGB(255, 255, 255);
                    image.renderToCanvas(bmcanvas);
                    return newBM;
                } catch (Exception e) {
                    //TODO
                    Log.e("HttpImageRequestTask:doInBackground:45 " + e.getMessage());
                }
                return null;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                country.getValue().bmpFlag = bitmap;
                country.postValue(country.getValue());
            }
        }
        HttpImageRequestTask httpImageRequestTask = new HttpImageRequestTask();
        httpImageRequestTask.execute(url);
    }
}
