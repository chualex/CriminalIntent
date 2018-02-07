package com.csci448.alchu.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Alex on 2/7/18.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
