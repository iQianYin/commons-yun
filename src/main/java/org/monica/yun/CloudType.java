package org.monica.yun;

public enum CloudType {

	/** 0: 本地文件local **/
	LOCAL("local file storage"),

	/** 1: 亚马逊s3 **/
	S3("amazon s3 storage"),

	/** 2: 阿里巴巴oss **/
	OSS("alibaba oss storage"),

	/** 3: 金山云ks3 **/
	KS3("kingsoft ks3 storage");

	private String type;

	private CloudType(String type) {
		this.type = type;
	}

	public String toString() {
		return this.type;
	}
	
}
