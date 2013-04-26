package General;

import java.net.*;
import java.util.*;

import javax.swing.DefaultListModel;

public class MulticastRequest extends Thread {
	private DefaultListModel serverList;
	private HashMap<String,String> servers;

	public MulticastRequest(DefaultListModel serverList,
			HashMap<String,String> servers) {
		this.serverList = serverList;
		this.servers = servers;
	}

	public void run() {
		try {
			serverList.clear();
			MulticastSocket ms = new MulticastSocket();
			ms.setTimeToLive(1);
			InetAddress ia = InetAddress.getByName("experiment.mcast.net");
			String send = "quickz";

			byte[] buf = send.getBytes();
			DatagramPacket dpSend = new DatagramPacket(buf, buf.length, ia,
					4099);
			ms.send(dpSend);

			long start = System.currentTimeMillis();
			long timeOut = 0;
			while (timeOut - start < 3000) {
				byte[] received = new byte[100];
				DatagramPacket dpReceive = new DatagramPacket(received,
						received.length);
				ms.receive(dpReceive);
				InetAddress adr = dpReceive.getAddress();
				String address = adr.toString().substring(1);				
				String receive = new String(dpReceive.getData(), 0,
						dpReceive.getLength());
				serverList.addElement(receive);
				servers.put(receive, address);
				
				timeOut = System.currentTimeMillis();

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
