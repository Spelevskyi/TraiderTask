package by.company.TraiderTask.util;

import by.company.TraiderTask.model.Post;

import java.util.Comparator;

public class RantingComparator implements Comparator<Post> {
    public int compare(Post a,Post b){
        return b.getRanting() - a.getRanting();
    }
}
