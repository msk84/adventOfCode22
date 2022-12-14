package net.msk.adventOfCode2022;

import net.msk.adventOfCode2022.model.Tree;

import java.util.ArrayList;
import java.util.List;

public class Day08_Forrest {

    private final List<List<Tree>> trees = new ArrayList<>();

    public Day08_Forrest(final List<String> forrestData) {
        forrestData.forEach(d -> this.trees.add(d.chars()
                    .mapToObj(Character::getNumericValue)
                    .map(Tree::new)
                    .toList()));
    }

    public Tree getTreeByCoordinate(final int x, final int y) {
        return this.trees.get(y).get(x);
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

    public int getMaxScenicScore() {
        this.calculateScenicScore();

        int maxScenicScore = 0;
        for(final List<Tree> treeRow : this.trees){
            for(final Tree tree : treeRow) {
                if(tree.getScenicScore() > maxScenicScore) {
                    maxScenicScore = tree.getScenicScore();
                }
            }
        }
        return maxScenicScore;
    }

    private void calculateTreeVisibility() {
        final int edgeLength = this.trees.size();
        for(int i=0; i<edgeLength; i++) {
            int currentMaxHeightLeft = -1;
            int currentMaxHeightRight = -1;
            int currentMaxHeightTop = -1;
            int currentMaxHeightBottom = -1;
            for(int j=0; j<edgeLength; j++) {
                currentMaxHeightLeft = checkTreeVisibilityAndMark(this.trees.get(i).get(j), currentMaxHeightLeft);
                currentMaxHeightRight = checkTreeVisibilityAndMark(this.trees.get(i).get(edgeLength -1 -j), currentMaxHeightRight);
                currentMaxHeightTop = checkTreeVisibilityAndMark(this.trees.get(j).get(i), currentMaxHeightTop);
                currentMaxHeightBottom = checkTreeVisibilityAndMark(this.trees.get(edgeLength -1 -j).get(i), currentMaxHeightBottom);
            }
        }
    }

    private int checkTreeVisibilityAndMark(final Tree tree, final int currentMaxHeight) {
        if(tree.getSize() > currentMaxHeight) {
            tree.setVisible();
            return tree.getSize();
        }
        else {
            return currentMaxHeight;
        }
    }

    private void calculateScenicScore() {
        final int edgeLength = this.trees.size();
        for(int i=0; i<edgeLength; i++) {
            for(int j=0; j<edgeLength; j++) {
                final Tree currentTree = this.trees.get(i).get(j);
                this.calculateScenicScorePerTreeAndSet(currentTree, i, j, edgeLength);
            }
        }
    }

    private void calculateScenicScorePerTreeAndSet(final Tree tree, final int row, final int column, final int edgeLength) {
        int right = 0;
        for(int r = column+1; r<edgeLength; r++) {
            right++;
            if(tree.getSize() <= this.trees.get(row).get(r).getSize()) {
                break;
            }
        }

        int left = 0;
        for(int l = column-1; l>=0; l--) {
            left++;
            if(tree.getSize() <= this.trees.get(row).get(l).getSize()) {
                break;
            }
        }

        int up = 0;
        for(int u = row-1; u>=0; u--) {
            up++;
            if(tree.getSize() <= this.trees.get(u).get(column).getSize()) {
                break;
            }
        }

        int down = 0;
        for(int d = row+1; d<edgeLength; d++) {
            down++;
            if(tree.getSize() <= this.trees.get(d).get(column).getSize()) {
                break;
            }
        }

        tree.setScenicScore(right * left * up * down);
    }
}
