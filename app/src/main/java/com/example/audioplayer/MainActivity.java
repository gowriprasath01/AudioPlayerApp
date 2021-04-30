package com.example.audioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {
    public static final int REQ_CODE_PICK_SOUNDFILE = 1;
    private Button playButton;
    private Button pauseButton;
    private List<String> AudioList = new ArrayList<String>();

    // private MediaStore mediaStore;
    // private List<AudioModel> tempAudioList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = findViewById(R.id.playbutton);
        pauseButton = findViewById(R.id.Pausebutton);

        getAllAudioFromDevice(MainActivity.this);


        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "you have clicked the button", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent().setAction(Intent.ACTION_GET_CONTENT);
//                intent.setType("audio/*");
//                startActivityForResult(Intent.createChooser(intent, getString(R.string.select_audio_file_title)), (Integer) REQ_CODE_PICK_SOUNDFILE);





//

            }
        });

    }

    public List<AudioModel> getAllAudioFromDevice(final Context context) {
        final List<AudioModel> tempAudioList = new ArrayList<>();

        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {MediaStore.Audio.AudioColumns.DATA, MediaStore.Audio.AudioColumns.TITLE, MediaStore.Audio.AudioColumns.DURATION, MediaStore.Audio.ArtistColumns.ARTIST,};

        //String[] projection = { MediaStore.Audio.ArtistColumns.DATA,MediaStore.Audio.AudioColumns.TITLE, MediaStore.Audio.AudioColumns.ARTIST, MediaStore.Audio.AudioColumns.DURATION,};
        Cursor c = context.getContentResolver().query(uri, projection, MediaStore.Audio.Media.DATA + " like ? ", new String[]{"%Path:/storage/emulated/0/Download%"}, null);

        if (c != null) {
            while (c.moveToNext()) {
                AudioModel audioModel = new AudioModel();
                String path = c.getString(0);
                String name = c.getString(1);
                String duration = c.getString(2);
                String artist = c.getString(3);


                audioModel.setAudio_name(name);
                audioModel.setAudio_artist(artist);
                audioModel.setAudio_duration(duration);
                audioModel.setAudio_path(path);

//                Log.e("Name :" + name, " duration :" + duration);
//                Log.e("Path :" + path, " Artist :" + artist);
                Log.d("main", "getAllAudioFromDevice: "+ name);

                tempAudioList.add(audioModel);
            }
            c.close();
        }


        for (int i = 0; i < tempAudioList.size(); i++) {
            Log.d("newlist", "onActivityResult: list added" +  tempAudioList.get(i).getAudio_artist() );
        }
         return tempAudioList;
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == REQ_CODE_PICK_SOUNDFILE && resultCode == Activity.RESULT_OK) {
//            if ((data != null) && (data.getData() != null)) {
//
//
//
//
//
//
//
//
//
//
//
//
//
//                Uri audioFileUri = data.getData();
//                // Now you can use that Uri to get the file path, or upload it, ...
//
//                Toast.makeText(this, "The path is :" + audioFileUri.getPath(), Toast.LENGTH_SHORT).show();
//
//                AudioList.add(audioFileUri.toString());
//                Toast.makeText(this, "Successfully added to the list", Toast.LENGTH_SHORT).show();
//
//
//                }
//                for (int i = 0; i < AudioList.size(); i++) {
//                    Log.d("list", "onActivityResult: list added" +  AudioList.get(i) );
//                }
//
//            }
//        }
    }
