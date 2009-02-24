package no.knowit.rfid;

import com.phidgets.event.TagGainListener;
import com.phidgets.event.TagGainEvent;

/**
 * Listens for tags in proximity of RFID reader
 * @author Tobias K Torrissen
 */
public class TagListener implements TagGainListener{

    /**
     * Method is called when ever a RFID chip moves into the range of the READER
     * @param event the event that happened. 
     */
    public void tagGained(TagGainEvent event) {
        System.out.println("TAG-GAIN-EVENT!");
        System.out.println("VALUE: " + event.getValue());
    }
}
