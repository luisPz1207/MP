package com.example.mobilprestamos.modulos.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mobilprestamos.R;
import com.example.mobilprestamos.modulos.home.Home;
import com.example.mobilprestamos.modulos.home.NavigationPrincipal;

public class MainActivity extends AppCompatActivity {

    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews(){
        btLogin = (Button) findViewById(R.id.btLogin);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHome();
            }
        });
    }

    private void goToHome(){
        Intent intent = new Intent(this, NavigationPrincipal.class);
        startActivity(intent);
    }
}