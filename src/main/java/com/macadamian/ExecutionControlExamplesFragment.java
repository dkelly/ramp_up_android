package com.macadamian;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class ExecutionControlExamplesFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.execution_control_examples);
    }
}
