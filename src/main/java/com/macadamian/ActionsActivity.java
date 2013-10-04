package com.macadamian;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ActionsActivity extends Activity {
    static final String EXTRA_OPTION = "com.macadamian.intent.extra.OPTION";
    static final String EXTRA_RESULT = "com.macadamian.intent.extra.RESULT";

    static final String ACTION_RESULT = "com.macadamian.intent.action.RESULT";

    View.OnClickListener _click_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.actions_action_browse:
                        view(make_web_uri());
                        break;
                    case R.id.actions_action_call:
                        view(make_tel_uri());
                        break;

                    case R.id.actions_action_dial:
                        dial(make_tel_uri());
                        break;
                }
            }
        };
    
    TextWatcher _text_watcher = new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                enable_buttons(s.length() > 0);
            }
        };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.actions);        
        connect();
    }

    private void connect() {
        findViewById(R.id.actions_action_browse).setOnClickListener(_click_listener);
        findViewById(R.id.actions_action_call).setOnClickListener(_click_listener);
        findViewById(R.id.actions_action_dial).setOnClickListener(_click_listener);
        ((TextView) findViewById(R.id.actions_input_target)).addTextChangedListener(_text_watcher);
        enable_buttons();
    }

    private void enable_buttons() {
        enable_buttons(getTarget().length() > 0);
    }

    private void enable_buttons(boolean enable) {
        enable_button(R.id.actions_action_browse, enable && can_view(make_web_uri()));
        enable_button(R.id.actions_action_call, enable && can_view(make_tel_uri()));
        enable_button(R.id.actions_action_dial, enable && can_dial(make_tel_uri()));
    }

    private void enable_button(int resId, boolean enable) {
        ((Button) findViewById(resId)).setEnabled(enable);
        ((Button) findViewById(resId)).setClickable(enable);
    }

    private boolean isIntentSafe(Intent i) {
        PackageManager pm = getPackageManager();
        return pm.queryIntentActivities(i, 0).size() > 0;
    }

    private boolean can_view(Uri uri) {
        return isIntentSafe(new Intent(Intent.ACTION_VIEW, uri));
    }

    private boolean can_dial(Uri uri) {
        return isIntentSafe(new Intent(Intent.ACTION_DIAL, uri));
    }

    private void view(Uri uri) {
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    private void dial(Uri uri) {
        startActivity(new Intent(Intent.ACTION_DIAL, uri));
    }

    private Uri make_web_uri() {
        return Uri.parse("http://" + getTarget());
    }

    private Uri make_tel_uri() {
        return Uri.parse("tel:" + getTarget());
    }

    private CharSequence getTarget() {
        return ((TextView) findViewById(R.id.actions_input_target)).getText();
    }
}
