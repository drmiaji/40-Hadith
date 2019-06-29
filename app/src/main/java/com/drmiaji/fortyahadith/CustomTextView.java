package com.drmiaji.fortyahadith;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import com.codesgood.views.JustifiedTextView;

/**
 * Created by bmiaj on 2017-04-09.
 */

public class CustomTextView extends JustifiedTextView {

    private int typefaceType;

    public CustomTextView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CustomTextView,
                0, 0);
        try {
            typefaceType = array.getInteger(R.styleable.CustomTextView_font_name, 0);
        } finally {
            array.recycle();
        }
        if (!isInEditMode()) {
            setTypeface(com.drmiaji.fortyahadith.CustomApp.getApp().getTypeFace(typefaceType));
        }
    }
}
