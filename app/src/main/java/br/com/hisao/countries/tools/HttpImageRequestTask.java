package br.com.hisao.countries.tools;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.AsyncTask;

import com.caverock.androidsvg.SVG;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by vinicius on 25/11/17.
 */
public class HttpImageRequestTask extends AsyncTask<String, Void, Bitmap> {

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
            Log.e("HttpImageRequestTask:doInBackground:45 " + e.getMessage());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {

    }
}