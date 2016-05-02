package com.example.kartheek.iiitbnavmap;

import java.util.HashMap;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SessionManagement {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;

    public SessionManagement(Context cont) {
        this.context=cont;
        pref=context.getSharedPreferences("Mypref",Context.MODE_PRIVATE);
        editor =pref.edit();
    }
    public void createLoginSession(String name, String email){
        editor.putBoolean(Constants.IS_LOGGED_IN, true);
        editor.putString(Constants.NAME, name);
        editor.putString(Constants.EMAIL, email);
        editor.commit();
    }
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(Constants.NAME, pref.getString(Constants.NAME, null));
        user.put(Constants.EMAIL, pref.getString(Constants.EMAIL, null));
        return user;
    }
    public void checkLogin() {
        if (!this.isLoggedIn()) {
            Intent i = new Intent(context, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
    public boolean isLoggedIn(){
        return pref.getBoolean(Constants.IS_LOGGED_IN,false);
    }
    public void logoutUser(){
        editor.clear();
        editor.commit();
        Intent i = new Intent(context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}

