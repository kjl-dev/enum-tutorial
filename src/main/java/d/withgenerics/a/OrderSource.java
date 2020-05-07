package d.withgenerics.a;

import java.util.EnumSet;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
@AllArgsConstructor
public enum OrderSource {

    WEB("W"),
    STORE("S");

    private String sourceCode;

    // Nearly duplicate code!
    @JsonCreator
    public static OrderSource fromValue(final String value) {

        if(StringUtils.isBlank(value)) {
            return STORE;
        }

        Optional<OrderSource> result = EnumSet.allOf(OrderSource.class)
                .stream()
                .filter(type -> type.getSourceCode().equalsIgnoreCase(value))
                .findFirst();

        return result.isPresent() ? result.get() : STORE;
    }
}
