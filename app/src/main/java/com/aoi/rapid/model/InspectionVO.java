package com.aoi.rapid.model;

import java.util.Date;

public class InspectionVO {
    private int inspectionId;
    private String propertyId;
    private String inspectionStatusCd;
    private String scheduleTime;

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getInspectionStatusCd() {
        return inspectionStatusCd;
    }

    public void setInspectionStatusCd(String inspectionStatusCd) {
        this.inspectionStatusCd = inspectionStatusCd;
    }








    public int getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(int inspectionId) {
        this.inspectionId = inspectionId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }



}
