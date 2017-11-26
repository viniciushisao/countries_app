package br.com.hisao.countries.data;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by vinicius on 26/11/17.
 */

public interface GoogleMapService {
    int ZOOM = 7;
    String SIZE = "600x300";
    String API_KEY = "AIzaSyC4AcGx3CAqJhy-LPIlNyHPssTInhwUrHI";

    @GET("staticmap")
    Call<ResponseBody> retrieveMapImage(@Query("zoom") int zoom, @Query("size") String size,
                                        @Query("key") String key, @Query("center") String latlon);
}
