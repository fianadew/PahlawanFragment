package com.example.pahlawanfragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {

    private RecyclerView rvHeroes;
    private ArrayList<Heroes> list = new ArrayList<>();
    private Activity view;

    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvHeroes = view.findViewById(R.id.rv_main);
        rvHeroes.setHasFixedSize(true);
        list.addAll(HeroesData.getHeroList());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvHeroes.setLayoutManager(new LinearLayoutManager(getActivity()));
        HeroesAdapter heroesAdapter = new HeroesAdapter(HeroesData.getHeroList(), getActivity());
        rvHeroes.addItemDecoration(new DividerItemDecoration(rvHeroes.getContext(), layoutManager.getOrientation()));
        rvHeroes.setAdapter(heroesAdapter);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
