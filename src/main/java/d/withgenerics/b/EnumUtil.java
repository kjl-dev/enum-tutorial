package d.withgenerics.b;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import static java.util.EnumSet.allOf;

public class EnumUtil {

    public static <E extends Enum<E> & EnumValueType> E fromStringValue(final Class<E> enumClazz, final String value) {

        if(StringUtils.isBlank(value)) {
            throw new IllegalArgumentException(String.format("Invalid value a {} for {}}", value, enumClazz));
        }

        String trimmedValue = StringUtils.trim(value);
        Optional<E> result = fromValue(enumClazz, trimmedValue);

        if (!result.isPresent()) {
            throw new IllegalArgumentException(String.format("Invalid value a {} for {}", trimmedValue, enumClazz));
        }

        return result.get();
    }


    public static <E extends Enum<E> & EnumValueType> E fromStringValue(final Class<E> enumClazz, final String value, final E defaultValue) {

        if(StringUtils.isBlank(value)) {
            return defaultValue;
        }

        String trimmedValue = StringUtils.trim(value);
        Optional<E> result = fromValue(enumClazz, value);
        return result.isPresent() ? result.get() : defaultValue;
    }


    private static <E extends Enum<E> & EnumValueType> Optional<E> fromValue(final Class<E> enumClazz, final String value) {
        return allOf(enumClazz)
                .stream()
                .filter(type -> type.getValue().equalsIgnoreCase(value))
                .findFirst();
    }
}