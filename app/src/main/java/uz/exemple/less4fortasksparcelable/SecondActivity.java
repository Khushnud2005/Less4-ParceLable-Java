package uz.exemple.less4fortasksparcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import uz.exemple.less4fortasksparcelable.model.Member;
import uz.exemple.less4fortasksparcelable.model.User;

public class SecondActivity extends AppCompatActivity {

    static final String TAG = SecondActivity.class.toString();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
    }

    void initViews(){
        TextView text1 = (TextView) findViewById(R.id.tv1_SecondActivity);
        Button btn_back = (Button) findViewById(R.id.btnBackPage);

        //Bundle arguments = getIntent().getExtras();
        User user = (User) getIntent().getParcelableExtra("user");

        /*if(arguments!=null){
            user = arguments.getParcelable(User.class.getSimpleName());

            text1.setText("Name: " + user.getName() + "\nAge: " + String.valueOf(user.getAge()));
        }*/
        text1.setText(user.toString());

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Member member = new Member(777, "Khushnud");
                toBackPage(member);
            }
        });

    }
    void toBackPage(Member member){
        Intent intent = new Intent();
        intent.putExtra("result",member);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }
}