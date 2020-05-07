package b.RestControllers.a;

/**
 All examples can be run in your IDE.

 You can send requests through your favorite API Client like Postman, or you can send them via cURL:

 Examples using RequestParams:
 curl --location --request GET 'http://localhost:8080/requestparams/?orderId=123&orderStatus=CANCELLED'

 Examples using RequestBody:
 curl --location --request GET 'http://localhost:8080/requestbody/' \
 --header 'Content-Type: application/json' \
 --data-raw '{
 "orderId" : "123",
 "orderStatus": "CANCELLED"
 }'

 **/