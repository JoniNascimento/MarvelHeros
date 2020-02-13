package br.com.joni.marvelheros.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.joni.marvelheros.Activity.HeroDetailActivity;
import br.com.joni.marvelheros.Adapter.RvHerosAdapter;
import br.com.joni.marvelheros.Model.Character;
import br.com.joni.marvelheros.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentList extends Fragment {
    RecyclerView recyclerView ;
    public List<Character> list = new ArrayList<Character>();
    public int position;
    RvHerosAdapter herosAdapter;


    public FragmentList() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rvHeros1);

        herosAdapter = new RvHerosAdapter(getContext(), list);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(herosAdapter);

        herosAdapter.setOnItemClickListener(new RvHerosAdapter.HerosVH.ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Character character = list.get(position);
                Intent i = new Intent(getContext(), HeroDetailActivity.class);
                i.putExtra("hero", character);
                startActivity(i);
            }
        });


        return view;
    }

}
