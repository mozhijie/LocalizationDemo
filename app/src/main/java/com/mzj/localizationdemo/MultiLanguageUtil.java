package com.mzj.localizationdemo;

import android.content.Context;

import java.util.Locale;

public class MultiLanguageUtil {

    private final String TAG_NAME = "multi_language";
    private final String TAG_LANGUAGE = "language_select";

    private static volatile MultiLanguageUtil instance;

    private final SecuritySharedPreferences mSharedPreferences;

    private Locale systemCurrentLocal = Locale.ENGLISH;

    public MultiLanguageUtil(Context context) {
        this.mSharedPreferences = new SecuritySharedPreferences(context, TAG_NAME, Context.MODE_PRIVATE);
    }

    public void saveLanguage(int select) {
        SecuritySharedPreferences.Editor edit = mSharedPreferences.edit();
        edit.putInt(TAG_LANGUAGE, select);
        edit.commit();
    }

    public int getSelectLanguage() {
        return mSharedPreferences.getInt(TAG_LANGUAGE, 0);
    }

    public Locale getSystemCurrentLocal() {
        return systemCurrentLocal;
    }

    public void setSystemCurrentLocal(Locale local) {
        systemCurrentLocal = local;
    }

    public static MultiLanguageUtil getInstance(Context context) {
        if (instance == null) {
            synchronized (MultiLanguageUtil.class) {
                if (instance == null) {
                    instance = new MultiLanguageUtil(context);
                }
            }
        }
        return instance;
    }

}
