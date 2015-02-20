package com.stackoverflow.repro.tasks;

import com.stackoverflow.repro.communication.IosLibComm;
import javafx.concurrent.Task;

/**
 * Created by karthik on 17/02/15.
 */
public class ProfilingTask extends Task<Void> {

    boolean stopProf;
    @Override
    protected Void call() throws Exception {
        IosLibComm comm = new IosLibComm();
        String deviceId = "062ff5dcc66d76f4766a1f54c9e5079b1c60646c";
        double f = 1.0;
        while(!getStopProf()){
            Thread.sleep(30);

        }
        return null;
    }
    public boolean getStopProf(){
        return stopProf;
    }

    public void setStopProf(boolean stop){
        stopProf = stop;
    }
}
