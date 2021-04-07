package service.impl;

import lombok.extern.slf4j.Slf4j;
import parsable.Parsable;
import parsable.impl.Word;
import service.SolutionTasks;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Slf4j
public class SolutionTasksImpl implements SolutionTasks {
    @Override
    public String swap(Parsable text) {
        log.info("In each sentence of the text, replace the first word with the last one without changing the length of the sentence.");
        StringBuilder result = new StringBuilder();
        List<Parsable> par = text.getChild();
        for (Parsable pr : par) {
            List<Parsable> sentence = pr.getChild();
            for (Parsable sn : sentence) {
                String string = sn.toString().replaceAll("([^.!?, ]+)([^.!?]+?)([^.!?, ]+)([.!?])", "$3$2$1$4");
                result.append(string);
            }
        }
        log.info("Result :");
        return result.toString();
    }
    @Override
    public String orderByAlphabet(Parsable text) {
        log.info("Type the words of the text alphabetically by first letter. Words beginning with a new letter should be printed on the new line.");
        StringBuilder result = new StringBuilder();
        int q = 0;
        TreeMap<String, Integer> wordsQuantity = new TreeMap<>();
        List<Parsable> par = text.getChild();
        for (Parsable pr : par) {
            List<Parsable> sentence = pr.getChild();
            for (Parsable sn : sentence) {
                List<Parsable> words = sn.getChild().stream().filter(e -> e instanceof Word).collect(Collectors.toList());
                words.forEach(word -> {
                    int quantity = wordsQuantity.getOrDefault(word.toString().toLowerCase(), 0);
                    wordsQuantity.put(word.toString().toLowerCase(), quantity + 1);
                });
            }
        }
        final char[] symbol = {'z'};
        wordsQuantity.forEach((word, quantity) -> {
            if (word.charAt(0) == symbol[0]) {
                result.append(word).append(" - ").append(quantity).append("  ");
            } else {
                symbol[0] = word.charAt(0);
                result.append("\n" + "\t").append(word.charAt(0)).append(": ").append(word).append(" - ").append(quantity).append(" ");
            }
        });
        log.info("Result : ");
        return result.toString();
    }
}
