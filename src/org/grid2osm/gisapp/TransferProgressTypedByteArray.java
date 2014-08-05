package org.grid2osm.gisapp;

import java.io.IOException;
import java.io.OutputStream;

import de.greenrobot.event.EventBus;

import retrofit.mime.TypedByteArray;

public class TransferProgressTypedByteArray extends TypedByteArray {

	public TransferProgressTypedByteArray(String mimeType, byte[] bytes) {
		super(mimeType, bytes);
	}

	@Override
	public void writeTo(OutputStream out) throws IOException {
		EventBus.getDefault().post(
				new TransferProgressChangedEvent(this.getBytes().length));
		out.write(this.getBytes());
	}

}
