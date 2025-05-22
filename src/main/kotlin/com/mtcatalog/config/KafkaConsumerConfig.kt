package com.mtcatalog.config

import com.mtcatalog.dtos.AnnouncedItemDto
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

@Configuration
@EnableKafka
class KafkaConsumerConfig(
    @Value("\${spring.kafka.bootstrap-server}")
    private val bootstrapServers: String
) {

    @Bean
    fun consumerFactory(): ConsumerFactory<String, AnnouncedItemDto> {
        val deserializer = JsonDeserializer(AnnouncedItemDto::class.java)
        deserializer.setUseTypeMapperForKey(true)

        val configs = mapOf(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to bootstrapServers,
            ConsumerConfig.GROUP_ID_CONFIG to "catalog-group",
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to JsonDeserializer::class.java,
            ConsumerConfig.AUTO_OFFSET_RESET_CONFIG to "earliest"
        )
        return DefaultKafkaConsumerFactory(configs, StringDeserializer(), deserializer)
    }

    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, AnnouncedItemDto>{
        val factory: ConcurrentKafkaListenerContainerFactory<String, AnnouncedItemDto> =
            ConcurrentKafkaListenerContainerFactory()
        factory.consumerFactory = consumerFactory()

        return factory
    }
}