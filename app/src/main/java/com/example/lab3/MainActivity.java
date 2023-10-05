package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences settings = getSharedPreferences("MyPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("Name",((EditText) findViewById(R.id.editText)).getText().toString());
        editor.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       EditText edit = findViewById(R.id.editText);
       Button nextBtn = findViewById(R.id.nextButton);

       //load SharedPreferences and put into editText
        SharedPreferences settings = getSharedPreferences("MyPrefs",MODE_PRIVATE);
        String userName = settings.getString("Name", "");
        edit.setText(userName);


        //
       nextBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              String name = edit.getText().toString();
              Intent nextPage = new Intent(MainActivity.this, NameActivity.class);
              nextPage.putExtra("Name", name);
              startActivityForResult(nextPage,1);
           }
       });







            

    }





}