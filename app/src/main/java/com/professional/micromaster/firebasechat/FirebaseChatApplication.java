package com.professional.micromaster.firebasechat;

import android.app.Application;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseChatApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        setupFirebase();
    }

    private void setupFirebase(){
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
