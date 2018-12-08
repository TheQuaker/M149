package gr.uoa.di.m149.domain;

import javax.persistence.*;

@Entity
@Table(name = "sanitation_complaints_info")
public class SanitationComplaintsInfo {

    @Id
    private long requestid;
    private String natureofCodeViolation;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "requestid", nullable = false)
    private ChicagoRequest cr;

    public long getRequestid() {
        return requestid;
    }

    public void setRequestid(long requestid) {
        this.requestid = requestid;
    }

    public String getNatureofCodeViolation() {
        return natureofCodeViolation;
    }

    public void setNatureofCodeViolation(String natureofCodeViolation) {
        this.natureofCodeViolation = natureofCodeViolation;
    }

    public ChicagoRequest getCr() {
        return cr;
    }

    public void setCr(ChicagoRequest cr) {
        this.cr = cr;
    }
}
