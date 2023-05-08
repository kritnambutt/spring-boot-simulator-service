package com.aiaplushk.helpers;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class FileReader {

    public String getResponse(String responseFile) {
        try {
            var inputStream = getClass().getClassLoader()
                    .getResourceAsStream("responses/" + responseFile);
            BufferedReader buffReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuffer stringBuffer = new StringBuffer();
            while ((line = buffReader.readLine()) != null) {
                stringBuffer.append(line);
            }
            buffReader.close();
            inputStream.close();
            return stringBuffer.toString();
        } catch (IOException ex) {
            throw new IllegalArgumentException();
        }
    }

    public List<String[]> getCsv(String responseFile) {
        try {
            var inputStream = getClass().getClassLoader()
                    .getResourceAsStream("responses/" + responseFile);
            BufferedReader buffReader = new BufferedReader(new InputStreamReader(inputStream));
            CSVReader csvReader = new CSVReaderBuilder(buffReader)
                    .withSkipLines(1)
                    .build();

            List<String[]> allData = csvReader.readAll();
            buffReader.close();
            inputStream.close();

            return allData;
        } catch (IOException | CsvException ex) {
            throw new IllegalArgumentException();
        }
    }


    public boolean hasResponse(String responseFile) {
        try {
            var inputStream = getClass().getClassLoader()
                    .getResourceAsStream("responses/" + responseFile);
            if (inputStream != null) {
                inputStream.close();
                return true;
            }
            return false;
        } catch (IOException ex) {
            throw new IllegalArgumentException();
        }
    }
    private String getFile(String path) {
        try (
                var inputStream = this.getClass().getClassLoader()
                        .getResourceAsStream(path);
                BufferedReader buffReader = new BufferedReader(new InputStreamReader(inputStream));
        ) {
            String line;
            StringBuilder stringBuffer = new StringBuilder();
            while ((line = buffReader.readLine()) != null) {
                stringBuffer.append(line);
            }

            return stringBuffer.toString();
        } catch (IOException | NullPointerException ex) {
            ex.printStackTrace();
            throw new IllegalArgumentException("Could not read file " + path);
        }
    }

    public ResponseEntity<String> buildResponse(String filePath, HttpStatus httpStatus) {
        if (filePath.startsWith("/")) filePath = filePath.substring(1);
        if (filePath.startsWith("response/"))
            return ResponseEntity.status(httpStatus).body(getFile(filePath));
        else return ResponseEntity.status(httpStatus).body(getResponse(filePath));
    }
}
