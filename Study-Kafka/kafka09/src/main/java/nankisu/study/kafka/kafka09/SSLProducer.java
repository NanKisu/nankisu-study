package nankisu.study.kafka.kafka09;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class SSLProducer {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties props = new Properties();
		props.put("bootstrap.servers", "kisu-kafka01.foo.bar:9093,kisu-kafka02.foo.bar:9093,kisu-kafka03.foo.bar:9093");
		props.put("security.protocol", "SSL");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = new KafkaProducer<String, String>(props);

		try {
			for(int i = 0; i < 1; i++) {
				ProducerRecord<String, String> record = new ProducerRecord<String, String>("ch9-test01", "ch9-test01 record");
				producer.send(record).get();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			producer.close();
		}
	}
}
