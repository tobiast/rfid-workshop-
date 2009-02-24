package no.knowit.rfid;

import com.phidgets.event.AttachListener;
import com.phidgets.event.AttachEvent;
import com.phidgets.RFIDPhidget;
import com.phidgets.PhidgetException;

/**
 * Listens for RFID-readers in proximity
 * @author Tobias K Torrissen
 */
public class DeviceListener implements AttachListener {


    /**
    * Method is called when a Phidget RFID reader is connected to the USB-port
    */
    public void attached(AttachEvent event) {
        try {

            RFIDPhidget attached = (RFIDPhidget) event.getSource();

            attached.setAntennaOn(true);
            attached.setLEDOn(true);
            System.out.println("Attached to new reader!!");

        } catch (PhidgetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
