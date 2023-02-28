package com.example.testdrive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.testdrive.databinding.ArmFragmentBinding;
import com.example.testdrive.databinding.EoieFragmentBinding;

import java.util.ArrayList;
import java.util.Collections;

public class EoieFragment extends Fragment {

    private EoieFragmentBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = EoieFragmentBinding.inflate(inflater, container, false);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "основама пројектовања електричних инсталација", "правилном одржавању електричних инсталација, апарата, уређаја и електромотора ", "одржавању електричних мрежа, извођењу радова у безнапонском стању, у близини напона и под напоном", "значају обновљивих извора енергије", "примени рачунара у електротехници и посебно у енергетици");
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),R.layout.text_color, list);
        binding.eoieList.setAdapter(arrayAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}