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

import java.util.ArrayList;
import java.util.Collections;

public class ArmFragment extends Fragment {

    private ArmFragmentBinding binding;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = ArmFragmentBinding.inflate(inflater, container, false);
        binding.armFlajer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ArmFragment.this)
                        .navigate(R.id.action_armFragment3_to_armFlajerFragment);
            }
        });
        binding.armList.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                binding.armList.requestDisallowInterceptTouchEvent(true);
                int action = event.getActionMasked();
                switch (action) {
                    case MotionEvent.ACTION_UP:
                        binding.armList.requestDisallowInterceptTouchEvent(false);
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
        Collections.addAll(list, "одржавање хардвера", "инсталирање и одржавање системског софтвера", "инсталирање и одржавање пасивне и активне мрежне опреме", "имплементацију, подешавање и одржавање рачунарских мрежа", "рад са базама података", "рад са мултимедијалним софтвером", "израду интеренет презентација", "програмирање апликација");
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),R.layout.text_color, list);
        binding.armList.setAdapter(arrayAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}