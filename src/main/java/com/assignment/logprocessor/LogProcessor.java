package com.assignment.logprocessor;

import com.assignment.logprocessor.dto.LogEntry;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LogProcessor {

    LogAggregator logAggregator = new LogAggregator();

    public void saveLogEntry(String officeName, String userName, long startScanTime, long scanEndTime, long saveStartTime, long saveEndTime, long showStartTime, long showEndTime) {
        logAggregator.addLogEntry(officeName, userName, new LogEntry(startScanTime, scanEndTime, saveStartTime, saveEndTime, showStartTime, showEndTime));
    }

    public void analyzeLogsAndPrintDetails(Integer monthDay, Integer hour, String office, String userName) {
        Map<String, OfficeLogManager> officeLogManagers = logAggregator.getOfficeLogManagers();
        for (Map.Entry<String, OfficeLogManager> officeLogManagerEntry : officeLogManagers.entrySet()) {
            if (Objects.nonNull(office) && officeLogManagerEntry.getKey().equals(office)) {
                // specific office log
                OfficeLogManager specificOfficeLog = officeLogManagers.get(office);
                System.out.println("Office " + specificOfficeLog.getOfficeName() + " : " + specificOfficeLog.getDocumentCountForOffice() + " documents scanned");
                printUserLogs(hour, monthDay, userName, specificOfficeLog);
                break;
            } else {
                // all offices analyzer
                OfficeLogManager specificOfficeLog = officeLogManagers.get(officeLogManagerEntry.getKey());
                System.out.println("Office " + specificOfficeLog.getOfficeName() + " : " + specificOfficeLog.getDocumentCountForOffice() + " documents scanned");
                printUserLogs(hour, monthDay, userName, specificOfficeLog);
            }
        }
    }

    private void printLogsForHour(Integer hour, List<LogEntry> logEntriesForSpecificUser) {
        if (Objects.nonNull(hour)) {
            // specific hour log
            long countForSpecificHour = logEntriesForSpecificUser.stream()
                    .filter(logEntry -> DateUtility.getHourFromMilliseconds(logEntry.startScanTime()) == hour)
                    .count();
            System.out.println("\t\t\t Hour " + hour + " : " + countForSpecificHour + " documents scanned");
        } else {
            // all hour logs
            Map<Integer, Long> userLogsForEachHourMap = logEntriesForSpecificUser.stream()
                    .collect(Collectors.groupingBy(x -> DateUtility.getHourFromMilliseconds(x.startScanTime()), Collectors.counting()));
            userLogsForEachHourMap.forEach((key, value) -> System.out.println("\t\t\t Hour " + key + " : " + value + " documents scanned"));
        }
    }

    private void printLogsForDay(Integer hour, Integer monthDay, List<LogEntry> logEntriesForSpecificUser) {
        if (Objects.nonNull(monthDay)) {
            // specific day log
            long countForSpecificDay = logEntriesForSpecificUser.stream()
                    .filter(logEntry -> DateUtility.getDayFromMilliseconds(logEntry.startScanTime()) == monthDay)
                    .count();
            System.out.println("\t\t Day " + monthDay + " : " + countForSpecificDay + " documents scanned");
            printLogsForHour(hour, logEntriesForSpecificUser);
        } else {
            // all days logs
            Map<Integer, Long> userLogsForEachDayMap = logEntriesForSpecificUser.stream()
                    .collect(Collectors.groupingBy(x -> DateUtility.getDayFromMilliseconds(x.startScanTime()), Collectors.counting()));
            userLogsForEachDayMap.forEach((key, value) -> System.out.println("\t\t Day " + key + " : " + value + " documents scanned"));
            printLogsForHour(hour, logEntriesForSpecificUser);
        }
    }

    private void printUserLogs(Integer hour, Integer monthDay, String userName, OfficeLogManager specificOfficeLog) {
        for (Map.Entry<String, UserLogManager> userLogManagerEntry : specificOfficeLog.getUserLogManagers().entrySet()) {
            if (Objects.nonNull(userName) && userLogManagerEntry.getKey().equals(userName)) {
                // specific user log
                UserLogManager specificUserLog = specificOfficeLog.getUserLogManagers().get(userName);
                List<LogEntry> logEntriesForSpecificUser = specificUserLog.getLogEntries();
                System.out.println("\t User " + specificUserLog.getUserName() + " : " + logEntriesForSpecificUser.size() + " documents scanned");
                printLogsForDay(hour, monthDay, logEntriesForSpecificUser);
                break;
            } else {
                // all users analyzer
                UserLogManager specificUserLog = specificOfficeLog.getUserLogManagers().get(userLogManagerEntry.getKey());
                List<LogEntry> logEntriesForSpecificUser = specificUserLog.getLogEntries();
                System.out.println("\t User " + specificUserLog.getUserName() + " : " + logEntriesForSpecificUser.size() + " documents scanned");
                printLogsForDay(hour, monthDay, logEntriesForSpecificUser);
            }
        }
    }

    public void printLogsReport() {
        System.out.println("Average scan time: " + logAggregator.calculateAverageScanTime());
        System.out.println("Average save time: " + logAggregator.calculateAverageSaveTime());
        System.out.println("Average show time: " + logAggregator.calculateAverageShowTime());
        System.out.println("Total documents scanned: " + logAggregator.getTotalDocumentsScanned());
    }
}

