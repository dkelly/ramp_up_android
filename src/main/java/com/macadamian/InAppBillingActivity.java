package com.macadamian;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.macadamian.billing.IabHelper;
import com.macadamian.billing.IabResult;

public class InAppBillingActivity extends Activity {
    IabHelper mBillingHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != mBillingHelper) {
            mBillingHelper.dispose();
            mBillingHelper = null;
        }
    }
}
