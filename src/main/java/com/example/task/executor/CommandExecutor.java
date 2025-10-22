package com.example.task.executor;

import com.example.task.model.TaskExecution;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

@Component
public class CommandExecutor {

    public TaskExecution execute(String command) {
        TaskExecution execution = new TaskExecution();
        execution.setStartTime(new Date());

        StringBuilder output = new StringBuilder();
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            process.waitFor();
        } catch (Exception e) {
            output.append("Error: ").append(e.getMessage());
        }

        execution.setEndTime(new Date());
        execution.setOutput(output.toString().trim());
        return execution;
    }
}
