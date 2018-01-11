
package com.example.user.simple_calculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;
import java.util.StringTokenizer;
import static com.example.user.simple_calculator.EvaluateString.evaluateInfix;


public class MainActivity extends Activity implements View.OnClickListener
{
    String TAG = "MainActivity";
    Button zero;
    Button one, two, three, four, five, six, seven, eight, nine,divide, add , times, minus;
    TextView textvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");
        textvalue = (TextView) findViewById(R.id.txtvalue);
        zero = (Button) findViewById(R.id.zerobtn);
        zero.setOnClickListener(this);


        one = (Button) findViewById(R.id.onebtn);
        one.setOnClickListener(this);

        two = (Button) findViewById(R.id.twobtn);
        two.setOnClickListener(this);

        three = (Button) findViewById(R.id.threebtn);
        three.setOnClickListener(this);

        four = (Button) findViewById(R.id.fourbtn);
        four.setOnClickListener(this);

        five = (Button) findViewById(R.id.fivebtn);
        five.setOnClickListener(this);

        six = (Button) findViewById(R.id.sixbtn);
        six.setOnClickListener(this);

        seven = (Button) findViewById(R.id.sevenbtn);
        seven.setOnClickListener(this);

        eight = (Button) findViewById(R.id.eightbtn);
        eight.setOnClickListener(this);

        nine = (Button) findViewById(R.id.ninebtn);
        nine.setOnClickListener(this);

        divide = (Button) findViewById(R.id.dividebtn);
        divide.setOnClickListener(this);

        times = (Button) findViewById(R.id.timesbtn);
        times.setOnClickListener(this);

        minus = (Button) findViewById(R.id.minusbtn);

        minus.setOnClickListener(this);


        add  = (Button) findViewById(R.id.addbtn);
        add.setOnClickListener(this);

        Button clear = (Button) findViewById(R.id.clearbtn);
        clear.setOnClickListener(this);
        Button equal = (Button) findViewById(R.id.equalbtn);
        equal.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {

        Log.d(TAG,"onClick: ");
        //String prev = ((TextView) findViewById(R.id.txtvalue)).toString();

        TextView textView = (TextView)findViewById(R.id.txtvalue);
        String prev = textView.getText().toString();

        String value = "";

        switch (v.getId()) {
            case R.id.zerobtn:
                Log.d(TAG, prev);

                value= "0";
                if (prev != null) value = prev + value;
                textvalue.setText(value);
                break;

            case R.id.onebtn:
                Log.d(TAG, prev);
                value= "1";

                if (prev != null) value = prev + value;
                textvalue.setText(value);
                break;
            case R.id.twobtn:
                Log.d(TAG, prev);
                value= "2";

                if (prev != null) value = prev + value;
                textvalue.setText(value);
                break;
            case R.id.threebtn:

                value= "3";
                if (prev != null) value = prev + value;
                textvalue.setText(value);
                break;
            case R.id.fourbtn:
                Log.d(TAG, prev);
                value= "4";
                if (prev != null) value = prev + value;
                textvalue.setText(value);
                break;
            case R.id.fivebtn:
                Log.d(TAG, prev);
                value= "5";
                if (prev != null) value = prev + value;
                textvalue.setText(value);
                break;
            case R.id.sixbtn:
                Log.d(TAG, prev);
                value= "6";
                if (prev != null) value = prev + value;
                textvalue.setText(value);
                break;
            case R.id.sevenbtn:
                value= "7";
                if (prev != null) value = prev + value;
                textvalue.setText(value);
                break;
            case R.id.eightbtn:
                value= "8";
                if (prev != null) value = prev + value;
                textvalue.setText(value);
                break;
            case R.id.ninebtn:
                value= "9";
                if (prev != null) value = prev + value;
                textvalue.setText(value);
                break;
            case R.id.addbtn:
                value= "+";
                if (prev != null) value = prev + value;
                textvalue.setText(value);
                break;
            case R.id.minusbtn:
                value= "-";
                if (prev != null) value = prev + value;
                textvalue.setText(value);
                break;
            case R.id.timesbtn:
                value= "*";
                if (prev != null) value = prev + value;
                textvalue.setText(value);
                break;
            case R.id.dividebtn:
                value= "/";
                if (prev != null) value = prev + value;
                textvalue.setText(value);
                break;
            case R.id.clearbtn:
                value= "";
                prev = "";
                textvalue.setText("");
                break;


            case R.id.equalbtn:


                prev = prev.replaceAll("\\s", "");
                Log.d(TAG, prev);

               // EvaluateString obj= new EvaluateString();


                String result =  evaluateInfix(prev);

                // Log.d(TAG, ""+result);

                String resule = prev +"="+ result;
                textvalue.setText(resule);

                break;
        }

    }

}


