package com.example.fahid.routineproject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import android.os.AsyncTask;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.fahid.routineproject.R.id.progressBar;

public class Syllabus extends AppCompatActivity {


    ListView SylListView;
    ProgressBar progressBar;
    String HttpURL = "https://ffahid11.000webhostapp.com/detailssyllabus.php";
    //String HttpURL1 = "https://ffahid11.000webhostapp.com/syllabus.php";
    List<String> CodeList = new ArrayList<>();
    String TempItem;
    ProgressDialog pDialog;
    String FinalJSonObject;
    String ParseResult;
    HashMap<String, String> ResultHash = new HashMap<>();
    Httpparser httpParse = new Httpparser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
        SylListView = (ListView)findViewById(R.id.listview2);
        setTitle("Syllabus");

        progressBar = (ProgressBar)findViewById(R.id.progressBar);

       // new GetHttpResponse(Syllabus.this).execute();

        //Adding ListView Item click Listener.
      /* SylListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // TODO Auto-generated method stub

                Intent intent = new Intent(Syllabus.this,Showsingleday.class);

                // Sending ListView clicked value using intent.
                intent.putExtra("ListViewValue", CodeList.get(position).toString());

                startActivity(intent);

                //Finishing current activity after open next activity.
                finish();

            }
        }); */

        //Receiving the ListView Clicked item value send by previous activity.
        TempItem = getIntent().getStringExtra("ListViewValue");

        //Calling method to filter Student Record and open selected record.
        HttpWebCall(TempItem);}



    public void HttpWebCall(final String PreviousListViewClickedItem) {

        class HttpWebCallFunction extends AsyncTask<String, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                pDialog = ProgressDialog.show(Syllabus.this, "Loading Data", null, true, true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                pDialog.dismiss();

                //Storing Complete JSon Object into String Variable.
                FinalJSonObject = httpResponseMsg;

                //Parsing the Stored JSOn String to GetHttpResponse Method.
                new GetHttpResponse(Syllabus.this).execute();

            }

            @Override
            protected String doInBackground(String... params) {

                ResultHash.put("id", params[0]);

                ParseResult = httpParse.postRequest(ResultHash,HttpURL);

                return ParseResult;
            }
        }

        HttpWebCallFunction httpWebCallFunction = new HttpWebCallFunction();

        httpWebCallFunction.execute(PreviousListViewClickedItem);



    }

    private class GetHttpResponse extends AsyncTask<Void, Void, Void>
    {
        public Context context;

        String JSonResult;

        List<Syllabuss> SyllabusList;

        public GetHttpResponse(Context context)
        {
            this.context = context;
        }

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0)
        {
            // Passing HTTP URL to HttpServicesClass Class.
           // Httpservice httpServicesClass = new Httpservice(HttpURL1);
            //try
           // {
             //   httpServicesClass.ExecutePostRequest();

             //   if(httpServicesClass.getResponseCode() == 200)
              //  {
              //      JSonResult = httpServicesClass.getResponse();

            try{
                    if(FinalJSonObject != null)
                    {
                        JSONArray jsonArray = null;

                        try {
                            jsonArray = new JSONArray(FinalJSonObject);

                            JSONObject jsonObject;

                            Syllabuss syllabus;

                            SyllabusList = new ArrayList<Syllabuss>();

                            for(int i=0; i<jsonArray.length(); i++)
                            {
                                syllabus = new Syllabuss();

                                jsonObject = jsonArray.getJSONObject(i);

                                // Adding Student Id TO IdList Array.
                                CodeList.add(jsonObject.getString("id").toString());

                                //Adding Student course.
                                syllabus.Coursecode = jsonObject.getString("Course_code").toString();
                                syllabus.Coursename = jsonObject.getString("Course_title").toString();
                                syllabus.Credit = jsonObject.getString("Credits").toString();


                                SyllabusList.add(syllabus);



                            }
                        }
                        catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }


            }
            catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(Void result)

        {
            progressBar.setVisibility(View.GONE);

            SylListView.setVisibility(View.VISIBLE);
            Listadapter2 adapter = new Listadapter2(SyllabusList,context);

            SylListView.setAdapter(adapter);



        }

}
}
