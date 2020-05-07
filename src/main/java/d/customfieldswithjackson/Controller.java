package d.customfieldswithjackson;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
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
