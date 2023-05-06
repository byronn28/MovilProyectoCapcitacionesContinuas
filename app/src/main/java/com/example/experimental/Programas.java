package com.example.experimental;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.experimental.Adaptadores.ProgramasAdaptador;
import com.example.experimental.DB.DataBase;
import com.example.experimental.Modelos.MProgramas;
import com.example.experimental.Utilidades.Atributos;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.time.LocalDate;
import java.util.ArrayList;

public class Programas extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    MProgramas mProgramas;
    ArrayList<MProgramas> listaProgramas;

    //vista
    private RecyclerView recycleViewProgramas;


    //use database
    private DataBase conection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programas);

        //boton de navegacion
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_programas);

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

                    case R.id.action_perfil:
                        startActivity(new Intent(getApplicationContext(),Perfil.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });

        //use database
        conection = new DataBase(getApplicationContext());


        //datos de main
        int id = (int) getIntent().getSerializableExtra("id");
        String rol = (String) getIntent().getSerializableExtra("rol");


        //vista
        recycleViewProgramas = (RecyclerView) findViewById(R.id.recicleProgramas);


        consultarListaProgramas(id, rol);
    }

    private void consultarListaProgramas(int id, String rol) {
        SQLiteDatabase db = conection.getReadableDatabase();

        if (rol.equals("alumno")){
            listaProgramas = new ArrayList<>();

            Cursor cursor = db.rawQuery("SELECT p.idPrograma, p.nombrePrograma, p.nombrePeriodoPrograma, p.fechaInicioPeriodoPrograma, p.fechaFinPeriodoPrograma " +
                            "                FROM programas p INNER JOIN cursos c ON c.idPrograma = p.idPrograma INNER JOIN inscritos i ON idUsuario = ? AND i.idCurso = c.idCurso " +
                            "              GROUP BY p.idPrograma ORDER BY p.fechaInicioPeriodoPrograma DESC;",
                    new String[]{String.valueOf(id)});

            while (cursor.moveToNext()){
                mProgramas = new MProgramas();
                mProgramas.setIdPrograma(cursor.getInt(0));
                mProgramas.setNombrePrograma(cursor.getString(1));
                mProgramas.setNombrePeriodoPrograma(cursor.getString(2));
                mProgramas.setFechaInicioPeriodoPrograma(cursor.getString(3));
                mProgramas.setFechaFinPeriodoPrograma(cursor.getString(4));

                listaProgramas.add(mProgramas);
            }
            init(id, rol);
        } else {
            listaProgramas = new ArrayList<>();

            Cursor cursor = db.rawQuery("SELECT p.idPrograma, p.nombrePrograma, p.nombrePeriodoPrograma, p.fechaInicioPeriodoPrograma, p.fechaFinPeriodoPrograma " +
                            "                FROM programas p INNER JOIN cursos c ON c.idCapacitador = ? AND c.idPrograma = p.idPrograma GROUP BY p.idPrograma " +
                            "                ORDER BY p.fechaInicioPeriodoPrograma DESC;",
                    new String[]{String.valueOf(id)});

            while (cursor.moveToNext()){
                mProgramas = new MProgramas();
                mProgramas.setIdPrograma(cursor.getInt(0));
                mProgramas.setNombrePrograma(cursor.getString(1));
                mProgramas.setNombrePeriodoPrograma(cursor.getString(2));
                mProgramas.setFechaInicioPeriodoPrograma(cursor.getString(3));
                mProgramas.setFechaFinPeriodoPrograma(cursor.getString(4));

                listaProgramas.add(mProgramas);
            }
            init(id, rol);
        }
    }

    public void init(int id, String rol) {
        ProgramasAdaptador programasAdaptador = new ProgramasAdaptador(listaProgramas, this, new ProgramasAdaptador.OnItemClickListener() {
            @Override
            public void onItemClick(MProgramas item) {
                moveToDescription(item, id, rol);
            }
        });

        recycleViewProgramas.setHasFixedSize(true);
        recycleViewProgramas.setLayoutManager(new LinearLayoutManager(this));
        recycleViewProgramas.setAdapter(programasAdaptador);
    }

    public void moveToDescription(MProgramas item, int id, String rol) {
        Intent intent = new Intent(this, Cursos.class);
        intent.putExtra("MProgramas", item);
        intent.putExtra("id", id);
        intent.putExtra("rol", rol);
        startActivity(intent);
    }
}