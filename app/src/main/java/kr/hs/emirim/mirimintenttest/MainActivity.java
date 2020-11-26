package kr.hs.emirim.mirimintenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1;
    EditText ed2;
    RadioGroup rg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.first);
        ed2 = findViewById(R.id.se);
        rg = findViewById(R.id.group);

        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                switch(rg.getCheckedRadioButtonId()){
                    case R.id.plus:
                        intent.putExtra("cal","+");
                        break;
                    case R.id.minus:
                        intent.putExtra("cal","-");
                        break;
                    case R.id.mul:
                        intent.putExtra("cal","*");
                        break;
                    case R.id.na:
                        intent.putExtra("cal","/");
                        break;
                }
                intent.putExtra("num1", Integer.parseInt(ed1.getText().toString()));
                intent.putExtra("num2", Integer.parseInt(ed2.getText().toString()));

                startActivityForResult(intent, 0);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK){
            int hap = data.getIntExtra("Hap", 0);
            Toast.makeText(getApplicationContext(), "결과" +hap, Toast.LENGTH_SHORT).show();
        }
    }
}