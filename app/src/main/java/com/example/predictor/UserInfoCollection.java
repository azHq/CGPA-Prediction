package com.example.predictor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shuhart.stepview.StepView;

import java.util.ArrayList;

public class UserInfoCollection extends AppCompatActivity {

    StepView stepView;
    public static float[] user_data=new float[28];
    LinearLayout layout1,layout2,layout3,layout4,layout5,layout6,layout7,layout8,layout9,layout10,layout11;
    LinearLayout current,previous;
    int index=0;
    @Override
    public void onBackPressed() {

        if(previous!=null&&current!=null){
            previous.setVisibility(View.VISIBLE);
            current.setVisibility(View.GONE);
        }
        else{
            super.onBackPressed();
        }

        user_data[index]=0;
        int x=stepView.getCurrentStep();
        stepView.go(x-1,true);
        if(Calculate_CGPA.calculate_complete) super.onBackPressed();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_collection);

        for(int i=0;i<28;i++){

            user_data[i]=0;
        }
        stepView=findViewById(R.id.step_view);


        previous=layout1;
        current=layout1;
        layout1=findViewById(R.id.layout1);
        layout2=findViewById(R.id.layout2);
        layout3=findViewById(R.id.layout3);
        layout4=findViewById(R.id.layout4);
        layout5=findViewById(R.id.layout5);
        layout6=findViewById(R.id.layout6);
        layout7=findViewById(R.id.layout7);
        layout8=findViewById(R.id.layout8);
        layout9=findViewById(R.id.layout9);
        layout10=findViewById(R.id.layout10);
        layout11=findViewById(R.id.layout11);
        final CheckBox before_exam=findViewById(R.id.before_exam);
        final CheckBox one_hour_per_day=findViewById(R.id.one_hour_per_day);
        final CheckBox three_hour_per_day=findViewById(R.id.three_hour_per_day);
        before_exam.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    user_data[3]=1;
                    layout1.setVisibility(View.GONE);
                    layout2.setVisibility(View.VISIBLE);
                    stepView.go(1,true);
                    current=layout2;
                    previous=layout1;
                    index=3;
                    one_hour_per_day.setActivated(false);
                    three_hour_per_day.setActivated(false);
                }
            }
        });
        one_hour_per_day.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    user_data[1]=1;
                    user_data[0]=1;
                    layout1.setVisibility(View.GONE);
                    layout2.setVisibility(View.VISIBLE);
                    stepView.go(1,true);

                    current=layout2;
                    previous=layout1;
                    index=1;
                    before_exam.setActivated(false);
                    three_hour_per_day.setActivated(false);
                }
            }
        });
        three_hour_per_day.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    user_data[2]=1;
                    layout1.setVisibility(View.GONE);
                    layout2.setVisibility(View.VISIBLE);
                    stepView.go(1,true);

                    current=layout2;
                    previous=layout1;
                    index=2;
                    before_exam.setActivated(false);
                    one_hour_per_day.setActivated(false);
                }
            }
        });

        CheckBox sleep_six_hour_per_day=findViewById(R.id.sleep_six_hour_per_day);
        CheckBox sleep_seven_hour_per_day=findViewById(R.id.sleep_seven_hour_per_day);
        CheckBox sleep_eight_hour_per_day=findViewById(R.id.sleep_eight_hour_per_day);
        sleep_six_hour_per_day.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    user_data[6]=1;
                    layout2.setVisibility(View.GONE);
                    layout3.setVisibility(View.VISIBLE);
                    stepView.go(2,true);

                    current=layout3;
                    previous=layout2;
                    index=6;
                }
            }
        });
        sleep_seven_hour_per_day.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    user_data[4]=1;
                    layout2.setVisibility(View.GONE);
                    layout3.setVisibility(View.VISIBLE);
                    stepView.go(2,true);

                    current=layout3;
                    previous=layout2;
                    index=4;
                }
            }
        });
        sleep_eight_hour_per_day.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    user_data[5]=1;
                    layout2.setVisibility(View.GONE);
                    layout3.setVisibility(View.VISIBLE);
                    stepView.go(2,true);

                    current=layout3;
                    previous=layout2;
                    index=5;
                }
            }
        });

        Button relaition_no=findViewById(R.id.relaition_no);
        relaition_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_data[7]=1;
                layout3.setVisibility(View.GONE);
                layout4.setVisibility(View.VISIBLE);
                stepView.go(3,true);

                previous=layout3;
                current=layout4;
                index=7;
            }
        });
        Button relaition_yes=findViewById(R.id.relaition_yes);
        relaition_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_data[8]=1;
                layout3.setVisibility(View.GONE);
                layout4.setVisibility(View.VISIBLE);
                stepView.go(3,true);

                previous=layout3;
                current=layout4;
                index=8;
            }
        });

        Button class_no=findViewById(R.id.class_no);
        class_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_data[9]=1;
                layout4.setVisibility(View.GONE);
                layout5.setVisibility(View.VISIBLE);
                stepView.go(4,true);

                previous=layout4;
                current=layout5;
                index=9;
            }
        });
        Button class_yes=findViewById(R.id.class_yes);
        class_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_data[10]=1;
                layout4.setVisibility(View.GONE);
                layout5.setVisibility(View.VISIBLE);
                stepView.go(4,true);

                previous=layout4;
                current=layout5;
                index=10;
            }
        });

        Button group_no=findViewById(R.id.group_no);
        group_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_data[11]=1;
                layout5.setVisibility(View.GONE);
                layout6.setVisibility(View.VISIBLE);
                stepView.go(5,true);

                previous=layout5;
                current=layout6;
                index=11;
            }
        });
        Button group_yes=findViewById(R.id.group_yes);
        group_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_data[12]=1;
                layout5.setVisibility(View.GONE);
                layout6.setVisibility(View.VISIBLE);
                stepView.go(5,true);

                previous=layout5;
                current=layout6;
                index=12;
            }
        });

        CheckBox book=findViewById(R.id.book);
        CheckBox both=findViewById(R.id.both);
        CheckBox slide=findViewById(R.id.slide);
        book.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    user_data[13]=1;
                    layout6.setVisibility(View.GONE);
                    layout7.setVisibility(View.VISIBLE);
                    stepView.go(6,true);

                    previous=layout6;
                    current=layout7;
                    index=13;
                }
            }
        });
        both.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    user_data[14]=1;
                    layout6.setVisibility(View.GONE);
                    layout7.setVisibility(View.VISIBLE);
                    stepView.go(6,true);

                    previous=layout6;
                    current=layout7;
                    index=14;
                }
            }
        });
        slide.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    user_data[15]=1;
                    layout6.setVisibility(View.GONE);
                    layout7.setVisibility(View.VISIBLE);
                    stepView.go(6,true);

                    previous=layout6;
                    current=layout7;
                    index=15;
                }
            }
        });
        Button drug_no=findViewById(R.id.drug_no);
        drug_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_data[16]=1;
                layout7.setVisibility(View.GONE);
                layout8.setVisibility(View.VISIBLE);
                stepView.go(7,true);

                previous=layout7;
                current=layout8;
                index=16;
            }
        });
        Button drug_yes=findViewById(R.id.drug_yes);
        drug_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_data[17]=1;
                layout7.setVisibility(View.GONE);
                layout8.setVisibility(View.VISIBLE);
                stepView.go(7,true);

                previous=layout7;
                current=layout8;
                index=17;
            }
        });

        Button think_no=findViewById(R.id.think_no);
        think_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_data[18]=1;
                layout8.setVisibility(View.GONE);
                layout9.setVisibility(View.VISIBLE);
                stepView.go(8,true);

                previous=layout8;
                current=layout9;
                index=18;
            }
        });
        Button think_yes=findViewById(R.id.think_yes);
        think_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_data[19]=1;
                layout8.setVisibility(View.GONE);
                layout9.setVisibility(View.VISIBLE);
                stepView.go(8,true);

                previous=layout8;
                current=layout9;
                index=19;
            }
        });
        CheckBox friend_one_hour=findViewById(R.id.friend_one_hour);
        CheckBox friend_two_hour=findViewById(R.id.friend_two_hour);
        CheckBox friend_no_hour=findViewById(R.id.friend_no_hour);
        friend_one_hour.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    user_data[20]=1;
                    layout9.setVisibility(View.GONE);
                    layout10.setVisibility(View.VISIBLE);
                    stepView.go(9,true);

                    previous=layout9;
                    current=layout10;
                    index=20;
                }
            }
        });
        friend_two_hour.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    user_data[21]=1;
                    layout9.setVisibility(View.GONE);
                    layout10.setVisibility(View.VISIBLE);
                    stepView.go(9,true);

                    previous=layout9;
                    current=layout10;
                    index=21;
                }
            }
        });
        friend_no_hour.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    user_data[22]=1;
                    layout9.setVisibility(View.GONE);
                    layout10.setVisibility(View.VISIBLE);
                    stepView.go(9,true);

                    previous=layout9;
                    current=layout10;
                    index=22;
                }
            }
        });

        Button game_no=findViewById(R.id.game_no);
        game_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_data[23]=1;
                layout10.setVisibility(View.GONE);
                layout11.setVisibility(View.VISIBLE);
                stepView.go(10,true);

                previous=layout10;
                current=layout11;
                index=23;
            }
        });
        Button game_yes=findViewById(R.id.game_yes);
        game_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_data[24]=1;
                layout10.setVisibility(View.GONE);
                layout11.setVisibility(View.VISIBLE);
                stepView.go(10,true);

                previous=layout10;
                current=layout11;
                index=24;
            }
        });

        CheckBox hall=findViewById(R.id.hall);
        CheckBox rent=findViewById(R.id.rent);
        CheckBox parents=findViewById(R.id.parents);
        hall.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    user_data[25]=1;
                    stepView.go(10,true);
                    startActivity(new Intent(getApplicationContext(),Calculate_CGPA.class));


                }
            }
        });
        rent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    user_data[26]=1;
                    stepView.go(10,true);
                    startActivity(new Intent(getApplicationContext(),Calculate_CGPA.class));
                }
            }
        });
        parents.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    user_data[27]=1;
                    stepView.go(10,true);
                    startActivity(new Intent(getApplicationContext(),Calculate_CGPA.class));
                }
            }
        });

    }




}
