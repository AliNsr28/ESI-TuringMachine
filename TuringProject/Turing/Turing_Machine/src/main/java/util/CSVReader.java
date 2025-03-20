package util;

import model.Code;
import model.Factory;
import model.Problem;
import model.validator.Validator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Code;
import model.Problem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class reads data from a CSV file containing known problems and their associated validators.
 */
public class CSVReader {

    /**
     * The secret code associated with the problems.
     */
    private Code codeSecret;

    /**
     * List to store the read problems.
     */
    private List<Problem> problemos;

    /**
     * List to store the indices of the validators.
     */
    private List<Integer> validator_index = new ArrayList<>();

    /**
     * Constructor for the CSVReader class.
     * Initializes the list of problems and reads data from the CSV file.
     */
    public CSVReader() {
        problemos = new ArrayList<>();
        filepath();
    }

    /**
     * Reads data from the CSV file containing known problems and their associated validators.
     */
    public void filepath() {
        String path = "/Users/byron/atlg3_projetfini/atlg3_61308/Turing/Turing_Machine/src/main/resources/TuringMachine-assets-20231127/known_problems.csv";
        String line = "";
        int minimumNumberOfColumns = 4; // Minimum number of columns expected before validators

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine(); // Ignore the header

            while ((line = br.readLine()) != null) {
                // Check if the line is empty
                if (line.trim().isEmpty()) {
                    continue; // Move to the next line if it is empty
                }

                String[] values = line.split(",");
                // Check if the number of values is at least the minimum expected
                if (values.length < minimumNumberOfColumns) {
                    continue; // Move to the next line if the number of values is insufficient
                }

                // Basic data processing
                int num = Integer.parseInt(values[0]);
                int difficulty = Integer.parseInt(values[1]);
                int luck = Integer.parseInt(values[2]);
                int code = Integer.parseInt(values[3]);
                List<Integer> validatorList = new ArrayList<>(); // Create a list of validators for the problem
                for (int i = 4; i < values.length; i++) {
                    try {
                        int id = Integer.parseInt(values[i]);
                        this.codeSecret = new Code(code);
                        validatorList.add(id);
                    } catch (NumberFormatException e) {
                        // Handle cases where conversion to integer fails
                        e.printStackTrace();
                    }
                }

                this.problemos.add(new Problem(num, difficulty, luck, code, validatorList));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the list of problems read from the CSV file.
     *
     * @return List of problems.
     */
    public List<Problem> getProblems() {
        return this.problemos;
    }
}
