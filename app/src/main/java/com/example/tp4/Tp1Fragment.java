package com.example.tp4;

import androidx.activity.EdgeToEdge;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Tp1Fragment extends Fragment {

    private Tp1ViewModel mViewModel;

    public static Tp1Fragment newInstance() {
        return new Tp1Fragment();
    }
    EditText editText1;
    EditText editText2 ;
    TextView result ;
    Button buttonAdd ; // Replace with your button IDs
    Button buttonSub ;
    Button buttonMul ;
    Button buttonDiv ;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_tp1, container, false);
        super.onCreate(savedInstanceState);
         buttonAdd = view.findViewById(R.id.buttonAdd); // Replace with your button IDs
         buttonSub = view.findViewById(R.id.buttonSub);
         buttonMul = view.findViewById(R.id.buttonMul);
         buttonDiv = view.findViewById(R.id.buttonDiv);
        editText1 = view.findViewById(R.id.input1);
        editText2 = view.findViewById(R.id.input2);
        result = view.findViewById(R.id.resultat);
        buttonAdd.setOnClickListener(v -> add(v)); // Use lambda expressions for conciseness
        buttonSub.setOnClickListener(v -> sub(v));
        buttonMul.setOnClickListener(v -> mul(v));
        buttonDiv.setOnClickListener(v -> div(v));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(Tp1ViewModel.class);
        // TODO: Use the ViewModel
    }
    public void add(View view){
        String input1=editText1.getText().toString();
        String input2=editText2.getText().toString();
        double value1=Double.parseDouble(input1);
        double value2=Double.parseDouble(input2);
        result.setText(value1+"+"+value2+"="+(value1+value2));
    }
    public void sub(View view){
        String input1=editText1.getText().toString();
        String input2=editText2.getText().toString();
        double value1=Double.parseDouble(input1);
        double value2=Double.parseDouble(input2);
        result.setText(value1+"-"+value2+"="+(value1-value2));
    }
    public void mul(View view){
        String input1=editText1.getText().toString();
        String input2=editText2.getText().toString();
        double value1=Double.parseDouble(input1);
        double value2=Double.parseDouble(input2);
        result.setText(value1+"X"+value2+"="+(value1*value2));
    }
    public void div(View view){
        String input1=editText1.getText().toString();
        String input2=editText2.getText().toString();
        double value1=Double.parseDouble(input1);
        double value2=Double.parseDouble(input2);
        result.setText(value1+"/"+value2+"="+(value1/value2));
    }

}