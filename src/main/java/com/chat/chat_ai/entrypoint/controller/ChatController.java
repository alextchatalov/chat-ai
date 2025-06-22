package com.chat.chat_ai.entrypoint.controller;

import com.chat.chat_ai.core.facede.CallAiFacade;
import com.chat.chat_ai.entrypoint.domain.AiModel;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ChatController {

    private final CallAiFacade callAiFacade;


    @GetMapping("/ai/generate")
    public Map<String,String> generate(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message,
    @RequestHeader("model") AiModel model) {
        return callAiFacade.execute(model, message);
    }

    @PostMapping("/ai/generate/file")
    public Map<String,String> handleFileUpload(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "message") String message,
            @RequestHeader("model") AiModel model) {

        String finalMessage = message + fileToString(file);
        return callAiFacade.execute(model, finalMessage);
    }

    private String fileToString(MultipartFile file) {
        try {
            String contentType = file.getContentType();
            if (contentType != null && (
                    contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") ||
                            contentType.equals("application/vnd.ms-excel"))) {

                // Handle Excel file
                StringBuilder content = new StringBuilder();
                try (XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
                    for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
                        XSSFSheet sheet = workbook.getSheetAt(sheetNum);
                        content.append("Sheet: ").append(sheet.getSheetName()).append("\n");

                        for (Row row : sheet) {
                            for (Cell cell : row) {
                                switch (cell.getCellType()) {
                                    case STRING:
                                        content.append(cell.getStringCellValue());
                                        break;
                                    case NUMERIC:
                                        if (DateUtil.isCellDateFormatted(cell)) {
                                            content.append(cell.getLocalDateTimeCellValue());
                                        } else {
                                            content.append(cell.getNumericCellValue());
                                        }
                                        break;
                                    case BOOLEAN:
                                        content.append(cell.getBooleanCellValue());
                                        break;
                                    case FORMULA:
                                        content.append(cell.getCellFormula());
                                        break;
                                    default:
                                        content.append(" ");
                                }
                                content.append("\t");
                            }
                            content.append("\n");
                        }
                        content.append("\n");
                    }
                }
                return content.toString();
            } else {
                // Handle text files as before
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
                    StringBuilder content = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        content.append(line).append("\n");
                    }
                    return content.toString();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file content", e);
        }
    }

}
