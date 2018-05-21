package com.utstar.kafkademo.admin;

public class Main {

	public static void main(String[] args) {
		ProducerDemo p = new ProducerDemo();
		ConsumeDemo c = new ConsumeDemo();
		p.start();
		c.start();
	}

}
