package com.macadamian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class IntentsActivity extends Activity {
    static final String EXTRA_OPTION = "com.macadamian.intent.extra.OPTION";
    static final String EXTRA_RESULT = "com.macadamian.intent.extra.RESULT";

    static final String ACTION_RESULT = "com.macadamian.intent.action.RESULT";

    View.OnClickListener _click_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.intents_start_activity:
                        send();
                        break;
                    case R.id.intents_start_activity_for_result:
                        send_for_result();
                        break;
                }
            }
        };
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.intents);        
        connect();
    }

    private void connect() {
        findViewById(R.id.intents_start_activity).setOnClickListener(_click_listener);
        findViewById(R.id.intents_start_activity_for_result).setOnClickListener(_click_listener);
    }

    private Intent make_intent() {
        Intent rv = new Intent(this, IntentsStartedActivity.class);
        rv.putExtra(EXTRA_OPTION, get_option());
        return rv;
    }

    private void send() {
        startActivity(make_intent());
    }

    static final int REQUEST_CODE = 1;

    private void send_for_result() {
        startActivityForResult(make_intent(), REQUEST_CODE);
    }

    private int get_option() {
        switch (((RadioGroup) findViewById(R.id.intents_selected_option)).getCheckedRadioButtonId()) {
            case R.id.intents_radio_option_a:
                return 0;
                
            case R.id.intents_radio_option_b:
                return 1;
        }
        return -1;
    }

    private void show_result(Intent i) {
        ((TextView) findViewById(R.id.intents_result)).setText(i.getStringExtra(EXTRA_RESULT));
    }

    @Override
    protected void onActivityResult(int code, int result, Intent i) {
        if (Activity.RESULT_OK == result) {
            switch (code) {
                case REQUEST_CODE:
                    show_result(i);
                    break;
            }
        }
    }
}
