import java.util.Scanner;

/**
 * Created by admin on 2016/10/10.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] hwStr = scanner.nextLine().split(" ");
        int h = Integer.valueOf(hwStr[0].trim());
        int w = Integer.valueOf(hwStr[1].trim());
        char[][] graph = new char[h][w];
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            String dotStr = scanner.nextLine();
            for (int j = 0; j < w; j++) {
                graph[i][j] = dotStr.charAt(j);
            }
        }
        int m = 0;
        int s = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[i][j] && graph[i][j]=='#') {
                    int[] ridge = new int[4];
                    ridge[1] = w-1;
                    ridge[3] = h-1;
                    dfs(graph, visited, i, j, ridge, h, w);
                    boolean isS = false;
                    boolean vertEven = false;
                    boolean horiEven = false;
                    int vertDiff = ridge[3]+ridge[2];
                    int horiDiff = ridge[1]+ridge[0];
                    if ((vertDiff) % 2 == 0)
                        vertEven = true;
                    if ((horiDiff) % 2 == 0)
                        horiEven = true;
                    if (vertEven && horiEven && graph[vertDiff/2][horiDiff/2] == '#')
                        isS = true;
                    else if (!vertEven && horiEven &&
                                (graph[(vertDiff+1)/2][horiDiff/2] == '#'
                                    || graph[(vertDiff-1)/2][horiDiff/2] == '#'))
                        isS = true;
                    else if (vertEven && !horiEven &&
                                (graph[(vertDiff)/2][horiDiff+1/2] == '#'
                                    || graph[(vertDiff)/2][horiDiff-1/2] == '#'))
                        isS = true;
                    else if (!vertEven && !horiEven &&
                                (graph[(vertDiff+1)/2][horiDiff+1/2] == '#'
                                    || graph[(vertDiff+1)/2][horiDiff-1/2] == '#'
                                        || graph[(vertDiff-1)/2][horiDiff+1/2] == '#'
                                        || graph[(vertDiff-1)/2][horiDiff-1/2] == '#'))
                        isS = true;
                    if (isS)
                        s++;
                    else
                        m++;
                } else {
                    visited[i][j] = true;
                }
            }
        }
        System.out.println(m + " " + s);
    }

    public static void dfs(char[][] g, boolean[][] v, int i, int j, int[] r, int h, int w) {
        v[i][j] = true;
        if (i > r[3])
            r[3] = i;
        if (i < r[2])
            r[2] = i;
        if (j > r[1])
            r[1] = j;
        if (j < r[0])
            r[0] = j;
        if ((i < h - 1) && (g[i+1][j] == '#') && (!v[i+1][j])) {
            dfs(g, v, i+1, j, r, h, w);
            if ((j < w - 1) && (g[i+1][j+1] == '#') && (!v[i+1][j+1]))
                dfs(g, v, i+1, j+1, r, h, w);
            if ((j > 0) && (g[i+1][j-1] == '#') && (!v[i+1][j-1]))
                dfs(g, v, i+1, j-1, r, h, w);
        }
        if ((i > 0) && (g[i-1][j] == '#') && (!v[i-1][j])) {
            dfs(g, v, i-1, j, r, h, w);
            if ((j < w - 1) && (g[i-1][j+1] == '#') && (!v[i-1][j+1]))
                dfs(g, v, i-1, j+1, r, h, w);
            if ((j > 0) && (g[i-1][j-1] == '#') && (!v[i-1][j-1]))
                dfs(g, v, i-1, j-1, r, h, w);
        }
        if ((j < w - 1) && (g[i][j+1] == '#') && (!v[i][j+1])) {
            dfs(g, v, i, j+1, r, h, w);
        }
        if ((j > 0) && (g[i][j-1] == '#') && (!v[i][j-1])) {
            dfs(g, v, i, j-1, r, h, w);
        }
    }
}
