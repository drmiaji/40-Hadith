package com.drmiaji.fortyahadith;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class chap27 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chap27);

        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null)
            getSupportActionBar().setHomeButtonEnabled(true);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = findViewById(R.id.fableft);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent right = new Intent(chap27.this, chap26.class);
                startActivity(right);
            }
        });
        FloatingActionButton fab2 = findViewById(R.id.fabright);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent right = new Intent(chap27.this, chap28.class);
                startActivity(right);
            }
        });

        TextView textView = findViewById(R.id.chap27);
        textView.setText(readTxt());
    }

    private String readTxt() {
        InputStream inputStream = getResources().openRawResource(R.raw.chap27);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            int i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuInflater = getMenuInflater();
        mMenuInflater.inflate(R.menu.action_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                onBackPressed();
                break;
            case R.id.share:
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareSub = getString(R.string.share_subject);
                String shareBody = getString(R.string.share_message);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareSub);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(myIntent, "Share using!"));
                break;
            case R.id.more_apps:
                Intent moreApp = new Intent(Intent.ACTION_VIEW);
                moreApp.setData(Uri.parse("http://play.google.com/store/apps/dev?id=5204491413792621474"));
                startActivity(moreApp);
                break;
            case R.id.action_content:
                startActivity(new Intent(this, Main2Activity.class));
                break;
            case R.id.action_about_us:
                startActivity(new Intent(this, About.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
