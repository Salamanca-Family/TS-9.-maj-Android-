package com.example.testdrive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.testdrive.databinding.ArmFragmentBinding;
import com.example.testdrive.databinding.MmvFragmentBinding;

import java.util.ArrayList;
import java.util.Collections;

public class MmvFragment extends Fragment {

    private MmvFragmentBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = MmvFragmentBinding.inflate(inflater, container, false);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "ће ти омогућити да уђеш у свет савремених аутомобила и теретних возила", "је увек тражен, како у прошлости тако и у будућности, јер се власници својих љубимаца (аутомобила) никада неће одрећи", "оспособљава ученике да врше сервис и одржавање моторних возила, откљањају неисправности на возилима, као и да растављају и састављају делове и склопове");
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),R.layout.text_color3, list);
        binding.mmvList.setAdapter(arrayAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}