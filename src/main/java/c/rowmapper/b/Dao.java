package c.rowmapper.b;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class Dao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Use EnumUtils API to map enum.  Handles nulls as well as case insensitivity
     */
    private RowMapper<Order> rowMapper = new RowMapper() {
        @Override
        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Order.builder()
                    .orderId(rs.getString("ORDER_ID"))
                    .orderStatus(EnumUtils.getEnumIgnoreCase(OrderStatus.class, rs.getString("ORDER_STATUS"))) //can be overloaded to specify default
                    .build();
        }
    };

    public Order getById(String id) {
        return jdbcTemplate.queryForObject("SELECT * FROM order_enum_value WHERE ORDER_ID = ?", new Object[]{id}, rowMapper);
    }
}
