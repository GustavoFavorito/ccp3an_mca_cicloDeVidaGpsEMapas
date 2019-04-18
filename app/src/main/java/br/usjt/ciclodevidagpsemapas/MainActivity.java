package br.usjt.ciclodevidagpsemapas;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView locationTextView;

    private LocationManager locationManager;
    private LocationListener locationListener;

    private double latitudeAtual;
    private double longitudeAtual;
    private ArrayList<Localizacao> localizacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        localizacoes = new ArrayList<>();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent
                        (MainActivity.this, ListarLocalizacoesActivity.class);
                intent.putExtra("localizacoes", localizacoes);
                startActivity(intent);
            }
        });

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                latitudeAtual = location.getLatitude();
                longitudeAtual = location.getLongitude();
                Localizacao localizacao = new Localizacao();
                localizacao.setLatitude(latitudeAtual);
                localizacao.setLongitude(longitudeAtual);
                localizacoes.add(0, localizacao);
                if(localizacoes.size() > 50){
                    Log.e("Size",">50");
                    localizacoes.remove(0);
                }
//                locationTextView.setText(String.format(
//                        Locale.ENGLISH, "Lat: %f, Long: %f", latitudeAtual, longitudeAtual));
                locationTextView.setText(sayLocalizacoes());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        locationTextView = findViewById(R.id.locationTextView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //a permissão já foi dada?
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED) {
            //somente ativa
            //a localização é obtida via hardware, intervalo de 0 segundos e 0 metros entre atualizações
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    Localizacao.getLocationInterval(),
                    Localizacao.getLocationDistance(),
                    locationListener);
        } else {
            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION}, Localizacao.REQUEST_CODE_GPS);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        locationManager.removeUpdates(locationListener);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == Localizacao.REQUEST_CODE_GPS) {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                if (ActivityCompat.checkSelfPermission(
                        this, Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED){
                    locationManager.requestLocationUpdates(
                            LocationManager.GPS_PROVIDER,
                            Localizacao.getLocationInterval(),
                            Localizacao.getLocationDistance(),
                            locationListener);
                }
            } else {
                Toast.makeText(
                        this, getString(R.string.no_gps_no_app), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private String sayLocalizacoes() {
        StringBuilder sb = new StringBuilder();
        for (Localizacao l: localizacoes) {
            sb.append(String.format(Locale.ENGLISH,
                    "Lat: %f, Long: %f\n", l.getLatitude(), l.getLongitude()));
        }
        return sb.toString();
    }
}
