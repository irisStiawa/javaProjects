package at.userChat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Date {
    private LocalDate date = LocalDate.now();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private String time = LocalTime.now().format(formatter);

    public Date() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
