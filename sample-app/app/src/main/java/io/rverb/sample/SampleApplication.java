package io.rverb.sample;

import android.app.Application;

import io.rverb.feedback.Rverbio;

public class SampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Rverbio.initialize(this);
        Rverbio.getInstance().getContextData().put("Test 2", "This happened at Application#onCreate");
    }
}
