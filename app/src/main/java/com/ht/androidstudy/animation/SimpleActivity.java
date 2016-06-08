package com.ht.androidstudy.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.ht.androidstudy.R;

public class SimpleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
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

        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll);


        // 简单动画，渐变
        // xml实现
        final Button button1 = (Button) findViewById(R.id.btn1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(SimpleActivity.this, R.anim.simple_1);
                linearLayout.startAnimation(animation);
            }
        });

        // 旋转动画
        final Button button2 = (Button) findViewById(R.id.btn2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(SimpleActivity.this, R.anim.simple_2);
                linearLayout.startAnimation(animation);
            }
        });

        // 缩放动画
        final Button button3 = (Button) findViewById(R.id.btn3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(SimpleActivity.this, R.anim.simple_3);
                linearLayout.startAnimation(animation);
            }
        });

        // 移动动画
        final Button button4 = (Button) findViewById(R.id.btn4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(SimpleActivity.this, R.anim.simple_4);
                linearLayout.startAnimation(animation);
            }
        });

        // 渐变、缩放、旋转动画
        findViewById(R.id.btn11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(SimpleActivity.this, R.anim.simple_5);
                linearLayout.startAnimation(animation);
            }
        });

        // 位移、渐变动画
        findViewById(R.id.btn21).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(SimpleActivity.this, R.anim.simple_6);
                linearLayout.startAnimation(animation);
            }
        });

        // 从右移动进来动画
        findViewById(R.id.btn31).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(SimpleActivity.this, R.anim.simple_7);
                linearLayout.startAnimation(animation);
            }
        });

        // 从最小放大，动画
        findViewById(R.id.btn41).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(SimpleActivity.this, R.anim.simple_8);
                linearLayout.startAnimation(animation);
            }
        });


        // 代码实现视图动画(视图动画不建议使用代码编写，动画重用性不高，实用性低)
        findViewById(R.id.btn111).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationSet animationSet = new AnimationSet(true);
                // 每个动画效果，所带参数也各不相同，开发者需要自己查看开发文档
                AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
                // 设置动画时间
                alphaAnimation.setDuration(3000);
                // 将alphaAnimation加入到动画序列中
                animationSet.addAnimation(alphaAnimation);
                // 为某个控件View添加动画
                linearLayout.startAnimation(animationSet);
            }
        });

        //zaker风格动画实现
        findViewById(R.id.btn211).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // 火车票出票动画实现
        findViewById(R.id.btn311).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SimpleActivity.this, TrainActivity.class);
                startActivity(intent);
            }
        });

        // 淘宝菜单效果
        findViewById(R.id.btn411).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // 腾讯安全雷达效果
        findViewById(R.id.btn1111).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // 高仿360首页动画效果
        findViewById(R.id.btn2111).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // 上拉抽屉效果
        findViewById(R.id.btn3111).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

}
