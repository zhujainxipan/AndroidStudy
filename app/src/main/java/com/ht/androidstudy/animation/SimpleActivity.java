package com.ht.androidstudy.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
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
import android.widget.ImageView;
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
                Intent intent = new Intent(SimpleActivity.this, ZakerActivity.class);
                startActivity(intent);
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


        // frame动画
        final ImageView imageView = (ImageView) findViewById(R.id.btn3111);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setBackgroundResource(R.drawable.drawable_progress);
                AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
                animationDrawable.start();
            }
        });


        // 上拉抽屉效果
        findViewById(R.id.btn4111).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




        // 属性动画
        final View view1 = findViewById(R.id.btn11111);
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofInt(view1, "width", 500).setDuration(5000).start();
            }
        });


        final View view2 = findViewById(R.id.btn21111);
        final ObjectAnimator alpha = ObjectAnimator.ofFloat(view2, "alpha", 1f, 0f, 1f).setDuration(5000);
        alpha.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        alpha.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        });
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 这个过程中也是渐变的
                alpha.start();
            }
        });


        final View view3 = findViewById(R.id.btn31111);
        final float curTranslationX = view3.getTranslationX();
        view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofFloat(view3, "translationX", curTranslationX, -500f, curTranslationX).setDuration(5000).start();
            }
        });


        final View view4 = findViewById(R.id.btn41111);
        view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator moveIn = ObjectAnimator.ofFloat(linearLayout, "translationX", -500f, 0f);
                ObjectAnimator rotate = ObjectAnimator.ofFloat(linearLayout, "rotation", 0f, 360f);
                ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(linearLayout, "alpha", 1f, 0f, 1f);
                AnimatorSet animSet = new AnimatorSet();
                animSet.play(rotate).with(fadeInOut).after(moveIn);
                animSet.setDuration(5000);
                animSet.start();
            }
        });


        findViewById(R.id.btn111111).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animator animator = AnimatorInflater.loadAnimator(SimpleActivity.this, R.animator.amima1);
                animator.setTarget(linearLayout);
                animator.start();
            }
        });


    }

}
