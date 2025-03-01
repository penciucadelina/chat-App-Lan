package chatapplication;
/**
 * @author Adelina Penciuc
 */

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class OnlineStatus implements Runnable {
    DatagramSocket ds;

    OnlineStatus() {
        try {
            ds = new DatagramSocket();
        } catch (SocketException ex) {
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                byte[] buf;
                buf = MulticastClient.name.getBytes();
                InetAddress group = InetAddress.getByName("230.0.0.2");
                DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 5000);
                ds.send(packet);
                try {
                    sleep((long) (Math.random() * 20000));

                } catch (Exception e) {
                }
            } catch (IOException e) {
                System.out.println("Error in online status class");
                ds.close();
            }
        }
    }
}

class ReceiveOnlineStatus implements Runnable {
    InetAddress address = null;
    MulticastSocket socket = null;
    public static ArrayList al = new ArrayList();

    ReceiveOnlineStatus() {
        try {
            socket = new MulticastSocket(5000);
            address = InetAddress.getByName("230.0.0.2");
            socket.joinGroup(address);
        } catch (Exception e) {
            System.err.println("error");
        }
    }

    @Override
    public void run() {
        al = new ArrayList();
        while (true) {
            try {
                DatagramPacket packet;
                byte[] buf = new byte[256];
                packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                String name = new String(packet.getData(), 0, packet.getLength());
                if (name.equals("exited")) al = new ArrayList();
                if (!al.contains(name) && !name.equals("exited")) {
                    al.add(name);
                    if (MulticastClient.jTextArea3.getText().equals("")) MulticastClient.jTextArea3.setText(name);
                    else {
                        MulticastClient.jTextArea3.setText("");
                        for (Object obj : al) {
                            MulticastClient.jTextArea3.setText(MulticastClient.jTextArea3.getText() + obj.toString() + "\n");
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println("Error in receive online status class");
            }


        }
    }
}