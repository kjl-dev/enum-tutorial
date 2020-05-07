package d.withgenerics.b;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderSource implements EnumValueType {

    WEB("W"),
    STORE("S");

    private String value;

    @JsonCreator
    public static OrderSource fromValue(final String value) {
        return EnumUtil.fromStringValue(OrderSource.class, value, STORE);
    }
}
