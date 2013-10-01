package com.macadamian;

import android.os.Bundle;

public class UserInterfaceExamplesFragment extends ExamplePreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        add("pref_basic_user_interface", BasicUserInterfaceActivity.class);
    }

    @Override
    protected int getResourceId() {
        return R.xml.user_interface_examples;
    }
}
