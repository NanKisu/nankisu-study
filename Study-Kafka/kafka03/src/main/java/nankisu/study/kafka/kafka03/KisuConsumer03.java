package nankisu.study.kafka.kafka03;

import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class KisuConsumer03 {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("bootstrap.servers", "kisu-kafka01.foo.bar:9092,kisu-kafka02.foo.bar:9092,kisu-kafka03.foo.bar:9092");
		props.put("group.id", "kisu-consumer01");
		props.put("enable.auto.commit", "false");
		props.put("auto.offset.reset", "latest");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

		Consumer<String, String> consumer = new KafkaConsumer<String, String>(props);
		consumer.subscribe(Set.of("kisu-basic01"));

		try {
			while(true) {
				ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
				for(ConsumerRecord<String, String> record : records) {
					System.out.printf("Topic: %s, Partition: %d, Offset: %d, Key: %s, Received Message: %s\n", record.topic(), record.partition(), record.offset(), record.key(), record.value());
				}
				consumer.commitAsync();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			consumer.close();
		}
	}
}
