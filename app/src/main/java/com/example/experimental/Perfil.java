package com.example.experimental;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Perfil extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        //boton de navegacion
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_perfil);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {

                    case R.id.action_misCursos:
                        startActivity(new Intent(getApplicationContext(),Asistencia.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.action_Cursos:
                        startActivity(new Intent(getApplicationContext(),Cursos.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.action_programas:
                        startActivity(new Intent(getApplicationContext(),Programas.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}