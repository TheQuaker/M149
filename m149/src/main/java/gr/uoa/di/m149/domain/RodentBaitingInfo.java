package gr.uoa.di.m149.domain;

import javax.persistence.*;

@Entity
@Table(name = "rodent_baiting_info")
public class RodentBaitingInfo {

    @Id
    private long requestid;
    private Float premisesbaited;
    private Integer premiseswithgarbage;
    private Float premiseswithrats;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "requestid", nullable = false)
    private ChicagoRequest cr;

    public long getRequestid() {
        return requestid;
    }

    public void setRequestid(long requestid) {
        this.requestid = requestid;
    }

    public Float getPremisesbaited() {
        return premisesbaited;
    }

    public void setPremisesbaited(Float premisesbaited) {
        this.premisesbaited = premisesbaited;
    }

    public Integer getPremiseswithgarbage() {
        return premiseswithgarbage;
    }

    public void setPremiseswithgarbage(Integer premiseswithgarbage) {
        this.premiseswithgarbage = premiseswithgarbage;
    }

    public Float getPremiseswithrats() {
        return premiseswithrats;
    }

    public void setPremiseswithrats(Float premiseswithrats) {
        this.premiseswithrats = premiseswithrats;
    }

    public ChicagoRequest getCr() {
        return cr;
    }

    public void setCr(ChicagoRequest cr) {
        this.cr = cr;
    }
}
