package mx.edu.ittepic.unidad3_31jsonclima;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.CollationElementIterator;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AsyncResponse {

    ConexionWeb conexionWeb;
    TextView clima1,clima2,climat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clima1=findViewById(R.id.Clima1);
        clima2=findViewById(R.id.Clima2);
        climat=findViewById(R.id.climat);


        /*Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String[] capital = {"Guadalajara","Tepic","Mazatlan","Manzanillo","Tijuana"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, capital));

        final String capSel = String.valueOf(spinner.getSelectedItem());*/
        //final String capSel2 = spinner.getSelectedView().toString();


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String[] letra = {"Tepic","Guadalajara","Monterrey","Mazatlan","Tijuana"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, letra));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id)
            {
                String capSel = (String) adapterView.getItemAtPosition(pos);
                Toast.makeText(adapterView.getContext(),capSel, Toast.LENGTH_SHORT).show();
                CargarClima(capSel);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {    }
        });



    }


    public void CargarClima(String capSel) {
        try {

            conexionWeb = new ConexionWeb(MainActivity.this);

            String link = "http://api.openweathermap.org/data/2.5/weather?q=" + capSel + ",mx&APPID=096d6e9eb9bf8c6a98890f411fd57c24";

            URL direcciopn = new URL(link);
            conexionWeb.execute(direcciopn);




        } catch (MalformedURLException e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void procesarRespuesta(String r) {
        try {

            JSONObject object = new JSONObject(r);

            //JSONArray clima =           object.getJSONArray("weather");
            //StringBuilder sb = new StringBuilder();
            /*for (int i = 0; i < clima.length(); i++) {
                JSONObject objeto = clima.getJSONObject(i);
                String main = objeto.getString("main");
                String des = objeto.getString("description");
                sb.append(main+" : "+des+"         ");
            }*/

            JSONObject coord = object.getJSONObject("coord");
            clima1.setText("Nombre : "+object.getString("name")+"\nLongitud: "+coord.getString("lon")+"\nLatitud: "+coord.getString("lat"));

            JSONObject  temperaturas = object.getJSONObject("main");
            double doubleTemperatura = Double.parseDouble(temperaturas.getString("temp")) - 273.15;
            double doubleTemperaturaMinima = Double.parseDouble(temperaturas.getString("temp_min")) - 273.15;
            double doubleTemperaturaMaxima = Double.parseDouble(temperaturas.getString("temp_max")) - 273.15;

            final DecimalFormat formatoDec = new DecimalFormat("#.#");
            formatoDec.setRoundingMode(RoundingMode.FLOOR);

            Double temperatura = new Double(formatoDec.format(doubleTemperatura));
            Double temperaturaMinima = new Double(formatoDec.format(doubleTemperaturaMinima));
            Double temperaturaMaxima = new Double(formatoDec.format(doubleTemperaturaMaxima));

            clima2.setText("\n"+"Temperatura: "+temperatura+"\nHumedad:"+temperaturas.getString("pressure")+"\nTemperatura minima: "+temperaturaMinima+"\nTemperatura maxima: "+temperaturaMaxima);


        }catch (JSONException e){
            System.out.println(""+e);
        }


    }

}
