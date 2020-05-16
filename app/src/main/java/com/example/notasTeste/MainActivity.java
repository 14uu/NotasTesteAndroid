package com.example.notasTeste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Button;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myapplication.MESSAGE";
    EditText notaInp;
    RadioButton n1;
    RadioButton n2;
    RadioButton n3;
    RadioButton n4;
    RadioButton n5;
    Button results;
    int SelectedNota;
    Aluno aluno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aluno = new Aluno();
        SelectedNota = 0;
        notaInp = (EditText) findViewById(R.id.tfNota);
        notaInp.setFilters(new  InputFilter[]{new DecimalDigitsInputFilter(1), new MinMaxFilter(0,10)} );
        n1 = (RadioButton) findViewById(R.id.rbNota1);
        n2 = (RadioButton) findViewById(R.id.rbNota2);
        n3 = (RadioButton) findViewById(R.id.rbNota3);
        n4 = (RadioButton) findViewById(R.id.rbNota4);
        n5 = (RadioButton) findViewById(R.id.rbNota5);
        results = (Button) findViewById(R.id.btnRes);
        notaInp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try{aluno.Notas[SelectedNota] = Double.parseDouble(s.toString());} catch (NumberFormatException ignored){}
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
        notaInp.setText(Double.toString(aluno.Notas[SelectedNota]));
    }
    public void changeSelected(View v) {
        if (v == n1){
            SelectedNota = 0;
            notaInp.setText(Double.toString(aluno.Notas[SelectedNota]));
        }
        else if (v == n2){
            SelectedNota = 1;
            notaInp.setText(Double.toString(aluno.Notas[SelectedNota]));
        }
        else if (v == n3){
            SelectedNota = 2;
            notaInp.setText(Double.toString(aluno.Notas[SelectedNota]));
        }
        else if (v == n4){
            SelectedNota = 3;
            notaInp.setText(Double.toString(aluno.Notas[SelectedNota]));
        }
        else if (v == n5){
            SelectedNota = 4;
            notaInp.setText(Double.toString(aluno.Notas[SelectedNota]));
        }
    }
    public  void showResults(View v) {
        char separator = '/';
        StringBuilder message = new StringBuilder();
        message.append(aluno.Passou());
        for (double nota:aluno.Notas) {
            message.append(separator);
            message.append(nota);
       }
        Intent intent = new Intent(this,showResultsActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message.toString());
        startActivity(intent);
    }

}
