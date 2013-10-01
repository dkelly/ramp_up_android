package com.macadamian;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import java.util.List;

public class ExamplesSelectionActivity extends PreferenceActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.examples_sections, target);
    }
}

