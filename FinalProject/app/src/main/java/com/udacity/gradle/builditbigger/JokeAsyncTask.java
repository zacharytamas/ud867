package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.jokesApi.JokesApi;
import com.zacharytamas.libs.jokeviewer.JokeViewerActivity;

import java.io.IOException;

/**
 * Created by zacharytamas on 7/30/15.
 */
public class JokeAsyncTask extends AsyncTask<Context, Void, String> {

    private static JokesApi jokesApiService = null;
    private static Context mContext = null;


    @Override
    protected String doInBackground(Context... params) {
        if (jokesApiService == null) {
            JokesApi.Builder builder = new JokesApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://zt-build-it-bigger.appspot.com/_ah/api/");

            jokesApiService = builder.build();
        }

        if (params != null) {
            mContext = params[0];
        }

        try {
            ((MainActivity) mContext).setSupportProgressBarIndeterminate(true);
            return jokesApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (mContext != null) {
            ((MainActivity) mContext).setSupportProgressBarIndeterminate(false);
            Intent jokeViewerIntent = new Intent(mContext, JokeViewerActivity.class);
            jokeViewerIntent.putExtra(JokeViewerActivity.EXTRA_JOKE_TEXT, result);
            mContext.startActivity(jokeViewerIntent);
        }
    }
}
