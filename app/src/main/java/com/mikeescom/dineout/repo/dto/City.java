package com.mikeescom.dineout.repo.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("country_id")
    @Expose
    private int country_id;
    @SerializedName("country_name")
    @Expose
    private String country_name;
    @SerializedName("country_flag_url")
    @Expose
    private String country_flag_url;
    @SerializedName("should_experiment_with")
    @Expose
    private int should_experiment_with;
    @SerializedName("discovery_enabled")
    @Expose
    private int discovery_enabled;
    @SerializedName("has_new_ad_format")
    @Expose
    private int has_new_ad_format;
    @SerializedName("is_state")
    @Expose
    private int is_state;
    @SerializedName("state_id")
    @Expose
    private int state_id;
    @SerializedName("state_name")
    @Expose
    private String state_name;
    @SerializedName("state_code")
    @Expose
    private String state_code;


    public City(int id
            , String name
            , int country_id
            , String country_name
            , String country_flag_url
            , int should_experiment_with
            , int discovery_enabled
            , int has_new_ad_format
            , int is_state
            , int state_id
            , String state_name
            , String state_code) {
        this.id = id;
        this.name = name;
        this.country_id = country_id;
        this.country_name = country_name;
        this.country_flag_url = country_flag_url;
        this.should_experiment_with = should_experiment_with;
        this.discovery_enabled = discovery_enabled;
        this.has_new_ad_format = has_new_ad_format;
        this.is_state = is_state;
        this.state_id = state_id;
        this.state_name = state_name;
        this.state_code = state_code;
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

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getCountry_flag_url() {
        return country_flag_url;
    }

    public void setCountry_flag_url(String country_flag_url) {
        this.country_flag_url = country_flag_url;
    }

    public int getShould_experiment_with() {
        return should_experiment_with;
    }

    public void setShould_experiment_with(int should_experiment_with) {
        this.should_experiment_with = should_experiment_with;
    }

    public int getHas_new_ad_format() {
        return has_new_ad_format;
    }

    public void setHas_new_ad_format(int has_new_ad_format) {
        this.has_new_ad_format = has_new_ad_format;
    }

    public int getIs_state() {
        return is_state;
    }

    public void setIs_state(int is_state) {
        this.is_state = is_state;
    }

    public int getState_id() {
        return state_id;
    }

    public void setState_id(int state_id) {
        this.state_id = state_id;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public int getDiscovery_enabled() {
        return discovery_enabled;
    }

    public void setDiscovery_enabled(int discovery_enabled) {
        this.discovery_enabled = discovery_enabled;
    }
}
