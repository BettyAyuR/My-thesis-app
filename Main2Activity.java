package com.example.loginregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ambil_data();
    }
    void ambil_data()
    {
        String url = "http://192.168.0.7/registerlogin/getData.php";
        StringRequest respon = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("result");
                            ArrayList<Get_data> list_data;
                            list_data=new ArrayList<>();
                            for (int i=-0; i<jsonArray.length(); i++)
                            {
                                JSONObject result=jsonArray.getJSONObject(i);
                                String get_hasil_diagnosa=result.getString("get_hasil_diagnosa");
                                String get_pengobatan=result.getString("get_pengobatan");
                                String get_namabayi=result.getString("get_namabayi");
                                list_data.add(new Get_data(
                                        get_hasil_diagnosa,
                                        get_pengobatan,
                                        get_namabayi
                                ));
                            }
                            ListView listView=findViewById(R.id.list);
                            Custom_adapter adapter = new Custom_adapter(Main2Activity.this,list_data);
                            listView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Main2Activity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(respon);
    }
}

class Get_data{
    String get_hasil_diagnosa="", get_pengobatan="", get_namabayi="";
    Get_data(String get_hasil_diagnosa, String get_pengobatan, String get_namabayi)
    {
        this.get_hasil_diagnosa=get_hasil_diagnosa;
        this.get_pengobatan=get_pengobatan;
        this.get_namabayi=get_namabayi;
    }

    public String getGet_hasil_diagnosa() {
        return get_hasil_diagnosa;
    }

    public String getGet_pengobatan() {
        return get_pengobatan;
    }

    public String getGet_namabayi() {
        return get_namabayi;
    }
}

class Custom_adapter extends BaseAdapter
{
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Get_data>model;
    Custom_adapter(Context context, ArrayList<Get_data> model)
    {
        layoutInflater=LayoutInflater.from(context);
        this.context=context;
        this.model=model;

    }

    @Override
    public int getCount() {
        return model.size();
    }

    @Override
    public Object getItem(int position) {
        return model.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=layoutInflater.inflate(R.layout.list, null);
        TextView get_hasil_diagnosa, get_pengobatan, get_namabayi;
        get_hasil_diagnosa=view.findViewById(R.id.get_hasil_diagnosa);
        get_pengobatan= view.findViewById(R.id.get_pengobatan);
        get_namabayi=view.findViewById(R.id.get_namabayi);

        get_hasil_diagnosa.setText(model.get(position).getGet_hasil_diagnosa());
        get_pengobatan.setText(model.get(position).getGet_pengobatan());
        get_namabayi.setText(model.get(position).getGet_namabayi());
        return view;
    }
}
