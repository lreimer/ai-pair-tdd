package org.example;

public class Diamond {

    public String print(char c) {
        if (c == 'A') {
            return "A";
        }
        
        int size = c - 'A';
        StringBuilder result = new StringBuilder();
        
        // Top half including middle
        for (int i = 0; i <= size; i++) {
            result.append(createLine(i, size));
            if (i < size) {
                result.append("\n");
            }
        }
        
        // Bottom half
        for (int i = size - 1; i >= 0; i--) {
            result.append("\n");
            result.append(createLine(i, size));
        }
        
        return result.toString();
    }
    
    private String createLine(int index, int size) {
        char letter = (char) ('A' + index);
        int outerSpaces = size - index;
        int innerSpaces = 2 * index - 1;
        
        StringBuilder line = new StringBuilder();
        
        for (int i = 0; i < outerSpaces; i++) {
            line.append(' ');
        }
        
        line.append(letter);
        
        if (index > 0) {
            for (int i = 0; i < innerSpaces; i++) {
                line.append(' ');
            }
            line.append(letter);
        }
        
        return line.toString();
    }
}

