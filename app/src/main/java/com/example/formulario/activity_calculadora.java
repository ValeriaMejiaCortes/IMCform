package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class activity_calculadora extends AppCompatActivity implements View.OnClickListener{

    private TextView tvInformation;
    private TextView tvResult;
    private EditText txtHeight;
    private EditText txtWeight;
    private Button btnCalculator;
    private ImageView imgState;

    private Double Height = 0.0;
    private Double Weight = 0.0;
    private Double IMC = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        Intent intent = getIntent();
        String name = intent.getStringExtra("nameCalculator");
        String surname = intent.getStringExtra("surnameCalculator");
        String email = intent.getStringExtra("emailCalculator");
        String message = "Hola "+ name+ " " + surname + " es un gusto conocerte aca su correo para informe es: "+ email;

        tvInformation = findViewById(R.id.tvInformation);
        tvResult = findViewById(R.id.tvResult);
        txtHeight = findViewById(R.id.txtHeight);
        txtWeight = findViewById(R.id.txtWeight);
        btnCalculator = findViewById(R.id.btnCalculator);
        imgState = findViewById(R.id.imgState);
        tvInformation.setText(message);
        btnCalculator.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCalculator){
            this.Height = Double.parseDouble(txtHeight.getText().toString());
            this.Weight = Double.parseDouble(txtWeight.getText().toString());
            this.IMC = Weight/Math.pow(Height,2);

            if (IMC < 18.5 && IMC > 0){
                tvResult.setText("Usted esta BAJO DE PESO");
                imgState.setImageResource(R.drawable.bajopeso);
            }else if(IMC >= 18.5 && IMC <= 24.9){
                tvResult.setText("Usted esta en peso NORMAL");
                imgState.setImageResource(R.drawable.normal);
            }else if(IMC > 24.9 && IMC <= 29.9){
                tvResult.setText("Usted esta en SOBREPESO");
                imgState.setImageResource(R.drawable.sobrepeso);
            }else if(IMC >= 30.0){
                tvResult.setText("Usted esta OBESO");
                imgState.setImageResource(R.drawable.obesidad);
            }else{
                tvResult.setText("ERROR, Los valores ingresados son incorrectos");
                imgState.setImageResource(R.drawable.error);
            }
        }
    }
}