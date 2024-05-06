package br.edu.fateczl.atividade03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etValorGasolina;
    private EditText etValorEtanol;
    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etValorGasolina = findViewById(R.id.etValorGasolina);
        etValorGasolina.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etValorEtanol = findViewById(R.id.etValorEtanol);
        etValorEtanol.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btnCalc = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(op -> calc());
    }

    private void calc(){
        float valorGasolina = Float.parseFloat(etValorGasolina.getText().toString());
        float valorEtanol = Float.parseFloat(etValorEtanol.getText().toString());
        if (valorEtanol <= 0.7 * valorGasolina) {
            tvRes.setText("Abasteça com Etanol!");
        } else {
            tvRes.setText("Abasteça com Gasolina");
        }
        etValorGasolina.setText("");
        etValorEtanol.setText("");
    }
}