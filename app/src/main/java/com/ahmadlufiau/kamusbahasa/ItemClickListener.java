package com.ahmadlufiau.kamusbahasa;

import android.view.View;

/**
 * Created by Ahmad Lufi A U on 17/12/2017.
 */

public class ItemClickListener implements View.OnClickListener {

    private int position;
    private OnItemClickCallback onItemClickCallback;

    public ItemClickListener(int position, OnItemClickCallback onItemClickCallback) {
        this.position = position;
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public void onClick(View view) {
        onItemClickCallback.onItemClicked(view,position);
    }

    public interface OnItemClickCallback {
        void onItemClicked(View view, int position);
    }
}