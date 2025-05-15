package com.advances.postman.controllers;

import com.advances.postman.DTO.RequestDTO;
import com.advances.postman.services.EarlyBirdDiscountService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DiscountController {
    private final EarlyBirdDiscountService earlyBirdDiscountService;

    @Autowired
    public DiscountController(EarlyBirdDiscountService earlyBirdDiscountService) {
        this.earlyBirdDiscountService = earlyBirdDiscountService;
    }


    @PostMapping("/discount")
    public ResponseEntity<?>  discount(@Valid @RequestBody RequestDTO dto){
       return earlyBirdDiscountService.earlyBirdDiscount(dto);
    }






}
