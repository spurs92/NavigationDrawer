package com.spurs.navigationdrawer2;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;

    NavigationView naviDrawer;

    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=(DrawerLayout)findViewById(R.id.layout_drawer);
        naviDrawer=(NavigationView)findViewById(R.id.navi);
        //item icon에 색조를 적용하지 않도록.. 설정안하면 자동으로 회색으로 적용
        naviDrawer.setItemIconTintList(null);

        //드로우어 토글 버튼 생성
        drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.app_name,R.string.app_name);

        //토글버튼이 액션바 제목왼쪽에 보이도록
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //삼선아이콘 모양으로 보이도록 토글버튼의 동기 맞추기
        drawerToggle.syncState();

        //삼선아이콘과 화살표아이콘이 자동으로 변환되도록..
        drawerLayout.addDrawerListener(drawerToggle);

        //네비게이션뷰의 메뉴이이템을 클릭하는 것을 듣는 리스너 생성 및 설정
        naviDrawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.menu_gallery:
                        Toast.makeText(MainActivity.this, "갤러리", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_send:
                        Toast.makeText(MainActivity.this, "보내기", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_calendar:
                        Toast.makeText(MainActivity.this, "달력", Toast.LENGTH_SHORT).show();
                        break;
                }

                return false;
            }
        });

    }

    //사용자가 액션바에 있는 토글 버튼을 눌렀다라는 것을 인지하도록..
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        drawerToggle.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }
}
