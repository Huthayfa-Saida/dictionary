package edu.birzeit.dictionary.model;

import java.util.ArrayList;
import java.util.List;

public class DAWord {
    private List<Word> words;

    public DAWord() {
        words = new ArrayList<>();
        words.add(new Word(1, "Happiness", "a feeling of pleasure or contentment", "سعادة", "English"));
        words.add(new Word(2, "Courage", "the ability to do something that frightens you.", "شجاعة", "English"));
        words.add(new Word(3, "Friendship", "a relationship between two people", "مسالم", "English"));
        words.add(new Word(4, "Responsibility", "the state or fact of being accountable", "مسؤول", "English"));
        words.add(new Word(5, "Curiosity", "a strong desire to know or learn something.", "صدق", "English"));
        words.add(new Word(6, "Honesty", "the quality of being truthful and straightforward.", "الصدق", "English"));
        words.add(new Word(7, "Imagination", "the ability to create mental images", "مبتكر", "English"));
        words.add(new Word(8, "Freedom", "the power or right to act, speak", "حرية", "English"));
        words.add(new Word(9, "Respect", "a feeling of admiration and deference toward someone or something.", "احترام", "English"));
        words.add(new Word(10, "Patience", "the capacity to accept or tolerate delay, trouble", "صبور", "English"));
        words.add(new Word(11, "Mutluluk", "Bir şeyden keyif veya tatmin duygusu", "Happiness", "Turkish"));
        words.add(new Word(12, "Cesaret", "Korktuğunuz bir şeyi yapabilme kabiliyeti", "Courage", "Turkish"));
        words.add(new Word(13, "Arkadaşlık", "İki kişi arasındaki ilişki", "Friendship", "Turkish"));
        words.add(new Word(14, "Sorumluluk", "Sorumlu olma durumu veya gerçeği", "Responsibility", "Turkish"));
        words.add(new Word(15, "Merak", "Bir şeyi bilmek veya öğrenmek isteme güdüsü", "Curiosity", "Turkish"));
        words.add(new Word(16, "Dürüstlük", "Doğru ve dürüst olma niteliği", "Honesty", "Turkish"));
        words.add(new Word(17, "Hayal gücü", "Zihinsel imgeler yaratma yeteneği", "Imagination", "Turkish"));
        words.add(new Word(18, "Özgürlük", "Hareket etme veya konuşma gücü veya hakkı", "Freedom", "Turkish"));
        words.add(new Word(19, "Saygı", "Birine veya bir şeye hayranlık ve saygı duygusu", "Respect", "Turkish"));
        words.add(new Word(20, "Sabır", "Gecikme, zorluk veya acıya katlanma kapasitesi", "Patience", "Turkish"));
        words.add(new Word(21, "Freude", "ein Gefühl von Vergnügen oder Zufriedenheit", "Mutluluk", "German"));
        words.add(new Word(22, "Mut", "die Fähigkeit, etwas zu tun, das dich erschreckt.", "Cesaret", "German"));
        words.add(new Word(23, "Freundschaft", "eine Beziehung zwischen zwei Menschen", "Arkadaşlık", "German"));
        words.add(new Word(24, "Verantwortung", "der Zustand oder die Tatsache, verantwortlich zu sein", "Sorumluluk", "German"));
        words.add(new Word(25, "Neugierde", "ein starker Wunsch, etwas zu wissen oder zu lernen.", "Merak", "German"));
        words.add(new Word(26, "Ehrlichkeit", "die Qualität, wahrhaftig und direkt zu sein.", "Dürüstlük", "German"));
        words.add(new Word(27, "Phantasie", "die Fähigkeit, mentale Bilder zu erstellen", "Hayal gücü", "German"));
        words.add(new Word(28, "Freiheit", "die Macht oder das Recht zu handeln, zu sprechen", "Özgürlük", "German"));
        words.add(new Word(29, "Respekt", "ein Gefühl der Bewunderung und des Respekts gegenüber jemandem oder etwas.", "Saygı", "German"));
        words.add(new Word(30, "Geduld", "die Fähigkeit, Verzögerungen, Probleme zu akzeptieren oder zu tolerieren", "Sabır", "German"));
        words.add(new Word(31, "Bonheur", "État de complète satisfaction et de bien-être", "Happiness", "French"));
        words.add(new Word(32, "Courage", "Force morale qui permet d'affronter les difficultés, les épreuves", "Courage", "French"));
        words.add(new Word(33, "Amitié", "Sentiment d'affection réciproque entre deux personnes", "Friendship", "French"));
        words.add(new Word(34, "Responsabilité", "Devoir de répondre de ses actes, de ses paroles", "Responsibility", "French"));
        words.add(new Word(35, "Curiosité", "Désir de savoir, de découvrir", "Curiosity", "French"));
        words.add(new Word(36, "Honnêteté", "Qualité de celui qui dit la vérité, qui agit avec droiture et intégrité", "Honesty", "French"));
        words.add(new Word(37, "Imagination", "Faculté de concevoir des images mentales, des idées", "Imagination", "French"));
        words.add(new Word(38, "Liberté", "État d'une personne qui n'est pas sous le joug d'une autorité ou d'une contrainte", "Freedom", "French"));
        words.add(new Word(39, "Respect", "Sentiment de considération envers quelqu'un ou quelque chose", "Respect", "French"));
        words.add(new Word(40, "Patience", "Capacité d'attendre calmement, sans se décourager", "Patience", "French"));
    }

    public List<Word> getWordsByCategory(String category) {
        List<Word> itemList = new ArrayList<>();
        for (Word word : words) {
            if (word.getCategory().equalsIgnoreCase(category)) {
                itemList.add(word);
            }
        }
        return itemList;
    }

    public String[] getCategories() {
         String[] cat = {"English", "Turkish","German", "French"};
        return cat;
    }
}
