package gr.uoa.di.m149.domain;

import javax.persistence.*;

@Entity
@Table(name = "garbage_carts_info")
public class GarbageCartsInfo {

    @Id
    private long requestid;
    private Float numberofblackcartsdelivered;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "requestid", nullable = false)
    private ChicagoRequest cr;

    public long getRequestid() {
        return requestid;
    }

    public void setRequestid(long requestid) {
        this.requestid = requestid;
    }

    public Float getNumberofblackcartsdelivered() {
        return numberofblackcartsdelivered;
    }

    public void setNumberofblackcartsdelivered(Float numberofblackcartsdelivered) {
        this.numberofblackcartsdelivered = numberofblackcartsdelivered;
    }

    public ChicagoRequest getCr() {
        return cr;
    }

    public void setCr(ChicagoRequest cr) {
        this.cr = cr;
    }
}
