package com.advances.postman.config;

import com.advances.postman.DTO.RequestDTO;
import com.advances.postman.services.EarlyBirdDiscountService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

@Configuration
public class DiscountFeatureConfig {


    @Bean
    @ConditionalOnProperty(name = "feature.earlybird.enabled", havingValue = "false")
    public EarlyBirdDiscountService earlyBirdDiscountService() {

        return new EarlyBirdDiscountService();
    }

    @Bean
    @ConditionalOnProperty(name = "feature.earlybird.enabled", havingValue = "false", matchIfMissing = true)
    public EarlyBirdDiscountService EarlyBirdDiscountServiceDisable() {
        return new EarlyBirdDiscountService() {
            @Override
            public ResponseEntity<?> earlyBirdDiscount(RequestDTO dto) {
                return ResponseEntity.ok("El servicio está desactivado. Para activarlo añade true en notification.sms" +
                        ".enabled");
            }
        };
    }
}
