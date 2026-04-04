@Configuration
public class KafkaProducerConfig{

    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(
          ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
          "localhost:9092");

        config.put(
          ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
          JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(config);
    }



}