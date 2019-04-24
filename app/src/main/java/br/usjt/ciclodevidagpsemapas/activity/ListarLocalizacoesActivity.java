

package br.usjt.ciclodevidagpsemapas.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.usjt.ciclodevidagpsemapas.R;
import br.usjt.ciclodevidagpsemapas.adapter.LocalizacaoRecyclerViewAdapter;
import br.usjt.ciclodevidagpsemapas.adapter.WeatherAdapter;
import br.usjt.ciclodevidagpsemapas.dao.LocalizacaoDAO;
import br.usjt.ciclodevidagpsemapas.model.Localizacao;
import br.usjt.ciclodevidagpsemapas.model.Weather;

public class ListarLocalizacoesActivity extends AppCompatActivity {

    private LocalizacaoDAO localizacaoDAO;
    private RecyclerView locationsRecyclerView;
    private List<Weather> previsoes;
    private WeatherAdapter adapterWeather;
    private RecyclerView weatherRecyclerView;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_localizacoes);
        localizacaoDAO = new LocalizacaoDAO(this);
        ArrayList<Localizacao> localizacoes = (ArrayList<Localizacao>) localizacaoDAO.listarLocalizacoes();
        locationsRecyclerView = findViewById(R.id.localizacoesRecyclerView);
        locationsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        LocalizacaoRecyclerViewAdapter adapterLocalizacao = new LocalizacaoRecyclerViewAdapter(localizacoes);
        locationsRecyclerView.setAdapter(adapterLocalizacao);

        requestQueue = Volley.newRequestQueue(this);
        weatherRecyclerView =
                findViewById(R.id.weatherRecyclerView);
        previsoes = new ArrayList<>();
        adapterWeather = new WeatherAdapter(previsoes, this);
        weatherRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        weatherRecyclerView.setAdapter(adapterWeather);
    }

    public void obtemPrevisoes (double latitude, double longitude){
        String url = getString(
                R.string.web_service_url,
                latitude,
                longitude,
                getString(R.string.api_key)
        );
        JsonObjectRequest req = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                (response)->{
                    previsoes.clear();
                    try{
                        JSONArray list = response.getJSONArray("list");
                        for (int i = 0; i < list.length(); i++){
                            JSONObject day = list.getJSONObject(i);
                            JSONObject main = day.getJSONObject("main");
                            JSONObject weather = day.getJSONArray("weather").getJSONObject(0);
                            previsoes.add (new Weather(day.getLong("dt"), main.getDouble("temp_min"),
                                    main.getDouble("temp_max"), main.getDouble ("humidity"),
                                    weather.getString("description"),weather.getString("icon")));
                        }
                        adapterWeather.notifyDataSetChanged();
                    }
                    catch (JSONException e){
                        e.printStackTrace();
                    }
                },
                (error)->{
                    Toast.makeText(
                            ListarLocalizacoesActivity.this,
                            getString(R.string.connect_error) + ": " + error.getLocalizedMessage(),
                            Toast.LENGTH_SHORT
                    ).show();
                }
        );
        requestQueue.add(req);
    }
}
