package com.example.garpinator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.BoringLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {



    private boolean crew;
    private boolean known_bounty;
    private boolean known_bounty_answer;
    private boolean bounty;
    private boolean nickname;
    private boolean status;
    private boolean age;
    private boolean birthday;
    private boolean height;
    private boolean devil_fruit;
    private boolean yonko_crew;
    private boolean yonko;
    private boolean scar;
    private boolean weapon;
    private boolean race;
    private boolean captain;
    private boolean vsLuffy;
    private boolean vsZoro;
    private boolean vsSanji;
    private boolean haki;
    private boolean answered;
    Random rand;

    List<String> crews;
    List<String> races;
    List<String> weapons;
    List<Pirate> pirates;

    TextView question;
    Button yes;
    Button no;
    Button idk;
    int question_time;

    private int min_age = 0;
    private int max_age = Integer.MAX_VALUE;

    private int min_height = 0;
    private int max_height =  Integer.MAX_VALUE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
//        boolean character_found = false;
        // if first time
        // Ask if you know the rules
        // Then do stuff

        question = findViewById(R.id.question);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        idk = findViewById(R.id.idk);

        rand = new Random();

        pirates = GarpinatorDatabase.retrieveAllPirates();

        crews = new ArrayList<>();
        for (Pirate pirate : pirates){
            if (!crews.contains(pirate.getCrew()))
                crews.add(pirate.getCrew());
        }

        races = new ArrayList<>();
        races.add("human");
        races.add("giant");
        races.add("fishMan");
        races.add("tontatta");

        weapons = new ArrayList<>();
        for (Pirate pirate : pirates){
            if (!weapons.contains(pirate.getWeapon()))
                weapons.add(pirate.getWeapon());
        }

        game();

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        idk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void game(){

        question_time = 0;//rand.nextInt(18);
        if (question_time == 0 && !crew){
            int chosen_crew = rand.nextInt(crews.size());
            question.setText("Is your character part of the " + crews.get(chosen_crew));
        }
        ////////////////////////////////////////////////////////////////////////////////////////
        else if (question_time == 1 && (!bounty || !known_bounty)){
            if (!known_bounty){
                question.setText("Does your character have a known bounty ?");
                known_bounty = !known_bounty;
                answered = !answered;
                if (!known_bounty_answer){
                    bounty = !bounty;
                }

            }
            else if(!bounty){
                // calculate average;
            }
        }
        ////////////////////////////////////////////////////////////////////////////////////////
        else if (question_time == 2 && !nickname){
            question.setText("Does your character have a nickname ?");
            nickname = !nickname;
        }
        else if (question_time == 3 && !status){
            question.setText("Is your character alive ?");
            status = !status;
        }
        else if (question_time == 4 && !age){

        }
        else if (question_time == 5 && !birthday){

        }
        else if (question_time == 6 && !height){

        }
        else if (question_time == 7 && !devil_fruit){
            question.setText("Does your character have a devil fruit power ?");
            devil_fruit = !devil_fruit;

        }
        else if (question_time == 8 && !yonko_crew){
            question.setText("Is your character part of a Yonko crew ?");
            yonko_crew = !yonko_crew;
        }
        else if (question_time == 9 && !yonko){
            question.setText("Is your character a Yonko ?");
            yonko = !yonko;
        }
        else if (question_time == 10 && !scar){
            question.setText("Does your character have an apparant scar ?");
            scar = !scar;
        }
        else if (question_time == 11 && !weapon){

        }
        else if (question_time == 12 && !race){

        }
        else if (question_time == 13 && !captain){
            question.setText("Is your character captain of a crew ?");
            captain = !captain;
        }
        else if (question_time == 14 && !vsLuffy){
            question.setText("Did your character fight angaints Luffy ?");
            vsLuffy = !vsLuffy;
        }
        else if (question_time == 15 && !vsZoro){
            question.setText("Did your character fight angaints Zoro ?");
            vsZoro = !vsZoro;
        }
        else if (question_time == 16 && !vsSanji){
            question.setText("Did your character fight angaints Sanji ?");
            vsSanji = !vsSanji;
        }
        else if (question_time == 17 && !haki){
            question.setText("Does your character know any type of haki ?");
            haki = !haki;
        }
    }
}