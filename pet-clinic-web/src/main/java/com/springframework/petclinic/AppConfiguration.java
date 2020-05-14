package com.springframework.petclinic;

import com.spring.petclinic.services.OwnerService;
import com.spring.petclinic.services.VetService;
import com.spring.petclinic.services.map.OwnerServiceMapImpl;
import com.spring.petclinic.services.map.VetServiceMapImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public OwnerService getOwnerService(){
        return new OwnerServiceMapImpl();
    }

    @Bean
    public VetService getVetService(){
        return new VetServiceMapImpl();
    }
}
