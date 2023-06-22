package edu.birzeit.dictionary.model;



public class Word {
    private int id;
    private String title;
    private String meaning;
    private String definition;
    private String category;

    public Word(int id, String title, String meaning, String definition, String category) {
        this.id = id;
        this.title = title;
        this.meaning = meaning;
        this.definition = definition;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

