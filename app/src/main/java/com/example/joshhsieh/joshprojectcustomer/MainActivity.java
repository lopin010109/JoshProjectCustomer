package com.example.joshhsieh.joshprojectcustomer;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //bottomnavigation item 監聽器
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch(item.getItemId()) {
                case R.id.item_instantService:
                    fragment = new InstantServiceFragment();
                    changFragment(fragment);
                    setTitle(R.string.textInstantService);
                    return true;
                case R.id.item_statusService:
                    fragment = new StatusServiceFragment();
                    changFragment(fragment);
                    setTitle(R.string.textStatusService);
                    return true;
                default:
                    initContent();
                    break;

            }
            return false;
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        initContent();


    }

    //fragment 換頁管理
    private void changFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.commit();

    }
    //預設頁面
    private void initContent() {
        Fragment fragment = new InstantServiceFragment();
        changFragment(fragment);
        setTitle(R.string.textInstantService);
    }
    //聯絡櫃檯顯示於右上角的option item

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflatesr = getMenuInflater();

        inflatesr.inflate(R.menu.call_service_menu, menu);

        return true;
    }



    public void onCallClick(MenuItem item) {

        Toast.makeText(MainActivity.this,"已通知",Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        /* 取得返回堆疊內的記錄筆數 */
        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (keyCode == KeyEvent.KEYCODE_BACK && count == 0) {
            initContent();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

}
