package com.kenni.datos.datos.model;

import lombok.Data;
import java.time.OffsetDateTime;
import java.util.Map;

@Data
public class CreditTransaction {
    private String transactionId;
    private String accountNumber;
    private String cardNumber;
    private String transactionType;
    private Double amount;
    private String currency;
    private Merchant merchant;
    private OffsetDateTime transactionDate;
    private String authorizationCode;
    private String status;
    private String description;
    private CreditDetails creditDetails;

    @Data
    public static class Merchant {
        private String name;
        private String merchantId;
        private Location location;

        @Data
        public static class Location {
            private String city;
            private String country;
        }
    }

    @Data
    public static class CreditDetails {
        private Double creditLimit;
        private Double availableCredit;
        private Double interestRate;
        private String dueDate;
    }
}