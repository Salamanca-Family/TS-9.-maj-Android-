package com.example.testdrive;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.testdrive.databinding.ArmFragmentBinding;
import com.example.testdrive.databinding.OSkoliBinding;

import java.util.ArrayList;
import java.util.Collections;

public class OSkoli extends Fragment {

    private OSkoliBinding binding;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = OSkoliBinding.inflate(inflater, container, false);

        binding.masinstvoList.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                binding.masinstvoList.requestDisallowInterceptTouchEvent(true);
                int action = event.getActionMasked();
                switch (action) {
                    case MotionEvent.ACTION_UP:
                        binding.masinstvoList.requestDisallowInterceptTouchEvent(false);
                        break;
                }
                return false;
            }
        });
        binding.elektroList.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                binding.elektroList.requestDisallowInterceptTouchEvent(true);
                int action = event.getActionMasked();
                switch (action) {
                    case MotionEvent.ACTION_UP:
                        binding.elektroList.requestDisallowInterceptTouchEvent(false);
                        break;
                }
                return false;
            }
        });
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list, "Техничар за компјутерско управљање (CNC) машина (4)", "Механичар моторних возила (3)", "Бравар - заваривач (3)");
        Collections.addAll(list2, "Електротехничар информационих технологија (4)", "Администратор рачунарских мрежа (4)","Техничар мултимедије (4)","Електротехничар обновљивих извора енергије (4)");
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),R.layout.text_color4, list);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(getContext(),R.layout.text_color4, list2);
        binding.masinstvoList.setAdapter(arrayAdapter);
        binding.elektroList.setAdapter(arrayAdapter2);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}