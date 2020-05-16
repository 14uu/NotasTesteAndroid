package com.example.notasTeste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class showResultsActivity extends AppCompatActivity {
TextView tvShowRes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_results);
        tvShowRes = (TextView) findViewById(R.id.tvShowRes);
        Intent intent = getIntent();
        String[] dados = intent.getStringExtra(MainActivity.EXTRA_MESSAGE).split("/");
        StringBuilder sb = new StringBuilder();
        if(Boolean.parseBoolean(dados[0]))
        {sb.append(getString(R.string.approved));}
        else{sb.append(getString(R.string.reproved));}
        sb.append("\u0020");
        sb.append(getString(R.string.wGrades));
        sb.append("\n");
        for (int i = 1; i < dados.length; i++){
            sb.append(dados[i]);
            sb.append("\n");
        }
        tvShowRes.setText(sb.toString());
    }
}
