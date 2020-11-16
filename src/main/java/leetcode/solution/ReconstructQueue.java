package leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 406. 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，
 * k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 */
public class ReconstructQueue {

    /**
     * 从高到低考虑
     * 将每个人按照身高从大到小进行排序
     * 第 0, \cdots, i-10,⋯,i−1 个人已经在队列中被安排了位置，他们只要站在第 ii 个人的前面，就会对第 ii 个人产生影响，因为他们都比第 ii 个人高；
     * 而第 i+1, \cdots, n-1i+1,⋯,n−1 个人还没有被放入队列中，并且他们无论站在哪里，对第 ii 个人都没有任何影响，因为他们都比第 ii 个人矮。
     * @param people
     * @return
     */
    public int[][] solution(int[][] people) {
        Arrays.sort(people, (person1, person2) -> {
            if (person1[0] != person2[0]) {
                return person2[0] - person1[0];
            } else {
                return person1[1] - person2[1];
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
