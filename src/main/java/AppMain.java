import com.example.javafxguice.module.CrawlerModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class AppMain extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Injector injector = Guice.createInjector(new CrawlerModule());
		FXMLLoader fxmlLoader = injector.getInstance(FXMLLoader.class);

		try (InputStream fxmlInputStream = ClassLoader.getSystemResourceAsStream("com/example/javafxguice/view/sample.fxml")) {
			Parent parent = fxmlLoader.load(fxmlInputStream);
			primaryStage.setScene(new Scene(parent));
			primaryStage.setTitle("Javafx-guice-integration");
			primaryStage.show();
			primaryStage.setOnCloseRequest(e -> {
				System.exit(0);
			});
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
