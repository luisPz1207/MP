package com.example.mobilprestamos.modulos.home;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.mobilprestamos.R;
import com.example.mobilprestamos.modulos.models.ObjectClient;

public class Home extends AppCompatActivity {

    private ObjectClient objectClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }
}