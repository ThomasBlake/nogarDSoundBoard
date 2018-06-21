package com.example.generalraxor.nogardsoundboard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    String TAG = "CREATION";
    String tileDB = "nogarDDB.db";
    public SQLiteDatabase db;
    //vars for MainGridLayout_RecyclerView
    private ArrayList<String> mTitles = new ArrayList<>();
//    private ArrayList<Image> mImages = new ArrayList<>();//TODO Uncomment this when working with the image for the tiles


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("CREATION", "onCreate: Program has started");
        GridView tileList;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //CreateRecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.MainGridLayout_RecyclerView); //defining objects can not be in class, must be in a method
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); //Set number of columns

        //Standard thing
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Preferences
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);//Get Preferences
        SharedPreferences.Editor editor = pref.edit();//Set Preferences


        //Open the database(Creating on first run)
        db = openOrCreateDatabase(tileDB, MODE_PRIVATE, null);

        //Open a new table
        db.execSQL("CREATE TABLE IF NOT EXISTS TileTable (Name VARCHAR, Description VARCHAR)");

        //insert values into the table
        db.execSQL("INSERT INTO TileTable VALUES('Tile1','This is a description of a tile');");

        //USED FOR testText ONLY
        EditText testText = (EditText) findViewById(R.id.testText);

        Cursor dbTest = db.rawQuery("SELECT * from TileTable", null);
        dbTest.moveToFirst();
        ///////////////////////////Continuing from https://www.youtube.com/watch?v=Vyqz_-sJGFk to learn how to use the recycler view... then the DB and images

//
        try {
            testText.setText(dbTest.getString(dbTest.getColumnIndex("Name")));
            Log.d(TAG, "Attempting to read from database");
        } catch (Exception e) {
            Log.d(TAG, "Trouble reading database \nError: " + e);
        }

//         //END testText ONLY
        //Call images list
        try {
            initImages();
        } catch (Exception e) {
            Log.d(TAG, "onCreate: Can't process initImage()\nReason: "+e);
        }


    }

    //Create the images list
    private void initImages() {
        Log.d(TAG, "initImages: preparing images");
        mTitles.add("Hello");
        mTitles.add("Tile2");

        //Get Images from database here------------------------Get Images from database here//TODO
        initRecyclerView();
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: starting");
        
        try{
            RecyclerView recyclerView = findViewById(R.id.MainGridLayout_RecyclerView);
            Log.d(TAG, "initRecyclerView: recyclerView defined");
            RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,mTitles);
            Log.d(TAG, "initRecyclerView: adapter defined");
            recyclerView.setAdapter(adapter);
            Log.d(TAG, "initRecyclerView: adapter set");
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            Log.d(TAG, "initRecyclerView: LinearLayoutManager set");
        }catch(Exception e){
            Log.d(TAG, "initRecyclerView: FAILED \nReason "+e);
        }


    }


    //The options button (the top right hand corner 3 dots button)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        Log.d(TAG, "onCreateOptionsMenu: Menu has been inflated");
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //item is the thing //<--I don't know why I wrote that... i'm sure it's not useless

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            try {
                Log.d(TAG, "onOptionsItemSelected: Opening Settings.");
                Intent settingsActivity = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(settingsActivity);
                Log.d(TAG, "onOptionsItemSelected: Settings have opened");
            } catch (Exception e) {
                Log.d(TAG, "onOptionsItemSelected: Opening Settings has FAILED.");
            }


        }

        if (id == R.id.action_profiles) {
            Log.d(TAG, "onOptionsItemSelected: Profiles have been clicked");
            return true; //This should be changed to either a quick select profile in the drop down or a new instance opens to choose the profile.

        }

        if (id == R.id.action_editToggle) {
            if (item.isChecked() == true) {
                item.setChecked(false);
                Log.d(TAG, "onOptionsItemSelected: Editing Toggle is disabled");


            } else if (item.isChecked() == false) {
                item.setChecked(true);
                Log.d(TAG, "onOptionsItemSelected: Editing Toggle is enabled");

            }

            return true; //This should be changed to either a quick select profile in the drop down or a new instance opens to choose the profile.
        }
        return super.onOptionsItemSelected(item);
    }


}

