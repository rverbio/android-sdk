package io.rverb.sample;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import java.util.Locale;
import java.util.UUID;

import io.rverb.feedback.Rverbio;
import io.rverb.feedback.RverbioOptions;

public class SampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Rverbio.initialize(this, "2341b8bf-c50e-4fc1-9410-6c09b5dd0119", new RverbioOptions().setDebugMode(BuildConfig.DEBUG));
        Rverbio.getInstance().setUserIdentifier(getSupportId(this));
    }

    public static String getSupportId(@NonNull Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String supportId = prefs.getString("support_id", "");
        if (TextUtils.isEmpty(supportId)) {
            supportId = UUID.randomUUID().toString();
            prefs.edit().putString("support_id", supportId).apply();
        }

        return supportId;
    }
}
