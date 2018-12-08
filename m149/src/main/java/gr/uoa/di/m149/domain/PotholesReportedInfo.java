package gr.uoa.di.m149.domain;

import javax.persistence.*;

@Entity
@Table(name = "potholes_reported_info")
public class PotholesReportedInfo {

    @Id
    private long requestid;
    private Float potholesFilledOnBlock;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "requestid", nullable = false)
    private ChicagoRequest cr;

    public long getRequestid() {
        return requestid;
    }

    public void setRequestid(long requestid) {
        this.requestid = requestid;
    }

    public Float getPotholesFilledOnBlock() {
        return potholesFilledOnBlock;
    }

    public void setPotholesFilledOnBlock(Float potholesFilledOnBlock) {
        this.potholesFilledOnBlock = potholesFilledOnBlock;
    }

    public ChicagoRequest getCr() {
        return cr;
    }

    public void setCr(ChicagoRequest cr) {
        this.cr = cr;
    }
}
