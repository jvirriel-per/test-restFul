package com.jvirriel.testrestful.backend.bus;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;

import java.util.concurrent.CountDownLatch;

public class Listener {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	public CountDownLatch countDownLatch0 = new CountDownLatch(16);
	public CountDownLatch countDownLatch1 = new CountDownLatch(16);
	public CountDownLatch countDownLatch2 = new CountDownLatch(16);
	public CountDownLatch countDownLatch3 = new CountDownLatch(16);
	public CountDownLatch countDownLatch4 = new CountDownLatch(16);
	public CountDownLatch countDownLatch5 = new CountDownLatch(16);
	public CountDownLatch countDownLatch6 = new CountDownLatch(16);
	public CountDownLatch countDownLatch7 = new CountDownLatch(16);
	public CountDownLatch countDownLatch8 = new CountDownLatch(16);
	public CountDownLatch countDownLatch9 = new CountDownLatch(16);
	public CountDownLatch countDownLatch10 = new CountDownLatch(16);
	public CountDownLatch countDownLatch11 = new CountDownLatch(16);
	public CountDownLatch countDownLatch12 = new CountDownLatch(16);
	public CountDownLatch countDownLatch13 = new CountDownLatch(16);
	public CountDownLatch countDownLatch14 = new CountDownLatch(16);
	public CountDownLatch countDownLatch15 = new CountDownLatch(16);



	@KafkaListener(id = "id0", topicPartitions = { @TopicPartition(topic = "${topic.helloworld}", partitions = { "0" }) })
	public void listenPartition0(ConsumerRecord<?, ?> record) {
		System.out.println("Listener Id0, Thread ID: " + Thread.currentThread().getId());
		LOGGER.info("Received: " + record);
		countDownLatch0.countDown();
	}

	@KafkaListener(id = "id1", topicPartitions = { @TopicPartition(topic = "${topic.helloworld}", partitions = { "1" }) })
	public void listenPartition1(ConsumerRecord<?, ?> record) {
		System.out.println("Listener Id1, Thread ID: " + Thread.currentThread().getId());
		LOGGER.info("Received: " + record);
		countDownLatch1.countDown();
	}

	@KafkaListener(id = "id2", topicPartitions = { @TopicPartition(topic = "${topic.helloworld}", partitions = { "2" }) })
	public void listenPartition2(ConsumerRecord<?, ?> record) {
		System.out.println("Listener Id2, Thread ID: " + Thread.currentThread().getId());
		LOGGER.info("Received: " + record);
		countDownLatch2.countDown();
	}

	@KafkaListener(id = "id3", topicPartitions = { @TopicPartition(topic = "${topic.helloworld}", partitions = { "3" }) })
	public void listenPartition3(ConsumerRecord<?, ?> record) {
		System.out.println("Listener Id3, Thread ID: " + Thread.currentThread().getId());
		LOGGER.info("Received: " + record);
		countDownLatch3.countDown();
	}

	@KafkaListener(id = "id4", topicPartitions = { @TopicPartition(topic = "${topic.helloworld}", partitions = { "4" }) })
	public void listenPartition4(ConsumerRecord<?, ?> record) {
		System.out.println("Listener Id4, Thread ID: " + Thread.currentThread().getId());
		LOGGER.info("Received: " + record);
		countDownLatch4.countDown();
	}

	@KafkaListener(id = "id6", topicPartitions = { @TopicPartition(topic = "${topic.helloworld}", partitions = { "6" }) })
	public void listenPartition6(ConsumerRecord<?, ?> record) {
		System.out.println("Listener Id6, Thread ID: " + Thread.currentThread().getId());
		LOGGER.info("Received: " + record);
		countDownLatch6.countDown();
	}

	@KafkaListener(id = "id5", topicPartitions = { @TopicPartition(topic = "${topic.helloworld}", partitions = { "5" }) })
	public void listenPartition5(ConsumerRecord<?, ?> record) {
		System.out.println("Listener Id5, Thread ID: " + Thread.currentThread().getId());
		LOGGER.info("Received: " + record);
		countDownLatch5.countDown();
	}

	@KafkaListener(id = "id7", topicPartitions = { @TopicPartition(topic = "${topic.helloworld}", partitions = { "7" }) })
	public void listenPartition7(ConsumerRecord<?, ?> record) {
		System.out.println("Listener Id7, Thread ID: " + Thread.currentThread().getId());
		LOGGER.info("Received: " + record);
		countDownLatch7.countDown();
	}

	@KafkaListener(id = "id8", topicPartitions = { @TopicPartition(topic = "${topic.helloworld}", partitions = { "8" }) })
	public void listenPartition8(ConsumerRecord<?, ?> record) {
		System.out.println("Listener Id8, Thread ID: " + Thread.currentThread().getId());
		LOGGER.info("Received: " + record);
		countDownLatch8.countDown();
	}

	@KafkaListener(id = "id9", topicPartitions = { @TopicPartition(topic = "${topic.helloworld}", partitions = { "9" }) })
	public void listenPartition9(ConsumerRecord<?, ?> record) {
		System.out.println("Listener Id9, Thread ID: " + Thread.currentThread().getId());
		LOGGER.info("Received: " + record);
		countDownLatch9.countDown();
	}

	@KafkaListener(id = "id10", topicPartitions = { @TopicPartition(topic = "${topic.helloworld}", partitions = { "10" }) })
	public void listenPartition10(ConsumerRecord<?, ?> record) {
		System.out.println("Listener Id10, Thread ID: " + Thread.currentThread().getId());
		LOGGER.info("Received: " + record);
		countDownLatch10.countDown();
	}

	@KafkaListener(id = "id11", topicPartitions = { @TopicPartition(topic = "${topic.helloworld}", partitions = { "11" }) })
	public void listenPartition11(ConsumerRecord<?, ?> record) {
		System.out.println("Listener Id11, Thread ID: " + Thread.currentThread().getId());
		LOGGER.info("Received: " + record);
		countDownLatch11.countDown();
	}

	@KafkaListener(id = "id12", topicPartitions = { @TopicPartition(topic = "${topic.helloworld}", partitions = { "12" }) })
	public void listenPartition12(ConsumerRecord<?, ?> record) {
		System.out.println("Listener Id12, Thread ID: " + Thread.currentThread().getId());
		LOGGER.info("Received: " + record);
		countDownLatch12.countDown();
	}

	@KafkaListener(id = "id13", topicPartitions = { @TopicPartition(topic = "${topic.helloworld}", partitions = { "13" }) })
	public void listenPartition13(ConsumerRecord<?, ?> record) {
		System.out.println("Listener Id13, Thread ID: " + Thread.currentThread().getId());
		LOGGER.info("Received: " + record);
		countDownLatch13.countDown();
	}

	@KafkaListener(id = "id14", topicPartitions = { @TopicPartition(topic = "${topic.helloworld}", partitions = { "14" }) })
	public void listenPartition14(ConsumerRecord<?, ?> record) {
		System.out.println("Listener Id14, Thread ID: " + Thread.currentThread().getId());
		LOGGER.info("Received: " + record);
		countDownLatch14.countDown();
	}

	@KafkaListener(id = "id15", topicPartitions = { @TopicPartition(topic = "${topic.helloworld}", partitions = { "15" }) })
	public void listenPartition15(ConsumerRecord<?, ?> record) {
		System.out.println("Listener Id15, Thread ID: " + Thread.currentThread().getId());
		LOGGER.info("Received: " + record);
		countDownLatch15.countDown();
	}


}
