package dalton.gray.currencyconversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double rateEuro = 0.90262;
    double ratePeso = 19.4542;
    double rateCaD = 1.32232;

    double usd;
    double converted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_round);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText txtUSD = (EditText) findViewById(R.id.txtUSD);
        final RadioButton radEuro = (RadioButton) findViewById(R.id.radEuro);
        final RadioButton radPeso = (RadioButton) findViewById(R.id.radPeso);
        final RadioButton radCaD = (RadioButton) findViewById(R.id.radCaD);
        final TextView result = (TextView) findViewById(R.id.txtResult);

        Button convert = (Button) findViewById(R.id.btnConvert);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usd = Double.parseDouble(txtUSD.getText().toString());

                if(usd <= 100000) {
                    DecimalFormat currencyUSD = new DecimalFormat("$###,###.##");
                    if(radEuro.isChecked()) {
                        converted = usd * rateEuro;
                        result.setText(currencyUSD.format(usd) + " is equal to " + converted + " EUR");
                    }

                    if(radPeso.isChecked()) {
                        converted = usd * ratePeso;
                        result.setText(currencyUSD.format(usd) + " is equal to " + converted + " MXN");
                    }

                    if(radCaD.isChecked()) {
                        converted = usd * rateCaD;
                        result.setText(currencyUSD.format(usd) + " is equal to " + converted + " CAD");
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a value below $100,000.00", Toast.LENGTH_LONG);
                }
            }
        });
    }
}
