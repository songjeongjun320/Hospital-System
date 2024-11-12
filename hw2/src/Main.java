import javafx.application.Application;
import javafx.stage.Stage;
import controllers.MainPageController.MainPageController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        MainPageController controller = new MainPageController(primaryStage);
        controller.showMainPage();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
