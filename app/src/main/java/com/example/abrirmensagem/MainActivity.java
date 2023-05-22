package com.example.abrirmensagem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.w3c.dom.Text;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.btm_gerar);
        button.setOnClickListener(
                v->btnGerarOnClick()
        );

    }
    private void btnGerarOnClick() {
        EditText textIp = (EditText) findViewById(R.id.textIP);
        String ip = textIp.getText().toString();
        try {

            Gerar gerar = ClienteGerar.request();
            Log.i("gerar", gerar.getAdvice());
            TextView advice = (TextView) findViewById(R.id.advice);
            advice.setText(gerar.getAdvice());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

/*
        TextView AdviceId = this.findViewById(R.id.advice_id);
        TextView Advice = this.findViewById(R.id.advice);


        AdviceId.setText();
        Advice.setText();
 */
    }
}