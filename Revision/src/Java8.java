import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8 {
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
        int[][] output = list2.toArray(new int[size1][]);//output is  array - have to provide size
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

    public void primitiveArrayToNonPrimitiveArray(int[] arr) {
        List<Integer> list = Arrays.stream(arr) //permutation
                .boxed()
                .collect(Collectors.toList());
    }

    public void mapSyntax() {
        Map<Integer, Integer> map = new HashMap<>();

        if (map.containsKey(123)) {
        }

    }

    public void copyPieceOfList(int k) { //top k
        int[] arr = new int[0];
        int[] output = Arrays.copyOfRange(arr, 0, k); //1 d array copy a range [   )

        int[][] arr1 = new int[0][0];
        int[][] output1 = Arrays.copyOfRange(arr1, 0, k); // 2 d array copy a range
//                                                      [   )
    }

    public void populateArrayWithDefaultVaue(int[] rank) { //disJoing/Kruskal
        Arrays.fill(rank, 1);
    }

    public void concepts() {
        //in normal bfs we find distance - level wise count++;
        //topo sort every element in the queue was put up in the answer inside while loop  count++

//course schedule: if queue is used it can contain nodes which are not present in adj map number of courses > than  dependencies
//connected  components can  contain like 5 nodes and only 1 edge
    }

    public void invertbinaryColorNode() {
        int color = 1;       //1
        int invert = color ^ 1; //0
    }

    public void fill2DArray(int[][] dp) {
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
    }

    public void lengths() {
        String s = "";
        int[] arr = new int[1];
        List<Integer> list = new ArrayList<>();

        int a = arr.length;
        s.length();
        list.size();
    }

    void print2dArray(int[][] arr) {
        Stream.of(arr).forEach(arr1 -> System.out.println(Arrays.toString(arr1)));
    }
}

