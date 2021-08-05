package com.dian.dquran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class viewpager extends AppCompatActivity {

    private OnBoardingAdapter onBoardingAdapter;
    private LinearLayout LayoutOnBoardingIndicators;
    private Button OnBoardingAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        LayoutOnBoardingIndicators = findViewById(R.id.vp1_layoutOnBoardingIndicator);
        OnBoardingAction = findViewById(R.id.vp1_buttonOnBoard);

        setupOnBoardingItems();

        ViewPager2 onBoardingViewPager = findViewById(R.id.vp1_onboardingvp);
        onBoardingViewPager.setAdapter(onBoardingAdapter);

        setupOnBoardingIndicators();
        setCurrentOnBoardingIndicator(0);

        onBoardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnBoardingIndicator(position);
            }
        });

        OnBoardingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onBoardingViewPager.getCurrentItem() + 1 < onBoardingAdapter.getItemCount()){
                    onBoardingViewPager.setCurrentItem(onBoardingViewPager.getCurrentItem() + 1);
                }else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }
        });
    }
    private void setupOnBoardingItems(){
        List<OnBoardingItem> onBoardingItems = new ArrayList<>();
        OnBoardingItem item1 = new OnBoardingItem();
        item1.setTittle("السَّلاَمُ عَلَيْكُمْ وَرَحْمَةُ اللهِ وَبَرَكَاتُهُ");
        item1.setDescription("Assalamu'alaikum Warahmatullahi Wabarakaatuh");
        item1.setImage(R.drawable.char1);

        OnBoardingItem item2 = new OnBoardingItem();
        item2.setTittle("Siap ?");
        item2.setDescription("Untuk membuka D'Quran");
        item2.setImage(R.drawable.char2);

        OnBoardingItem item3 = new OnBoardingItem();
        item3.setTittle("Jangan lupa untuk bilang");
        item3.setDescription("بِسْمِ اللَّهِ الرَّحْمَنِ الرَّحِيم");
        item3.setImage(R.drawable.logobiru);

        onBoardingItems.add(item1);
        onBoardingItems.add(item2);
        onBoardingItems.add(item3);

        onBoardingAdapter = new OnBoardingAdapter(onBoardingItems);
    }
    private void setupOnBoardingIndicators(){
        ImageView[] indicators = new ImageView[onBoardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8, 0,8,0);
        for (int i = 0 ; i < indicators.length; i++){
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.onboarding_indicator_active
            ));
            indicators[i].setLayoutParams(layoutParams);
            LayoutOnBoardingIndicators.addView(indicators[i]);

        }
    }

    private void setCurrentOnBoardingIndicator(int index){
        int childCount = LayoutOnBoardingIndicators.getChildCount();
        for (int i = 0; i < childCount; i++){
            ImageView imageView = (ImageView)LayoutOnBoardingIndicators.getChildAt(i);
            if(i == index){
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicator_active)
                );
            } else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicator_inactive)
                );
            }
        }
        if (index == onBoardingAdapter.getItemCount() - 1 ){
            OnBoardingAction.setText("Mulai");

        }else {
            OnBoardingAction.setText("Lanjut");
        }


    }
}