package com.goterl.lazycode.lazysodium.example.activities;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.goterl.lazycode.lazysodium.LazySodiumAndroid;
import com.goterl.lazycode.lazysodium.example.R;
import com.goterl.lazycode.lazysodium.SodiumAndroid;

public abstract class BaseActivity extends AppCompatActivity  {


    protected LazySodiumAndroid ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symmetric_enc);

        // Create ls object, this should usually be
        // initialised once somewhere. Perhaps in an
        // Application.java class.
        ls = new LazySodiumAndroid(new SodiumAndroid());
    }

    protected void setupToolbar(String title) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int accentColor = ContextCompat.getColor(this, R.color.colorAccentL3);
        toolbar.getNavigationIcon().setColorFilter(accentColor, PorterDuff.Mode.SRC_ATOP);
        toolbar.setTitleTextColor(accentColor);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, android.R.anim.fade_out);
    }
}
