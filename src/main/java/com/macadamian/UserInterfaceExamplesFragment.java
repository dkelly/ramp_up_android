package com.macadamian;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class UserInterfaceExamplesFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.user_interface_examples);
    }
}
