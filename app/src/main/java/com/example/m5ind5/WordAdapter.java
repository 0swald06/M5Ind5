package com.example.m5ind5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.m5ind5.databinding.WordItemListBinding;


import java.util.List;


public class WordAdapter  extends  RecyclerView.Adapter<WordAdapter.WordViewHolder>{

    private List<String > mWordlist;

    public WordAdapter(List<String>mWordlist){

        this.mWordlist= mWordlist;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        WordItemListBinding mBinding = WordItemListBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return  new WordViewHolder(mBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String element = mWordlist.get(position);
        holder.textView.setText(element);
    }

    @Override
    public int getItemCount() {

        return mWordlist.size();
    }

    public class WordViewHolder  extends RecyclerView.ViewHolder {
        private TextView textView;
        public WordViewHolder(@NonNull WordItemListBinding mBinding) {
            super(mBinding.getRoot());

            mBinding.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mWordlist.add("Cliked PALABRA"+ mWordlist.size());

                }
            });
            textView= mBinding.textView;


        }
    }


}