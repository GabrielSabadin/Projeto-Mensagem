package com.example.abrirmensagem;


import android.util.Log;

import androidx.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

// Classe para se comunicar com a API via internet


    public class ClienteGerar {

        private static Gerar gerar;



        public static Gerar request() throws IOException {
            try {
                Request request = new Request.Builder()
                        .url("https://api.flutter-community.de/api/v1/advice")
                        .build();
                Log.i("request", request.toString());

                OkHttpClient client = new OkHttpClient();
                Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                        Log.i("code", String.valueOf(response.code()));
                        if (response.code() == 200) {

                            String body = response.body().string();
                            try {
                                JSONObject object = new JSONObject(body);
                                Log.i("ebjeto", object.toString());
                                 gerar = new Gerar(object);
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }


                    public void onFailure(Call call, IOException e) {
                        try {
                            throw  new IOException("Deu paia");
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }

                    }
                });
            }
            catch (Exception e) {
                e.printStackTrace();
                throw new IOException("num deu");
            }
            while (gerar == null) {

            }
            return gerar;
        }

}
