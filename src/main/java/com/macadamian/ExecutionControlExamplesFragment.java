package com.macadamian;

import android.os.Bundle;

public class ExecutionControlExamplesFragment extends ExamplePreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        add("pref_intents", IntentsActivity.class);
    }

    @Override
    protected int getResourceId() {
        return R.xml.execution_control_examples;
    }
}
