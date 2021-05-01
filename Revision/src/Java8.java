import java.util.PriorityQueue;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8 {
    public void primitiveArrayToNonPrimitiveArray(int[] arr) {
        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());
    }

    public void primitiveArrayToNonPrimitiveList(int[][] arr) { //2d array to list
        Integer[][] output = Stream.of(arr).
                map(interval -> Arrays.stream(interval).boxed().toArray(Integer[]::new))
                .toArray(Integer[][]::new);
    }

    public void lambdaWithPriorityQueue(int[][] arr) {
        Queue<Integer[]> queue = new PriorityQueue<>((int1, int2) -> Integer.compare(int1[1], int2[1])); //sort based upon end time
    }

    public void sortArrayLambda(int[][] arr) {
        Arrays.sort(arr, (int1, int2) -> Integer.compare(int1[0], int2[0])); //sort based upon start time
    }

    public void sortListCollections(List<Integer> list) {
        Collections.sort(list, (a, b) -> Integer.compare(a, b));
    }

    public void listToArray() {
        List<Integer> list = new ArrayList<>();
        int size = list.size(); //first get the fixed size instead of using list.size()
        list.toArray(new Integer[size]);//{1,2}

        List<int[]> list2 = new ArrayList<>(); //{{}}
        int size1 = list2.size();
        int[][] output = list2.toArray(new int[size1][]);
    }

    public void arrayToList() { //create array or have an array
        int index = 0, left = 0, right = 1;
        List<List<Integer>> output = new ArrayList<>();

        List<Integer> ans = Arrays.asList(index, left, right); //output 3 indexes here primitive type
    }

    public void arrayToListObject() {
        Integer[] arr = new Integer[]{};
        List<Integer> list = Arrays.asList(arr);
        //either create Integer type array
        //else use stream and box the array
    }

    public void mapSyntax() {
        Map<Integer, Integer> map = new HashMap<>();

        if (map.containsKey(123)) {
        }

    }
}

