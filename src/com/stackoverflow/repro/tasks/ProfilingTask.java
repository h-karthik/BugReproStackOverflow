package com.stackoverflow.repro.tasks;

import javafx.concurrent.Task;

/**
 * Created by karthik on 17/02/15.
 */
public class ProfilingTask extends Task<Void> {

    boolean stopProf;
    @Override
    protected Void call() throws Exception {
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
