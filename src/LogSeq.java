import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jinglongyang on 12/2/14.
 */
public class LogSeq {
    private final List<String> pageTypes = new ArrayList<>(6);
    private int count;

    public void addPageType(String pageType) {
        pageTypes.add(pageType);
    }

    public int size() {
        return pageTypes.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogSeq)) return false;
        LogSeq logSeq = (LogSeq) o;
        if (!pageTypes.equals(logSeq.pageTypes)) return false;
        return true;
    }

    public void removeFirst() {
        ((LinkedList) pageTypes).removeFirst();
    }

    @Override
    public int hashCode() {
        return pageTypes.hashCode();
    }
}
