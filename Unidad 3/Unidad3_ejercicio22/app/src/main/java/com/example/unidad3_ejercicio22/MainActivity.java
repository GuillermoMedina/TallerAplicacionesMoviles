package com.example.unidad3_ejercicio22;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewResult;
    private RequestQueue mQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewResult = findViewById(R.id.text_view_result);

        mQueue = Volley.newRequestQueue(this);


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String[] letra = {"Aguascalientes","Baja California","Baja California Sur","Campeche","Coahuila de Zaragoza","Colima","Chiapas","Chihuahua","Ciudad de México","Durango","Guanajuato","Guerrero","Hidalgo","Jalisco","México","Michoacán de Ocampo","Morelos","Nayarit","Nuevo León","Oaxaca","Puebla","Querétaro","Quintana Roo","San Luis Potosí","Sinaloa","Sonora","Tabasco","Tamaulipas","Tlaxcala","Veracruz","Yucatán","Zacatecas"};
        final String[] ides = {"aguas","bc","bcs","camp","coah","col","chis","chih","cdmx","dgo","gto","gro","hgo","jal","mex","mich","mor","nay","nl","oax","pue","qro","qroo","slp","sin","son","tab","tamps","tlax","ver","yuc","zac"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, letra));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id)
            {
                //String capSel = (String) adapterView.getItemAtPosition(pos);
                //String ide = ides[pos];
                pos = pos+1;

                String pos1;

                if (pos <= 9)
                {
                    pos1 = String.valueOf("0" + pos);
                }
                else
                {
                    pos1 = String.valueOf(pos);
                }


                //Toast.makeText(adapterView.getContext(),pos1, Toast.LENGTH_SHORT).show();
                jsonParse(pos1);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {    }
        });

    }


    private void jsonParse(String capsel) {

        String url = "https://gaia.inegi.org.mx/wscatgeo/mgee/"+capsel;
        //Toast.makeText(this,url, Toast.LENGTH_SHORT).show();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            //JSONArray jsonArray = response.getJSONArray("datos");

                            JSONObject datos = response.getJSONObject("datos");

                            mTextViewResult.setText("Nombre:    "+datos.getString("nom_agee") + "\n" +
                                    "Nombre abreviado:  " + datos.getString("nom_abrev") + "\n" +
                                    "Poblacion total:   " + datos.getString("pob") + "\n" +
                                    "Poblacion femenina:    " + datos.getString("pob_fem") + "\n" +
                                    "Poblacion masculina:   " + datos.getString("pob_mas") + "\n" +
                                    "Total de viviendas:     " + datos.getString("viv") + "\n");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }


}
