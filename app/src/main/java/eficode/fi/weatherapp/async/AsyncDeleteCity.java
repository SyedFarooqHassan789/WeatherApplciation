package eficode.fi.weatherapp.async;


import android.os.AsyncTask;

import eficode.fi.weatherapp.WeatherApplication;
import eficode.fi.weatherapp.common.Extra;

public class AsyncDeleteCity extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... params) {
        String id = params[0];
        WeatherApplication.getInstance().getAppDatabase().iLocationDao().deleteId(id);
        return Extra.DATA_DELETED;
    }

    @Override
    protected void onPostExecute(String result) {

    }

    @Override
    protected void onPreExecute() {
    }
}
