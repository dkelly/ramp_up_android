package com.macadamian;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.util.Log;
import android.view.View;

public class BasicUserInterfaceActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_user_interface);
        connect();
    }

    private void connect() {
        findViewById(R.id.basic_user_interface_confirm).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    update_result();
                }
            });
    }

    private void update_result() {
        TextView content = (TextView) findViewById(R.id.basic_user_interface_edit_content);
        TextView result = (TextView) findViewById(R.id.basic_user_interface_result);

        Log.d("donk", String.format("text=%s", content.getText()));

        result.setText(content.getText());
    }
}
