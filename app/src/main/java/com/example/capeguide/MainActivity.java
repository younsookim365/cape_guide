//Deep Programming (2021) Near Me | Firebase, Google Map, Place & Direction API's | Intro & Setup Project Android Java source code (Version 1.0) [Source code]. https://www.youtube.com/watch?v=dfTzz5AhBNQ&list=PLpQFhyCcxiCqDFYQabluYIYsNSsCFMNFk&index=1
package com.example.capeguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mb_getStarted;
    private ProgressBar pb_loginLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb_loginLoading = (ProgressBar) findViewById(R.id.pb_loginLoading);
        mb_getStarted = (Button) findViewById(R.id.mb_getStarted);
        mb_getStarted.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                pb_loginLoading.setVisibility(View.VISIBLE);
                openLogin();
            }
        });

    }

        private void openLogin()
        {
            pb_loginLoading.setVisibility(View.GONE);
            Intent i = new Intent(this, Login.class);
            startActivity(i);
        }
    }

   