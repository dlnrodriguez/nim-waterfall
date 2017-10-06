package edu.neumont.csc130.nim.objects;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Block> blocks;

    public Heap(int nofBlocks) {
        blocks = new ArrayList<>();
        for (int i = 0; i < nofBlocks; i++) blocks.add(new Block());
    }

    public boolean isEmpty() {
        return blocks.isEmpty();
    }

    public boolean removeBlocks(int nofBlocks) {
        if (blocks.size() < nofBlocks) return false;
        for (int i = 0; i < nofBlocks; i++) blocks.remove(0);
        return true;
    }
}
