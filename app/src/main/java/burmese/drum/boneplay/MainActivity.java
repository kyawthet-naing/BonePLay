package burmese.drum.boneplay;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SoundPool soundPool;
    private int btn1, btn2, btn3, btn4, btn5, btn6, btn_left, btn_middle, btn_right;
    private Boolean bol = true;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*For Orientation LandScape*/
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        /*For ActionBar hide*/
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        /*For StatusBar hide*/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // mediaPlayer = MediaPlayer.create(this, R.raw.solo);
        mediaPlayer = new MediaPlayer();
        /*SoundPool Object*/
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);

        btn1 = soundPool.load(MainActivity.this, R.raw.note01, 1);
        btn2 = soundPool.load(MainActivity.this, R.raw.note02, 1);
        btn3 = soundPool.load(MainActivity.this, R.raw.note03, 1);
        btn4 = soundPool.load(MainActivity.this, R.raw.note04, 1);
        btn5 = soundPool.load(MainActivity.this, R.raw.note05, 1);
        btn6 = soundPool.load(MainActivity.this, R.raw.note06, 1);
        btn_left = soundPool.load(MainActivity.this, R.raw.left, 1);
        btn_middle = soundPool.load(MainActivity.this, R.raw.middle, 1);
        btn_right = soundPool.load(MainActivity.this, R.raw.right, 1);

    }

    /*ခြောက်လုံးပတ် ဗုံသံ Button*/
    public void kk(View v) {

        if (bol) {
            mediaPlayer.pause();
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.solo);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(MainActivity.this,"End..",Toast.LENGTH_SHORT).show();
            }
        });

        if (bol) {
            mediaPlayer.start();
            Toast.makeText(MainActivity.this,"Started..",Toast.LENGTH_SHORT).show();

        }

    }


    public void whenButtonClick(View v) {


        mediaPlayer.seekTo(0);
        mediaPlayer.pause();
        switch (v.getId()) {
            case R.id.btn1:
                soundPool.play(btn1, 1, 1, 0, 0, 1);
                break;
            case R.id.btn2:
                soundPool.play(btn2, 1, 1, 0, 0, 1);
                break;
            case R.id.btn3:
                soundPool.play(btn3, 1, 1, 0, 0, 1);
                break;
            case R.id.btn4:
                soundPool.play(btn4, 1, 1, 0, 0, 1);
                break;
            case R.id.btn5:
                soundPool.play(btn5, 1, 1, 0, 0, 1);
                break;
            case R.id.btn6:
                soundPool.play(btn6, 1, 1, 0, 0, 1);
                break;
            case R.id.btn_left:
                soundPool.play(btn_left, 1, 1, 0, 0, 1);
                break;
            case R.id.btn_middle:
                soundPool.play(btn_middle, 1, 1, 0, 0, 1);
                break;
            case R.id.btn_right:
                soundPool.play(btn_right, 1, 1, 0, 0, 1);
                break;


        }

    }
}
