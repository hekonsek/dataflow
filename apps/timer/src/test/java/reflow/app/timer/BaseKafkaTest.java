package reflow.app.timer;

import org.apache.kafka.clients.consumer.Consumer;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.test.rule.KafkaEmbedded;

import static java.util.Collections.singletonList;
import static org.springframework.kafka.test.utils.KafkaTestUtils.consumerProps;
import static org.springframework.kafka.test.utils.KafkaTestUtils.producerProps;

@Configuration
public class BaseKafkaTest {

    @ClassRule
    public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, "vehicle");

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("spring.kafka.bootstrapServers", embeddedKafka.getBrokersAsString());
        System.setProperty("spring.cloud.stream.kafka.binder.zkNodes", embeddedKafka.getZookeeperConnectionString());
    }

    @Autowired
    protected ApplicationContext applicationContext;

    protected <K,V> Consumer<K, V> consumer(String topic) {
        Consumer<K,V> consumer = applicationContext.getBean(ConsumerFactory.class).createConsumer();
        consumer.subscribe(singletonList(topic));
        return consumer;
    }

    @Bean
    ConsumerFactory<?, ?> kafkaConsumerFactory() {
        return new DefaultKafkaConsumerFactory<Object, Object>(consumerProps("test", "true", embeddedKafka));
    }

    @Bean
    ProducerFactory<?, ?> kafkaProducerFactory() {
        return new DefaultKafkaProducerFactory<>(producerProps(embeddedKafka));
    }

}
