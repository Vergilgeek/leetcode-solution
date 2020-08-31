package leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 841. 钥匙和房间
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 * 你可以自由地在房间之间来回走动。
 * 如果能进入每个房间返回 true，否则返回 false。
 */
public class CanVisitAllRooms {

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(List.of(6,7,8)); 
        rooms.add(List.of(5,4,9)); 
        rooms.add(List.of());
        rooms.add(List.of(8));
        rooms.add(List.of(4));
        rooms.add(List.of());
        rooms.add(List.of(1,9,2,3));
        rooms.add(List.of(7));
        rooms.add(List.of(6,5));
        rooms.add(List.of(2,3,1));
        solution(rooms);
    }

    /**
     * 深度优先搜索
     * 可以使用深度优先搜索的方式遍历整张图，统计可以到达的节点个数，并利用数组标记当前节点是否访问过，以防止重复访问。
     * 
     * 时间复杂度：O(n+m)O(n+m)，其中 nn 是房间的数量，mm 是所有房间中的钥匙数量的总数。
     * 空间复杂度：O(n)O(n)，其中 nn 是房间的数量。主要为栈空间的开销。
     * @param rooms
     * @return
     */
    public static boolean solution(final List<List<Integer>> rooms) {
        if (rooms.size() == 0) {
            return true;
        }
        int[] roomArr = new int[rooms.size()];
        roomArr[0] = 1;
        openRoom(roomArr, rooms, 0);
        for (int i : roomArr) {
            if (i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void openRoom(int[] roomArr,List<List<Integer>> rooms, int roomNum){
        for (int key : rooms.get(roomNum)) {
            if (roomArr[key] == 1){
                continue;
            }
            roomArr[key] = 1;
            openRoom(roomArr, rooms, key);
        }
    }
}