package edu.birzeit.dictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


import edu.birzeit.dictionary.model.Word;
public class MainActivity extends AppCompatActivity {

    private Spinner my_spinner;
    private Button my_button;
    private TextView my_messageTextView;

    private List<Word> myWords;
    private RecyclerView recycler;
    private SharedPreferences mySharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my_spinner = findViewById(R.id.spinner);
        my_messageTextView = findViewById(R.id.txtview);
        recycler = findViewById(R.id.list_words);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String str = mySharedPreferences.getString("Dictionary", "");

        if (str.isEmpty()) {
            List<Word> words = getWordsList();

            SharedPreferences.Editor editor = mySharedPreferences.edit();
            Gson gson = new Gson();
            String myWordsString = gson.toJson(words);

            editor.putString("Dictionary", myWordsString);
            editor.commit();

            myWords = words;
        } else {
            Gson gson = new Gson();
            Type itemListType = new TypeToken<ArrayList<Word>>() {}.getType();
            myWords = gson.fromJson(str, itemListType);
        }

        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_spinner_dropdown_item, getCategories());
        my_spinner.setAdapter(categoryAdapter);

        my_button = findViewById(R.id.btnsubmit);
        my_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedCategory = my_spinner.getSelectedItem().toString();
                List<Word> words = getWordsByCategory(selectedCategory);
                if (words.isEmpty()) {
                    recycler.setAdapter(null);
                } else {
                    CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(MainActivity.this,
                            words);
                    recycler.setAdapter(adapter);
                }
            }
        });
    }
    public String[] getCategories() {
        String[] cat = {"English", "Turkish","German", "French"};
        return cat;
    }
    public List<Word> getWordsByCategory(String category) {
        List<Word> wordsList = new ArrayList<>();
        for (Word word : myWords) {
            if (word.getCategory().equalsIgnoreCase(category)) {
                wordsList.add(word);
            }
        }
        return wordsList;
    }
    public List<Word> getWordsList() {
        List<Word> words = new ArrayList<>();
        words.add(new Word(1, "Happiness", "a feeling of pleasure or contentment", "سعادة", "English"));
        words.add(new Word(2, "Courage", "the ability to do something that frightens you.", "شجاعة", "English"));
        words.add(new Word(3, "Friendship", "a relationship between two people", "صداقة", "English"));
        words.add(new Word(4, "Responsibility", "the state or fact of being accountable", "مسؤوليات", "English"));
        words.add(new Word(5, "Curiosity", "a strong desire to know or learn something.", "???", "English"));
        words.add(new Word(6, "Honesty", "the quality of being truthful and straightforward.", "صدق", "English"));
        words.add(new Word(7, "Imagination", "the ability to create mental images", "خيال", "English"));
        words.add(new Word(8, "Freedom", "the power or right to act, speak", "حرية", "English"));
        words.add(new Word(9, "Respect", "a feeling of admiration and deference toward someone or something.", "احترام", "English"));
        words.add(new Word(10, "Patience", "the capacity to accept or tolerate delay, trouble", "صبور", "English"));
        words.add(new Word(11, "Mutluluk", "Bir ?eyden keyif veya tatmin duygusu", "Happiness", "Turkish"));
        words.add(new Word(12, "Cesaret", "Korktu?unuz bir ?eyi yapabilme kabiliyeti", "Courage", "Turkish"));
        words.add(new Word(13, "Arkada?l?k", "?ki ki?i aras?ndaki ili?ki", "Friendship", "Turkish"));
        words.add(new Word(14, "Sorumluluk", "Sorumlu olma durumu veya gerçe?i", "Responsibility", "Turkish"));
        words.add(new Word(15, "Merak", "Bir ?eyi bilmek veya ö?renmek isteme güdüsü", "Curiosity", "Turkish"));
        words.add(new Word(16, "Dürüstlük", "Do?ru ve dürüst olma niteli?i", "Honesty", "Turkish"));
        words.add(new Word(17, "Hayal gücü", "Zihinsel imgeler yaratma yetene?i", "Imagination", "Turkish"));
        words.add(new Word(18, "Özgürlük", "Hareket etme veya konu?ma gücü veya hakk?", "Freedom", "Turkish"));
        words.add(new Word(19, "Sayg?", "Birine veya bir ?eye hayranl?k ve sayg? duygusu", "Respect", "Turkish"));
        words.add(new Word(20, "Sab?r", "Gecikme, zorluk veya ac?ya katlanma kapasitesi", "Patience", "Turkish"));
        words.add(new Word(21, "Freude", "ein Gefühl von Vergnügen oder Zufriedenheit", "Mutluluk", "German"));
        words.add(new Word(22, "Mut", "die Fähigkeit, etwas zu tun, das dich erschreckt.", "Cesaret", "German"));
        words.add(new Word(23, "Freundschaft", "eine Beziehung zwischen zwei Menschen", "Arkada?l?k", "German"));
        words.add(new Word(24, "Verantwortung", "der Zustand oder die Tatsache, verantwortlich zu sein", "Sorumluluk", "German"));
        words.add(new Word(25, "Neugierde", "ein starker Wunsch, etwas zu wissen oder zu lernen.", "Merak", "German"));
        words.add(new Word(26, "Ehrlichkeit", "die Qualität, wahrhaftig und direkt zu sein.", "Dürüstlük", "German"));
        words.add(new Word(27, "Phantasie", "die Fähigkeit, mentale Bilder zu erstellen", "Hayal gücü", "German"));
        words.add(new Word(28, "Freiheit", "die Macht oder das Recht zu handeln, zu sprechen", "Özgürlük", "German"));
        words.add(new Word(29, "Respekt", "ein Gefühl der Bewunderung und des Respekts gegenüber jemandem oder etwas.", "Sayg?", "German"));
        words.add(new Word(30, "Geduld", "die Fähigkeit, Verzögerungen, Probleme zu akzeptieren oder zu tolerieren", "Sab?r", "German"));
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

        return words;
    }
}
