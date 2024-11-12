package controllers.MainPageController;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class MainPageController {
    private Stage jun_stage;

    public MainPageController(Stage jun_stage) {
        this.jun_stage = jun_stage;
    }

    // Main Page
    public void showMainPage() {
        jun_stage.setTitle("Heart Health Imaging and Recording System");

        Label jun_titleLabel = new Label("Welcome to Heart Health Imaging and Recording System");
        jun_titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        
        VBox titleBox = new VBox(jun_titleLabel);
        titleBox.setAlignment(Pos.CENTER);  // Center alignment
        titleBox.setPadding(new Insets(10));

        Button jun_patientIntakeBtn = new Button("Patient Intake");
        Button jun_ctScanTechBtn = new Button("CT Scan Tech View");
        Button jun_patientViewBtn = new Button("Patient View");

        String jun_buttonStyle = "-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-pref-width: 200px; -fx-pref-height: 40px;";
        jun_patientIntakeBtn.setStyle(jun_buttonStyle);
        jun_ctScanTechBtn.setStyle(jun_buttonStyle);
        jun_patientViewBtn.setStyle(jun_buttonStyle);

        jun_patientIntakeBtn.setOnAction(event -> showPatientIntakePage());
        jun_ctScanTechBtn.setOnAction(event -> showCTScanTechPage());
        jun_patientViewBtn.setOnAction(event -> showPatientIDInputPage());

        VBox jun_layout = new VBox(20, titleBox, jun_patientIntakeBtn, jun_ctScanTechBtn, jun_patientViewBtn);
        jun_layout.setAlignment(Pos.CENTER);
        jun_layout.setPadding(new Insets(20));

        Scene jun_scene = new Scene(jun_layout, 1000, 500);
        jun_stage.setScene(jun_scene);
        jun_stage.show();
    }

    // Patient Intake Page
    public void showPatientIntakePage() {
        jun_stage.setTitle("Patient Intake Form");

        GridPane jun_grid = new GridPane();
        jun_grid.setPadding(new Insets(10));
        jun_grid.setVgap(10);
        jun_grid.setHgap(10);

        // Title label for center alignment
        Label titleLabel = new Label("Patient Intake Form");
        titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        VBox titleBox = new VBox(titleLabel);
        titleBox.setAlignment(Pos.CENTER);  // Center alignment
        jun_grid.add(titleBox, 0, 0, 2, 1);

        TextField jun_firstName = new TextField();
        jun_firstName.setPromptText("First Name");
        jun_firstName.setAlignment(Pos.CENTER_LEFT);
        jun_grid.add(new Label("First Name:"), 0, 1);
        jun_grid.add(jun_firstName, 1, 1);

        TextField jun_lastName = new TextField();
        jun_lastName.setPromptText("Last Name");
        jun_lastName.setAlignment(Pos.CENTER_LEFT);
        jun_grid.add(new Label("Last Name:"), 0, 2);
        jun_grid.add(jun_lastName, 1, 2);

        TextField jun_email = new TextField();
        jun_email.setPromptText("Email");
        jun_email.setAlignment(Pos.CENTER_LEFT);
        jun_grid.add(new Label("Email:"), 0, 3);
        jun_grid.add(jun_email, 1, 3);

        TextField jun_phoneNumber = new TextField();
        jun_phoneNumber.setPromptText("Phone Number");
        jun_phoneNumber.setAlignment(Pos.CENTER_LEFT);
        jun_grid.add(new Label("Phone Number:"), 0, 4);
        jun_grid.add(jun_phoneNumber, 1, 4);

        TextField jun_healthHistory = new TextField();
        jun_healthHistory.setPromptText("Health History");
        jun_healthHistory.setAlignment(Pos.CENTER_LEFT);
        jun_grid.add(new Label("Health History:"), 0, 5);
        jun_grid.add(jun_healthHistory, 1, 5);

        TextField jun_insuranceID = new TextField();
        jun_insuranceID.setPromptText("Insurance ID");
        jun_insuranceID.setAlignment(Pos.CENTER_LEFT);
        jun_grid.add(new Label("Insurance ID:"), 0, 6);
        jun_grid.add(jun_insuranceID, 1, 6);

        Button jun_saveBtn = new Button("Save");
        HBox buttonBox = new HBox(jun_saveBtn);
        buttonBox.setAlignment(Pos.CENTER);  // Center alignment
        jun_grid.add(buttonBox, 1, 7);
        GridPane.setMargin(jun_saveBtn, new Insets(10, 0, 0, 0));

        jun_saveBtn.setOnAction(event -> {
            int jun_patientID = generatePatientID();

            savePatientInfo(jun_patientID, jun_firstName.getText(), jun_lastName.getText(),
                    jun_email.getText(), jun_phoneNumber.getText(), jun_healthHistory.getText(), jun_insuranceID.getText());

            System.out.println("Saved Patient Intake Information for ID: " + jun_patientID);
            showMainPage();
        });

        Scene jun_scene = new Scene(jun_grid, 1000, 500);
        jun_stage.setScene(jun_scene);
    }

    // Generates a unique 5-digit patient ID
    private int generatePatientID() {
        Random jun_random = new Random();
        return 10000 + jun_random.nextInt(90000);
    }

    // Saves patient information to a file
    private void savePatientInfo(int jun_patientID, String jun_firstName, String jun_lastName,
                                 String jun_email, String jun_phoneNumber, String jun_healthHistory, String jun_insuranceID) {
        String jun_directoryPath = "hw2/db";
        File jun_directory = new File(jun_directoryPath);
        
        if (!jun_directory.exists()) {
            jun_directory.mkdirs();
        }

        String jun_filePath = jun_directoryPath + "/" + jun_patientID + "_PatientInfo.txt";

        try (BufferedWriter jun_writer = new BufferedWriter(new FileWriter(jun_filePath))) {
            jun_writer.write("Patient ID: " + jun_patientID);
            jun_writer.newLine();
            jun_writer.write("First Name: " + jun_firstName);
            jun_writer.newLine();
            jun_writer.write("Last Name: " + jun_lastName);
            jun_writer.newLine();
            jun_writer.write("Email: " + jun_email);
            jun_writer.newLine();
            jun_writer.write("Phone Number: " + jun_phoneNumber);
            jun_writer.newLine();
            jun_writer.write("Health History: " + jun_healthHistory);
            jun_writer.newLine();
            jun_writer.write("Insurance ID: " + jun_insuranceID);
            jun_writer.newLine();
            jun_writer.write("Appointment Date: (Reserved)");
            System.out.println("File saved at: " + jun_filePath);
        } catch (IOException e) {
            System.err.println("Error saving patient information: " + e.getMessage());
        }
    }

    // CT Scan Technician Page
    public void showCTScanTechPage() {
        jun_stage.setTitle("CT Scan Technician View");

        GridPane jun_grid = new GridPane();
        jun_grid.setPadding(new Insets(20));
        jun_grid.setVgap(10);
        jun_grid.setHgap(10);

        // Center/left alignment for each field and label
        Label titleLabel = new Label("CT Scan Technician View");
        titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        VBox titleBox = new VBox(titleLabel);
        titleBox.setAlignment(Pos.CENTER);  // Center alignment
        jun_grid.add(titleBox, 0, 0, 2, 1);

        TextField jun_patientID = new TextField();
        jun_patientID.setPromptText("Patient ID");
        jun_patientID.setAlignment(Pos.CENTER_LEFT);
        jun_grid.add(new Label("Patient ID:"), 0, 1);
        jun_grid.add(jun_patientID, 1, 1);

        TextField jun_totalScore = new TextField();
        jun_totalScore.setPromptText("Total Agatston CAC Score");
        jun_totalScore.setAlignment(Pos.CENTER_LEFT);
        jun_grid.add(new Label("The total Agatston CAC score"), 0, 2);
        jun_grid.add(jun_totalScore, 1, 2);

        Label jun_vesselLevelLabel = new Label("Vessel level Agatston CAC score");
        jun_vesselLevelLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        jun_grid.add(jun_vesselLevelLabel, 0, 3, 2, 1);

        // CAC score fields
        TextField jun_LM = new TextField();
        jun_LM.setPromptText("LM");
        jun_LM.setAlignment(Pos.CENTER_LEFT);
        jun_grid.add(new Label("LM:"), 0, 4);
        jun_grid.add(jun_LM, 1, 4);

        TextField jun_LAD = new TextField();
        jun_LAD.setPromptText("LAD");
        jun_LAD.setAlignment(Pos.CENTER_LEFT);
        jun_grid.add(new Label("LAD:"), 0, 5);
        jun_grid.add(jun_LAD, 1, 5);

        TextField jun_LCX = new TextField();
        jun_LCX.setPromptText("LCX");
        jun_LCX.setAlignment(Pos.CENTER_LEFT);
        jun_grid.add(new Label("LCX:"), 0, 6);
        jun_grid.add(jun_LCX, 1, 6);

        TextField jun_RCA = new TextField();
        jun_RCA.setPromptText("RCA");
        jun_RCA.setAlignment(Pos.CENTER_LEFT);
        jun_grid.add(new Label("RCA:"), 0, 7);
        jun_grid.add(jun_RCA, 1, 7);

        TextField jun_PDA = new TextField();
        jun_PDA.setPromptText("PDA");
        jun_PDA.setAlignment(Pos.CENTER_LEFT);
        jun_grid.add(new Label("PDA:"), 0, 8);
        jun_grid.add(jun_PDA, 1, 8);

        Button jun_saveBtn = new Button("Save");
        jun_saveBtn.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold;");
        HBox buttonBox = new HBox(jun_saveBtn);
        buttonBox.setAlignment(Pos.CENTER);  // Center alignment
        jun_grid.add(buttonBox, 1, 9);
        GridPane.setMargin(jun_saveBtn, new Insets(20, 0, 0, 0));

        jun_saveBtn.setOnAction(event -> {
            if (isAnyFieldEmpty(jun_patientID, jun_totalScore, jun_LM, jun_LAD, jun_LCX, jun_RCA, jun_PDA)) {
                showErrorAlert("All fields must be filled before saving.");
            } else {
                int jun_id = Integer.parseInt(jun_patientID.getText().trim());
                saveCTScanData(jun_id, jun_totalScore.getText(), jun_LM.getText(), jun_LAD.getText(), jun_LCX.getText(), jun_RCA.getText(), jun_PDA.getText());
                showMainPage();
            }
        });

        Scene jun_scene = new Scene(jun_grid, 600, 400);
        jun_stage.setScene(jun_scene);
        jun_stage.show();
    }

    // Checks if any field is empty
    private boolean isAnyFieldEmpty(TextField... jun_fields) {
        for (TextField jun_field : jun_fields) {
            if (jun_field.getText().trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    // Displays an error message
    private void showErrorAlert(String jun_message) {
        Alert jun_alert = new Alert(AlertType.ERROR);
        jun_alert.setTitle("Error");
        jun_alert.setHeaderText(null);
        jun_alert.setContentText(jun_message);
        jun_alert.showAndWait();
    }

    // Saves CT scan data to a file
    private void saveCTScanData(int jun_patientID, String jun_totalScore, String jun_LM, String jun_LAD, String jun_LCX, String jun_RCA, String jun_PDA) {
        String jun_directoryPath = "hw2/db";
        String jun_ctResultsFilePath = jun_directoryPath + "/" + jun_patientID + "CTResults.txt";
    
        File jun_directory = new File(jun_directoryPath);
        File[] jun_files = jun_directory.listFiles();
    
        if (jun_files == null) {
            showErrorAlert("No files found in directory: " + jun_directoryPath);
            return;
        }
    
        File jun_patientFile = null;
        for (File jun_file : jun_files) {
            String jun_fileName = jun_file.getName();
            if (jun_fileName.startsWith(String.valueOf(jun_patientID)) && jun_fileName.endsWith("_PatientInfo.txt")) {
                jun_patientFile = jun_file;
                break;
            }
        }
    
        if (jun_patientFile == null) {
            showErrorAlert("Patient file not found for ID: " + jun_patientID);
            return;
        }
    
        try (BufferedReader jun_reader = new BufferedReader(new FileReader(jun_patientFile));
             BufferedWriter jun_writer = new BufferedWriter(new FileWriter(jun_ctResultsFilePath))) {
            
            String jun_line;
            while ((jun_line = jun_reader.readLine()) != null) {
                jun_writer.write(jun_line);
                jun_writer.newLine();
            }
    
            jun_writer.write("Total Agatston CAC Score: " + jun_totalScore);
            jun_writer.newLine();
            jun_writer.write("Vessel level Agatston CAC score:");
            jun_writer.newLine();
            jun_writer.write("LM: " + jun_LM);
            jun_writer.newLine();
            jun_writer.write("LAD: " + jun_LAD);
            jun_writer.newLine();
            jun_writer.write("LCX: " + jun_LCX);
            jun_writer.newLine();
            jun_writer.write("RCA: " + jun_RCA);
            jun_writer.newLine();
            jun_writer.write("PDA: " + jun_PDA);
            jun_writer.newLine();
    
            System.out.println("CT Scan data saved to " + jun_ctResultsFilePath);
        } catch (IOException e) {
            showErrorAlert("Error saving CT scan data: " + e.getMessage());
        }
    }
    
    // Patient ID input page
    public void showPatientIDInputPage() {
        jun_stage.setTitle("Enter Patient ID");

        GridPane jun_grid = new GridPane();
        jun_grid.setPadding(new Insets(20));
        jun_grid.setVgap(10);
        jun_grid.setHgap(10);

        TextField jun_patientIDField = new TextField();
        jun_patientIDField.setPromptText("Enter Patient ID");
        jun_grid.add(new Label("Patient ID:"), 0, 0);
        jun_grid.add(jun_patientIDField, 1, 0);

        Button jun_submitBtn = new Button("Submit");
        jun_grid.add(jun_submitBtn, 1, 1);
        GridPane.setMargin(jun_submitBtn, new Insets(10, 0, 0, 0));

        jun_submitBtn.setOnAction(event -> {
            String jun_patientID = jun_patientIDField.getText().trim();
            if (jun_patientID.isEmpty()) {
                showErrorAlert("Please enter a valid Patient ID.");
                return;
            }

            Map<String, String> jun_patientData = loadPatientCTResults(jun_patientID);
            if (jun_patientData != null) {
                showPatientViewPage(jun_patientID, jun_patientData);
            }
        });

        Scene jun_scene = new Scene(jun_grid, 400, 200);
        jun_stage.setScene(jun_scene);
        jun_stage.show();
    }

    // Loads patient data from CT results file
    private Map<String, String> loadPatientCTResults(String jun_patientID) {
        String jun_directoryPath = "hw2/db";
        String jun_filePath = jun_directoryPath + "/" + jun_patientID + "CTResults.txt";
        File jun_file = new File(jun_filePath);

        if (!jun_file.exists()) {
            showErrorAlert("No CT results found for Patient ID: " + jun_patientID);
            return null;
        }

        Map<String, String> jun_data = new HashMap<>();

        try (BufferedReader jun_reader = new BufferedReader(new FileReader(jun_file))) {
            String jun_line;
            while ((jun_line = jun_reader.readLine()) != null) {
                if (jun_line.contains(":")) {
                    String[] jun_parts = jun_line.split(":", 2);
                    String jun_key = jun_parts[0].trim();
                    String jun_value = jun_parts.length > 1 ? jun_parts[1].trim() : "";
                    jun_data.put(jun_key, jun_value);
                }
            }
            return jun_data;
        } catch (IOException e) {
            showErrorAlert("Error reading CT results for Patient ID: " + jun_patientID);
            return null;
        }
    }

    // Patient view page to display CT results
    public void showPatientViewPage(String jun_patientID, Map<String, String> jun_patientData) {
        jun_stage.setTitle("Patient View (Seeing the Results)");
    
        GridPane jun_grid = new GridPane();
        jun_grid.setPadding(new Insets(20));
        jun_grid.setVgap(10);
        jun_grid.setHgap(10);
    
        // Create HBox for title and center align
        HBox jun_titleBox = new HBox();
        jun_titleBox.setAlignment(Pos.CENTER); // Center align
    
        // Create label for patient name and set style
        Label jun_patientNameLabel = new Label("Hello " + jun_patientData.getOrDefault("First Name", "") + " " + jun_patientData.getOrDefault("Last Name", ""));
        jun_patientNameLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        
        // Add label to HBox
        jun_titleBox.getChildren().add(jun_patientNameLabel);
        
        // Add HBox to the first row of GridPane and span full width
        jun_grid.add(jun_titleBox, 0, 0, 2, 1); // Span full width
    
        // Total Agatston CAC Score field
        TextField jun_totalScore = new TextField(jun_patientData.getOrDefault("Total Agatston CAC Score", ""));
        jun_totalScore.setEditable(false);
        jun_grid.add(new Label("The total Agatston CAC score"), 0, 1);
        jun_grid.add(jun_totalScore, 1, 1);
    
        // Each vessel's CAC score fields
        TextField jun_LM = new TextField(jun_patientData.getOrDefault("LM", ""));
        jun_LM.setEditable(false);
        jun_grid.add(new Label("LM:"), 0, 2);
        jun_grid.add(jun_LM, 1, 2);
    
        TextField jun_LAD = new TextField(jun_patientData.getOrDefault("LAD", ""));
        jun_LAD.setEditable(false);
        jun_grid.add(new Label("LAD:"), 0, 3);
        jun_grid.add(jun_LAD, 1, 3);
    
        TextField jun_LCX = new TextField(jun_patientData.getOrDefault("LCX", ""));
        jun_LCX.setEditable(false);
        jun_grid.add(new Label("LCX:"), 0, 4);
        jun_grid.add(jun_LCX, 1, 4);
    
        TextField jun_RCA = new TextField(jun_patientData.getOrDefault("RCA", ""));
        jun_RCA.setEditable(false);
        jun_grid.add(new Label("RCA:"), 0, 5);
        jun_grid.add(jun_RCA, 1, 5);
    
        TextField jun_PDA = new TextField(jun_patientData.getOrDefault("PDA", ""));
        jun_PDA.setEditable(false);
        jun_grid.add(new Label("PDA:"), 0, 6);
        jun_grid.add(jun_PDA, 1, 6);
    
        Scene jun_scene = new Scene(jun_grid, 600, 400);
        jun_stage.setScene(jun_scene);
        jun_stage.show();
    }
    
}
