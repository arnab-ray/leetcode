package string.medium;

import java.util.regex.Pattern;

public class ValidateIPAddress {
    public String validIPAddress(String IP) {
        String IPV4 = "^((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]\\d|\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]\\d|\\d)$";
        String IPV6 = "^([0-9a-fA-F]{1,4}:){7}([0-9a-fA-F]{1,4})$";

        Pattern IPV4_PATTERN = Pattern.compile(IPV4);
        Pattern IPV6_PATTERN = Pattern.compile(IPV6);

        if(IPV4_PATTERN.matcher(IP).matches())
            return "IPv4";
        else if(IPV6_PATTERN.matcher(IP).matches())
            return "IPv6";
        else
            return "Neither";
    }
}
