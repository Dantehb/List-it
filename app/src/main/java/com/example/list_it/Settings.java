package com.example.list_it;

public class Settings {
    private String settingName;
    private int settingImageId;

    public Settings(String settingName, int settingImageId) {
        this.settingName = settingName;
        this.settingImageId = settingImageId;
    }

    public String getSettingName() {
        return settingName;
    }

    public int getSettingImageId() {
        return settingImageId;
    }
}
