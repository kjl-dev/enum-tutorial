package b.RestControllers.a.dfault;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    /**
     * A simple method that shows how Spring automatically converts a @RequestParam to an enum for us.
     *
     * @param orderId
     * @param orderStatus
     * @return
     */
    @GetMapping("/requestparams")
    @ResponseBody
    public Order get(@RequestParam String orderId, @RequestParam OrderStatus orderStatus) {
        System.out.println("OrderId: " + orderId);
        System.out.println("OrderStatus:" + orderStatus.toString());

        // Perform a simple mutation on the orderId to reflect this code is being executed
        return new Order(orderId + "-a", orderStatus);
    }


    /**
     * A simple method that shows how Jackson automatically converts a field in a @RequestBody to an enum for us.
     * @param order
     * @return
     */
    @GetMapping(value = "/requestbody", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Order get(@RequestBody Order order) {
        System.out.println("OrderId: " + order.getOrderId());
        System.out.println("OrderStatus:" + order.getOrderStatus().toString());
        order.setOrderId((order.getOrderId() + "-changed"));
        return order;
    }
}
