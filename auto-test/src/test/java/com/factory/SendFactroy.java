package com.factory;

public class SendFactroy {
	public Sender produce(String type) {  
		if (type.equals("mail")) {
			return new MailSender();
		}else {
			return new SmsSender();
		}
	}
	public static void main(String[] args) {
		SendFactroy sendFactroy = new SendFactroy();
		sendFactroy.produce("mail").send();
	}
}
