package com.drmiaji.fortyahadith;

import android.app.Application;
import android.graphics.Typeface;

/**
 * Created by bmiaj on 2017-04-09.
 */
public class CustomApp extends Application {

    private static CustomApp mInstance;
    private TypeFactory mFontFactory;

    public static synchronized CustomApp getApp() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public Typeface getTypeFace(int type) {
        if (mFontFactory == null)
            mFontFactory = new TypeFactory(this);

        switch (type) {
            case Constants.SOLAIMANLIPI:
                return mFontFactory.getSolaimanlipi();
            case Constants.MUSHAF:
                return mFontFactory.getMushaf();
            default:
                return mFontFactory.getSolaimanlipi();
        }
    }

    public interface Constants {
        int SOLAIMANLIPI = 1;
        int MUSHAF = 2;
    }
}
