package com.davidlopes.alcoolougasolina;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText editField_alcohol;
    private EditText editField_gasoline;
    private TextView txt_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editField_alcohol = findViewById(R.id.editField_alcohol);
        editField_gasoline = findViewById(R.id.editField_gasoline);
        txt_result = findViewById(R.id.txt_result);
        Button btn_calc = findViewById(R.id.btn_calc);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateResult();
            }
        });


    }

    private void generateResult(){
        double alcoholPrice = Double.parseDouble(editField_alcohol.getText().toString());
        double gasolinePrice = Double.parseDouble(editField_gasoline.getText().toString());
        FuelCalculator fuelCalculator = new FuelCalculator(gasolinePrice, alcoholPrice);
        double result = fuelCalculator.calculate();
        txt_result.setVisibility(View.VISIBLE);

        if(result < 0.70) {
            txt_result.setTextColor(ContextCompat.getColor(this, R.color.alcool));
            txt_result.setText(getString(R.string.txt_alcool));
        } else {
            txt_result.setTextColor(ContextCompat.getColor(this, R.color.gasoline));
            txt_result.setText(getString(R.string.txt_gasoline));
        }

        //txt_result.setText(String.format("%.2f", result));
    }

}