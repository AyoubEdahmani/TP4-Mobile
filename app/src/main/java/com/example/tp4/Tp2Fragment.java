package com.example.tp4;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Tp2Fragment extends Fragment {

    private Tp2ViewModel mViewModel;
    ListView listView;
    ArrayList<User> arrayList;
    ArrayAdapter adapter;

    public static Tp2Fragment newInstance() {
        return new Tp2Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_tp2, container, false);
        arrayList=new ArrayList<>();
        arrayList.add(new User("user1","pass1"));
        arrayList.add(new User("user2","pass2"));
        arrayList.add(new User("user3","pass3"));
        arrayList.add(new User("user4","pass4"));
        arrayList.add(new User("user5","pass5"));

        adapter = new ArrayAdapter(view.getContext(), android.R.layout.simple_list_item_1, arrayList);
        listView = view.findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(
                (parent, view2, position, id) -> {
                    User user = arrayList.get(position);
                    Tp2_DetailsFragment tp2DetailsFragment=Tp2_DetailsFragment.newInstance(user);
                    FragmentManager fragmentManager =requireActivity().getSupportFragmentManager();
                    FragmentTransaction transaction=fragmentManager.beginTransaction();
                    transaction.replace(R.id.nav_tp2,tp2DetailsFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                });


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(Tp2ViewModel.class);
        // TODO: Use the ViewModel
    }

}