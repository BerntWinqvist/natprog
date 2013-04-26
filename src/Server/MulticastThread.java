package Server;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastThread extends Thread {
	private String serverName;
	public MulticastThread(String serverName) {
		this.serverName = serverName;
	}

	public void run() {
		try {

			MulticastSocket ms = new MulticastSocket(4099);
			InetAddress inetaddr = InetAddress.getByName("experiment.mcast.net");
			ms.joinGroup(inetaddr);

			while (true) {
				byte[] receive = new byte[100];
				DatagramPacket dprec = new DatagramPacket(receive, receive.length);
				ms.receive(dprec);
				String s = new String(dprec.getData(), 0, dprec.getLength());
				if(s.equals("quickz")){
					byte[] send = new byte[100];
					send = serverName.getBytes();
					DatagramPacket dpsend = new DatagramPacket(send,send.length,dprec.getAddress(),dprec.getPort());				
					ms.send(dpsend);	
				}

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
