package design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author arnab.ray
 * @created on 05/11/22
 */
public class Logger {
    Map<String, Integer> logs;

    public Logger() {
        logs = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (logs.containsKey(message)) {
            if (timestamp - logs.get(message) >= 0) {
                logs.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        } else {
            logs.put(message, timestamp);
        }

        return true;
    }
}
