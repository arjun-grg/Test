package com.wongel.test;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by tseringwongelgurung on 11/23/17.
 */

public class MyVH extends RecyclerView.ViewHolder {
    public EditText edtName;
    public Button btnDel, btnUpdate;

    public MyVH(View itemView, final OnMyClickListner listner) {
        super(itemView);
        edtName = itemView.findViewById(R.id.edtName);
        btnDel = itemView.findViewById(R.id.btnDel);
        btnUpdate = itemView.findViewById(R.id.btnUpdate);

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listner.onDelClicked(getAdapterPosition());
            }
        });


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listner.onUpdateClicked(edtName.getText().toString(), getAdapterPosition());
            }
        });
    }
}
