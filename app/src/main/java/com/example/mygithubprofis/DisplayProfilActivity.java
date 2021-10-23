package com.example.mygithubprofis;

import static com.example.mygithubprofis.MainActivity.USERS_LIST_PREFERENCE_KEY;
import static com.example.mygithubprofis.MainActivity.USER_LIST_EXTRA;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DisplayProfilActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private UserAdapter adapterUser;
    private User user;
    private ArrayList<User>listUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_profil);

        //user=(User) getIntent().getSerializableExtra(USER_KEY);
        listUser= (ArrayList<User>) getIntent().getSerializableExtra(USER_LIST_EXTRA);
        //myUserList=new ArrayList<>(SharedPreferencesManager.getInstance(this).getUserList(USER_KEY));
        recyclerView=findViewById(R.id.recyclerViewDisplayProfil);
        setViewItem();
    }

    private void setViewItem(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterUser=new UserAdapter(listUser);
        recyclerView.setAdapter(adapterUser);
    }



}
