package com.example.loginregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RiwayatPenyakit extends AppCompatActivity {
    public static final String url = "http://192.168.0.5/registerlogin/riwayatpenyakit.php";
    EditText hasil_diagnosa, pengobatan, namabayi;
    TextView tket;
    String get_hasil_diagnosa, get_pengobatan, get_namabayi;
    Button btnok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat_penyakit);

        btnok = findViewById(R.id.btnok);


        Bundle b = getIntent().getExtras();

        namabayi = (EditText)findViewById(R.id.namabayi_editText);
        hasil_diagnosa = (EditText)findViewById(R.id.hasil_diagnosa_editText);
        pengobatan = (EditText)findViewById(R.id.pengobatan_editText);


        get_namabayi = b.getString("parse_namabayi");
        get_hasil_diagnosa = b.getString("parse_hasil_diagnosa");
        get_pengobatan = b.getString("parse_pengobatan");


        namabayi.setText("Nama Bayi : "+get_namabayi);
        hasil_diagnosa.setText("" +get_hasil_diagnosa);
        pengobatan.setText("" +get_pengobatan);


        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputData();
            }
        });
    }

    private void InputData() {
        final String get_namabayi = namabayi.getText().toString();
        final String get_hasil_diagnosa = hasil_diagnosa.getText().toString();
        final String get_pengobatan = pengobatan.getText().toString();
        final ProgressDialog progressDialog = new ProgressDialog(RiwayatPenyakit.this);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        progressDialog.setTitle("Simpan Riwayat Penyakit");
        progressDialog.show();
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Successfully")) {
                    progressDialog.dismiss();
                    Toast.makeText(RiwayatPenyakit.this, response, Toast.LENGTH_SHORT).show();
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(RiwayatPenyakit.this, response, Toast.LENGTH_SHORT).show();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(RiwayatPenyakit.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("get_namabayi", get_namabayi);
                params.put("get_hasil_diagnosa", get_hasil_diagnosa);
                params.put("get_pengobatan", get_pengobatan);
                return params;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MySingleton.getmInstance(RiwayatPenyakit.this).addToRequestQueue(request);
    }
}


