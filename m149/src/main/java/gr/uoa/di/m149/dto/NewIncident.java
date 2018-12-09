package gr.uoa.di.m149.dto;

import gr.uoa.di.m149.domain.*;

public class NewIncident{

    private ChicagoRequest chicagoRequest;
    private AbandonedVehiclesInfo abandonedVehiclesInfo;
    private CurrentActivityMostRecentAction currentActivityMostRecentAction;
    private GarbageCartsInfo garbageCartsInfo;
    private GraffitiRemovalInfo graffitiRemovalInfo;
    private PotholesReportedInfo potholesReportedInfo;
    private RodentBaitingInfo rodentBaitingInfo;
    private SanitationComplaintsInfo sanitationComplaintsInfo;
    private SSA ssa;
    private TreeDebrisTrimsInfo treeDebrisTrimsInfo;

    public ChicagoRequest getChicagoRequest() {
        return chicagoRequest;
    }

    public void setChicagoRequest(ChicagoRequest chicagoRequest) {
        this.chicagoRequest = chicagoRequest;
    }

    public AbandonedVehiclesInfo getAbandonedVehiclesInfo() {
        return abandonedVehiclesInfo;
    }

    public void setAbandonedVehiclesInfo(AbandonedVehiclesInfo abandonedVehiclesInfo) {
        this.abandonedVehiclesInfo = abandonedVehiclesInfo;
    }

    public CurrentActivityMostRecentAction getCurrentActivityMostRecentAction() {
        return currentActivityMostRecentAction;
    }

    public void setCurrentActivityMostRecentAction(CurrentActivityMostRecentAction currentActivityMostRecentAction) {
        this.currentActivityMostRecentAction = currentActivityMostRecentAction;
    }

    public GarbageCartsInfo getGarbageCartsInfo() {
        return garbageCartsInfo;
    }

    public void setGarbageCartsInfo(GarbageCartsInfo garbageCartsInfo) {
        this.garbageCartsInfo = garbageCartsInfo;
    }

    public GraffitiRemovalInfo getGraffitiRemovalInfo() {
        return graffitiRemovalInfo;
    }

    public void setGraffitiRemovalInfo(GraffitiRemovalInfo graffitiRemovalInfo) {
        this.graffitiRemovalInfo = graffitiRemovalInfo;
    }

    public PotholesReportedInfo getPotholesReportedInfo() {
        return potholesReportedInfo;
    }

    public void setPotholesReportedInfo(PotholesReportedInfo potholesReportedInfo) {
        this.potholesReportedInfo = potholesReportedInfo;
    }

    public RodentBaitingInfo getRodentBaitingInfo() {
        return rodentBaitingInfo;
    }

    public void setRodentBaitingInfo(RodentBaitingInfo rodentBaitingInfo) {
        this.rodentBaitingInfo = rodentBaitingInfo;
    }

    public SanitationComplaintsInfo getSanitationComplaintsInfo() {
        return sanitationComplaintsInfo;
    }

    public void setSanitationComplaintsInfo(SanitationComplaintsInfo sanitationComplaintsInfo) {
        this.sanitationComplaintsInfo = sanitationComplaintsInfo;
    }

    public SSA getSsa() {
        return ssa;
    }

    public void setSsa(SSA ssa) {
        this.ssa = ssa;
    }

    public TreeDebrisTrimsInfo getTreeDebrisTrimsInfo() {
        return treeDebrisTrimsInfo;
    }

    public void setTreeDebrisTrimsInfo(TreeDebrisTrimsInfo treeDebrisTrimsInfo) {
        this.treeDebrisTrimsInfo = treeDebrisTrimsInfo;
    }
}
