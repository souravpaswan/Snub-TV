package com.example.snubtv;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class user_profile extends AppCompatActivity
{

    TextView cn, un, fw_count, f_count, l_count;
    CircleImageView pp;
    int curr_vid = MainActivity.current_video;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);


        cn = (TextView) findViewById(R.id.creator_name);
        pp = (CircleImageView) findViewById(R.id.profile_pic);
        un = (TextView) findViewById(R.id.username);
        fw_count = (TextView) findViewById(R.id.following_count);
        f_count = (TextView) findViewById(R.id.follower_count);
        l_count = (TextView) findViewById(R.id.likes_count);


        if (curr_vid == 1)
        {
            cn.setText("Rick Astley");
            pp.setImageResource(R.drawable.rick);
            un.setText("@rickastley");
            fw_count.setText("1933");
            f_count.setText("1.1M");
            l_count.setText("45M");

        }
        else if (curr_vid == 2)
        {
            cn.setText("Sia Official");
            pp.setImageResource(R.drawable.sia);
            un.setText("@thesia");
            fw_count.setText("1232");
            f_count.setText("9.5M");
            l_count.setText("95M");
        }
        else if (curr_vid == 3)
        {
            cn.setText("Ai Hinatsuru");
            pp.setImageResource(R.drawable.lol);
            un.setText("@nextloliryou");
            fw_count.setText("6594");
            f_count.setText("2.3M");
            l_count.setText("25M");
        }
        else
        {
            cn.setText("Antony Chen");
            pp.setImageResource(R.drawable.antony);
            un.setText("@antonychenn");
            fw_count.setText("2501");
            f_count.setText("1.5M");
            l_count.setText("45M");
        }
    }
}