package com.example.mygithubprofis;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private ArrayList<User>listUserAdapter;

    public UserAdapter(ArrayList<User> listUserAdapter) {
        this.listUserAdapter = listUserAdapter;
    }

    public void setListUserAdapter(ArrayList<User> listUserAdapter) {
        this.listUserAdapter = listUserAdapter;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.raw_user_list,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.bind(listUserAdapter.get(position));
    }

    @Override
    public int getItemCount() {
        return listUserAdapter.size();
    }
}
