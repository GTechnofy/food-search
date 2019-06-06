package com.gtechnofy.sample;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class FoodSearchActivity extends AppCompatActivity {

    private SearchView mSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_search);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.app_name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        mSearch = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        prepareSearchView();
        return true;
    }

    private void prepareSearchView() {
        mSearch.setQueryHint(getResources().getString(R.string.search_your_favorite_food));
        mSearch.setMaxWidth(Resources.getSystem().getDisplayMetrics().widthPixels);

        mSearch.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Hide the action bar title as search view expands
                getSupportActionBar().setTitle("");
            }
        });


        mSearch.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {

                // Show the action bar title as search view collapses
                getSupportActionBar().setTitle(R.string.app_name);
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.app_bar_search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
