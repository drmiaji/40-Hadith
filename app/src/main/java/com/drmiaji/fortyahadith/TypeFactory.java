package com.drmiaji.fortyahadith;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by bmiaj on 2017-04-04.
 */

public class TypeFactory {

    final String SOLAIMANLIPI = "fonts/solaimanlipi.ttf";
    final String MUSHAF = "fonts/mushaf.ttf";

    private Typeface soliamanlipi, mushaf;

    public TypeFactory(Context context) {
        soliamanlipi = Typeface.createFromAsset(context.getAssets(), SOLAIMANLIPI);
        mushaf = Typeface.createFromAsset(context.getAssets(), MUSHAF);
    }

    public Typeface getSolaimanlipi() {
        return soliamanlipi;
    }

    public Typeface getMushaf() {
        return mushaf;
    }

}
