package com.otaviofr.correioscubagem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.textResultado = findViewById(R.id.text_View_Reultado);
        this.mViewHolder.editAltura = findViewById(R.id.edit_altura);
        this.mViewHolder.editLargura = findViewById(R.id.edit_largura);
        this.mViewHolder.editComprimento = findViewById(R.id.edit_comprimento);
        this.mViewHolder.btnCalcular = findViewById(R.id.button_calcular);
        this.mViewHolder.btnNovo = findViewById(R.id.button_novo);

        this.mViewHolder.btnNovo.setOnClickListener(this);
        this.mViewHolder.btnCalcular.setOnClickListener(this);

        this.LimpaValores();
    }


    @Override
    public void onClick(View v) {
        //Botão Calcular
        if (v.getId() == R.id.button_calcular) {
            String valorAltura = this.mViewHolder.editAltura.getText().toString();
            if ("".equals(valorAltura)) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else if (v.getId() == R.id.button_calcular) {
                String valorLargura = this.mViewHolder.editLargura.getText().toString();
                if ("".equals(valorLargura)) {
                    Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else if (v.getId() == R.id.button_calcular) {
                    String valorComprimento = this.mViewHolder.editComprimento.getText().toString();
                    if ("".equals(valorComprimento)) {
                        Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
        if (v.getId() == R.id.button_calcular) {
            String valorAltura = this.mViewHolder.editAltura.getText().toString();
            Integer altura = Integer.valueOf(valorAltura);
            if (altura > 105) {
                Toast.makeText(this, "Máximo 105 cm", Toast.LENGTH_SHORT).show();
            } else if (v.getId() == R.id.button_calcular) {
                String valorLargura = this.mViewHolder.editLargura.getText().toString();
                Integer largura = Integer.valueOf(valorLargura);
                if (largura > 105) {
                    Toast.makeText(this, "Máximo 105 cm", Toast.LENGTH_SHORT).show();
                } else if (v.getId() == R.id.button_calcular) {
                    String valorComprimento = this.mViewHolder.editComprimento.getText().toString();
                    Integer comprimento = Integer.valueOf(valorComprimento);
                    if (comprimento > 105) {
                        Toast.makeText(this, "Máximo 105 cm", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }

        //Botão Novo
        if (v.getId() == R.id.button_novo) {
            this.mViewHolder.editAltura.setText("");
            this.mViewHolder.editLargura.setText("");
            this.mViewHolder.editComprimento.setText("");
        }

    }

    private void LimpaValores() {
        this.mViewHolder.textResultado.setText("");
    }

    private static class ViewHolder {
        EditText editAltura;
        EditText editLargura;
        EditText editComprimento;
        Button btnCalcular;
        Button btnNovo;
        TextView textResultado;
    }


}
