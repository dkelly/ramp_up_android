package com.macadamian;

import android.os.Bundle;

public class SystemExamplesFragment extends ExamplePreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        add("pref_inapp_billing", InAppBillingActivity.class);
    }

    @Override
    protected int getResourceId() {
        return R.xml.system_examples;
    }
}
