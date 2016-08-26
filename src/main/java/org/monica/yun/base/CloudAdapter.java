package org.monica.yun.base;

import org.monica.yun.CloudParam;

public abstract class CloudAdapter {

	protected CloudFile file;

	public CloudFile createFile() {
		return this.file;
	}

	public abstract void init(CloudParam param);

}
