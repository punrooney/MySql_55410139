package com.example.Mysql_55410139;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

	private EditText edt1,edt2,edt3;
	private Button btn1;
	private ProgressDialog pDialog;
	private static String url_create_student = "http://www.sawasdeemall.com/android/create_student.php";
	JSONParser jsonParser = new JSONParser();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = (EditText)findViewById(R.id.edt_id);
        edt2 = (EditText)findViewById(R.id.edt_name);
        edt3 = (EditText)findViewById(R.id.edt_tel);
        btn1 = (Button)findViewById(R.id.btn_save);
        btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new CreateNewStudent().execute();
				
			}
		});
    }
        class CreateNewStudent extends AsyncTask<String, String, String>{
        	
        	
        @Override
        protected void onPreExecute() {
        	
        	super.onPreExecute();
        	pDialog = new ProgressDialog(MainActivity.this);
        	pDialog.setMessage("Createing Student....");
        	pDialog.setIndeterminate(false);
        	pDialog.setCancelable(true);
        	pDialog.show();
        	
        }
			@Override
			protected String doInBackground(String... arg0) {
				String stu_id = edt1.getText().toString();
				String name = edt2.getText().toString();
				String tel = edt3.getText().toString();
				
				List<NameValuePair> list = new ArrayList<NameValuePair>();
				list.add(new BasicNameValuePair("stu_id", stu_id));
				list.add(new BasicNameValuePair("name", name));
				list.add(new BasicNameValuePair("tel", tel));
				
				JSONObject json = jsonParser.makeHttpRequest(url_create_student,
						"POST", list);
				return null;
			}
			@Override
				protected void onPostExecute(String result) {
					// TODO Auto-generated method stub
					pDialog.dismiss();
					
				}
			
        	
        }
    }


   

