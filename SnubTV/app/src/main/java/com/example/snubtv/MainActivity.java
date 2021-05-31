package com.example.snubtv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener
{

    public static int current_video = 1;

    private static final String TAG = "SWIPE GESTURE";
    private float x1,x2,y1,y2;
    private static int MIN_DISTANCE = 150;
    GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //intialising gestureDetector
        this.gestureDetector = new GestureDetector(MainActivity.this,this);

        try
        {
            VideoView videoView = (VideoView) findViewById(R.id.videoView1);

            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.first);

            videoView.setVideoURI(uri);
            videoView.requestFocus();
            videoView.start();

            //setting the video on loop
            videoView.setOnCompletionListener ( new MediaPlayer.OnCompletionListener()
            {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer)
                {
                    videoView.start();
                }
            });

        }
        catch (Exception e)
        {
            Toast.makeText(this,"Something went wrong while playing the video",Toast.LENGTH_SHORT).show();
        }
    }


    protected void onStart()
    {
        super.onStart();
        setContentView(R.layout.activity_main);

        //intialising gestureDetector
        this.gestureDetector = new GestureDetector(MainActivity.this,this);

        try
        {
            VideoView videoView = (VideoView) findViewById(R.id.videoView1);

            Uri uri;
            //Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.second);

            if(current_video==1)
                uri= Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.first);
            else if(current_video==2)
                uri= Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.second);
            else if(current_video==3)
                uri= Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.third);
            else
                uri= Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.fourth);


            videoView.setVideoURI(uri);
            videoView.requestFocus();
            videoView.start();

            //setting the video on loop
            videoView.setOnCompletionListener ( new MediaPlayer.OnCompletionListener()
            {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer)
                {
                    videoView.start();
                }
            });

        }
        catch (Exception e)
        {
            Toast.makeText(this,"Something went wrong while playing the video",Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        gestureDetector.onTouchEvent(event);

        switch (event.getAction())
        {
            //starting to swipe time gestures
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1 = event.getY();
                break;

            //ending time swipe gesture
            case MotionEvent.ACTION_UP:
                x2=event.getX();
                y2=event.getY();

                //getting value for horizontal swipe
                float valueX = x2 - x1;

                //getting value for vertical swipe
                float valueY = y2 - y1;

                if(Math.abs(valueX) > MIN_DISTANCE)
                {
                    //detect left to right swipe
                    if(x2>x1)
                    {
                        //Toast.makeText(this,"Right swipe",Toast.LENGTH_SHORT).show();
                        Log.d(TAG,"Right Swipe");
                        startActivity(new Intent(MainActivity.this, user_profile.class));
                    }

                    //detect right to left swipe
                    else
                    {

                        if(current_video==1)
                            Toast.makeText(this,"Subscribed to Rick Astley",Toast.LENGTH_SHORT).show();
                        else if(current_video==2)
                            Toast.makeText(this,"Subscribed to Sia Offical",Toast.LENGTH_SHORT).show();
                        else if(current_video==3)
                            Toast.makeText(this,"Subscribed to Ai Hinatsuru",Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(this,"Subscribed to Antony Chen",Toast.LENGTH_SHORT).show();

                        Log.d(TAG,"Left Swipe");

                    }
                }
                else if(Math.abs(valueY) > MIN_DISTANCE)
                {
                    //detect top to bottom swipe
                    if(y2 > y1)
                    {
                        Log.d(TAG,"Bottom Swipe");
                        //Toast.makeText(this,"Bottom swipe",Toast.LENGTH_SHORT).show();
                        if(current_video!=1)
                            current_video-=1;
                        else
                            current_video=4;
                    }
                    //detect bottom to top swipe
                    else
                    {
                        Log.d(TAG,"Top Swipe");
                        //Toast.makeText(this,"Top swipe",Toast.LENGTH_SHORT).show();
                        if(current_video!=4)
                            current_video+=1;
                        else
                            current_video=1;
                    }
                    //after storing current video onStart() is called
                    onStart();
                }
        }

        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e)
    {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e)
    {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e)
    {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY)
    {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e)
    {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY)
    {
        return false;
    }
}