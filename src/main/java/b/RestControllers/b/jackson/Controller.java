package b.RestControllers.b.jackson;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    /**
     * Uses jackson to deserialize json into an object with the help of @JsonCreator.
     * @param order
     * @return
     */
    @GetMapping(value = "/requestbody", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Order get(@RequestBody
                              Order order) {

        System.out.println("OrderId: " + order.getOrderId());
        System.out.println("OrderStatus:" + order.getOrderStatus().toString());
        order.setOrderId((order.getOrderId() + "-changed"));

        return order;
    }
}
