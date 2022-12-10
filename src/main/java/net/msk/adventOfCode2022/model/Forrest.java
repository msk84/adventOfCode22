package net.msk.adventOfCode2022.model;

import java.util.ArrayList;
import java.util.List;

public class Forrest {

    private final List<List<Tree>> trees = new ArrayList<>();

    public Forrest(final List<String> forrestData) {
        forrestData.forEach(d -> this.trees.add(d.chars()
                    .mapToObj(Character::getNumericValue)
                    .map(Tree::new)
                    .toList()));
    }

    public long getNumberOfVisibleTrees() {
        this.calculateTreeVisibility();
        long visibleTreeCount = 0;
        for(final List<Tree> treeRow : this.trees){
            visibleTreeCount += treeRow.stream()
                    .filter(Tree::isVisible)
                    .count();
        }
        return visibleTreeCount;
    }

    private void calculateTreeVisibility() {
        final int edgeLength = this.trees.size();
        for(int i=0; i<edgeLength; i++) {
            int currentMaxHeightLeft = -1;
            int currentMaxHeightRight = -1;
            int currentMaxHeightTop = -1;
            int currentMaxHeightBottom = -1;
            for(int j=0; j<edgeLength; j++) {
                currentMaxHeightLeft = checkAndMark(this.trees.get(i).get(j), currentMaxHeightLeft);
                currentMaxHeightRight = checkAndMark(this.trees.get(i).get(edgeLength -1 -j), currentMaxHeightRight);
                currentMaxHeightTop = checkAndMark(this.trees.get(j).get(i), currentMaxHeightTop);
                currentMaxHeightBottom = checkAndMark(this.trees.get(edgeLength -1 -j).get(i), currentMaxHeightBottom);
            }
        }
    }

    private int checkAndMark(final Tree tree, final int currentMaxHeight) {
        if(tree.getSize() > currentMaxHeight) {
            tree.setVisible();
            return tree.getSize();
        }
        else {
            return currentMaxHeight;
        }
    }
}
