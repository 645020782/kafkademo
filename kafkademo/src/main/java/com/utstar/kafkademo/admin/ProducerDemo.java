package com.utstar.kafkademo.admin;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class ProducerDemo extends Thread {
	private Producer<String, String> producer;
	private Properties props;
	private int i = 0;
	public ProducerDemo() {
		props = new Properties();
        props.put("bootstrap.servers", "192.168.1.170:9092,192.168.1.171:9092,192.168.1.172:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<>(props);
	}
	
	@Override
	public void run() {
		String value = "producer : ";
		while (true) {
			producer.send(new ProducerRecord<String, String>("test", value + i));
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
