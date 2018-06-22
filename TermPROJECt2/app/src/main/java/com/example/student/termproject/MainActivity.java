package com.example.student.termproject;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] bands={"The Beatles", "Coldplay", "Imagine Dragons", "Our Website"};
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, R.id.concert, bands));
    }
    protected void onListItemClick(ListView l, View v, int position, long id){
        switch(position){
            case 0:
                startActivity(new Intent(MainActivity.this, theBeatles.class));
                break;

            case 1:
                startActivity(new Intent(MainActivity.this, coldPlay.class));
                break;

            case 2:
                startActivity(new Intent(MainActivity.this, imagineDragons.class));
                break;

            case 3:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ticketmaster.com/section/concerts")));
                break;
            default:
        }
    }
}
