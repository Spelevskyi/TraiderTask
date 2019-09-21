package mvc.util;

import mvc.models.Post;

import java.util.Comparator;

public class RantingComparator implements Comparator<Post> {
    public int compare(Post a,Post b){
        return b.getRanting() - a.getRanting();
    }
}
