package no.knowit.rfid;

import com.phidgets.RFIDPhidget;
import com.phidgets.PhidgetException;
import com.phidgets.Phidget;

import java.io.IOException;

import no.knowit.rfid.DeviceListener;

/**
 * Mainclass of the RFID 
 * @author Tobias K Torrissen
 *
 * Must set -Djava.library.path=/System/Library/Frameworks/JavaVM.framework/Libraries
 *
 * (Path varies from platform to platform. This is the mac platform) 
 *
 */
public class Reader {


    /**
     * Starts to listen for an attached RFID-readers and tag-events (tags entering or leaving the
     * range of the RFID-reader
     *
     * @param args any command line parameters.
     */
    public static void main(String[] args) {

        System.out.println(Phidget.getLibraryVersion());

        try {

            RFIDPhidget rfid;
            rfid = new RFIDPhidget();

            rfid.addAttachListener(new DeviceListener());
            rfid.addTagGainListener(new TagListener());

            rfid.openAny();
            System.out.println("waiting for RFID attachment...");
            rfid.waitForAttachment(1000);

            System.out.println("Serial: " + rfid.getSerialNumber());
            System.out.println("Outputs: " + rfid.getOutputCount());

            System.out.println("Outputting events.  Input to stop.");
            System.in.read();
            System.out.print("closing...");
            rfid.close();
            rfid = null;
            System.out.println(" ok");
            if (false) {
                System.out.println("wait for finalization...");
                System.gc();
            }

        } catch (PhidgetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

}
