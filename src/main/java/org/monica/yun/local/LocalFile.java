package org.monica.yun.local;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.monica.yun.CloudParam;
import org.monica.yun.base.CloudFile;

public class LocalFile extends CloudFile {

	public LocalFile(CloudParam param) {
		this.param = param;
	}

	@Override
	protected String getRealKey(String bucketName, String key) {
		StringBuilder builder = new StringBuilder();
		String realBucket = getRealBucket(bucketName);
		builder.append(realBucket).append("/");
		if (param.getBucketName().equalsIgnoreCase(realBucket)) {
			builder.append(param.getRootDir()).append("/");
		}

		return builder.append(key).toString();
	}

	@Override
	public void read(String bucketName, String key, OutputStream outStream) {
		InputStream inStream = null;

		try {
			String name = getRealKey(bucketName, key);
			inStream = new FileInputStream(name);
			IOUtils.copy(inStream, outStream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(inStream);
		}
	}

	@Override
	public void write(String bucketName, String key, InputStream inStream) {
		OutputStream outStream = null;

		try {
			String name = getRealKey(bucketName, key);
			File destFile = new File(name);
			File parent = destFile.getParentFile();
			if (parent != null && !parent.exists()) {
				parent.mkdirs();
			}

			outStream = new FileOutputStream(destFile);
			IOUtils.copy(inStream, outStream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(outStream);
		}
	}

}
