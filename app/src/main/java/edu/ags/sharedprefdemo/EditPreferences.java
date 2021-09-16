package edu.ags.sharedprefdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class EditPreferences extends AppCompatActivity {

    public static final String TAG = "EditPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_prefernces);

        Log.d(TAG, "onCreate: ");

        SharedPreferences preferences = getApplicationContext().getSharedPreferences("MyPrefs", MODE_PRIVATE);
        CheckBox checkBox = findViewById(R.id.chkSetting);
        checkBox.setText(Boolean.toString(preferences.getBoolean("darkmode", false)));
        checkBox.setChecked(preferences.getBoolean("darkmode", false));
        
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                Log.d(TAG, "onCheckedChanged: ");   
                SharedPreferences.Editor editor = preferences.edit(); //Begin Trans and open for editing
                
                //Show the new value in the checkbox
                checkBox.setText(Boolean.toString(b));
                
                //change it
                editor.putBoolean("darkmode", b);
                editor.putString("name", "EditPreferences");
                editor.putInt("age",29);
                
                //Commit the changes
                editor.commit();
                Log.d(TAG, "onCheckedChanged: Commit Change Completed");
            }
        });
    }
}