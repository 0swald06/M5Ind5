package com.example.m5ind5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.m5ind5.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private List<String> datalist = new ArrayList<>();
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        WordAdapter adapter = new WordAdapter(setData());


        binding.recyclerview1.setAdapter(adapter);


        binding.recyclerview1.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerview1.setHasFixedSize(true);



        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                datalist.add("PALABRA"+ datalist.size());
                // notoficar al adapter que insertamos datos

                binding.recyclerview1.getAdapter().notifyItemInserted(datalist.size());
                // scroll al final de la lista
                binding.recyclerview1.smoothScrollToPosition(datalist.size());

            }
        });
    }
    private List<String> setData() {


        return datalist;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}