package com.naman14.timber.factories;

import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.CursorLoader;

import com.naman14.timber.utils.PreferencesUtility;

/**
 * Created by Ravishankar Ahirwar on 16-2-6.
 * This is class is use for Create verious loaders for loading data from Media Store.
 */
public class CursorLoaderFactory {

    private static final Uri SONG_URI = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    private static final String[] SONG_COLUMNS = new String[]{
            MediaStore.Audio.AudioColumns._ID, // ..........................................0
            MediaStore.Audio.AudioColumns.TITLE, // .................................1
            MediaStore.Audio.AudioColumns.ARTIST, // ......................................2
            MediaStore.Audio.AudioColumns.ALBUM, // ....................................3
            MediaStore.Audio.AudioColumns.DURATION, // ...................................4
            MediaStore.Audio.AudioColumns.TRACK, //                               5
            MediaStore.Audio.AudioColumns.ARTIST_ID, //                               6
            MediaStore.Audio.AudioColumns.ALBUM_ID, // .............................7
    };


    public static CursorLoader createSongLoader(Context context) {
        String selectionStatement = "is_music=1 AND title != ''";
        final String songSortOrder = PreferencesUtility.getInstance(context).getSongSortOrder();

        return new CursorLoader(context, SONG_URI, SONG_COLUMNS, selectionStatement, null,
                songSortOrder);
    }
}
