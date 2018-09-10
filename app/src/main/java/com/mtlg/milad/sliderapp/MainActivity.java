package com.mtlg.milad.sliderapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener {


    SliderLayout sliderLayout;
    String[] img = {


            "https://m.media-amazon.com/images/M/MV5BODY5NjIyNTcyNV5BMl5BanBnXkFtZTgwNjc4NDEzMzI@._V1_SY1000_CR0,0,1503,1000_AL_.jpg",
            "https://m.media-amazon.com/images/M/MV5BMjE2MjcxMTAyNV5BMl5BanBnXkFtZTgwNjg2MDU5NTM@._V1_SY1000_CR0,0,1505,1000_AL_.jpg",
            "https://m.media-amazon.com/images/M/MV5BNTc5MzhjY2QtYWRlYi00ZjA4LWExY2UtMzhhYWM3NWQwMzQ4XkEyXkFqcGdeQXVyNjc5Mjg0NjU@._V1_SY1000_SX1500_AL_.jpg"

    };

    String desc[] = {"Game of Thrones", "Breaking Bad", "The Walking Dead"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderConfig();
    }

    private void sliderConfig() {

        SliderLayout slider = findViewById(R.id.slider);

        for (int i = 0; i < img.length; i++) {
            CustomTextSliderView sItem = new CustomTextSliderView(this);
            sItem.description(desc[i])
                    .image(img[i])
                    .setOnSliderClickListener(this)
                    .bundle(new Bundle())
                    .getBundle().putString("desc", desc[i]);

            slider.addSlider(sItem);
        }

        slider.setPresetTransformer(SliderLayout.Transformer.Fade);
        slider.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);
        slider.setCustomAnimation(new DescriptionAnimation());
        slider.setDuration(3000);
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

        Toast.makeText(getApplicationContext(), slider.getBundle().getString("desc"), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
