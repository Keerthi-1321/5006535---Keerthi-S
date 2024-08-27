package com.example.BookstoreAPI.config;


import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfig {

    @Bean
    public MeterRegistry meterRegistry() {
        return new SimpleMeterRegistry();
    }

    @Bean
    public CustomMetrics customMetrics(MeterRegistry meterRegistry) {
        return new CustomMetrics(meterRegistry);
    }
}

class CustomMetrics {

    private final MeterRegistry meterRegistry;

    public CustomMetrics(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        registerCustomMetrics();
    }

    private void registerCustomMetrics() {
        // Example of a custom gauge
        meterRegistry.gauge("custom_metric_example", Tags.of("type", "example"), this, CustomMetrics::getMetricValue);
    }

    // Method to return the metric value
    public double getMetricValue() {
        // Return some dynamic value; for example, this could be a count or status
        return 1.0; // Example static value, replace with actual metric value
    }
}

