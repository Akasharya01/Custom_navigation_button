package com.example.customnavigationbottom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.util.Function;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.etebarian.meowbottomnavigation.MeowBottomNavigationCell;
import com.etebarian.meowbottomnavigation.MeowBottomNavigationKt;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    private final int ID_HOME = 1;
    private final int ID_MESSAGE = 2;
    private final int ID_NOTIFICATION = 3;
    private final int ID_ACCOUNT = 4;

    RelativeLayout home_layout, message_layout, notification_layout, account_layout;

    MeowBottomNavigation bottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home_layout = findViewById(R.id.home_layout);
        notification_layout = findViewById(R.id.notification_layout);
        message_layout = findViewById(R.id.message_layout);
        account_layout = findViewById(R.id.account_layout);

        home_layout.setVisibility(View.VISIBLE);
        message_layout.setVisibility(View.GONE);
        notification_layout.setVisibility(View.GONE);
        account_layout.setVisibility(View.GONE);


        MeowBottomNavigation bottomNavigation = findViewById(R.id.bottomnavigation);
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_HOME,R.drawable.home));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_MESSAGE,R.drawable.message));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_NOTIFICATION,R.drawable.notifications));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_ACCOUNT,R.drawable.person));


        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {

                switch (model.getId()){

                    case 1:
                        home_layout.setVisibility(View.VISIBLE);
                        message_layout.setVisibility(View.GONE);
                        notification_layout.setVisibility(View.GONE);
                        account_layout.setVisibility(View.GONE);
                        break;

                    case 2:
                        home_layout.setVisibility(View.GONE);
                        message_layout.setVisibility(View.VISIBLE);
                        notification_layout.setVisibility(View.GONE);
                        account_layout.setVisibility(View.GONE);
                        break;

                    case 3:
                        home_layout.setVisibility(View.GONE);
                        message_layout.setVisibility(View.GONE);
                        notification_layout.setVisibility(View.VISIBLE);
                        account_layout.setVisibility(View.GONE);
                        break;

                    case 4:
                        home_layout.setVisibility(View.GONE);
                        message_layout.setVisibility(View.GONE);
                        notification_layout.setVisibility(View.GONE);
                        account_layout.setVisibility(View.VISIBLE);
                        break;
                }
                return null;
            }
        });



    }
}