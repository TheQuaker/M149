package gr.uoa.di.m149.domain;

import javax.persistence.*;

@Entity
@Table(name = "graffiti_removal_info")
public class GraffitiRemovalInfo {

    @Id
    private long requestid;
    private String surface;
    private String graffitilocation;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "requestid", nullable = false)
    private ChicagoRequest cr;

    public long getRequestid() {
        return requestid;
    }

    public void setRequestid(long requestid) {
        this.requestid = requestid;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public String getGraffitilocation() {
        return graffitilocation;
    }

    public void setGraffitilocation(String graffitilocation) {
        this.graffitilocation = graffitilocation;
    }

    public ChicagoRequest getCr() {
        return cr;
    }

    public void setCr(ChicagoRequest cr) {
        this.cr = cr;
    }
}
