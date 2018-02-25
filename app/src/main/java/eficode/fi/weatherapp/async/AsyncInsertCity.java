package eficode.fi.weatherapp.async;


import android.os.AsyncTask;

import eficode.fi.weatherapp.WeatherApplication;
import eficode.fi.weatherapp.common.Extra;
import eficode.fi.weatherapp.entity.LocationInfo;

public class AsyncInsertCity extends AsyncTask<LocationInfo, Void, String> {
    @Override
    protected String doInBackground(LocationInfo... locationInfo) {
        WeatherApplication.getInstance().getAppDatabase().iLocationDao().insertAll(locationInfo);
        return Extra.DATA_SAVED;
    }

    @Override
    protected void onPostExecute(String result) {

    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected void onProgressUpdate(Void... values) {
    }
}
