package com.lukaswalser.simongame;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.AudioManager;

/* Implementation of class SoundPlayer:
   In this class, some sound effects and background music will be added to the app.
 */

public class SoundPlayer {
    MediaPlayer music;
    private static SoundPool soundPool;
    private static int clickSound;
    private boolean isActive;

    public SoundPlayer(Context context) {
        music = MediaPlayer.create(context, R.raw.background);
        soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        clickSound = soundPool.load(context, R.raw.click, 1);
    }

    // play music as long as activity_main is in the foreground
    public void playBackgroundMusic() {
        music.start();

        // music will be played endless number of times
        music.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                if(isActive) {
                    music.start();
                }
            }
        });
    }

    public void stopBackgroundMusic() {
        music.release();
    }

    //
    public void playClickSound() {
        soundPool.play(clickSound, 1.0f, 1.0f, 1, 0,1.0f);
    }

    // set and get methods (data encapsulation)
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean getIsActive() {
        return isActive;
    }
}
