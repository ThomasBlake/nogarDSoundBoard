package com.example.generalraxor.nogardsoundboard;

import android.animation.TypeConverter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.widget.SeekBar;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {
    String TAG = "CREATION";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);


        final TextView textView_TileAcrossResult = (TextView) findViewById(R.id.textView_TileAcrossResult);
        final SeekBar seekBar_TileAcross = (SeekBar) findViewById(R.id.seekBar_TileAcross);
        final TextView textView_TileHeightResult = (TextView) findViewById(R.id.textView_TileHeightResult);
        final SeekBar seekBar_TileHeight = (SeekBar) findViewById(R.id.seekBar_TileHeight);
        final TextView textView_TilePaddingResult = (TextView) findViewById(R.id.textView_TilePaddingResult);
        final SeekBar seekBar_TilePadding = (SeekBar) findViewById(R.id.seekBar_TilePadding);

        seekBar_TileAcross.setProgress(pref.getInt("tileAcrossResult", 0));
        seekBar_TileHeight.setProgress(pref.getInt("tileHeightResult", 0));
        seekBar_TilePadding.setProgress(pref.getInt("tilePaddingResult", 0));


        seekBar_TilePadding.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { //PADDING
            public int tilePaddingResult = 0;
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);

            @Override
            public void onProgressChanged(SeekBar seekBar_TilePadding, int progress, boolean b) {

                try {
                    textView_TilePaddingResult.setText(Double.parseDouble(String.format("%.1f", progress * 0.1)) + "");
                    tilePaddingResult = (progress);

                } catch (Exception e) {
                    Log.d(TAG, "seekBar_TilePadding...onStopTrackingTouch: " + e);
                }


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar_TilePadding) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar_TilePadding) {
                try {
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putInt("tilePaddingResult", tilePaddingResult);
                    editor.commit();
                    Log.d(TAG, "onStopTrackingTouch: \nTile Padding settings saved");
                } catch (Exception e) {
                    Log.d(TAG, "seekBar_TilePadding...onStopTrackingTouch: \n" + e);
                }

            }

        });

        seekBar_TileHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {//HEIGHT
            public int tileHeightResult = 0;

            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);

            @Override
            public void onProgressChanged(SeekBar seekBar_TileHeight, int progress, boolean b) {
                try {
                    tileHeightResult = (progress);
                    textView_TileHeightResult.setText("" + tileHeightResult + "");
                } catch (Exception e) {
                    Log.d(TAG, "seekBar_TileHeight...onStopTrackingTouch: \n" + e);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar_TileHeight) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar_TileHeight) {
                try {
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putInt("tileHeightResult", tileHeightResult);
                    editor.commit();
                    Log.d(TAG, "onStopTrackingTouch: \nTile Height setting saved.");
                } catch (Exception e) {
                    Log.d(TAG, "seekBar_TileHeight...onStopTrackingTouch: \n" + e);
                }
            }

        });

        seekBar_TileAcross.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {// ACROSS
            public int tileAcrossResult = 0;
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);

            @Override
            public void onProgressChanged(SeekBar seekBar_TileAcross, int progress, boolean b) {
                textView_TileAcrossResult.setText("" + (progress) + "");
                try {
                    tileAcrossResult = (progress);
                    textView_TileAcrossResult.setText("" + tileAcrossResult + "");
                } catch (Exception e) {
                    Log.d(TAG, "seekBar_TileAcross...onStopTrackingTouch: " + e);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar_TileAcross) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar_TileAcross) {
                try {
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putInt("tileAcrossResult", tileAcrossResult);
                    editor.commit();
                    Log.d(TAG, "onStopTrackingTouch: \nTile Across setting saved.");
                } catch (Exception e) {
                    Log.d(TAG, "seekBar_TileAcross...onStopTrackingTouch: \n" + e);
                }

            }


        });


    }

}
