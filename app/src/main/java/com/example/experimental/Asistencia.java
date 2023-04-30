package com.example.experimental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.experimental.Adaptadores.AsistenciaAdaptador;
import com.example.experimental.Modelos.MAsistencia;
import com.example.experimental.Modelos.MPersona;

import java.util.ArrayList;

public class Asistencia extends AppCompatActivity {

    MAsistencia mAsistencia;

    MPersona mPersona;
    MAsistencia mAsistenci;

    ArrayList<MPersona> listapersona;
    ArrayList<MAsistencia> listaasistencia = new ArrayList<>();

    private RecyclerView recycleViewListado;

    private Button btnguardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asistencia);


        recycleViewListado = (RecyclerView) findViewById(R.id.recicleasistencia);
        btnguardar = (Button) findViewById(R.id.btnguardarasistencia);

        listapersona = new ArrayList<>();

        for (int a = 0 ; a < 30 ; a++){
            mPersona = new MPersona();

            mPersona.setIdPersona(a);
            mPersona.setNombre1("Nombre 1: " + a);
            mPersona.setNombre2("Nombre 2: " + a);
            mPersona.setApellido1("Apellido 1: " + a);
            mPersona.setApellido2("Apellido 2: " + a);

            listapersona.add(mPersona);

        }

        System.out.println(listapersona.size() + "Asistenciaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        init();

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listaasistencia.size() != 0){
                    for (int a = 0 ; a < listaasistencia.size() ; a++){
                        System.out.println(listaasistencia.get(a).getIdAsistencia() + ", " +
                                listaasistencia.get(a).getEstadoAsistencia() + ", " +
                                listaasistencia.get(a).getFechaAsistencia() + ", " +
                                listaasistencia.get(a).getObservacionAsistencia());
                    }
                }
            }
        });



    }

    public void init() {
        AsistenciaAdaptador asistenciaAdaptador = new AsistenciaAdaptador(listapersona, this, new AsistenciaAdaptador.OnItemClickListener() {
            @Override
            public void onItemClick(MPersona item) {

            }

            @Override
            public void obtenList(MAsistencia item) {
                listaasistencia.add(item);
            }
        });

        recycleViewListado.setHasFixedSize(true);
        recycleViewListado.setLayoutManager(new LinearLayoutManager(this));
        recycleViewListado.setAdapter(asistenciaAdaptador);
    }

    /*public void moveToDescription(MListado item) {
        Intent intent = new Intent(this, Cursos.class);
        intent.putExtra("MProgramas", item);
        startActivity(intent);
    }*/
}