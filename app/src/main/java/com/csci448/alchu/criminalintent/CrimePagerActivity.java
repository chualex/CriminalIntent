package com.csci448.alchu.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.List;
import java.util.UUID;

/**
 * Created by Alex on 2/10/18.
 */

public class CrimePagerActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private List<Crime> mCrimes;
    private Button mFirstCrimeButton;
    private Button mLastCrimeButton;


    private static final String EXTRA_CRIME_ID = "com.csci448.alchu.criminalintent.crime_id";
    public static Intent newIntent(Context packageContext, UUID crimeId) {
        Intent intent = new Intent(packageContext, CrimePagerActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_pager);
        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        mViewPager = (ViewPager) findViewById(R.id.crime_view_pager);
        mCrimes = CrimeLab.get(this).getCrimes();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Crime crime = mCrimes.get(position);
                return CrimeFragment.newInstance(crime.getId());
            }

            @Override
            public int getCount() {
                return mCrimes.size();
            }
        });
        for (int i = 0; i < mCrimes.size(); i++) {
            if (mCrimes.get(i).getId().equals(crimeId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
        mFirstCrimeButton = (Button) findViewById(R.id.first_button);
        mFirstCrimeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(0);
            }

        });

        mLastCrimeButton = (Button) findViewById(R.id.last_button);
        mLastCrimeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(mCrimes.size() - 1);
            }

        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (mViewPager.getAdapter().getCount() == 0 || mViewPager.getCurrentItem() <= 0) {
                    mFirstCrimeButton.setVisibility(View.INVISIBLE);
                } else {
                    mFirstCrimeButton.setVisibility(View.VISIBLE);
                }

                if (mViewPager.getAdapter().getCount() == 0 || mViewPager.getCurrentItem() == mViewPager.getAdapter().getCount() - 1) {
                    mLastCrimeButton.setVisibility(View.INVISIBLE);
                } else {
                    mLastCrimeButton.setVisibility(View.VISIBLE);
                }
            }


            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }



}
