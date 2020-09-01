package br.rnt;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.rnt.R;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private TextView txtPrivacyPolicy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.buttonConvert);
        txtPrivacyPolicy = (TextView) findViewById(R.id.txtPrivacyPolicy);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                EditText editText=findViewById(R.id.editTextCelsius);
                String temp = editText.getText().toString();
                if(!temp.equals("")){
                    ConvertTemp cv = new ConvertTemp();
                    double f = cv.celsiusToFahrenheit(Double.parseDouble(temp));
                    double k = cv.celsiusToKelvin(Double.parseDouble(temp));

                    EditText fa = (EditText)findViewById(R.id.editTextFahreinheit);
                    fa.setText(String.valueOf(f));

                    EditText ke = (EditText)findViewById(R.id.editTextKelvin);
                    ke.setText(String.valueOf(k));
                } else {
                    Toast.makeText(MainActivity.this, "Please enter some data", Toast.LENGTH_SHORT).show();
                }
            }
        });
        txtPrivacyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PrivacyPolicy.class);
                startActivity(intent);
            }
        });
    }
}