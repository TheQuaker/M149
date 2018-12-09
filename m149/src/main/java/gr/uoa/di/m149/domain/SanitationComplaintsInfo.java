package gr.uoa.di.m149.domain;

import javax.persistence.*;

@Entity
@Table(name = "sanitation_complaints_info")
public class SanitationComplaintsInfo {

    @Id
    private long requestid;
    private String natureofcodeviolation;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "requestid", nullable = false)
    private ChicagoRequest cr;

    public long getRequestid() {
        return requestid;
    }

    public void setRequestid(long requestid) {
        this.requestid = requestid;
    }

    public String getNatureofcodeviolation() {
        return natureofcodeviolation;
    }

    public void setNatureofcodeviolation(String natureofcodeviolation) {
        this.natureofcodeviolation = natureofcodeviolation;
    }

    public ChicagoRequest getCr() {
        return cr;
    }

    public void setCr(ChicagoRequest cr) {
        this.cr = cr;
    }
}
