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
        StringBuilder uniqueCharacters = new StringBuilder();
        Character firstUniqueCharInWord;
        for (String word : words) {
            firstUniqueCharInWord = findFirstUniqueCharInWord(word);
            if (nonNull(firstUniqueCharInWord)) {
                uniqueCharacters.append(firstUniqueCharInWord);
            }
        }
        return findFirstUniqueCharInWord(uniqueCharacters.toString());
    }

    private Character findFirstUniqueCharInWord(String word) {
        if (word.length() == 1) {
            return word.charAt(0);
        }
        Map<Character, Integer> letters = new LinkedHashMap<>();
        for (int i = 0; i < word.length(); i++) {
            letters.put(word.charAt(i), letters.getOrDefault(word.charAt(i), 0) + 1);
        }
        for (var entry : letters.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }
}
