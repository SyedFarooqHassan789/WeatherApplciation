package eficode.fi.weatherapp;


import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import android.support.v4.content.ContextCompat;

public class GpsChecker {
    Context context;

    public GpsChecker(@NonNull Context context) {
        this.context = context;
    }
    //Check Gps is turned on or not
    @CheckResult
    @RequiresPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    public boolean CheckStatus() {
        ContentResolver contentResolver = context.getContentResolver();
        checkPermission(context);
        return Settings.Secure
                .isLocationProviderEnabled(contentResolver,
                        LocationManager.GPS_PROVIDER);
    }

    private void checkPermission(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 23 &&
                ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
    }
}
