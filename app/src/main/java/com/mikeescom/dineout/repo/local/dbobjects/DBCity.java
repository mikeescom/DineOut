package com.mikeescom.dineout.repo.local.dbobjects;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mikeescom.dineout.repo.local.DBConstant;

@Entity(tableName = DBConstant.CITIES_TABLE_NAME)
public class DBCity {
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = DBConstant.CITY_ID)
    @SerializedName("id")
    @Expose
    private int id;
    @ColumnInfo(name = DBConstant.CITY_NAME)
    @SerializedName("name")
    @Expose
    private String name;
    @ColumnInfo(name = DBConstant.COUNTRY_ID)
    @SerializedName("country_id")
    @Expose
    private int countryId;
    @ColumnInfo(name = DBConstant.COUNTRY_NAME)
    @SerializedName("country_name")
    @Expose
    private String countryName;
    @ColumnInfo(name = DBConstant.COUNTRY_FLAG_URL)
    @SerializedName("country_flag_url")
    @Expose
    private String countryFlagUrl;
    @ColumnInfo(name = DBConstant.SHOULD_EXPERIMENT_WITH)
    @SerializedName("should_experiment_with")
    @Expose
    private int shouldExperimentWith;
    @ColumnInfo(name = DBConstant.DISCOVERY_ENABLED)
    @SerializedName("discovery_enabled")
    @Expose
    private int discoveryEnabled;
    @ColumnInfo(name = DBConstant.HAS_NEW_AD_FORMAT)
    @SerializedName("has_new_ad_format")
    @Expose
    private int hasNewAdFormat;
    @ColumnInfo(name = DBConstant.IS_STATE)
    @SerializedName("is_state")
    @Expose
    private int isState;
    @ColumnInfo(name = DBConstant.STATE_ID)
    @SerializedName("state_id")
    @Expose
    private int stateId;
    @ColumnInfo(name = DBConstant.STATE_NAME)
    @SerializedName("state_name")
    @Expose
    private String stateName;
    @ColumnInfo(name = DBConstant.STATE_CODE)
    @SerializedName("state_code")
    @Expose
    private String stateCode;

    public DBCity(int id
            , String name
            , int countryId
            , String countryName
            , String countryFlagUrl
            , int shouldExperimentWith
            , int discoveryEnabled
            , int hasNewAdFormat
            , int isState
            , int stateId
            , String stateName
            , String stateCode) {
        this.id = id;
        this.name = name;
        this.countryId = countryId;
        this.countryName = countryName;
        this.countryFlagUrl = countryFlagUrl;
        this.shouldExperimentWith = shouldExperimentWith;
        this.discoveryEnabled = discoveryEnabled;
        this.hasNewAdFormat = hasNewAdFormat;
        this.isState = isState;
        this.stateId = stateId;
        this.stateName = stateName;
        this.stateCode = stateCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryFlagUrl() {
        return countryFlagUrl;
    }

    public void setCountryFlagUrl(String countryFlagUrl) {
        this.countryFlagUrl = countryFlagUrl;
    }

    public int getShouldExperimentWith() {
        return shouldExperimentWith;
    }

    public void setShouldExperimentWith(int shouldExperimentWith) {
        this.shouldExperimentWith = shouldExperimentWith;
    }

    public int getDiscoveryEnabled() {
        return discoveryEnabled;
    }

    public void setDiscoveryEnabled(int discoveryEnabled) {
        this.discoveryEnabled = discoveryEnabled;
    }

    public int getHasNewAdFormat() {
        return hasNewAdFormat;
    }

    public void setHasNewAdFormat(int hasNewAdFormat) {
        this.hasNewAdFormat = hasNewAdFormat;
    }

    public int getIsState() {
        return isState;
    }

    public void setIsState(int isState) {
        this.isState = isState;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
}
