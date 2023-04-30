package com.example.experimental.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.experimental.Modelos.MAsistencia;
import com.example.experimental.Modelos.MPersona;
import com.example.experimental.R;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AsistenciaAdaptador extends RecyclerView.Adapter<AsistenciaAdaptador.ViewHolder> {

    MAsistencia mAsistencia;

    private List<MPersona> mData;
    private LayoutInflater mInflater;
    private Context context;
    final AsistenciaAdaptador.OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(MPersona item);

        void obtenList(MAsistencia item);
    }

    public AsistenciaAdaptador(List<MPersona> itemList, Context context, AsistenciaAdaptador.OnItemClickListener listener){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
        this.listener = listener;
    }

    @Override
    public int getItemCount(){
        return mData.size();
    }

    @Override
    public AsistenciaAdaptador.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.list_asistencia, null);
        return new AsistenciaAdaptador.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AsistenciaAdaptador.ViewHolder holder, final int position){
        holder.bindData(mData.get(position), position);
    }

    public void setItems(List<MPersona> items){
        mData = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtnombres, txtapellidos;
        Button btnasiste, btnnoasiste, btnobservacione;

        ViewHolder(View itemView){
            super(itemView);
            txtnombres = itemView.findViewById(R.id.txtvnombresasistencia);
            txtapellidos = itemView.findViewById(R.id.txtvapellidosasistencia);
            btnasiste = itemView.findViewById(R.id.btnasisteasistencia);
            btnnoasiste = itemView.findViewById(R.id.btnnoasisteasistencia);
            btnobservacione = itemView.findViewById(R.id.btnobservacionesasistencia);
        }

        void bindData(final MPersona item, int position){

            txtnombres.setText(item.getNombre1() + ", " + item.getNombre2());
            txtnombres.setText(item.getApellido1() + ", " + item.getApellido2());

            btnasiste.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "ASISTE " + item.getIdPersona() + " id " + item.getNombre1() + ", " + item.getNombre2() + " nombres " + item.getApellido1() + ", " + item.getApellido2()  + " apellido", Toast.LENGTH_SHORT).show();

                    mAsistencia = new MAsistencia();

                    mAsistencia.setIdAsistencia(item.getIdPersona());
                    mAsistencia.setEstadoAsistencia(true);
                    mAsistencia.setFechaAsistencia("2023, 4, 26");
                    mAsistencia.setObservacionAsistencia(item.getNombre1() + ", " + item.getNombre2() + ", " + item.getApellido1() + ", " + item.getApellido2());

                    listener.obtenList(mAsistencia);
                }
            });

            btnnoasiste.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "NO ASISTE " + item.getIdPersona() + " id " + item.getNombre1() + ", " + item.getNombre2() + " nombres " + item.getApellido1() + ", " + item.getApellido2()  + " apellido", Toast.LENGTH_SHORT).show();

                    mAsistencia = new MAsistencia();

                    mAsistencia.setIdAsistencia(item.getIdPersona());
                    mAsistencia.setEstadoAsistencia(false);
                    mAsistencia.setFechaAsistencia("2023, 4, 26");
                    mAsistencia.setObservacionAsistencia(item.getNombre1() + ", " + item.getNombre2() + ", " + item.getApellido1() + ", " + item.getApellido2());

                    listener.obtenList(mAsistencia);
                }
            });

            btnobservacione.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Observaciones uwu", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
