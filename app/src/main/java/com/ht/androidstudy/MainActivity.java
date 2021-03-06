package com.ht.androidstudy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.ht.androidstudy.animation.SimpleActivity;
import com.ht.androidstudy.dialog.DialogFragmentTest;
import com.ht.androidstudy.dialog.DialogFragmentTestDemo;
import com.ht.androidstudy.dropmenu.demo1.DropDownMenuActivity;
import com.ht.androidstudy.meituanxuanting.ListViewHeightActivity;
import com.ht.androidstudy.meituanxuanting.ScrollHeightViewActivity;
import com.ht.androidstudy.scroller.ScollerActivity;
import com.ht.androidstudy.scroller.ScrollerLayoutActivity;
import com.ht.androidstudy.view.ViewActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        findViewById(R.id.btn_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_scoller).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScollerActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_scollerlayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScrollerLayoutActivity.class);
                startActivity(intent);
            }
        });

        final Button viewById = (Button) findViewById(R.id.btn_dialogfragment_test);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<DialogFragmentTestDemo> demos = new ArrayList<DialogFragmentTestDemo>();
                for (int i = 0; i < 3; i++) {
                    DialogFragmentTestDemo demo = new DialogFragmentTestDemo();
                    demo.setStr("我是" + i);
                    demos.add(demo);
                }
                ;
                DialogFragmentTest instance = DialogFragmentTest.getInstance(demos);
                instance.setCallBack(new DialogFragmentTest.CallBack() {
                    @Override
                    public void getChoicedTxt(String str) {
                        viewById.setText(str);
                    }
                });
                instance.show(getFragmentManager(), DialogFragmentTest.DIALOGFRAGMENTTEST);
            }
        });



        findViewById(R.id.btn_scroll_view_height).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScrollHeightViewActivity.class);
                startActivity(intent);
            }
        });


        findViewById(R.id.btn_lv_height).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListViewHeightActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_dropmenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DropDownMenuActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_animation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SimpleActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
