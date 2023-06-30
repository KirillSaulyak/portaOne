package com.example.testassignment.service.algorithm;

import org.springframework.stereotype.Service;

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
        for (int i = 1; i < word.length(); i++) {
            if (word.indexOf(word.charAt(i - 1), i) == -1) {
                return word.charAt(i - 1);
            }
        }
        return null;
    }
}
