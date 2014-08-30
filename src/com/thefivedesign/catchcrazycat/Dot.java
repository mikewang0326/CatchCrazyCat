package com.thefivedesign.catchcrazycat;

public class Dot {

	private int x;
	private int y;

	private int status;

	public static final int STATUS_OFF = 0;
	public static final int STATUS_ON = 1;
	public static final int STATUS_IN = 2;

	public Dot (int x, int y) {
		this.x = x;
		this.y = y;
		status = STATUS_ON;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setXY() {
		this.x = x;
		this.y = y;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
