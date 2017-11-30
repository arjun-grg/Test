package com.wongel.test;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by tseringwongelgurung on 11/23/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyVH> {
    private List<Student> list;
    private OnMyClickListner listner;

    public MyAdapter(List<Student> list, OnMyClickListner listner) {
        this.list = list;
        this.listner = listner;
    }

    @Override
    public MyVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_adapter, null);
        return new MyVH(view,listner);
    }

    @Override
    public void onBindViewHolder(MyVH holder, int position) {
        Student student = list.get(position);

        holder.edtName.setText(student.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
