package com.ahmadlufiau.kamusbahasa;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Ahmad Lufi A U on 17/12/2017.
 */

public class AppPreference {

    SharedPreferences prefs;
    Context context;

    public AppPreference(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
        this.context = context;
    }

    public void setFirstRunning(Boolean input){
        SharedPreferences.Editor editor = prefs.edit();
        String key = context.getResources().getString(R.string.first_running);
        editor.putBoolean(key,input);
        editor.commit();
    }

    public Boolean getFirstRunning(){
        String key = context.getResources().getString(R.string.first_running);
        return prefs.getBoolean(key,true);
    }
}