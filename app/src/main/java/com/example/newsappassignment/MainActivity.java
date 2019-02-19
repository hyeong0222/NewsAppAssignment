package com.example.newsappassignment;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements HeadlineFragment.OnHeadlineSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onArticleSelected(int position, String item) {

        NewsFragment newsFragment = (NewsFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentNewsLarge);

        if (newsFragment != null) {
            newsFragment.updateArticleView(item);
        }
        else {
            NewsFragment newFragment = new NewsFragment();
            Bundle bundle = new Bundle();
            bundle.putString(NewsFragment.ARG_POSITION, item);
            newFragment.setArguments(bundle);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.fragmentHeadline, newFragment);
            transaction.addToBackStack(null);

            transaction.commit();
        }

    }
}
