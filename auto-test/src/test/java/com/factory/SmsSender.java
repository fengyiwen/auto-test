package com.factory;

public class SmsSender implements Sender{

	@Override
	public void send() {
		System.out.println("SmsSender.send()");
	}

}
