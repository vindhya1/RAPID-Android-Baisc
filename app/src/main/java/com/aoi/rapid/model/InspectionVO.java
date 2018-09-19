package com.aoi.rapid.model;

import java.util.Date;

public class InspectionVO {
    private int inspectionId;
    private String propertyId;

    @Override
    public String toString() {
        return "InspectionVO{" +
                "inspectionId=" + inspectionId +
                ", propertyId='" + propertyId + '\'' +
                ", scheduledTime=" + scheduledTime +
                '}';
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

    public Date getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(Date scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    private Date scheduledTime;
}
