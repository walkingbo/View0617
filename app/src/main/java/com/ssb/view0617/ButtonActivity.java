package com.ssb.view0617;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ButtonActivity extends AppCompatActivity {
    //xml에 만들어진 뷰를 위한 변수
    private TextView display;
    private Button btn;
    private CheckBox bold;

    private RadioGroup colorradio;

    private RadioButton red;
    private RadioButton blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //레이아웃 파일의 내용을 메모리에 로드해서 출력
        //레이아웃에 작성된 뷰 들의 설정은 이 메소드 호출 이후에 해야 합니다.

        setContentView(R.layout.activity_button);

        display = (TextView)findViewById(R.id.display);
        btn = (Button)findViewById(R.id.btn);
        bold = (CheckBox)findViewById(R.id.bold);

        colorradio = (RadioGroup)findViewById(R.id.colorradio);
        red = (RadioButton)findViewById(R.id.red);
        blue = (RadioButton)findViewById(R.id.blue);

        //버튼의 이벤트 처리
        btn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                display.setText(R.string.displaytext2);
            }
        });

        //체크박스의 이벤트 처리
        bold.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){
            //이벤트처리 메소드의 첫번째 매개변수는
            //이벤트가 발생한 객체입니다.
            public void onCheckedChanged(CompoundButton checkBox, boolean isChecked){
                if(isChecked){
                    display.setTextSize(35);
                }else{
                    display.setTextSize(20);
                }
            }
        });

        //라디오 버튼은 라디오 버튼의 이벤트를 처리하지 않고
        //라디오 그룹의 이벤트를 처리하는 경우가 많습니다.
        colorradio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            //두번째 매개 변수가 눌러진 RadioButton의 id
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                        case R.id.red:
                            display.setTextColor(Color.RED);
                            break;
                        case R.id.blue:
                            display.setTextColor(Color.BLUE);
                             break;
                        default:
                            display.setTextColor(Color.BLACK);
                            break;


                }
            }
        });

    }
}
