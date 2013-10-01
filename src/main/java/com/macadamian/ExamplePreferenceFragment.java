package com.macadamian;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;

import java.util.HashMap;
import java.util.Map;

public abstract class ExamplePreferenceFragment extends PreferenceFragment {
    private Map<String, Class<?>> _klasses = new HashMap<String, Class<?>>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(getResourceId());
    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen screen, Preference pref) {
        String key = pref.getKey();
        if (_klasses.containsKey(key)) {
            getActivity().startActivity(new Intent(getActivity(), _klasses.get(key)));
            return true;
        }

        return false;
    }

    protected void add(String key, Class<?> klass) {
        _klasses.put(key, klass);
    }

    protected abstract int getResourceId();
}
