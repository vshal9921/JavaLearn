public class Enum {

    public enum Day{sunday,monday,tuesday}

    public static void main(String[] args) {

        Day[] dayData = Day.values();

        for(Day day : dayData){
            System.out.println(day.name());
        }

    }
}