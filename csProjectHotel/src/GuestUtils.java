import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GuestUtils {

    public static String generateGuestId() {
        String fileName = "guest_sequence.txt";
        String datePrefix = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yy"));
        String newGuestId = "";

        try {
            File file = new File(fileName);
            int nextSequenceNumber = 1; // Default sequence

            // If file doesn't exist, create it and start the sequence
            if (!file.exists()) {
                file.createNewFile();
            } else {
                // Read the last line of the file
                String lastLine = getLastLine(file);
                if (lastLine != null && lastLine.startsWith(datePrefix)) {
                    String[] parts = lastLine.split("\\.");
                    nextSequenceNumber = Integer.parseInt(parts[3]) + 1; // Increment sequence
                }
            }

            // Generate new Guest ID
            newGuestId = datePrefix + "." + String.format("%03d", nextSequenceNumber);

            // Append the new Guest ID to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(newGuestId);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error generating Guest ID: " + e.getMessage());
        }

        return newGuestId;
    }

    // Helper method to read the last line of a file
    private static String getLastLine(File file) {
        String lastLine = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                lastLine = currentLine; // Keep updating to the last line
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return lastLine;
    }
}
