package General;

import java.net.*;
import java.util.*;

public class MulticastRequest extends Thread {
	private ArrayList<String> serverList;

	public MulticastRequest(ArrayList<String> serverList) {
		this.serverList = serverList;
	}

	public void run() {
		try {
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
				String receive = new String(dpReceive.getData(), 0,
						dpReceive.getLength());
				serverList.add(receive);
				timeOut = System.currentTimeMillis();

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
