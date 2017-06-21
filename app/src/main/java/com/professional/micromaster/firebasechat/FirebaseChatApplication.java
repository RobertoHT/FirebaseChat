package com.professional.micromaster.firebasechat;

import android.app.Application;
import com.google.firebase.database.FirebaseDatabase;
import com.professional.micromaster.firebasechat.lib.GlideImageLoader;
import com.professional.micromaster.firebasechat.lib.ImageLoader;

public class FirebaseChatApplication extends Application {
    private ImageLoader imageLoader;

    @Override
    public void onCreate() {
        super.onCreate();
        setupFirebase();
        setupImageLoader();
    }

    private void setupImageLoader() {
        imageLoader = new GlideImageLoader(this);
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    private void setupFirebase(){
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
