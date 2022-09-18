package com.example.loginregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class gejala extends AppCompatActivity {
    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10, cb11, cb12;

    Button btnpenyakit, btnriwayat2;

    String var_hasil_diagnosa,var_pengobatan, var_namabayi;
    EditText hasil_diagnosa, pengobatan, namabayi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gejala);

        cb1 = findViewById(R.id.G01);
        cb2 = findViewById(R.id.G02);
        cb3 = findViewById(R.id.G03);
        cb4 = findViewById(R.id.G04);
        cb5 = findViewById(R.id.G05);
        cb6 = findViewById(R.id.G06);
        cb7 = findViewById(R.id.G07);
        cb8 = findViewById(R.id.G08);
        cb9 = findViewById(R.id.G09);
        cb10 = findViewById(R.id.G10);
        cb11 = findViewById(R.id.G11);
        cb12 = findViewById(R.id.G12);

        btnpenyakit = findViewById(R.id.btnpenyakit);
        btnriwayat2 = findViewById(R.id.btnriwayat2);
        hasil_diagnosa = (EditText) findViewById(R.id.hasil_diagnosa_editText);
        pengobatan = (EditText) findViewById(R.id.pengobatan_editText);
        namabayi = (EditText) findViewById(R.id.namabayi_editText);

        hasil_diagnosa.setText(""); //untuk mengosongkan TextView saat pertama kali dijalankan
        pengobatan.setText(""); //untuk mengosongkan TextView saat pertama kali dijalankan
        namabayi.setText(""); //untuk mengosongkan TextView saat pertama kali dijalankan

        btnriwayat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var_namabayi=namabayi.getText().toString();
                var_hasil_diagnosa= hasil_diagnosa.getText().toString();
                var_pengobatan = pengobatan.getText().toString();
                Intent i = null;
                i = new Intent(gejala.this, RiwayatPenyakit.class);
                Bundle b = new Bundle();
                b.putString("parse_namabayi", var_namabayi);
                b.putString("parse_hasil_diagnosa", var_hasil_diagnosa);
                b.putString("parse_pengobatan", var_pengobatan);
                i.putExtras(b);
                startActivity(i);

            }
        });

        btnpenyakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String HasilPenyakit = "Anda Menderita Penyakit :";
                String Solusi = "Pengobatan :";

                //Aturan Penyakit
                if (cb3.isChecked() && cb1.isChecked() && cb2.isChecked()) {
                    HasilPenyakit += "\nDermatitis Atopik";
                    Solusi += "\nPengobatan oles (tropikal) dengan menggunakan steroid ringan dan pelembab serta obat minum antihistamin apabila bayi tampak gatal dan gelisah";
                }
                if (cb3.isChecked() && cb4.isChecked() && cb5.isChecked() && cb6.isChecked()
                        && cb12.isChecked()) {
                    HasilPenyakit += "\nDermatitis Atopik Berat";
                    Solusi += "\n 1. Obat oles yang mengandung steroid ringan atau sedang potensinya" +
                            "\n  2. Diberikan pelembab" +
                            "\n  3. Obat minum antihistamin"+
                            "\n  4. Obat minum steroid sesuai dosis kebutuhan"+
                            "\n  5. Antibiotik minum pada kasus yang dicurigai ada infeksi sebagai pencetusnya";
                }
                if (cb3.isChecked() && cb7.isChecked() && cb8.isChecked()) {
                    HasilPenyakit += "\nDermatitis Seboroik";
                    Solusi += "\nPengobatan dengan obat oles yang mengandung steroid";
                }
                if (cb3.isChecked() && cb5.isChecked() && cb6.isChecked() && cb9.isChecked() && cb10.isChecked() && cb11.isChecked()) {
                    HasilPenyakit += "\nDermatitis Seboroik Leiners Disease";
                    Solusi += "\n 1. Diberikan obat oles" +
                            "\n 2. Obat minum seperti antihistamin" +
                            "\n 3. Antibiotik bila dicurigai ada infeksi pencetus" +
                            "\n 4. Obat minum yang mengandung steroid sebagai antiradang";
                }
                //tampilkan penyakit
                hasil_diagnosa.setText("" + HasilPenyakit);
                pengobatan.setText("" + Solusi);

            }
        });
    }

            public void onCheckboxClicked(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                String str = "";

                //menampilkan pesan ke layar nama gejala
                switch (view.getId()) {
                    case R.id.G01:
                        str = checked ? "Gejala ruam kemerahan di pipi diseleksi" : "Gejala ruam kemerahan di pipi tidak diseleksi";
                        break;
                    case R.id.G02:
                        str = checked ? "Gejala kulit kering di bagian kulit wajah diseleksi" : "Gejala kulit kering di bagian kulit wajah tidak diseleksi";
                        break;
                    case R.id.G03:
                        str = checked ? "Gejala Gatal diseleksi" : "Gejala Gatal tidak diseleksi";
                        break;
                    case R.id.G04:
                        str = checked ? "Gejala Ruam kemerahan muncul selain di pipi, tetapi terdapat pada daerah lipatan kulit, dada dan perut diseleksi" : "Gejala Ruam kemerahan muncul selain di pipi, tetapi terdapat pada daerah lipatan kulit, dada dan perut tidak diseleksi";
                        break;
                    case R.id.G05:
                        str = checked ? "Gejala Deman diseleksi" : "Gejala Demam tidak diseleksi";
                        break;
                    case R.id.G06:
                        str = checked ? "Gejala Bayi tampak rewel diseleksi" : "Gejala Bayi tambak rewel tidak diseleksi";
                        break;
                    case R.id.G07:
                        str = checked ? "Gejala Terdapat sisik kekuningan di area kulit kepala, alis atau sekitar bulu mata diseleksi" : "Gejala Terdapat sisik kekuningan di area kulit kepala, alis atau sekitar bulu mata tidak diseleksi";
                        break;
                    case R.id.G08:
                        str = checked ? "Gejala Kulit kepala, alis atau sekitar bulu mata kemerahan diatas sisik kekuningan diseleksi" : "Gejala Kulit kepala, alis atau sekitar bulu mata kemerahan diatas sisik kekuningan tidak diseleksi";
                        break;
                    case R.id.G09:
                        str = checked ? "Gejala diare diseleksi" : "Gejala diare tidak diseleksi";
                        break;
                    case R.id.G10:
                        str = checked ? "Gejala Kulit sangat kering sehingga mengelupas seperti berketombe di kulit kepala diseleksi" : "Gejala Kulit sangat kering sehingga mengelupas seperti berketombe di kulit kepala tidak diseleksi";
                        break;
                    case R.id.G11:
                        str = checked ? "Gejala Terdapat sisik kekuningan dengan berbagai perluasan pada daerah seluruh tubuh yang mengandung banyak kelenjar keringat diseleksi" : "Gejala Terdapat sisik kekuningan dengan berbagai perluasan pada daerah seluruh tubuh yang mengandung banyak kelenjar keringat tidak diseleksi";
                        break;
                    case R.id.G12:
                        str = checked ? "Gejala Kulit sangat kering bahkan mengelupas meluas bukan hanya di bagian wajah diseleksi" : "Gejala Kulit sangat kering bahkan mengelupas meluas bukan hanya di bagian wajah tidak diseleksi";
                }
                //Tampilkan pesan
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }
}
