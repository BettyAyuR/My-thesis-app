package com.example.loginregistration;


import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.rengwuxian.materialedittext.MaterialEditText;


import java.util.HashMap;
import java.util.Map;

public class biodata extends AppCompatActivity {
    MaterialEditText namaibu, namaayah, namabayi, usiabayi;
    Button simpan;

    SharedPreferences sharedPreferences;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);

        namaibu = findViewById(R.id.namaibu);
        namaayah = findViewById(R.id.namaayah);
        namabayi = findViewById(R.id.namabayi);
        usiabayi = findViewById(R.id.usiabayi);
        simpan = findViewById(R.id.simpan);

        progressDialog = new ProgressDialog(this);
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtNamaIbu = namaibu.getText().toString();
                String txtNamaAyah = namaayah.getText().toString();
                String txtNamaBayi = namabayi.getText().toString();
                String txtUsiaBayi = usiabayi.getText().toString();
                if (TextUtils.isEmpty(txtNamaIbu) || TextUtils.isEmpty(txtNamaAyah)
                        || TextUtils.isEmpty(txtNamaBayi) || TextUtils.isEmpty(txtUsiaBayi)) {
                    Toast.makeText(biodata.this, "All Fields Required", Toast.LENGTH_SHORT).show();
                } else {
                    simpan(txtNamaIbu, txtNamaAyah, txtNamaBayi, txtUsiaBayi);
                }
            }

            private void simpan(final String namaibu, final String namaayah, final String namabayi, final String usiabayi) {
                final ProgressDialog progressDialog = new ProgressDialog(biodata.this);
                progressDialog.setCancelable(false);
                progressDialog.setIndeterminate(false);
                progressDialog.setTitle("Simpan Biodata");
                progressDialog.show();
                String URL = "http://192.168.0.5/registerlogin/biodata.php";
                StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("Successfully")) {
                            progressDialog.dismiss();
                            Toast.makeText(biodata.this, response, Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(biodata.this, gejala.class));
                            finish();
                        } else {
                            progressDialog.dismiss();
                            Toast.makeText(biodata.this, response, Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(biodata.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String, String> param = new HashMap<>();
                        param.put("namaibu", namaibu);
                        param.put("namaayah", namaayah);
                        param.put("namabayi", namabayi);
                        param.put("usiabayi", usiabayi);
                        return param;
                    }
                };
                request.setRetryPolicy(new DefaultRetryPolicy(30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                MySingleton.getmInstance(biodata.this).addToRequestQueue(request);
            }
        });
    }
}



