package com.drmiaji.fortyahadith;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.kobakei.ratethisapp.RateThisApp;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();

        // Custom condition: 3 days and 2 launches
        RateThisApp.Config config = new RateThisApp.Config(3, 2);
        RateThisApp.init(config);

        // Monitor launch times and interval from installation
        RateThisApp.onCreate(this);
        // If the condition is satisfied, "Rate this app" dialog will be shown
        RateThisApp.showRateDialogIfNeeded(this);

        RateThisApp.setCallback(new RateThisApp.Callback() {
            @Override
            public void onYesClicked() {
                Toast.makeText(MainActivity.this, "Yes event", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNoClicked() {
                Toast.makeText(MainActivity.this, "No event", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelClicked() {
                Toast.makeText(MainActivity.this, "Cancel event", Toast.LENGTH_SHORT).show();

            }
        });
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
                break;
            default:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {
        createDialog();
    }

    protected void createDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage(R.string.action_exit);
        alertDialog.setCancelable(false);

        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.super.onBackPressed();
            }
        });

        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertDialog.create().show();
    }

    public void goToMenu(View view) {
        Intent nextPage = new Intent(this, Main2Activity.class);
        startActivity(nextPage);
    }
}
