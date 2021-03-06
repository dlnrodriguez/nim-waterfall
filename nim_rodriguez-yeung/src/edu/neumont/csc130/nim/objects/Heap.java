package edu.neumont.csc130.nim.objects;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Block> blocks;
    public final int id;

    public Heap(final int nofBlocks, int id) {
        this.id = id;
        blocks = new ArrayList<>();
        for (int i = 0; i < nofBlocks; i++) blocks.add(new Block());
    }

    public boolean isEmpty() {
        return blocks.isEmpty();
    }

    public boolean removeBlocks(int nofBlocks) {
        if (blocks.size() < nofBlocks || nofBlocks < 0) return false;
        for (int i = 0; i < nofBlocks; i++) blocks.remove(0);
        return true;
    }

    @Override
    public String toString() {
        return "Heap{" +
                "id=" + id +
                ", blocks=" + (isEmpty() ? "is empty" : blocks.size()) +
                '}';
    }
}
