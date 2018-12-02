package com.example.javafxguice.module;

import com.google.inject.AbstractModule;
import javafx.fxml.FXMLLoader;

public class CrawlerModule extends AbstractModule {

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		bind(FXMLLoader.class).toProvider(FXMLLoaderProvider.class);
	}
}
