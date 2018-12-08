package gr.uoa.di.m149.tempdomain;

import javax.persistence.Transient;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DayRequests {

    @Transient
    private final DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    Timestamp date;
    long count;

    public Timestamp getDate() { return date; }

    @Transient
    public String getDateFormatted() { return df.format(date); }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
