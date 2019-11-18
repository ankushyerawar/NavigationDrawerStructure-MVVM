package com.ankushyerwar.blankndstructure.ui.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ankushyerwar.blankndstructure.R;
import com.ankushyerwar.blankndstructure.ui.activities.MainActivity;
import com.ankushyerwar.blankndstructure.ui.interfaces.OnToolbarTitleChanged;

public class HomeFragment extends Fragment {

    private OnToolbarTitleChanged mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnToolbarTitleChanged) {
            mListener = (OnToolbarTitleChanged) context;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mListener.onTitleChanged("My Fragment");
        navItemChecked(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        navItemChecked(false);
    }

    private void navItemChecked(boolean isChecked) {
        if (getActivity() != null){
            ((MainActivity)getActivity())
                    .mNavigationView.getMenu().findItem(R.id.nav_home).setChecked(isChecked);
        }
    }
}
