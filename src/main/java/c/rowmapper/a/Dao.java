package c.rowmapper.a;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class Dao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Order> rowMapper = new RowMapper() {
        @Override
        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Order.builder()
                    .orderId(rs.getString("ORDER_ID"))
                    .orderStatus(OrderStatus.valueOf(rs.getString("ORDER_STATUS")))
                    .build();
        }
    };

    public Order getById(String id) {
        return jdbcTemplate.queryForObject("SELECT * FROM order_enum_value WHERE ORDER_ID = ?", new Object[]{id}, rowMapper);
    }
}
