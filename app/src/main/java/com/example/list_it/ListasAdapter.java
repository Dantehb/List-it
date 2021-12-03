package com.example.list_it;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class ListasAdapter extends FirestoreRecyclerAdapter<Listas, ListasAdapter.ViewHolder>{
    public ListasAdapter(@NonNull FirestoreRecyclerOptions<Listas> options){
        super (options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Listas listas)
            {
                holder.textViewTituloIzq.setText(listas.getTitulo());
                holder.textViewContenidoIzq.setText(listas.getContenido());
                holder.textViewFechaIzq.setText(String.valueOf(listas.getFecha()));
            }

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_view_lista_izquierda, viewGroup, false);
        return new ViewHolder(view);
            }


    public class ViewHolder extends RecyclerView.ViewHolder{
                TextView textViewTituloIzq;
                TextView textViewContenidoIzq;
                TextView textViewFechaIzq;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTituloIzq = itemView.findViewById(R.id.TituloIzq);
            textViewContenidoIzq = itemView.findViewById(R.id.ContenidoIzq);
            textViewFechaIzq = itemView.findViewById(R.id.FechaIzq);
        }
    }
}
