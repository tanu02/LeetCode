//399. Evaluate Division
//https://leetcode.com/problems/evaluate-division/


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class EvaluateDivision399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        UnionFind uf = new UnionFind(equations);
        for (int j = 0; j < equations.size(); j++) {
            List<String> equation = equations.get(j);
            uf.union(equation.get(0), equation.get(1), values[j]);
        }

        double[] output = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String from = query.get(0);
            String to = query.get(1);

            output[i] = uf.query(from, to);
        }
        return output;
    }

    class UnionFind {
        //parent, distance
        Map<String, String> parent;
        Map<String, Double> distance;

        public UnionFind(List<List<String>> equations) {
//parent - self, distance 1
            parent = new HashMap<>();
            distance = new HashMap<>();
            for (int i = 0; i < equations.size(); i++) {
                List<String> equation = equations.get(i);

                String from = equation.get(0);
                String to = equation.get(1);

                parent.put(from, from);
                parent.put(to, to);
                distance.put(from, 1.0);
                distance.put(to, 1.0);
            }

        }

        public String find(String node) {
            String par = node;
            double product = distance.get(node);

            while (!parent.get(par).equals(par)) {
                par = parent.get(par);
                product *= distance.get(par);
            }
            parent.put(node, par);
            distance.put(node, product);
            return par;

        }

        public void union(String from, String to, double dst) {

            String p1 = find(from);
            String p2 = find(to);

            if (p1.equals(p2)) return;

            parent.put(p1, p2); //joining 2 diff parents
            double parentDis = dst * distance.get(to) / distance.get(from);
            distance.put(p1, parentDis);
        }

//from -> x    y <- to
//from -> x -- y <- to
// from/x x/y y/to = dst

//dst(from) * ans * 1/dst(to) = dst
//ans = dst * dst(to)/dst(from)

        public double query(String from, String to) {
            if (!parent.containsKey(from) || !parent.containsKey(to)) return -1;

            String p1 = find(from);
            String p2 = find(to);

            if (!p1.equals(p2)) return -1.0;

            return distance.get(from) / distance.get(to);
        }
    }
}


class Main17 {
    public static void main(String[] args) {
        EvaluateDivision399 sol = new EvaluateDivision399();

        String[][] equations = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        List<List<String>> eqList = Arrays.stream(equations).map(Arrays::asList).collect(Collectors.toList());
        List<List<String>> inputList = Arrays.stream(queries).map(Arrays::asList).collect(Collectors.toList());
        System.out.println(Arrays.toString(sol.calcEquation(eqList, values, inputList)));


        String[][] equations1 = {{"a", "b"}, {"b", "c"}, {"bc", "cd"}};
        double[] values1 = {1.5, 2.5, 5.0};
        String[][] queries1 = {{"a", "c"}, {"c", "b"}, {"bc", "cd"}, {"cd", "bc"}};
        List<List<String>> eqList1 = Arrays.stream(equations1).map(Arrays::asList).collect(Collectors.toList());
        List<List<String>> inputList1 = Arrays.stream(queries1).map(Arrays::asList).collect(Collectors.toList());

        //    System.out.println(Arrays.toString(sol.calcEquation(eqList1, values1, inputList1)));

    }
}