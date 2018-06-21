package com.example.generalraxor.nogardsoundboard;

import android.content.Context;
import android.database.Cursor;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
{

    private static final String TAG = "RecyclerViewAdapter";
    //ViewAdapter Arrays
//       private ArrayList<ImageView> mtileImages = new ArrayList<>();TODO
    private ArrayList<String> mtileTexts = new ArrayList<String>();

    private Context mContext;

    public RecyclerViewAdapter( Context mContext,ArrayList<String> mtileTexts /*,ArrayList<Image> mtileImages TODO*/) {

        this.mtileTexts = mtileTexts;
//        this.mtileImages = mtileImage;TODO
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_tile,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "RecyclerViewAdapter.onBindViewHolder: called");//This will report for each item in the RecyclerView.


        holder.tileText.setText(mtileTexts.get(position));
        //Tutorial https://www.youtube.com/watch?v=Vyqz_-sJGFk 14:30
        
        holder.mainTile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.d(TAG, "onClick: Tile was clicked on");
            }
        });
        Toast.makeText(mContext,mtileTexts.get(position), Toast.LENGTH_SHORT).show();

    }

    @Override
    public int getItemCount() {
        //This returns the amount of tiles to display
        return mtileTexts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

//        ImageButton tileImage;TODO
        TextView tileText;
        RelativeLayout mainTile;

        public ViewHolder(View itemView) {
            super(itemView);
//          tileImage = itemView.findViewById(R.id.tileImage);TODO
            tileText = itemView.findViewById(R.id.tileText);

            mainTile = itemView.findViewById(R.id.mainTile);
        }
    }














}
