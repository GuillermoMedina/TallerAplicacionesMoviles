package com.example.unidad3_ejercicio2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;

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


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        //String[] letra = {"Afghanistan","Åland Islands ","Albania","Algeria","American Samoa ","Andorra","Angola","Anguilla","Antarctica","Antigua and Barbuda ","Argentina","Armenia","Aruba","Australia","Austria","Azerbaijan","The Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bermuda","Bhutan","Bolivia ","Caribbean Netherlands Bonaire","Bosnia and Herzegovina ","Botswana","Bouvet Island ","Brazil","British Indian Ocean Territory ","Brunei Darussalam","Bulgaria","Burkina Faso ","Burundi","Cabo Verde","Cambodia","Cameroon","Canada","Cayman Islands ","Central African Republic ","Chad","Chile","China","Christmas Island ","Cocos (Keeling) Islands ","Colombia","Comoros","Republic of the Congo","Democratic Republic of the Congo","Cook Islands ","Costa Rica ","Ivory Coast ","Croatia","Cuba","Curaçao","Cyprus","Czech Republic ","Denmark","Djibouti","Dominica","Dominican Republic ","Ecuador","Egypt","El Salvador ","Equatorial Guinea ","Eritrea","Estonia","Eswatini","Ethiopia","Falkland Islands ","Faroe Islands ","Fiji","Finland","France","French Guiana ","French Polynesia ","French Southern and Antarctic Lands ","Gabon","The Gambia","Georgia ","Germany","Ghana","Gibraltar","Greece","Greenland","Grenada","Guadeloupe","Guam","Guatemala","Guernsey","Guinea","Guinea-Bissau","Guyana","Haiti","Heard Island and McDonald ","Vatican City ","Honduras","Hong Kong ","Hungary","Iceland","India","Indonesia","Iran ","Iraq","Republic of Ireland","Isle of Man ","Israel","Italy","Jamaica","Japan","Jersey","Jordan","Kazakhstan","Kenya","Kiribati","North Korea ","South Korea","Kuwait","Kyrgyzstan","Laos Lao People's Democratic Republic","Latvia","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macau Macao","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands ","Martinique","Mauritania","Mauritius","Mayotte","Mexico","Federated States of Micronesia ","Moldova","Monaco","Mongolia","Montenegro","Montserrat","Morocco","Mozambique","Myanmar","Namibia","Nauru","Nepal","Netherlands","New Caledonia ","New Zealand ","Nicaragua","Niger","Nigeria","Niue","Norfolk Island ","Republic of Macedonia ","Northern Mariana Islands ","Norway","Oman","Pakistan","Palau","State of Palestine","Panama","Papua New Guinea ","Paraguay","Peru","Philippines","Pitcairn Islands ","Poland","Portugal","Puerto Rico ","Qatar","Réunion","Romania","Russia Russian Federation","Rwanda","Saint Barthélemy Saint Barthélemy","Saint Helena","Saint Kitts and Nevis ","Saint Lucia ","Saint Martin ","Saint Pierre and Miquelon ","Saint Vincent and the Grenadines ","Samoa","San Marino ","Sao Tome and Principe","Saudi Arabia ","Senegal","Serbia","Seychelles","Sierra Leone ","Singapore","Sint Maarten ","Slovakia","Slovenia","Solomon Islands ","Somalia","South Africa ","South Georgia and the South Sandwich Islands ","South Sudan ","Spain","Sri Lanka ","Sudan","Suriname","Svalbard and Jan Mayen ","Sweden","Switzerland","Syria Syrian Arab Republic","Taiwan","Tajikistan","Tanzania","Thailand","Timor-Leste","Togo","Tokelau","Tonga","Trinidad and Tobago ","Tunisia","Turkey","Turkmenistan","Turks and Caicos Islands ","Tuvalu","Uganda","Ukraine","United Arab Emirates ","United Kingdom","United States ","Uruguay","Uzbekistan","Vanuatu","Venezuela ","Vietnam ","British Virgin Islands Virgin Islands ","United States Virgin Islands Virgin Islands ","Wallis and Futuna ","Western Sahara ","Yemen","Zambia","Zimbabwe"};
        //final String[] ides = {"AF","AX","AL","DZ","AS","AD","AO","AI","AQ","AG","AR","AM","AW","AU","AT","AZ","BS","BH","BD","BB","BY","BE","BZ","BJ","BM","BT","BO","BQ","BA","BW","BV","BR","IO","BN","BG","BF","BI","CV","KH","CM","CA","KY","CF","TD","CL","CN","CX","CC","CO","KM","CG","CD","CK","CR","CI","HR","CU","CW","CY","CZ","DK","DJ","DM","DO","EC","EG","SV","GQ","ER","EE","SZ","ET","FK","FO","FJ","FI","FR","GF","PF","TF","GA","GM","GE","DE","GH","GI","GR","GL","GD","GP","GU","GT","GG","GN","GW","GY","HT","HM","VA","HN","HK","HU","IS","IN","ID","IR","IQ","IE","IM","IL","IT","JM","JP","JE","JO","KZ","KE","KI","KP","KR","KW","KG","LA","LV","LB","LS","LR","LY","LI","LT","LU","MO","MG","MW","MY","MV","ML","MT","MH","MQ","MR","MU","YT","MX","FM","MD","MC","MN","ME","MS","MA","MZ","MM","NA","NR","NP","NL","NC","NZ","NI","NE","NG","NU","NF","MK","MP","NO","OM","PK","PW","PS","PA","PG","PY","PE","PH","PN","PL","PT","PR","QA","RE","RO","RU","RW","BL","SH","KN","LC","MF","PM","VC","WS","SM","ST","SA","SN","RS","SC","SL","SG","SX","SK","SI","SB","SO","ZA","GS","SS","ES","LK","SD","SR","SJ","SE","CH","SY","TW","TJ","TZ","TH","TL","TG","TK","TO","TT","TN","TR","TM","TC","TV","UG","UA","AE","GB","US","UY","UZ","VU","VE","VN","VG","VI","WF","EH","YE","ZM","ZW"};
        //spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, letra));

        /*spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id)
            {
                //String capSel = (String) adapterView.getItemAtPosition(pos);
                String ide = ides[pos];
                Toast.makeText(adapterView.getContext(),ide, Toast.LENGTH_SHORT).show();
                CargarClima(capSel);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {    }
        });*/

        CargarClima(null);

    }

    public void CargarClima(String capSel) {
        try {

            conexionWeb = new ConexionWeb(MainActivity.this);

            String link = "https://gaia.inegi.org.mx/wscatgeo/mgee/buscar/nay";

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

            //JSONObject coord = object.getJSONObject("coord");
            clima1.setText("Nombre : "+object.getString("name")+"\n" +
                    "Capital: "+ object.getString("capital")+"\n" +
                    "Region: "+object.getString("region")+"\n" +
                    "Subregion: "+object.getString("subregion")+"\n" +
                    "Poblacion: "+object.getString("population")+"\n"
            );


        }catch (JSONException e){
            System.out.println(""+e);
        }


    }
}
