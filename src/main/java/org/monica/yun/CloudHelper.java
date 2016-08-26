package org.monica.yun;

import java.io.InputStream;
import java.io.OutputStream;

import org.monica.yun.base.CloudAdapter;
import org.monica.yun.base.CloudFile;
import org.monica.yun.local.LocalAdapter;

public class CloudHelper {

	private CloudAdapter adapter;

	private static class CloudHolder {
		private static final CloudHelper INSTANCE = new CloudHelper();
	}

	private CloudHelper() {

	}

	private static CloudHelper getInstance() {
		return CloudHolder.INSTANCE;
	}

	private static CloudFile createFile() {
		CloudHelper self = getInstance();
		if (self.adapter == null) {

		}

		return self.adapter.createFile();
	}

	public static void init(CloudType type, CloudParam param) {
		CloudHelper self = getInstance();

		switch (type) {
		case LOCAL:
			self.adapter = new LocalAdapter();
			break;
		default:
			break;
		}

		self.adapter.init(param);
	}

	public static void upload(String key, InputStream inStream) {
		upload(null, key, inStream);
	}

	public static void upload(String bucketName, String key, InputStream inStream) {
		CloudFile cloudFile = null;

		try {
			cloudFile = createFile();
			cloudFile.write(bucketName, key, inStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void download(String key, OutputStream outStream) {
		download(null, key, outStream);
	}

	public static void download(String bucketName, String key, OutputStream outStream) {
		CloudFile cloudFile = null;

		try {
			cloudFile = createFile();
			cloudFile.read(bucketName, key, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
