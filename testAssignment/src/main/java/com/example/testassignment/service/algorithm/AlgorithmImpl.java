package com.example.testassignment.service.algorithm;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

@Service
public class AlgorithmImpl implements AlgorithmService {
    @Override
    public Character calculate(String userText) {
        String[] words = userText.split(" ");
        Map<Character, Integer> uniqueCharacters = new LinkedHashMap<>();
        Character firstUniqueCharInWord;
        for (String word : words) {
            firstUniqueCharInWord = getFirstUniqueCharInWord(word.toCharArray());
            if (nonNull(firstUniqueCharInWord)) {
                uniqueCharacters.put(firstUniqueCharInWord, uniqueCharacters.getOrDefault(firstUniqueCharInWord, 0) + 1);
            }
        }
        return findFirstUniqueCharInMap(uniqueCharacters);
    }

    private Character getFirstUniqueCharInWord(char[] word) {
        if (word.length == 1) {
            return word[0];
        }
        Map<Character, Integer> letters = new LinkedHashMap<>();
        for (char letter : word) {
            letters.put(letter, letters.getOrDefault(letter, 0) + 1);
        }
        return findFirstUniqueCharInMap(letters);
    }

    private Character findFirstUniqueCharInMap(Map<Character, Integer> letters) {
        for (var entry : letters.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }
}
