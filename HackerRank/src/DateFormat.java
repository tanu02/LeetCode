import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DateFormat {
    public static void main(String[] args) {
        double a = 1.1;
        List<String > input = new ArrayList<>();
        input.add("28th Jul 1963");
        List<String> out = preprocessDate(input);
        for (String s : out) {
            System.out.println(s);
        }
    }

    public static List<String> preprocessDate(List<String> dates) {
        // Write your code here
        Map<String, String> monthMap = new HashMap<>();
        String[] monthArr = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov","Dec"};
        String[] monthNum = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        List<String> output = new ArrayList<>();
        for(int i = 0; i < monthArr.length; i++){
            monthMap.put(monthArr[i], monthNum[i]);
        }

        for(int i = 0; i < dates.size(); i++){
            String[] date = dates.get(i).split(" ");
            StringBuilder sb = new StringBuilder();
            sb.append(date[2]).append("-").append(monthMap.get(date[1])).append("-");

            String sub = "";
            if(date[0].length() > 3){
                sub = date[0].substring(0, 2);
            }
            else{
                sb.append("0");
                sub  = date[0].substring(0, 1);
            }

            sb.append(sub);
            output.add(sb.toString());
        }
        return output;
    }
}