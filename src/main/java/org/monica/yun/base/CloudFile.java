package org.monica.yun.base;

import java.io.InputStream;
import java.io.OutputStream;

import org.monica.yun.CloudParam;

public abstract class CloudFile {

	protected CloudParam param;

	protected String getRealBucket(String bucketName) {
		return bucketName != null ? bucketName : param.getBucketName();
	}
	
	protected abstract String getRealKey(String bucketName, String key);

	public abstract void read(String bucketName, String key, OutputStream outStream);

	public abstract void write(String bucketName, String key, InputStream inStream);
	
}
