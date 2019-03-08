package com.hjapps.sinpefacil.sinpefacil;

import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.os.Bundle;

public class ConfigActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new ConfigPreferenceFragment()).commit();
    }

    public static class ConfigPreferenceFragment extends PreferenceFragment
    {
        @Override
        public void onCreate(final Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
    }
}
