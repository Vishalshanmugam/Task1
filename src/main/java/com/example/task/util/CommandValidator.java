package com.example.task.util;

public class CommandValidator {

    // Simple safety check (rejects dangerous commands)
    public static boolean isSafe(String command) {
        String lower = command.toLowerCase();
        return !(lower.contains("rm") || lower.contains("shutdown") || lower.contains("reboot"));
    }
}
