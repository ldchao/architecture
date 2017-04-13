package service.search_good_sort;

import vo.GoodVO;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ldchao on 2017/4/13.
 */
public class SortByCommentsVolume implements SortStrategy{
    public void sort(List<GoodVO> goodVOList) {
        Collections.sort(goodVOList, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((GoodVO)o2).getComments_volume()-((GoodVO)o1).getComments_volume();
            }
        });
    }
}
