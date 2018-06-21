package com.example.generalraxor.nogardsoundboard;


import android.media.Image;
import android.provider.MediaStore;

public final class nogardDbContract {
//    private nogardDbContract(){} // make non-creatable... find out what "non-creatable" means

    public static final class TileInformationEntry{
        public static final String TABLE_NAME = "tile_information";
        public static final String COLUMN_TILE_ID = "tile_id";
        public static final String COLUMN_TILE_TITLE = "tile_title";
        public static final String COLUMN_TILE_DESC = "tile_description";
        public static final String COLUMN_TILE_IMAGE = "tile_image";
        public static final String COLUMN_TILE_AUDIO = "tile_audio";


        //CREATE TABLE tile_information(tile_id,tile_title,tile_image,tile_audio)

        public static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_TILE_ID + ", "+ COLUMN_TILE_TITLE + ", "+ COLUMN_TILE_DESC + ", "+ COLUMN_TILE_IMAGE + ", "+ COLUMN_TILE_AUDIO + ")";

    }
}
