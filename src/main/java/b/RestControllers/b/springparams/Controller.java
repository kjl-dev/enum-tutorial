package b.RestControllers.b.springparams;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    /**
     * Converts string request params to an enum via the converter declared in main.
     *
     * @param orderId
     * @param orderStatus
     * @return
     */
    @GetMapping("/requestparams")
    @ResponseBody
    public Order get(
            @RequestParam
                    String orderId,
            @RequestParam
                    OrderStatus orderStatus) {
        System.out.println("OrderId: " + orderId);
        System.out.println("OrderStatus:" + orderStatus.toString());

        return new Order(orderId + "-changed", orderStatus);
    }

}
