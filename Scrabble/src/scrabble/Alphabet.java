/*
Jordan Molefe
19330106
29/08/2019
 */
package Scrabble;

import java.util.ArrayList;
import java.util.List;

public class Alphabet {

    List<Character> AlphabetList;
    List<Character> VowelsList;

    public Alphabet() {
        AlphabetList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            AlphabetList.add((char) (97 + i));
        }

        VowelsList = new ArrayList<>();
        char[] vowels = {'a','e','i','o','u'};
        for (int i = 0; i < vowels.length; i++) {
            VowelsList.add(vowels[i]);
        }
    }

    public List<Character> getAlphabetList() {
        return AlphabetList;
    }

    public List<Character> getVowels() {
        return VowelsList;
    }

    private boolean isVowel(char vowel) {
        return VowelsList.contains(vowel);
    }

    private boolean usedAlphabet(char alphabet) {
        return AlphabetList.contains(alphabet);

    }

    public boolean checkWord(String Word) {
        char e;
        List<Character> alphabet = new ArrayList<>();
        for (int i = 0; i < Word.length(); i++) {
            if (!alphabet.contains(Word.charAt(i))) {
                alphabet.add(Word.charAt(i));
            }
        }
        for (int i = 0; i < alphabet.size(); i++) {
            e = alphabet.get(i);
            if (!isVowel(e)) {
                if (!usedAlphabet(e)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean RemoveAlphabet(String word) {
        char f;
        List<Character> a = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (!a.contains(word.charAt(i))) {
                a.add(word.charAt(i));
            }
        }
        for (int i = 0; i < a.size(); i++) {
            f = a.get(i);
            if (!isVowel(f)) {
                if (!usedAlphabet(f)) {
                    return false;
                } else {
                    for (int j = 0; j < this.AlphabetList.size(); j++) {
                        if (this.AlphabetList.get(j) == f) {
                            this.AlphabetList.set(j, ' ');
                        }
                    }
                }
            }
        }
        return true;
    }

}