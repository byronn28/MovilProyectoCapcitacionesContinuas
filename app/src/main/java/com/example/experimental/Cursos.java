package com.example.experimental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.experimental.Adaptadores.CursosAdaptador;
import com.example.experimental.DB.DataBase;
import com.example.experimental.Modelos.MCursos;
import com.example.experimental.Modelos.MProgramas;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cursos extends AppCompatActivity {

    MCursos mCursos;
    ArrayList<MCursos> listaCursos;


    private RecyclerView recycleViewCursos;


    //use database
    private DataBase conection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos);

        //use database
        conection = new DataBase(getApplicationContext());
        //use consultar datos
        MProgramas mProgramas = (MProgramas) getIntent().getSerializableExtra("MProgramas");
        int id_usu = (int) getIntent().getSerializableExtra("id_usu");


        recycleViewCursos = (RecyclerView) findViewById(R.id.recicleCursos);


        consultarListaCursos(mProgramas.getIdPrograma(), id_usu);
    }

    private void consultarListaCursos(int id_pro, int id_usu) {

        SQLiteDatabase db = conection.getReadableDatabase();

        listaCursos = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT idCurso, nombreCurso, duracionCurso, nombreModalidadCurso, nombreTipoCurso, nombreEspecialidad, nombreArea, fechaInicioCurso, fechaFinalizacionCurso " +
                "FROM cursos WHERE idUsuario = '" + id_usu + "' AND idPrograma = '" + id_pro + "' " +
                "ORDER BY fechaInicioCurso DESC;", null);
        while (cursor.moveToNext()){
            mCursos = new MCursos();
            mCursos.setIdCurso(cursor.getInt(0));
            mCursos.setNombreCurso(cursor.getString(1));
            mCursos.setNombreModalidadCurso(cursor.getString(2));
            mCursos.setNombreTipoCurso(cursor.getString(3));
            mCursos.setNombreEspecialidad(cursor.getString(4));
            mCursos.setNombreArea(cursor.getString(5));
            mCursos.setFechaInicioCurso(cursor.getString(6));
            mCursos.setFechaFinalizacionCurso(cursor.getString(7));

            listaCursos.add(mCursos);
        }
        init();
    }

    public void init() {
        CursosAdaptador cursosAdaptador = new CursosAdaptador(listaCursos, this, new CursosAdaptador.OnItemClickListener() {
            @Override
            public void onItemClick(MCursos item) {
                moveToDescription(item);
            }
        });

        recycleViewCursos.setHasFixedSize(true);
        recycleViewCursos.setLayoutManager(new LinearLayoutManager(this));
        recycleViewCursos.setAdapter(cursosAdaptador);
    }

    public void moveToDescription(MCursos item) {
        Intent intent = new Intent(this, Asistencia.class);
        intent.putExtra("MAsistencia", item);
        startActivity(intent);
    }
}