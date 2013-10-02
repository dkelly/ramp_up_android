package com.macadamian;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import android.support.v7.app.ActionBarActivity;

public class ActionBarExampleActivity extends ActionBarActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_bar_example);
        setContent("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu m) {
        getMenuInflater().inflate(R.menu.action_bar_example, m);
        return super.onCreateOptionsMenu(m);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mi) {
        switch (mi.getItemId()) {
            case R.id.action_bar_example_action_search:
                setContent("Search clicked");
                return true;
            case R.id.action_bar_example_action_settings:
                setContent("Settings clicked");
                return true;
            default:
                return super.onOptionsItemSelected(mi);
        }
    }

    private void setContent(String content) {
        ((TextView) findViewById(R.id.action_bar_example_content)).setText(content);
    }
}

