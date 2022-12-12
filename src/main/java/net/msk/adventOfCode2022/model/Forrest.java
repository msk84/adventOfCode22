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
                currentMaxHeightLeft = checkAndMark(this.trees.get(i).get(j), currentMaxHeightLeft);
                currentMaxHeightRight = checkAndMark(this.trees.get(i).get(edgeLength -1 -j), currentMaxHeightRight);
                currentMaxHeightTop = checkAndMark(this.trees.get(j).get(i), currentMaxHeightTop);
                currentMaxHeightBottom = checkAndMark(this.trees.get(edgeLength -1 -j).get(i), currentMaxHeightBottom);
            }
        }
    }

    private void calculateScenicScore() {
        final int edgeLength = this.trees.size();
        for(int i=0; i<edgeLength; i++) {
            for(int j=0; j<edgeLength; j++) {
                final Tree currentTree = this.trees.get(i).get(j);

                int right = 0;
                for(int r = j+1; r<edgeLength; r++) {
                    right++;
                    if(currentTree.getSize() <= this.trees.get(i).get(r).getSize()) {
                        break;
                    }
                }

                int left = 0;
                for(int l = j-1; l>=0; l--) {
                    left++;
                    if(currentTree.getSize() <= this.trees.get(i).get(l).getSize()) {
                        break;
                    }
                }

                int up = 0;
                for(int u = i-1; u>=0; u--) {
                    up++;
                    if(currentTree.getSize() <= this.trees.get(u).get(j).getSize()) {
                        break;
                    }
                }

                int down = 0;
                for(int d = i+1; d<edgeLength; d++) {
                    down++;
                    if(currentTree.getSize() <= this.trees.get(d).get(j).getSize()) {
                        break;
                    }
                }

                currentTree.setScenicScore(right * left * up * down);
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
