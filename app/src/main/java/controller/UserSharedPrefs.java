package not_needed.db;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import model.Users;

public class UserSharedPrefs {

    private static final String USER_PREFKEY = "USER_PREFKEY";
    private static final String USER_KEY = "USER_KEY";
    private static final String USER_PREFID = "USER_PREFID";
    private static final String USERID_KEY = "USERID_KEY";



    public static void saveUser(Context context, Users user){
        SharedPreferences sharedPreferences = context.getSharedPreferences(USER_PREFKEY,Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(USER_KEY, new Gson().toJson(user)).apply();

    }


    public static Users getUser(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(USER_PREFKEY,Context.MODE_PRIVATE);
        return new Gson().fromJson(sharedPreferences.getString(USER_KEY, "\n"),Users.class);
    }

    public static void clear(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(USER_PREFKEY,Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
    }
}