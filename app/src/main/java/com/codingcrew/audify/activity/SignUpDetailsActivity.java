package com.codingcrew.audify.activity;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.codingcrew.audify.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class SignUpDetailsActivity extends AppCompatActivity implements LocationListener {

    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;
    NumberPicker yearPicker;
    LocationManager locationManager;
    TextInputEditText addressInputField;
    Button addressButton;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION) {
            if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_details);

        getLocationPermission();

        yearPicker = findViewById(R.id.yearPicker);
        addressInputField = findViewById(R.id.address_text);
        addressButton = findViewById(R.id.get_location);

        int year = Calendar.getInstance().get(Calendar.YEAR);
        yearPicker.setMinValue(year - 100);
        yearPicker.setMaxValue(year);
        yearPicker.setValue(year - 30);
        yearPicker.setWrapSelectorWheel(false);


        addressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLocation();
            }
        });


    }

    private void getLocationPermission() {
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
        } else {

            new MaterialAlertDialogBuilder(this).setTitle("Location Access")
                    .setMessage("This App needs Location Access")
                    .setPositiveButton("GOT IT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ActivityCompat.requestPermissions(SignUpDetailsActivity.this,
                                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
                        }
                    }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            }).show();

//            MaterialAlertDialogBuilder(context,
//                    R.style.ThemeOverlay_MaterialComponents_MaterialAlertDialog_FullWidthButtons)
//                    .setMessage(resources.getString(R.string.long_message))
//                    .setNegativeButton(resources.getString(R.string.decline)) {
//                dialog, which ->
//                // Respond to negative button press
//            }
//        .setPositiveButton(resources.getString(R.string.accept)) {
//                dialog, which ->
//                // Respond to positive button press
//            }
//        .show();


        }
    }

    private void getLocation() {

        try {
            locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                getLocationPermission();
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, SignUpDetailsActivity.this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        getAddressFromLocation(location.getLatitude(), location.getLongitude(), this, new GeocoderHandler());
    }

    private void getAddressFromLocation(final double latitude, final double longitude, final Context context, final Handler handler) {
        new Thread() {
            @Override
            public void run() {
                Geocoder geocoder = new Geocoder(context, Locale.getDefault());
                String result = null;

                try {
                    List<Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);
                    if (addressList != null && addressList.size() > 0) {
                        Address address = addressList.get(0);
                        StringBuilder addressString = new StringBuilder();
                        for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                            addressString.append(address.getAddressLine(i)).append("\n");
                        }
                        addressString.append(address.getLocality()).append("\n");
                        addressString.append(address.getPostalCode()).append("\n");
                        addressString.append(address.getCountryName());
                        result = addressString.toString();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    Message message = Message.obtain();
                    message.setTarget(handler);
                    message.what = 1;
                    Bundle bundle = new Bundle();
                    if (result == null) {
                        result = "Latitude: " + latitude + " Longitude: " + longitude + "\nUnable to Fetch Address";
                    }
                    bundle.putString("address", result);
                    message.setData(bundle);
                    message.sendToTarget();
                }
            }
        }.start();
    }

    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            String locationAddress;
            switch (msg.what) {
                case 1:
                    Bundle bundle = msg.getData();
                    locationAddress = bundle.getString("address");
                    addressInputField.setText(locationAddress);
                    break;
                default:
                    locationAddress = null;
            }
        }
    }
}