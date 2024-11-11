import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class hw2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        jun_createMainUI(primaryStage);
    }

    // Main UI with buttons
    private void jun_createMainUI(Stage stage) {
        stage.setTitle("Heart Health Imaging and Recording System");

        Button jun_patientIntakeBtn = new Button("Patient Intake");
        jun_patientIntakeBtn.setOnAction(event -> jun_openPatientIntake(stage)); // 오타 수정됨

        Button jun_ctScanTechBtn = new Button("CT Scan Tech View");
        jun_ctScanTechBtn.setOnAction(e -> jun_openCTScanTech(stage));

        Button jun_patientViewBtn = new Button("Patient View");
        jun_patientViewBtn.setOnAction(e -> jun_openPatientView(stage));

        Button jun_doctorViewBtn = new Button("Doctor View");
        jun_doctorViewBtn.setOnAction(e -> jun_openDoctorView(stage));

        GridPane jun_grid = new GridPane();
        jun_grid.setPadding(new Insets(10, 10, 10, 10));
        jun_grid.setVgap(10);
        jun_grid.setHgap(10);
        jun_grid.add(jun_patientIntakeBtn, 0, 0);
        jun_grid.add(jun_ctScanTechBtn, 0, 1);
        jun_grid.add(jun_patientViewBtn, 0, 2);
        jun_grid.add(jun_doctorViewBtn, 0, 3);

        Scene jun_scene = new Scene(jun_grid, 300, 250);
        stage.setScene(jun_scene);
        stage.show();
    }

    // Patient Intake Form
    private void jun_openPatientIntake(Stage stage) {
        stage.setTitle("Patient Intake Form");

        GridPane jun_grid = new GridPane();
        jun_grid.setPadding(new Insets(10, 10, 10, 10));
        jun_grid.setVgap(10);
        jun_grid.setHgap(10);

        TextField jun_firstName = new TextField();
        jun_firstName.setPromptText("First Name");
        jun_grid.add(new Label("First Name:"), 0, 0);
        jun_grid.add(jun_firstName, 1, 0);

        TextField jun_lastName = new TextField();
        jun_lastName.setPromptText("Last Name");
        jun_grid.add(new Label("Last Name:"), 0, 1);
        jun_grid.add(jun_lastName, 1, 1);

        TextField jun_email = new TextField();
        jun_email.setPromptText("Email");
        jun_grid.add(new Label("Email:"), 0, 2);
        jun_grid.add(jun_email, 1, 2);

        TextField jun_phoneNumber = new TextField();
        jun_phoneNumber.setPromptText("Phone Number");
        jun_grid.add(new Label("Phone Number:"), 0, 3);
        jun_grid.add(jun_phoneNumber, 1, 3);

        TextField jun_healthHistory = new TextField();
        jun_healthHistory.setPromptText("Health History");
        jun_grid.add(new Label("Health History:"), 0, 4);
        jun_grid.add(jun_healthHistory, 1, 4);

        TextField jun_insuranceID = new TextField();
        jun_insuranceID.setPromptText("Insurance ID");
        jun_grid.add(new Label("Insurance ID:"), 0, 5);
        jun_grid.add(jun_insuranceID, 1, 5);

        Button jun_saveBtn = new Button("Save");
        jun_grid.add(jun_saveBtn, 1, 6);

        jun_saveBtn.setOnAction(e -> {
            String firstName = jun_firstName.getText();
            String lastName = jun_lastName.getText();
            String email = jun_email.getText();
            String phoneNumber = jun_phoneNumber.getText();
            String healthHistory = jun_healthHistory.getText();
            String insuranceID = jun_insuranceID.getText();

            // 입력한 정보를 콘솔에 출력
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Email: " + email);
            System.out.println("Phone Number: " + phoneNumber);
            System.out.println("Health History: " + healthHistory);
            System.out.println("Insurance ID: " + insuranceID);
        });

        Scene jun_scene = new Scene(jun_grid, 400, 300);
        stage.setScene(jun_scene);
        stage.show();
    }

    // CT Scan Technician View
    private void jun_openCTScanTech(Stage stage) {
        stage.setTitle("CT Scan Technician View");

        GridPane jun_grid = new GridPane();
        jun_grid.setPadding(new Insets(10, 10, 10, 10));
        jun_grid.setVgap(10);
        jun_grid.setHgap(10);

        TextField jun_patientID = new TextField();
        jun_patientID.setPromptText("Patient ID");
        jun_grid.add(new Label("Patient ID:"), 0, 0);
        jun_grid.add(jun_patientID, 1, 0);

        TextField jun_totalScore = new TextField();
        jun_totalScore.setPromptText("Total Agatston CAC Score");
        jun_grid.add(new Label("Total Agatston CAC Score:"), 0, 1);
        jun_grid.add(jun_totalScore, 1, 1);

        TextField jun_LM = new TextField();
        jun_LM.setPromptText("LM");
        jun_grid.add(new Label("LM:"), 0, 2);
        jun_grid.add(jun_LM, 1, 2);

        TextField jun_LAD = new TextField();
        jun_LAD.setPromptText("LAD");
        jun_grid.add(new Label("LAD:"), 0, 3);
        jun_grid.add(jun_LAD, 1, 3);

        TextField jun_LCX = new TextField();
        jun_LCX.setPromptText("LCX");
        jun_grid.add(new Label("LCX:"), 0, 4);
        jun_grid.add(jun_LCX, 1, 4);

        TextField jun_RCA = new TextField();
        jun_RCA.setPromptText("RCA");
        jun_grid.add(new Label("RCA:"), 0, 5);
        jun_grid.add(jun_RCA, 1, 5);

        TextField jun_PDA = new TextField();
        jun_PDA.setPromptText("PDA");
        jun_grid.add(new Label("PDA:"), 0, 6);
        jun_grid.add(jun_PDA, 1, 6);

        Button jun_saveBtn = new Button("Save");
        jun_grid.add(jun_saveBtn, 1, 7);

        jun_saveBtn.setOnAction(e -> {
            String patientID = jun_patientID.getText();
            String totalScore = jun_totalScore.getText();
            String LM = jun_LM.getText();
            String LAD = jun_LAD.getText();
            String LCX = jun_LCX.getText();
            String RCA = jun_RCA.getText();
            String PDA = jun_PDA.getText();

            // 데이터 콘솔 출력
            System.out.println("Patient ID: " + patientID);
            System.out.println("Total Agatston CAC Score: " + totalScore);
            System.out.println("LM: " + LM);
            System.out.println("LAD: " + LAD);
            System.out.println("LCX: " + LCX);
            System.out.println("RCA: " + RCA);
            System.out.println("PDA: " + PDA);
        });

        Scene jun_scene = new Scene(jun_grid, 400, 400);
        stage.setScene(jun_scene);
        stage.show();
    }

    // Patient View
    private void jun_openPatientView(Stage stage) {
        stage.setTitle("Patient View");

        GridPane jun_grid = new GridPane();
        jun_grid.setPadding(new Insets(10, 10, 10, 10));
        jun_grid.setVgap(10);
        jun_grid.setHgap(10);

        Label jun_patientNameLabel = new Label("Hello <Patient Name>");
        jun_grid.add(jun_patientNameLabel, 0, 0, 2, 1);

        TextField jun_totalScore = new TextField();
        jun_totalScore.setPromptText("Total Agatston CAC Score");
        jun_grid.add(new Label("Total Agatston CAC Score:"), 0, 1);
        jun_grid.add(jun_totalScore, 1, 1);

        TextField jun_LM = new TextField();
        jun_LM.setPromptText("LM");
        jun_grid.add(new Label("LM:"), 0, 2);
        jun_grid.add(jun_LM, 1, 2);

        TextField jun_LAD = new TextField();
        jun_LAD.setPromptText("LAD");
        jun_grid.add(new Label("LAD:"), 0, 3);
        jun_grid.add(jun_LAD, 1, 3);

        TextField jun_LCX = new TextField();
        jun_LCX.setPromptText("LCX");
        jun_grid.add(new Label("LCX:"), 0, 4);
        jun_grid.add(jun_LCX, 1, 4);

        TextField jun_RCA = new TextField();
        jun_RCA.setPromptText("RCA");
        jun_grid.add(new Label("RCA:"), 0, 5);
        jun_grid.add(jun_RCA, 1, 5);

        TextField jun_PDA = new TextField();
        jun_PDA.setPromptText("PDA");
        jun_grid.add(new Label("PDA:"), 0, 6);
        jun_grid.add(jun_PDA, 1, 6);

        Scene jun_scene = new Scene(jun_grid, 400, 350);
        stage.setScene(jun_scene);
        stage.show();
    }

    // Doctor View
    private void jun_openDoctorView(Stage stage) {
        stage.setTitle("Doctor View");

        GridPane jun_grid = new GridPane();
        jun_grid.setPadding(new Insets(10, 10, 10, 10));
        jun_grid.setVgap(10);
        jun_grid.setHgap(10);

        TextField jun_totalScore = new TextField();
        jun_totalScore.setPromptText("Total Agatston CAC Score");
        jun_grid.add(new Label("Total Agatston CAC Score:"), 0, 0);
        jun_grid.add(jun_totalScore, 1, 0);

        TextField jun_LM = new TextField();
        jun_LM.setPromptText("LM");
        jun_grid.add(new Label("LM:"), 0, 1);
        jun_grid.add(jun_LM, 1, 1);

        TextField jun_LAD = new TextField();
        jun_LAD.setPromptText("LAD");
        jun_grid.add(new Label("LAD:"), 0, 2);
        jun_grid.add(jun_LAD, 1, 2);

        TextField jun_LCX = new TextField();
        jun_LCX.setPromptText("LCX");
        jun_grid.add(new Label("LCX:"), 0, 3);
        jun_grid.add(jun_LCX, 1, 3);

        TextField jun_RCA = new TextField();
        jun_RCA.setPromptText("RCA");
        jun_grid.add(new Label("RCA:"), 0, 4);
        jun_grid.add(jun_RCA, 1, 4);

        TextField jun_PDA = new TextField();
        jun_PDA.setPromptText("PDA");
        jun_grid.add(new Label("PDA:"), 0, 5);
        jun_grid.add(jun_PDA, 1, 5);

        Button jun_riskBtn = new Button("Determine Risk");
        jun_grid.add(jun_riskBtn, 1, 6);

        jun_riskBtn.setOnAction(e -> {
            String totalScoreStr = jun_totalScore.getText();
            int totalScore = Integer.parseInt(totalScoreStr);

            String riskMessage;
            if (totalScore == 0) {
                riskMessage = "Zero: No plaque. Your risk of heart attack is low.";
            } else if (totalScore <= 10) {
                riskMessage = "Small amount of plaque. Less than 10% chance of heart disease.";
            } else if (totalScore <= 100) {
                riskMessage = "Some plaque. Mild heart disease and moderate heart attack risk.";
            } else if (totalScore <= 400) {
                riskMessage = "Moderate plaque. Moderate to high risk of heart attack.";
            } else {
                riskMessage = "Large plaque. High risk of heart attack.";
            }

            System.out.println("Risk Evaluation: " + riskMessage);
        });

        Scene jun_scene = new Scene(jun_grid, 400, 350);
        stage.setScene(jun_scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
