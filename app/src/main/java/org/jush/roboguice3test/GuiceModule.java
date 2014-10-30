package org.jush.roboguice3test;

import android.app.Application;

import com.google.inject.AbstractModule;

public class GuiceModule extends AbstractModule {
    private Application application;

    public GuiceModule(Application application) {
        this.application = application;
    }

    @Override
    protected void configure() {
    }
}
