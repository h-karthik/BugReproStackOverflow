package com.stackoverflow.repro.model;

/**
 * Created by karthik on 17/02/15.
 */
public class App {

    String bundleExe;
    String bundleId;
    String version;
    String displayName;

    byte[] icon;

    public String getBundleId(){
        return bundleId;
    }

    public void setAppIcon(byte[] pngData){
        icon = pngData;
    }

    public byte[] getAppIcon() {
        return icon;
    }

    public String getDisplayName() {
        return displayName;
    }
}
