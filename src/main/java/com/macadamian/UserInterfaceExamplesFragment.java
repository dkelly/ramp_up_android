package com.macadamian;

import android.os.Bundle;

public class UserInterfaceExamplesFragment extends ExamplePreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        add("pref_basic_user_interface", BasicUserInterfaceActivity.class);
        add("pref_simple_list_adapter", SimpleListAdapterActivity.class);
        add("pref_cursor_adapter", CursorAdapterActivity.class);
    }

    @Override
    protected int getResourceId() {
        return R.xml.user_interface_examples;
    }
}
