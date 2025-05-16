package kg.aklimoff.spy.utils;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class UniqueIdGenerator {
    private final Map<IdPrefix, AtomicLong> counters = new ConcurrentHashMap<>();

    public String generateIdForUser() {
        return generateId(IdPrefix.USER);
    }

    public String generateIdForProduct() {
        return generateId(IdPrefix.PRODUCT);
    }

    private String generateId(IdPrefix prefix) {
        AtomicLong counter = counters.computeIfAbsent(prefix, k -> new AtomicLong(0));
        long nextValue = counter.incrementAndGet();

        return String.format("%s%09d", prefix.getPrefix(), nextValue);
    }

    @Getter
    public enum IdPrefix {
        COMPANY("co"),
        USER("us"),
        PRODUCT("pr");

        private final String prefix;

        IdPrefix(String prefix) {
            this.prefix = prefix;
        }
    }
}
