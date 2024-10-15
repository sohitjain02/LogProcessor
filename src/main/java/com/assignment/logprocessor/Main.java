package com.assignment.logprocessor;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        LogProcessor logProcessor = new LogProcessor();
        processLogFiles(logProcessor);
        logProcessor.printLogsReport();
        logProcessor.analyzeLogsAndPrintDetails(1, 12, "Pune", "Sohit");
        System.out.println("*******************");
        logProcessor.analyzeLogsAndPrintDetails(1, 1, "Pune", null);
        System.out.println("*******************");
        logProcessor.analyzeLogsAndPrintDetails(null, null, "Pune", null);
        System.out.println("*******************");
        logProcessor.analyzeLogsAndPrintDetails(1, null, null, "Sohit");
        System.out.println("*******************");
        logProcessor.analyzeLogsAndPrintDetails(null, null, "Mumbai", null);
    }

    private static void processLogFiles(LogProcessor logProcessor) {
        // Code to read and parse log files will go here and all details required will be extracted out
        // Here we are directly inserting the entry to the log processors.
        logProcessor.saveLogEntry("Pune",
                "Sohit",
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 1, 12, 1, 1)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 1, 12, 1, 45)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 1, 12, 1, 45)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 1, 12, 2, 50)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 1, 12, 2, 50)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 1, 12, 3, 0))
        );
        logProcessor.saveLogEntry("Pune",
                "Sohit",
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 1, 13, 1, 1)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 1, 13, 1, 45)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 1, 13, 1, 45)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 1, 13, 2, 50)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 1, 13, 2, 50)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 1, 13, 3, 0))
        );
        logProcessor.saveLogEntry("Pune",
                "Sohit",
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 5, 20, 1, 1)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 5, 20, 1, 45)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 5, 20, 1, 45)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 5, 20, 2, 50)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 5, 20, 2, 50)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 5, 20, 3, 0))
        );
        logProcessor.saveLogEntry("Pune",
                "Jack",
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 1, 12, 1, 1)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 1, 12, 1, 30)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 1, 12, 1, 30)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 1, 12, 2, 50)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 1, 12, 2, 50)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 1, 12, 3, 25))
        );
        logProcessor.saveLogEntry("Mumbai",
                "Alan",
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 3, 15, 7, 1, 1)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 3, 15, 7, 1, 30)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 3, 15, 7, 1, 30)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 3, 15, 7, 2, 50)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 3, 15, 7, 2, 50)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 3, 15, 7, 3, 25))
        );
        logProcessor.saveLogEntry("Mumbai",
                "Alan",
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 3, 15, 7, 1, 1)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 3, 15, 7, 1, 30)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 3, 15, 7, 1, 30)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 3, 15, 7, 2, 50)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 3, 15, 7, 2, 50)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 3, 15, 7, 3, 25))
        );
        logProcessor.saveLogEntry("Mumbai",
                "Sohit",
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 1, 12, 1, 1)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 1, 12, 1, 45)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 1, 12, 1, 45)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 1, 12, 2, 50)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 1, 12, 2, 50)),
                DateUtility.localDateTimeToMilliseconds(LocalDateTime.of(2024, 1, 1, 12, 3, 0))
        );
    }

}