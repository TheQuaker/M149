package gr.uoa.di.m149.domain;

import javax.persistence.*;

@Entity
@Table(name = "currentactivity_mostrecentaction")
public class CurrentActivityMostRecentAction {

    @Id
    private long requestid;
    private String currentactivity;
    private String mostrecentaction;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "requestid", nullable = false)
    private ChicagoRequest cr;

    public long getRequestid() {
        return requestid;
    }

    public void setRequestid(long requestid) {
        this.requestid = requestid;
    }

    public String getCurrentactivity() {
        return currentactivity;
    }

    public void setCurrentactivity(String currentactivity) {
        this.currentactivity = currentactivity;
    }

    public String getMostrecentaction() {
        return mostrecentaction;
    }

    public void setMostrecentaction(String mostrecentaction) {
        this.mostrecentaction = mostrecentaction;
    }

    public ChicagoRequest getCr() {
        return cr;
    }

    public void setCr(ChicagoRequest cr) {
        this.cr = cr;
    }
}
