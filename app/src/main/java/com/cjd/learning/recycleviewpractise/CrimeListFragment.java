package com.cjd.learning.recycleviewpractise;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

/**
 * Created by cdavis on 2/6/18.
 */

public class CrimeListFragment extends android.support.v4.app.Fragment {
    List<Crime> mCrimes;
    RecyclerView mRecyclerView;
    CrimeAdapter mCrimeAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);
        mRecyclerView = view.findViewById(R.id.crime_recycle_view);
        CrimeListClickListener crimeListClick = (v, position) -> {
            Toast.makeText(getContext(),mCrimes.get(position).getName(),Toast.LENGTH_SHORT).show();
        };
        mCrimeAdapter = new CrimeAdapter(CrimeLab.getCrimeLab(getActivity()).getCrimes(),crimeListClick);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mCrimeAdapter);
        return view;
    }


        // inner classes

    /**
     * Holder for Recycle View
     */
    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CrimeListClickListener mCrimeListClickListener;

        public CrimeHolder(View v,CrimeListClickListener crimeListClickListener) {
            super(v);
            mCrimeListClickListener = crimeListClickListener;
            v.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mCrimeListClickListener.popUpCrimeInfo(v,getAdapterPosition());
        }
    }

    /**
     * Adapter for Recycle View
     */
    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {
        CrimeListClickListener mCrimeListClickListener;
        public CrimeAdapter(List<Crime> crimes, CrimeListClickListener crimeListClickListener) {
            mCrimes = crimes;
            mCrimeListClickListener = crimeListClickListener;
        }

        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View v = layoutInflater.inflate(R.layout.list_item_crime, parent, false);
            return new CrimeHolder(v, mCrimeListClickListener);
        }

        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {
            //todo bind the crime to the viewholder
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }
}

