package com.example.pahlawanfragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.ViewHolder> {

    private ArrayList<Heroes> listHero = new ArrayList<>();
    private Context context;

    public HeroesAdapter(ArrayList<Heroes> listHero, Context context) {
        this.listHero = listHero;
        this.context = context;
    }

    public ArrayList<Heroes> getListHero() {
        return listHero;
    }

    @NonNull
    @Override
    //Responsible for inflating the view
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_heroes, parent, false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.ivHeroes.setImageResource(getListHero().get(position).getHeroImage());
        holder.tvHeroes.setText(getListHero().get(position).getHeroName());
        holder.itemHeroes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, getListHero().get(position).getHeroName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, HeroesDetail.class);
                intent.putExtra("img_url", getListHero().get(position).getHeroImage());
                intent.putExtra("title", getListHero().get(position).getHeroName());
                intent.putExtra("detail", getListHero().get(position).getHeroDetail());
                context.startActivity(intent);
            }
        });
        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                final int position = 0;
                String heroName = "Pahlawan " + getListHero().get(position).getHeroName();
                intent.putExtra(Intent.EXTRA_TEXT, heroName);
                context.startActivity(Intent.createChooser(intent, "Share Using"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListHero().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView btnShare;
        TextView tvHeroes;
        CircularImageView ivHeroes;
        RelativeLayout itemHeroes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHeroes = itemView.findViewById(R.id.iv_hero);
            tvHeroes = itemView.findViewById(R.id.tv_hero);
            itemHeroes = itemView.findViewById(R.id.item_heroes);
            btnShare = itemView.findViewById(R.id.btn_share);
        }
    }
}
