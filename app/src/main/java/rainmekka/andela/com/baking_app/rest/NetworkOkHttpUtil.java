package rainmekka.andela.com.baking_app.rest;

/**
 * Created by Oluleke on 6/20/2017.
 */

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import org.json.JSONException;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkOkHttpUtil extends AsyncTask<String, Void, JSONArray> {
    OkHttpClient client = new OkHttpClient();

    @Override
    protected JSONArray doInBackground(String... params) {
        try {
            Request request = new Request.Builder()
                    .url(params[0])
                    .build();
            Response response = client.newCall(request).execute();
            //return new JSONObject(response.body().string());
            return new JSONArray(response.body().string());
        }
        catch(@NonNull IOException | JSONException e){
            e.printStackTrace();
        }
        return null;
    }
}