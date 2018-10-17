package com.yablonskyi;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);

        showList();
    }

    private void showList(){
        Gson gson = new Gson();
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(
                "UsersList", Context.MODE_PRIVATE);
        String jsonPreferences = sharedPref.getString("UsersList", "");
        Log.i("Users", jsonPreferences);

        Type type = new TypeToken<List<User>>() {}.getType();
        List<User> usersFromShared = gson.fromJson(jsonPreferences, type);
        Log.i("Users", usersFromShared.toString());

        ListView listView = findViewById(R.id.users_list);
        ArrayAdapter<User> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                usersFromShared);

        listView.setAdapter(arrayAdapter);
    }
}