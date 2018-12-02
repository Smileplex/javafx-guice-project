package com.example.javafxguice.module;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import javafx.fxml.FXMLLoader;

public class FXMLLoaderProvider implements Provider<FXMLLoader> {
    @Inject
    Injector injector;

    public FXMLLoader get() {
        FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(p -> {
            return injector.getInstance(p);
        });
        return loader;
    }
}
