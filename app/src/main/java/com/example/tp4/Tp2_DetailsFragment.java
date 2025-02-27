package com.example.tp4;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Tp2_DetailsFragment extends Fragment {

    private Tp2DetailsViewModel mViewModel;
    TextView textItem;

    public static Tp2_DetailsFragment newInstance() {
        return new Tp2_DetailsFragment();
    }
    public static Tp2_DetailsFragment newInstance(User user) {
        Tp2_DetailsFragment fragment = new Tp2_DetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable("user", user);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_tp2__details, container, false);
        Bundle bundle =getArguments();
        if(bundle!=null){
            User user=(User)bundle.getSerializable("user");
            textItem = view.findViewById(R.id.textItem);
            textItem.setText(""+user);
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(Tp2DetailsViewModel.class);
        // TODO: Use the ViewModel
    }

}