package com.example.admin.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calc(View view)
    {
        Intent i = new Intent(getApplicationContext(), secondActivity.class);

        i.putExtra("a",getA());
        i.putExtra("b",getB());
        startActivityForResult(i, code);
    }

    public double getA()
    {
        EditText a = (EditText)findViewById(R.id.a);
        return Double.parseDouble(a.getText().toString());
    }

    public double getB()
    {
        EditText b = (EditText)findViewById(R.id.b);
        return Double.parseDouble(b.getText().toString());
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
            EditText result = (EditText)findViewById(R.id.result);
            result.setText(String.valueOf("Wynik = "+ intent.getStringExtra("result")));
    }
}
