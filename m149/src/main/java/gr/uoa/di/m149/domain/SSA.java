package gr.uoa.di.m149.domain;

import javax.persistence.*;

@Entity
@Table(name = "SSA")
public class SSA {

    @Id
    private long requestid;
    private String SSA;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "requestid", nullable = false)
    private ChicagoRequest cr;

    public long getRequestid() {
        return requestid;
    }

    public void setRequestid(long requestid) {
        this.requestid = requestid;
    }

    public String getSSA() {
        return SSA;
    }

    public void setSSA(String SSA) {
        this.SSA = SSA;
    }

    public ChicagoRequest getCr() {
        return cr;
    }

    public void setCr(ChicagoRequest cr) {
        this.cr = cr;
    }
}
