package stepdefs;

import org.apache.commons.exec.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateHelper {

    public  String parseTimeModifyingStringToDateString(String modifyingString, String format) {
        Date date = new Date();
        Long timestamp = date.getTime();

        if ("BST".contains(parseDateTime(System.currentTimeMillis() , "z")) && modifyingString.contains("UTC") ) {
            timestamp -= getInterval("h", 1);
        }
        String modifyString = modifyingString.replace("UTC","");

        if(modifyString == null || modifyString.equals("now")) {
            return parseDateTime(new Date().getTime() , format);
        }

        Pattern pattern = Pattern.compile("now (?<operator>[+-])(?<modifiers>([0-9]{1,3}[dhms] ?){1,3})");
        Matcher matcher = pattern.matcher(modifyString);
        if (matcher.matches()) {
            String[] modifiers = StringUtils.split(matcher.group("modifiers"), " ");
            Pattern modifierPattern = Pattern.compile("(?<interval>[0-9]{1,3})(?<modifier>[dhms])");

            for(String modifier : modifiers) {
                Matcher modifierMatcher = modifierPattern.matcher(modifier);

                if(modifierMatcher.matches()) {
                    if (matcher.group("operator").equals("+")) {
                        timestamp += getInterval(modifierMatcher.group("modifier"), Integer.parseInt(modifierMatcher.group("interval")));
                    } else if (matcher.group("operator").equals("-")) {
                        timestamp -= getInterval(modifierMatcher.group("modifier"), Integer.parseInt(modifierMatcher.group("interval")));
                    }
                }
            }
        }
        date.setTime(timestamp);

        return parseDateTime(date.getTime() , format);
    }

    private  Long getInterval(String modifier, int interval) {
        switch(modifier) {
            case "d":
                return TimeUnit.DAYS.toMillis(interval);
            case "h":
                return TimeUnit.HOURS.toMillis(interval);
            case "m":
                return TimeUnit.MINUTES.toMillis(interval);
            default:
                return TimeUnit.SECONDS.toMillis(interval);
        }
    }

    private  String parseDateTime(Long modifyingString, String format) {
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat(format);
        return dateTimeFormat.format(modifyingString);
    }

}
