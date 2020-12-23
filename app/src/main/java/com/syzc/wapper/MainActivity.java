package com.syzc.wapper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    // WallpaperManager类：系统壁纸管理。通过它可以获得当前壁纸以及设置指定图片作为系统壁纸。
    private WallpaperManager wallpaperManager;
    // 展示样式的ImageView
    private ImageView imageView;
    // 随机生成图片的颜色 Button
    private Button setWallpaper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 初始化WallpaperManager
        wallpaperManager = WallpaperManager.getInstance(this);
        imageView = (ImageView) findViewById(R.id.imageview);
        imageView.setDrawingCacheEnabled(true);
        setWallpaper = (Button) findViewById(R.id.setwallpaper);
        initListeners();
    }
    private void initListeners() {
        setWallpaper.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    // 设置壁纸
                    wallpaperManager.setBitmap(imageView.getDrawingCache());
                    finish();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
