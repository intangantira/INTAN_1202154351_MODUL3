package com.example.android.intan_1202154351_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText username = (EditText) findViewById(R.id.user);
        final EditText password = (EditText) findViewById(R.id.pass);
        Button login = (Button) findViewById(R.id.Login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = username.getText().toString();
                String pass =  password.getText().toString();
                if (uname.equals("EAD")&&pass.equals("MOBILE")){
                    //jika username dan password yang dimasukan benar
                    Toast.makeText(getApplicationContext(),"Username dan Password benar Selamat Login",Toast.LENGTH_SHORT).show();
                    //tampilan message jika login berhasil
                    Intent list = new Intent(getApplicationContext(),ListAir.class);
                    //akan menampilkan ke activity selanjutnya yaitu List Air
                    startActivity(list);
                    //activity List Air dijalankan
            }
                else {
                    //jika username dan password salah
                    Toast.makeText(getApplicationContext(),"Username dan Password tidak sesuai Gagal Login",Toast.LENGTH_SHORT).show();
                    //akan menampilkan message jika login gagal
                }
            }
        });
    }
}

