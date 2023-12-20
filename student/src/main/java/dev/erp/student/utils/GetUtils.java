package dev.erp.student.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface GetUtils {
    String TIMESTAMP = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy:MM:dd, HH:mm:ss"));
    String ROLE_ = "ROLE_";
}
