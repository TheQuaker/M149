package gr.uoa.di.m149.domain;

import javax.persistence.*;

@Entity
@Table(name = "CurrentActivity_MostRecentAction")
public class CurrentActivityMostRecentAction {

    @Id
    private long requestid;
    private String currentActivity;
    private String mostRecentAction;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "requestid", nullable = false)
    private ChicagoRequest cr;

    public long getRequestid() {
        return requestid;
    }

    public void setRequestid(long requestid) {
        this.requestid = requestid;
    }

    public String getCurrentActivity() {
        return currentActivity;
    }

    public void setCurrentActivity(String currentActivity) {
        this.currentActivity = currentActivity;
    }

    public String getMostRecentAction() {
        return mostRecentAction;
    }

    public void setMostRecentAction(String mostRecentAction) {
        this.mostRecentAction = mostRecentAction;
    }

    public ChicagoRequest getCr() {
        return cr;
    }

    public void setCr(ChicagoRequest cr) {
        this.cr = cr;
    }
}
