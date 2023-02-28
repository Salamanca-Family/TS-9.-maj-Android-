package com.example.testdrive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.testdrive.databinding.ArmFragmentBinding;
import com.example.testdrive.databinding.TzkumFragmentBinding;

import java.util.ArrayList;
import java.util.Collections;

public class TzkumFragment extends Fragment {

    private TzkumFragmentBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = TzkumFragmentBinding.inflate(inflater, container, false);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "овладавају програмирањем компјутерски управљаним машинама", "стичу основна знања о технолошким могућностима обрадних система са компјутерским управљањем", "оспособљавају се за повезивање теоријских знања о обрадним процесима и принципима пројектовања нових производа и технолошких процеса уз подршку рачунара(CAD/CAM системи)", "стичу знања о пројектовању технологије за CNC машине и њену примену", "упознају функције управљачке јединице и оспособљавају се за програмирање и тестирање програма", "развијају смисао за сарадњу са пројектантима и конструкторима производа као и оператерима за CNC машине и са осталим субјектима у пословном систему");
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),R.layout.text_color2, list);
        binding.tzkumList.setAdapter(arrayAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}