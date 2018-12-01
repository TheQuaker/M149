package gr.uoa.di.m149.tempdomain;

public class TypeTotalRequests {

    String typeofrequest;
    long count;

    public TypeTotalRequests(String typeofrequest, long count) {
        this.typeofrequest = typeofrequest;
        this.count = count;
    }

    public String getTypeofrequest() {
        return typeofrequest;
    }

    public void setTypeofrequest(String typeofrequest) {
        this.typeofrequest = typeofrequest;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
