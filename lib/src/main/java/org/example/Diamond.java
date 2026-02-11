package org.example;

public class Diamond {

    private static final char FIRST_LETTER = 'A';
    private static final char LAST_LETTER = 'Z';

    public String print(char c) {
        char letter = normalizeAndValidate(c);
        
        if (letter == FIRST_LETTER) {
            return String.valueOf(FIRST_LETTER);
        }
        
        return buildDiamond(letter);
    }
    
    private char normalizeAndValidate(char c) {
        char upperChar = Character.toUpperCase(c);
        
        if (!Character.isLetter(upperChar) || upperChar < FIRST_LETTER || upperChar > LAST_LETTER) {
            throw new IllegalArgumentException("Input must be a letter from A to Z");
        }
        
        return upperChar;
    }
    
    private String buildDiamond(char letter) {
        int size = letter - FIRST_LETTER;
        StringBuilder result = new StringBuilder();
        
        buildTopHalf(result, size);
        buildBottomHalf(result, size);
        
        return result.toString();
    }
    
    private void buildTopHalf(StringBuilder result, int size) {
        for (int i = 0; i <= size; i++) {
            result.append(createLine(i, size));
            if (i < size) {
                result.append("\n");
            }
        }
    }
    
    private void buildBottomHalf(StringBuilder result, int size) {
        for (int i = size - 1; i >= 0; i--) {
            result.append("\n");
            result.append(createLine(i, size));
        }
    }
    
    private String createLine(int index, int size) {
        char letter = (char) (FIRST_LETTER + index);
        int outerSpaces = size - index;
        int innerSpaces = 2 * index - 1;
        
        StringBuilder line = new StringBuilder();
        
        appendSpaces(line, outerSpaces);
        line.append(letter);
        
        if (index > 0) {
            appendSpaces(line, innerSpaces);
            line.append(letter);
        }
        
        return line.toString();
    }
    
    private void appendSpaces(StringBuilder builder, int count) {
        for (int i = 0; i < count; i++) {
            builder.append(' ');
        }
    }
}

