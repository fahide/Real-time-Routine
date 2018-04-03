package com.example.fahid.routineproject;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class Showsnglday4th extends AppCompatActivity {

    Httpparser httpParse = new Httpparser();
    ProgressDialog pDialog;

    // Http Url For Filter Student Data from Id Sent from previous activity.
    String HttpURL = "https://ffahid11.000webhostapp.com/single4th.php";

    // Http URL for delete Already Open Student Record.
    String HttpUrlDeleteRecord = "https://ffahid11.000webhostapp.com/delete.php";

    String finalResult;
    HashMap<String, String> hashMap = new HashMap<>();
    String ParseResult;
    HashMap<String, String> ResultHash = new HashMap<>();
    String FinalJSonObject;
    TextView period1,period2,period3,period4,period5,period6;
    String period1holder, period2holder, period3holder,period4holder,period5holder,period6holder;
    Button UpdateButton, DeleteButton;
    String TempItem;
    ProgressDialog progressDialog2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showsnglday4th);
        setTitle("Fourth Year");

        period1 = (TextView) findViewById(R.id.p1);
        period2 = (TextView) findViewById(R.id.p2);
        period3 = (TextView) findViewById(R.id.p3);
        period4 = (TextView) findViewById(R.id.p4);
        period5 = (TextView) findViewById(R.id.p5);
        period6 = (TextView) findViewById(R.id.p6);
        //  UpdateButton = (Button) findViewById(R.id.bu);
        //DeleteButton = (Button) findViewById(R.id.bd);

        //Receiving the ListView Clicked item value send by previous activity.
        TempItem = getIntent().getStringExtra("ListViewValue");

        //Calling method to filter Student Record and open selected record.
        HttpWebCall(TempItem);}
    public void HttpWebCall(final String PreviousListViewClickedItem) {

        class HttpWebCallFunction extends AsyncTask<String, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                pDialog = ProgressDialog.show(Showsnglday4th.this, "Loading Data", null, true, true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                pDialog.dismiss();

                //Storing Complete JSon Object into String Variable.
                FinalJSonObject = httpResponseMsg;

                //Parsing the Stored JSOn String to GetHttpResponse Method.
                new GetHttpResponse(Showsnglday4th.this).execute();

            }

            @Override
            protected String doInBackground(String... params) {

                ResultHash.put("dayID", params[0]);

                ParseResult = httpParse.postRequest(ResultHash, HttpURL);

                return ParseResult;
            }
        }

        HttpWebCallFunction httpWebCallFunction = new HttpWebCallFunction();

        httpWebCallFunction.execute(PreviousListViewClickedItem);
    }


    // Parsing Complete JSON Object.
    private class GetHttpResponse extends AsyncTask<Void, Void, Void> {
        public Context context;

        public GetHttpResponse(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            try {
                if (FinalJSonObject != null) {
                    JSONArray jsonArray = null;

                    try {
                        jsonArray = new JSONArray(FinalJSonObject);

                        JSONObject jsonObject;

                        for (int i = 0; i < jsonArray.length(); i++) {
                            jsonObject = jsonArray.getJSONObject(i);

                            // Storing Student Name, Phone Number, Class into Variables.
                            period1holder = jsonObject.getString("period_1").toString();
                            period2holder = jsonObject.getString("period_2").toString();
                            period3holder = jsonObject.getString("period_3").toString();
                            period4holder = jsonObject.getString("period_4");
                            period5holder = jsonObject.getString("period_5");
                            period6holder = jsonObject.getString("period_6");

                        }
                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            // Setting Student Name, Phone Number, Class into TextView after done all process .
            period1.setText(period1holder);
            period2.setText(period2holder);
            period3.setText(period3holder);
            period4.setText(period4holder);
            period5.setText(period5holder);
            period6.setText(period6holder);

        }
    }
}

