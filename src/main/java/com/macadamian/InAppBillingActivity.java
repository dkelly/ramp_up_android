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
        mBillingHelper = new IabHelper(
            this,
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlL1EsvhmqS2wRpNmdQiFWSgvGXLSoP6c2upVrAHS1+96HYyNLxW8nVOp2gij5N1kUMwBKRuOBko7OHDrOIQiL6k2KNcYzeFe7L++8H5QZzjyDsNOO3vIBpk8FoPeQlq81ZzEbJsqr71BABgxV8gFzCJzXg6nhciEVXXgEWCS7b2MbA4oOX85drYYJTYLTOzVCb3tM2wcK+FNh06NlqGqHHoDSjSuBpkUmyASmMnY2etqUhKL36iztIdALQnswTYEJXV3nAxtDPAy7aov7Hhhvc0wea1lrg92ZtHj6/RBl7jwFcz6KXyGDDI17SSc5aWZMMqFFBGkS+7EdckI2gBbfwIDAQAB");
        mBillingHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
                public void onIabSetupFinished(IabResult r) {
                    if (!r.isSuccess()) {
                        Log.e("rampup", "failed to setup IAB: " + r);
                    }
                }
            });
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
