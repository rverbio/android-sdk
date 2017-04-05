package io.rverb.sample;

import android.app.Application;

import com.facebook.stetho.Stetho;

import io.rverb.feedback.Rverbio;

public class SampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initializeWithDefaults(this);

        Rverbio.initialize(this);
        Rverbio.getInstance().getContextData().put("Test 2", "This happened at Application#onCreate");
    }
}
