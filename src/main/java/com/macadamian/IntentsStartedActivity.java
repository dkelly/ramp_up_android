package com.macadamian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class IntentsStartedActivity extends Activity {
    View.OnClickListener _click_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish_with_result();
            }
        };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.intents_started);
        findViewById(R.id.intents_started_action_confirm).setOnClickListener(_click_listener);
        ((TextView) findViewById(R.id.intents_started_provided_option)).setText(format_option());
    }

    private void finish_with_result() {
        setResult(Activity.RESULT_OK, get_result());
        finish();
    }

    private String format_option() {
        String rv = "Received option: ";

        Intent i = getIntent();
        switch (i.getIntExtra(IntentsActivity.EXTRA_OPTION, -1)) {
            case 0:
                rv += "A";
                break;
            case 1:
                rv += "B";
                break;
        }

        return rv;
    }

    private Intent get_result() {
        Intent rv = new Intent(IntentsActivity.ACTION_RESULT);
        Intent i = getIntent();
        switch (i.getIntExtra(IntentsActivity.EXTRA_OPTION, -1)) {
            case 0:
                rv.putExtra(IntentsActivity.EXTRA_RESULT, "option a");
                break;
            case 1:
                rv.putExtra(IntentsActivity.EXTRA_RESULT, "option b");
                break;
        }
        return rv;
    }
}
