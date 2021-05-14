package com.gabrielpeixoto.musicapi.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;

import static com.gabrielpeixoto.musicapi.constants.MusicsConstant.ENDPOINT_DYNAMO;
import static com.gabrielpeixoto.musicapi.constants.MusicsConstant.REGION_DYNAMO;


public class MusicData {
    public static void main(String[] args) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Musics_Table_Demo");
        Item music = new Item().withPrimaryKey("id", 1)
                .withString("title", "1812 Overture")
                .withString("composer", "Tchaikovsky")
                .withNumber("year_comp", 1882);

        Item music2 = new Item().withPrimaryKey("id", 2)
                .withString("title", "Marche Slave")
                .withString("composer", "Tchaikovsky")
                .withNumber("year_comp", 1876);

        Item music3 = new Item().withPrimaryKey("id", 3)
                .withString("title", "Symphony no 5")
                .withString("composer", "Mahler")
                .withNumber("year_comp", 1901);

        PutItemOutcome outcome = table.putItem(music);
        PutItemOutcome outcome2 = table.putItem(music2);
        PutItemOutcome outcome3 = table.putItem(music3);
    }
}
