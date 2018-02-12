package com.cjd.learning.recycleviewpractise;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdavis on 2/6/18.
 */

public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private List<Crime> mCrimes;

    public static CrimeLab getCrimeLab(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mCrimes.add(new Crime(i,"Crime number: " + i));
        }
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(int id) {
        for (Crime crime : mCrimes) {
            if (crime.getId() == id ) {
                return crime;
            }
        }
        return null;
    }
}
