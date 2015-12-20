package common.demo;

import common.ICmd2ModelAdapter;
import common.IUser;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;

public class StringConsoleDataPacketAlgoCmd extends ADataPacketAlgoCmd<String,String,IUser> {
	
		/**
		 * 
		 */
		private static final long serialVersionUID = -8784334914895891287L;

		ICmd2ModelAdapter _adapter;
		
		
		@Override
		public String apply(Class<?> index, DataPacket<String> host, IUser... params) {
			System.out.println(host.getData().toString());
			return "";
		}

		@Override
		public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
			// TODO Auto-generated method stub
			
		}
}
