package com.ankushyerwar.blankndstructure.utils;

import android.content.SharedPreferences;

public class SharedPreferenceHelper {

    public static void setSharedPreferenceString(SharedPreferences pref, String key, String value){
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void setSharedPreferenceInt(SharedPreferences pref, String key, int value){
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static void setSharedPreferenceLong(SharedPreferences pref, String key, long value){
        SharedPreferences.Editor editor = pref.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public static void setSharedPreferenceFloat(SharedPreferences pref, String key, float value){
        SharedPreferences.Editor editor = pref.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    public static void setSharedPreferenceBoolean(SharedPreferences pref, String key, boolean value){
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static String getSharedPreferenceString(SharedPreferences pref, String key, String defValue){
        return pref.getString(key, defValue);
    }

    public static int getSharedPreferenceInt(SharedPreferences pref, String key, int defValue){
        return pref.getInt(key, defValue);
    }

    public static Long getSharedPreferenceLong(SharedPreferences pref, String key, long defValue){
        return pref.getLong(key, defValue);
    }

    public static Float getSharedPreferenceFloat(SharedPreferences pref, String key, float defValue){
        return pref.getFloat(key, defValue);
    }

    public static boolean getSharedPreferenceBoolean(SharedPreferences pref, String key, boolean defValue){
        return pref.getBoolean(key, defValue);
    }

    public static void removeString(SharedPreferences pref, String key){
        SharedPreferences.Editor editor = pref.edit();
        editor.remove(key);
        editor.apply();
    }

}
