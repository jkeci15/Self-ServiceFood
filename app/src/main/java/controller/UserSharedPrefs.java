package controller;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import model.User;
import model.Business;

public class UserSharedPrefs {

    private static final String USER_PREFKEY = "USER_PREFKEY";
    private static final String USER_KEY = "USER_KEY";
    private static final String BUSINESS_PREFKEY = "USER_PREFKEY";
    private static final String BUSINESS_KEY = "USER_KEY";

    private static final String USER_PREFID = "USER_PREFID";
    private static final String USERID_KEY = "USERID_KEY";



    public static void saveUser(Context context, User user){
        SharedPreferences sharedPreferences = context.getSharedPreferences(USER_PREFKEY,Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(USER_KEY, new Gson().toJson(user)).apply();

    }
    public static void saveBusiness(Context context, Business business){
        SharedPreferences sharedPreferences = context.getSharedPreferences(BUSINESS_PREFKEY,Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(BUSINESS_KEY, new Gson().toJson(business)).apply();

    }

    public static User getUser(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(USER_PREFKEY,Context.MODE_PRIVATE);
        return new Gson().fromJson(sharedPreferences.getString(USER_KEY, "\n"),User.class);
    }

    public static Business getBusiness(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(BUSINESS_PREFKEY,Context.MODE_PRIVATE);
        return new Gson().fromJson(sharedPreferences.getString(BUSINESS_KEY,"\n"),Business.class);


    }

    public static void clear(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(USER_PREFKEY,Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
    }
}