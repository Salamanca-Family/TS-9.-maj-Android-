package com.example.testdrive;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.testdrive.databinding.EtitFragmentBinding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class EtitFragment extends Fragment {

    private EtitFragmentBinding binding;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = EtitFragmentBinding.inflate(inflater, container, false);
        binding.etitList.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                binding.etitList.requestDisallowInterceptTouchEvent(true);
                int action = event.getActionMasked();
                switch (action) {
                    case MotionEvent.ACTION_UP:
                        binding.etitList.requestDisallowInterceptTouchEvent(false);
                        break;
                }
                return false;
            }
        });
        binding.flajer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(EtitFragment.this)
                        .navigate(R.id.action_EtitFragment_to_etitFlajerFragment);
            }
        });
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "израду десктоп апликација", "израду статичких и динамичких веб апликација", "програмирање у неколико програмских језика и технологија: C, Java, C#, HTML, JavaScript, ASP.NET", "пројектовање и реализацију база података", "инсталирање и одржавање системског софтвера", "одржавање хардвера", "заштиту рачунарских система");
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),R.layout.text_color, list);
        binding.etitList.setAdapter(arrayAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}