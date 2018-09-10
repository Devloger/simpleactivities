package com.example.admin.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class secondActivity extends AppCompatActivity {

    public double a;
    public double b;
    public double c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();

        a = extras.getDouble("a");
        b = extras.getDouble("b");

        EditText aa = (EditText)findViewById(R.id.aa);
        EditText bb = (EditText)findViewById(R.id.bb);

        setText(aa,a);
        setText(bb,b);
    }

    public void setText(EditText editText, double number)
    {
        editText.setText(String.valueOf(number));
    }

    public void operacja(View view)
    {
        switch(view.getId())
        {
            case R.id.add:
                c=a+b;
                break;
            case R.id.sub:
                c=a-b;
                break;
            case R.id.multiply:
                c=a*b;
                break;
            case R.id.divide:
                if(b==0) {
                    c=0;
                } else {
                    c = a / b;
                }
                break;
        }
        finishWithResult();

    }

    private void finishWithResult()
    {
        Intent intent = new Intent();
        intent.putExtra("result", String.valueOf(c));
        setResult(RESULT_OK, intent);
        finish();
    }
}
