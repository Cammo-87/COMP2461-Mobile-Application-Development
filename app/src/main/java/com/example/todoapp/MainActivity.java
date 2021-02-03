package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import java.time.Month;

public class MainActivity extends AppCompatActivity {

    //OnCreate runs when the activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Sets the activity to display the layout defined in a XML layout file
        setContentView(R.layout.activity_main);
    }

    //=================================================================== week 2 worksheet ==============================================================================================================================================================================================
    Context mContext = this;

    //handles the save button clicks
    public void onSaveClick(View view) {
        Log.d("ToDoApp", "onSaveClick");
    }

    //handles the date clicks
    public void onDateClick(View view) {
        Log.d("ToDoApp", "onDateClick");

        //creates a DatePickerDialog Listener with an event handler for onDateChanged
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {

            //handler for the date set event
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                //get a reference to the Date view from the layout by its ID
                EditText dateView = findViewById(R.id.editTextDate);

                //Change the date displayed in the date view to that selected in the DatePickerDialog
                dateView.setText(dayOfMonth + "/" + month + "/" + year);
            }
        };

        //creates a DatePickerDialog
        DatePickerDialog dialog = new DatePickerDialog(this, listener, 2020, 1, 1);
        dialog.show(); // display the dialog
    }


    //handles the time clicks
    public void onTimeClick(View view) {
        Log.d("ToDoApp", "onTimeClick");

        //creates a TimePickerDialog Listener with an event handler for onTimeChanged
        TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                //get a reference to the time view from the layout by its ID
                EditText timeView = findViewById(R.id.editTextTime);

                //Change the date displayed in the date view to that selected in the TimePickerDialog
                timeView.setText(hourOfDay + ":" + minute);
            }
        };

        //creates a TimePickerDialog
        TimePickerDialog dialog = new TimePickerDialog(this, listener, 00, 00, android.text.format.DateFormat.is24HourFormat(mContext));
        dialog.show(); // display the dialog
    }





    //================================================================= week 3 worksheet ==================================================================================================================================================================================================
    EditText titleView = findViewById(R.id.taskTitleView);
    EditText descView = findViewById(R.id.taskDescriptionView);
    EditText dateView = findViewById(R.id.editTextDate);
    EditText timeView = findViewById(R.id.editTextTime);

    String title = titleView.getText().toString();
    String description = descView.getText().toString();
    String date = dateView.getText().toString();
    String time = timeView.getText().toString();


    SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPref.edit();

    editor.putString("title", title);
    editor.putString("description", description);
    editor.putString("date", date);
    editor.putString("time", time);

    editor.commit();




}