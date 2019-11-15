package com.example.predictor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.tensorflow.lite.Interpreter;
import org.tensorflow.lite.gpu.GpuDelegate;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import pl.droidsonroids.gif.GifTextView;

public class Calculate_CGPA extends AppCompatActivity {

    Interpreter interpreter;
    TextView tv;
    GifTextView gifTextView;
    Button cgpa;
    public static boolean calculate_complete=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate__cgp);
        gifTextView=findViewById(R.id.gifTextView2);
        cgpa=findViewById(R.id.cgpa);

        tv=findViewById(R.id.text);
        //GpuDelegate delegate = new GpuDelegate();
        //Interpreter.Options options = (new Interpreter.Options()).addDelegate(delegate);
        try {
            interpreter = new Interpreter(loadModelFile(Calculate_CGPA.this,"linear2.tflite"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doPredict();
            }
        },2000);



    }
    public void doPredict(){
        Toast.makeText(getApplicationContext(),"predicting",Toast.LENGTH_LONG).show();
        tv.setVisibility(View.VISIBLE);
        float[][] output=new float[1][1];
        interpreter.run(UserInfoCollection.user_data, output);

        //float cgpa_value=output[0][0]-(output[0][0]%5);
        String s=String.format("%.2f",output[0][0]);
        tv.setText(s);
        calculate_complete=true;
        gifTextView.setVisibility(View.GONE);
        cgpa.setVisibility(View.VISIBLE);
    }

    private MappedByteBuffer loadModelFile(Activity activity, String MODEL_FILE) throws IOException {
        AssetFileDescriptor fileDescriptor = activity.getAssets().openFd(MODEL_FILE);
        FileInputStream inputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
        FileChannel fileChannel = inputStream.getChannel();
        long startOffset = fileDescriptor.getStartOffset();
        long declaredLength = fileDescriptor.getDeclaredLength();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
    }
}
