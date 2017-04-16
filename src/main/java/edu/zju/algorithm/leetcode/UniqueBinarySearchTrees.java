import com.sun.javafx.scene.control.skin.VirtualFlow;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2015/9/14.
 */
public class UniqueBinarySearchTrees {
    List<Integer> list = new ArrayList<>();
    public int numTrees(int n) {
        if (n == 0 || n == 1)
            return 1;
        list.add(1);
        list.add(1);
        for (int i = 2; i <= n; i++)
            recursion(i);
        return list.get(n);
    }

    public void recursion(int n){
        int num = 0;
        for (int i = 0; i < n; i++)
            num += list.get(i)*list.get(n - i - 1);
        list.add(num);
    }
}
