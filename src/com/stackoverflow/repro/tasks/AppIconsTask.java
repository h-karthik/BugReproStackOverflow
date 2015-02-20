package com.stackoverflow.repro.tasks;
import javafx.concurrent.Task;

/**
 * Created by karthik on 17/02/15.
 */
public class AppIconsTask extends Task<Void> {

    @Override
    protected Void call() throws Exception {
        updateProgress(0.0f , 100);
        // Get list of installed apps
        for(int i = 0; i < 1000; i+=5){

            Thread.sleep(30);
            updateProgress(i, 1000);
        }
        return null;
    }
}
