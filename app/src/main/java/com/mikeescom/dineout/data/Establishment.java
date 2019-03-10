package com.mikeescom.dineout.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Establishment {

    @SerializedName("establishment_id")
    @Expose
    private String establishmentId;
    @SerializedName("establishment_name")
    @Expose
    private String establishmentName;

    public String getEstablishmentId() {
        return establishmentId;
    }

    public void setEstablishmentId(String establishmentId) {
        this.establishmentId = establishmentId;
    }

    public String getEstablishmentName() {
        return establishmentName;
    }

    public void setEstablishmentName(String establishmentName) {
        this.establishmentName = establishmentName;
    }

}
