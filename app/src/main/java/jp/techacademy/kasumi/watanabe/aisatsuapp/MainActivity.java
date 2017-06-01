package jp.techacademy.kasumi.watanabe.aisatsuapp;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

    }

    //ボタンがクリックされたらTimePickerDialogを表示させ、onTimeSetリスナーを記述しておく。
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            showTimePickerDialog();

        }
    }

    //onTimeSet内で、hourOfDayを使い条件文を作成し、準備したテキストに挨拶文を表示させる。
    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        TextView textView = (TextView) findViewById(R.id.textView);

                        if((hourOfDay>=2)&&(hourOfDay<10)){

                            textView.setText("おはよう");

                        }else if((hourOfDay>=10)&&(hourOfDay<18)){

                            textView.setText("こんにちは");

                        }else if((hourOfDay>=18)&&(hourOfDay<1)){
                            textView.setText("こんばんは");
                        }

                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }


}