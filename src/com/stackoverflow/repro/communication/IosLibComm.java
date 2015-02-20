package com.stackoverflow.repro.communication;

import com.stackoverflow.repro.model.App;

/**
 * Created by karthik on 16/02/15.
 */

public class IosLibComm  {

    public native int getNumApps(String deviceId);
    public native App[] getAppsList(String deviceId, boolean includeSystemApps);

    public native byte[] getAppIcon(String deviceId, String appBundleId);

}
