package leetcode.bfs;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution133 {
    private Node[] nodes =new Node[101];
    public Node cloneGraph(Node node) {
        /**
         先创建节点。然后创建与之相连的节点。添加到neighhood中，并入队。
         create【】标记是否以及创建了该节点，已经创建则添加进neighood中，否则创建后添加进去。，visited判断是否已经在队列中，在的不用入队了。
         用Nodes<Node> 数组存新创建的节点。然后广度优先即可。
         nodes:深拷贝的数组
         */
        if (node==null) return null;
        int root = node.val;

        nodes[root] =new Node(root);
        if (node.neighbors==null||node.neighbors.size()==0){
            return nodes[root];
        }
        Queue<Node> q = new LinkedList<>();
        Set<Integer> visted =new HashSet<>();
        q.add(node);
        visted.add(node.val);
        while (!q.isEmpty()){
            Node node1=q.poll();
            int node1Val = node1.val;
            List<Node> nodeList = node1.neighbors;
            for (Node temp:nodeList) {
                int val = temp.val;
                // 该新节点未创建，则创建
                if (nodes[val]==null){
                    nodes[val]=new Node(val);
                    // 如果该节点邻居未初始化，则初始化。
                    if (nodes[val].neighbors==null){
                        nodes[node1Val].neighbors=new ArrayList<>();
                    }
                    if (!visted.contains(val)){
                        q.offer(temp);
                        visted.add(val);
                    }
                }
                nodes[node1Val].neighbors.add(nodes[val]);
            }
        }

        return nodes[root];

    }
}


public class leetcode133 {
}
