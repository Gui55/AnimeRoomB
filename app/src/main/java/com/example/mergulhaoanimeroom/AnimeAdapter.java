package com.example.mergulhaoanimeroom;

//Adapater para o RecyclerView

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder> {

    Context ctx;
    private List<Anime> animeList;

    public AnimeAdapter(Context ctx, List<Anime> animeList) {

        this.ctx = ctx;
        this.animeList = animeList;

    }

    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parentVG, int viewType) {

        //Pelo que entendi, este método aparenta ser aquele que bota um grupo de elementos do
        //layout da linha na activity onde está o recyclerview

        View itemView = LayoutInflater.from(parentVG.getContext())
                .inflate(R.layout.row_style, parentVG, false);

        return new AnimeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder, int position) {

        //Aqui aparenta ser onde ele define os textos dos elementos do recyclerview

        Anime anime = animeList.get(position);

        holder.nome.setText(anime.getNome());
        holder.genero.setText(anime.getGenero());
        holder.ano.setText(String.valueOf(anime.getAno()));

    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }

    protected class AnimeViewHolder extends RecyclerView.ViewHolder{

        protected TextView nome, genero, ano;

        public AnimeViewHolder(@NonNull View itemView) {
            super(itemView);

            nome=(TextView)itemView.findViewById(R.id.recycleNomeOutput);
            genero=(TextView)itemView.findViewById(R.id.recycleGeneroOutput);
            ano=(TextView)itemView.findViewById(R.id.recycleAnoOutput);

            //Aqui pode-se colocar um listener para os elementos do recyclerview
            //Mas pode-se precisar de outras coisas na classe AnimeAdapter para isso

            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //Alguma ação para acontecer aqui

                }
            });*/

        }
    }
}
