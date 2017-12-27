package com.ahmadlufiau.kamusbahasa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static String EXTRA_KAMUS = "kamus bahasa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tvName = (TextView) findViewById(R.id.txt_nama);
        TextView tvDesc = (TextView) findViewById(R.id.txt_desc);

        KamusModel model = getIntent().getParcelableExtra(EXTRA_KAMUS);

        tvName.setText(model.getName());
        tvDesc.setText(model.getDescription());

    }
}