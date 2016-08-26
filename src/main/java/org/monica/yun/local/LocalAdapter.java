package org.monica.yun.local;

import org.monica.yun.CloudParam;
import org.monica.yun.base.CloudAdapter;

public class LocalAdapter extends CloudAdapter {

	@Override
	public void init(CloudParam param) {
		file = new LocalFile(param);
	}

}
