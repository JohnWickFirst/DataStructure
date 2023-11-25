package com.apigateway.demo.Enum;

public enum ServiceEnum {
        BackEndDb("BACKEND-DB/"),
        Header("http://");

        private final String serviceName;

        public String getServiceName() {
                return serviceName;
        }

        ServiceEnum(String serviceName) {
                this.serviceName = serviceName;
        }
}
