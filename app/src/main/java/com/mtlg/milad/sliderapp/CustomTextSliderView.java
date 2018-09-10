package com.mtlg.milad.sliderapp;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.view.LayoutInflaterCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;

import java.util.IllegalFormatCodePointException;

public class CustomTextSliderView extends BaseSliderView {

    private static Typeface font = null;
    private Context context;

    protected CustomTextSliderView(Context context) {
        super(context);
    }

    @Override
    public View getView() {

        View v = LayoutInflater.from(getContext()).inflate(R.layout.render_type_text, null);
        ImageView target = v.findViewById(R.id.daimajia_slider_image);
        TextView description = v.findViewById(R.id.description);
        description.setText(getDescription());

//        if(font == null){
//            font = Typeface.createFromAsset(context.getAssets(), appFonts.fonts.BOLD);
//        }

        description.setTypeface(font);
        description.setPadding(0,2,10,3);
        description.setTextSize(18);

        bindEventAndShow(v, target);
        return v;
    }
}
