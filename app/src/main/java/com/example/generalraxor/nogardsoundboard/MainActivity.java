package com.example.generalraxor.nogardsoundboard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.GridView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    String TAG = "CREATION";





    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.MainGridLayout_RecyclerView);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("CREATION", "onCreate: Program has started");
        GridView tileList;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref",0);
                SharedPreferences.Editor editor = pref.edit();









    }


//   SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref",0);



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //item is the thing

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
           try
           {
               Log.d(TAG, "onOptionsItemSelected: Opening Settings.");
               Intent settingsActivity = new Intent(MainActivity.this, SettingsActivity.class);
               startActivity(settingsActivity);
           }
           catch(Exception e)
           {
               Log.d(TAG, "onOptionsItemSelected: Opening Settings has FAILED.");
           }


        }

        if (id == R.id.action_profiles) {
            return true; //This should be changed to either a quick select profile in the drop down or a new instance opens to choose the profile.
        }

        if (id == R.id.action_editToggle) {
            if(item.isChecked()==true){
                item.setChecked(false);

                
            }
            else if(item.isChecked()==false){
            item.setChecked(true);

            }

            return true; //This should be changed to either a quick select profile in the drop down or a new instance opens to choose the profile.
        }
        return super.onOptionsItemSelected(item);
    }



}

