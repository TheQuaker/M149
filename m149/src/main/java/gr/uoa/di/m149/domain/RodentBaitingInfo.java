package gr.uoa.di.m149.domain;

import javax.persistence.*;

@Entity
@Table(name = "rodent_baiting_info")
public class RodentBaitingInfo {

    @Id
    private long requestid;
    private Float premisesBaited;
    private Integer premiseswithGarbage;
    private Float premiseswithRats;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "requestid", nullable = false)
    private ChicagoRequest cr;

    public long getRequestid() {
        return requestid;
    }

    public void setRequestid(long requestid) {
        this.requestid = requestid;
    }

    public Float getPremisesBaited() {
        return premisesBaited;
    }

    public void setPremisesBaited(Float premisesBaited) {
        this.premisesBaited = premisesBaited;
    }

    public Integer getPremiseswithGarbage() {
        return premiseswithGarbage;
    }

    public void setPremiseswithGarbage(Integer premiseswithGarbage) {
        this.premiseswithGarbage = premiseswithGarbage;
    }

    public Float getPremiseswithRats() {
        return premiseswithRats;
    }

    public void setPremiseswithRats(Float premiseswithRats) {
        this.premiseswithRats = premiseswithRats;
    }

    public ChicagoRequest getCr() {
        return cr;
    }

    public void setCr(ChicagoRequest cr) {
        this.cr = cr;
    }
}
