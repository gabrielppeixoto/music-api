package com.gabrielpeixoto.musicapi.document;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import org.springframework.data.annotation.Id;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@DynamoDBTable(tableName = "Musics_Table")
public class Musics {
    @Id
    @DynamoDBHashKey(attributeName = "id")
    private String id;

    @DynamoDBAttribute(attributeName = "name")
    private String title;

    @DynamoDBAttribute(attributeName = "composer")
    private String composer;

    @DynamoDBAttribute(attributeName = "year_comp")
    private int yearComp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public int getYearComp() {
        return yearComp;
    }

    public void setYearComp(int yearComp) {
        this.yearComp = yearComp;
    }

    public Musics(String id, String title, String composer, int year)
    {
        this.id = id;
        this.title = title;
        this.composer = composer;
        this.yearComp = year;
    }
}
