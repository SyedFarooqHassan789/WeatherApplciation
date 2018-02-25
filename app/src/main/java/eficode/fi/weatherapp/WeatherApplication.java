package eficode.fi.weatherapp;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.graphics.drawable.PictureDrawable;

import com.bumptech.glide.RequestBuilder;

import eficode.fi.weatherapp.common.Extra;
import eficode.fi.weatherapp.interfaces.IEficodeWeatherService;
import eficode.fi.weatherapp.svg.GlideApp;
import eficode.fi.weatherapp.svg.SvgSoftwareLayerSetter;

import static eficode.fi.weatherapp.common.Extra.EFICODE_API_BASE_URL;

public class WeatherApplication extends Application {
    private static WeatherApplication instance;

    private IEficodeWeatherService iApiWeatherService;
    private RequestBuilder<PictureDrawable> requestBuilderPictureDrawable;
    private AppDatabase appDatabase;

    public static WeatherApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        iApiWeatherService = RetrofitClient.getClient(EFICODE_API_BASE_URL).create(IEficodeWeatherService.class);
        requestBuilderPictureDrawable = GlideApp.with(this)
                .as(PictureDrawable.class)
                .listener(new SvgSoftwareLayerSetter());
        appDatabase = Room.databaseBuilder(this, AppDatabase.class, Extra.LOCATION_DB).build();
    }

    public IEficodeWeatherService getApiWeatherService() {
        return iApiWeatherService;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }

    public RequestBuilder<PictureDrawable> getRequestBuilderPictureDrawable() {
        return requestBuilderPictureDrawable;
    }
}
