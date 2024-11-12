# Heart Health Imaging and Recording System

## Project Overview

This project is a Heart Health Imaging and Recording System, designed to input patient information, record CT scan results, and retrieve patient data. The application is built with JavaFX to create a user-friendly GUI that allows users to store and access patient information and CT scan data in text files.

## Features

1. **Main Page**: The main interface provides navigation buttons for patient intake, CT scan data entry, and viewing patient information.
2. **Patient Intake Form**: Allows users to input basic patient information, which is saved along with a unique 5-digit Patient ID. The data is stored in text files within the `hw2/db` directory.
3. **CT Scan Technician View**: Provides fields for entering CT scan data (such as the Agatston CAC score and vessel-level scores) based on a Patient ID. This data is saved in a separate text file within the same directory.
4. **Patient Data Viewing**: Enables users to retrieve and view patient CT scan results by entering the patient’s ID.

## Code Overview

- **MainPageController.java**: This file contains all the main functions for the application, including the GUI for patient intake, CT scan data entry, and patient data viewing.

### Key Methods

- `showMainPage()`: Displays the main page of the application with navigation options.
- `showPatientIntakePage()`: Shows the patient intake form, where users can enter and save patient information.
- `savePatientInfo(int patientID, String firstName, ...)`: Saves the entered patient information to a file in the `hw2/db` directory. The file is named `<patientID>_PatientInfo.txt` and includes an appointment date set to 3 days from the current date.
- `showCTScanTechPage()`: Displays the CT scan technician page for entering scan data.
- `saveCTScanData(int patientID, String totalScore, ...)`: Saves CT scan results to a file named `<patientID>CTResults.txt`, which includes both patient and scan data.
- `showPatientIDInputPage()`: Prompts the user to enter a Patient ID for data retrieval.
- `loadPatientCTResults(String patientID)`: Loads and retrieves CT scan data for a given Patient ID.
- `showPatientViewPage(String patientID, Map<String, String> patientData)`: Displays the retrieved patient data in a user-friendly format.

## Installation and Usage

1. **Set Up Directory**: Ensure a `hw2/db` directory exists in the root folder of the project for data storage.
2. **Run Application**: Compile and run the application. The main page will appear with options for entering patient data, recording CT scan data, and viewing patient information.
3. **Saving Data**: Enter required data in the patient intake and CT scan pages. Information is saved as text files in the `hw2/db` directory.
4. **Viewing Data**: Use the Patient View page to retrieve and view saved data by entering a Patient ID.

## Example File Structure

Upon saving patient and CT scan data, the `hw2/db` directory may contain files like:

- `12345_PatientInfo.txt`: Stores basic patient information and appointment date.
- `12345CTResults.txt`: Stores the patient's CT scan results including vessel-level CAC scores.

## Requirements

- JavaFX
- Java 8 or higher
