package com.example.mygithubprofis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Button btnDisplay;
    public static final String ID_KEY = "ID_KEY";
    public ArrayList<User>myUserList=new ArrayList<>();
    public static String USERS_LIST_PREFERENCE_KEY = "user_key";
    public static String USER_LIST_EXTRA ="userListExtra";
    private User user;
    private static Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDisplay=findViewById(R.id.btnDisplayProfil);
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                callService();
            }
        });

    }

    public void callService(){
        GithubProfilApi.GithubProfilService service =  GithubProfilApi.getInstance().getClient().create(GithubProfilApi.GithubProfilService.class);
            Call<List<User>> call= service.getUsers();
            call.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        updateView(response);
                }
                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {

                    onNetworkFailure();
                }
            });
    }

    private void updateView(Response<List<User>> response) {
        if (response.body().size() > 0) {
            myUserList = (ArrayList<User>) response.body();
            //Enregister ma userLis dans les preferences
            SharedPreferencesManager.getInstance(this).saveUserList(myUserList, USERS_LIST_PREFERENCE_KEY);
            Log.e("la liste", String.valueOf(myUserList.size()));
            Intent intent = new Intent(MainActivity.this, DisplayProfilActivity.class);
            intent.putExtra(USER_LIST_EXTRA, myUserList);
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Reponse du serveur", Toast.LENGTH_SHORT).show();

        }
    }
    private void onNetworkFailure(){

        /*si j'ai es donnee dans le share preference je vais les afficher'*/
        Toast.makeText(MainActivity.this, "Impossible de reccuperer vos donnees veuillez verifier votre connexion internet", Toast.LENGTH_SHORT).show();
        if(SharedPreferencesManager.getInstance(MainActivity.this).getUserList(USERS_LIST_PREFERENCE_KEY).size()>0){
            Intent intent = new Intent(MainActivity.this, DisplayProfilActivity.class);
            ArrayList<User> userPreferencesList = new ArrayList<User> (SharedPreferencesManager.getInstance(MainActivity.this).getUserList(USERS_LIST_PREFERENCE_KEY));
            intent.putExtra(USER_LIST_EXTRA,userPreferencesList);
            startActivity(intent);
            //Toast.makeText(MainActivity.this, "Données du SharedPreferences", Toast.LENGTH_SHORT).show();
        }




    }




}