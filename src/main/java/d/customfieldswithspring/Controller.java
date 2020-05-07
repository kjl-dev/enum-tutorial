package d.customfieldswithspring;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/spring")
    @ResponseBody
    public Order get(@RequestParam String orderId, @RequestParam
            OrderStatus orderStatus) {
        System.out.println("OrderId: " + orderId);
        System.out.println("OrderStatus:" + orderStatus.toString());

        return new Order(orderId + "-changed", orderStatus);
    }

}
