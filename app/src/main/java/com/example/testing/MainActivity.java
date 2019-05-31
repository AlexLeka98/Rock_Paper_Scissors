package com.example.testing;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int choice;
    private int wins;
    private int loses;
    private int ties;
    private boolean flag;

    private ImageButton rock_button;
    private ImageButton scissors_button;
    private ImageButton paper_button;

    private ImageView image_win;
    private ImageView image_lose;
    private ImageView image_draw;

    private ImageView rock_img_player;
    private ImageView scissors_img_player;
    private ImageView paper_img_player;

    private ImageView rock_img_bot;
    private ImageView scissors_img_bot;
    private ImageView paper_img_bot;

    private TextView winsV;
    private TextView losesV;
    private TextView tiesV;

    private ImageView botTitle;
    private ImageView youTitle;

    private ConstraintLayout mConstraintLayout;

    private ImageView versus;

    private Switch swtch;

    private Button rst;

    /**
     * This method creates random numbers from 1 to 3. It is used to give the Bot it's three options.
     * 1 = rock, 2 = paper, 3 = scissors.
     * @return it returns a random number between 1 to 3.
     */
    private int randomBotChoice() {
        Random rand = new Random();
        return (rand.nextInt(3)+1);
    }



    /**
     * This method is called when the user presses the button "reset".
     * Basically, it sets score(wins, loses, draws) to 0, and makes invisible some images, so that the screen looks
     * like the fist time someone starts a game.
     */
    private void reset() {
        wins = 0;
        loses = 0;
        ties = 0;
        losesV.setText("LOSES: "+loses);
        tiesV.setText("TIES: "+ties);
        winsV.setText("WINS: "+wins);

        image_lose.setVisibility(View.INVISIBLE);
        image_draw.setVisibility(View.INVISIBLE);
        image_win.setVisibility(View.INVISIBLE);

        versus.setVisibility(View.INVISIBLE);

        botTitle.setVisibility(View.INVISIBLE);
        youTitle.setVisibility(View.INVISIBLE);

        scissors_img_player.setVisibility(View.INVISIBLE);
        rock_img_player.setVisibility(View.INVISIBLE);
        paper_img_player.setVisibility(View.INVISIBLE);

        scissors_img_bot.setVisibility(View.INVISIBLE);
        rock_img_bot.setVisibility(View.INVISIBLE);
        paper_img_bot.setVisibility(View.INVISIBLE);

        scissors_button.setBackgroundColor(0x00000000);
        rock_button.setBackgroundColor(0x00000000);
        paper_button.setBackgroundColor(0x00000000);

        flag = false;


    }

    /**
     * This method is used everytime the user clicks on a playing option(button_rock, button_paper, button_scissors).
     * It basically, makes invisible the images of the last play, so that they disappear from the screen.
     * @param @flag. At the first round, flag is false, so image "VS" becomes visible and nothing disappears from the screen.
     *              If the game is on any other round than the first, it resets the images as I mentioned before.
     */
    private void reset(boolean flag) {
        if (flag == false){
            versus.setVisibility(View.VISIBLE);
            botTitle.setVisibility(View.VISIBLE);
            youTitle.setVisibility(View.VISIBLE);
            return;
        }
        rock_img_player.setVisibility(View.INVISIBLE);
        scissors_img_player.setVisibility(View.INVISIBLE);
        paper_img_player.setVisibility(View.INVISIBLE);
        rock_img_bot.setVisibility(View.INVISIBLE);
        scissors_img_bot.setVisibility(View.INVISIBLE);
        paper_img_bot.setVisibility(View.INVISIBLE);
        image_lose.setVisibility(View.INVISIBLE);
        image_win.setVisibility(View.INVISIBLE);
        image_draw.setVisibility(View.INVISIBLE);

        scissors_button.setBackgroundColor(0x00000000);
        rock_button.setBackgroundColor(0x00000000);
        paper_button.setBackgroundColor(0x00000000);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        wins = 0;
        loses =0;
        ties =0;
        flag = false;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        versus = (ImageView) this.findViewById(R.id.versus);

        image_lose = (ImageView) this.findViewById(R.id.imagelose);
        image_win = (ImageView) this.findViewById(R.id.imagewin);
        image_draw = (ImageView) this.findViewById(R.id.imagedraw);

        rock_button = (ImageButton) this.findViewById(R.id.rock1);
        scissors_button = (ImageButton) this.findViewById(R.id.scissors1);
        paper_button = (ImageButton) this.findViewById(R.id.paper1);

        rock_img_player = (ImageView) this.findViewById(R.id.rock3) ;
        scissors_img_player = (ImageView) this.findViewById(R.id.scissors3) ;
        paper_img_player = (ImageView) this.findViewById(R.id.paper3) ;

        rock_img_bot = (ImageView) this.findViewById(R.id.rock2) ;
        scissors_img_bot = (ImageView) this.findViewById(R.id.scissors2) ;
        paper_img_bot = (ImageView) this.findViewById(R.id.paper2) ;

        winsV = (TextView) this.findViewById(R.id.wins);
        losesV = (TextView) this.findViewById(R.id.loses);
        tiesV = (TextView) this.findViewById(R.id.ties);

        botTitle = (ImageView) this.findViewById(R.id.botTitle);
        youTitle = (ImageView) this.findViewById(R.id.youTitle);

        mConstraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);

        swtch = (Switch) this.findViewById(R.id.nightMode);

        rst = (Button) this.findViewById(R.id.reset);

        /**
         * This method is basically used when user chooses rock option.
         * At first, it calls reset method and then sets flag = true (Comment section on "reset(boolean flag)" explains why.
         * Then checks the option bot has.
         * It makes rock image visible.
         * It makes bot_choice image visible.
         * If it's 1, then we have a draw. So, ties = + 1.
         * If bot choice = 2 (paper), then we have a lose. So, loses = + 1.
         * If bot choice = 3(scissors), then we have a win. SO, wins = + 1.
         */

        rock_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reset(flag);
                flag = true;
                rock_button.setBackgroundColor(rock_button.getResources().getColor(R.color.gray));
                choice = randomBotChoice();
                if (choice == 1 ) {
                    rock_img_player.setVisibility(View.VISIBLE);
                    rock_img_bot.setVisibility(View.VISIBLE);
                    image_draw.setVisibility(View.VISIBLE);

                    ties++;
                    tiesV.setText("TIES: "+ties);
                }
                else if (choice == 2) {
                    rock_img_player.setVisibility(View.VISIBLE);
                    paper_img_bot.setVisibility(View.VISIBLE);
                    image_lose.setVisibility(View.VISIBLE);
                    loses++;
                    losesV.setText("LOSES: "+loses);

                }
                else {
                    rock_img_player.setVisibility(View.VISIBLE);
                    scissors_img_bot.setVisibility(View.VISIBLE);
                    image_win.setVisibility(View.VISIBLE);
                    wins++;
                    winsV.setText("WINS: "+wins);
                }
            }
        });

        /**
         * This method is basically used when user chooses scissors option.
         * At first, it calls reset method and then sets flag = true (Comment section on "reset(boolean flag)" explains why.
         * Then checks the option bot has.
         * It makes scissors image visible.
         * It makes bot_choice image visible.
         * If it's 1, then we have a lose. So, loses = + 1.
         * If bot choice = 2 (paper), then we have a win. So, wins = + 1.
         * If bot choice = 3(scissors), then we have a win. So, draws = + 1.
         */

        scissors_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reset(flag);
                flag = true;
                scissors_button.setBackgroundColor(scissors_button.getResources().getColor(R.color.gray));
                choice = randomBotChoice();
                if (choice == 1 ) {
                    scissors_img_player.setVisibility(View.VISIBLE);
                    rock_img_bot.setVisibility(View.VISIBLE);
                    image_lose.setVisibility(View.VISIBLE);
                    loses++;
                    losesV.setText("LOSES: "+loses);
                }
                else if (choice == 2) {
                    scissors_img_player.setVisibility(View.VISIBLE);
                    paper_img_bot.setVisibility(View.VISIBLE);
                    image_win.setVisibility(View.VISIBLE);
                    wins++;
                    winsV.setText("WINS: "+wins);
                }
                else {
                    scissors_img_player.setVisibility(View.VISIBLE);
                    scissors_img_bot.setVisibility(View.VISIBLE);
                    image_draw.setVisibility(View.VISIBLE);
                    ties++;
                    tiesV.setText("TIES: "+ties);
                }
            }
        });

        /**
         * This method is basically used when user chooses paper option.
         * At first, it calls reset method and then sets flag = true (Comment section on "reset(boolean flag)" explains why.
         * Then checks the option bot has.
         * It makes paper image visible.
         * It makes bot_choice image visible.
         * If it's 1, then we have a win. So, wins = + 1.
         * If bot choice = 2 (paper), then we have a draw. So, draws = + 1.
         * If bot choice = 3(scissors), then we have a lose. So, lose = + 1.
         */

        paper_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reset(flag);
                flag = true;
                paper_button.setBackgroundColor(paper_button.getResources().getColor(R.color.gray));
                choice = randomBotChoice();
                if (choice == 1 ) {
                    paper_img_player.setVisibility(View.VISIBLE);
                    rock_img_bot.setVisibility(View.VISIBLE);
                    image_win.setVisibility(View.VISIBLE);
                    wins++;
                    winsV.setText("WINS: "+wins);
                }
                else if (choice == 2) {
                    paper_img_player.setVisibility(View.VISIBLE);
                    scissors_img_bot.setVisibility(View.VISIBLE);
                    image_lose.setVisibility(View.VISIBLE);
                    loses++;
                    losesV.setText("LOSES: "+loses);
                }
                else {
                    paper_img_player.setVisibility(View.VISIBLE);
                    paper_img_bot.setVisibility(View.VISIBLE);
                    image_draw.setVisibility(View.VISIBLE);
                    ties++;
                    tiesV.setText("TIES: "+ties);
                }
            }
        });


        /**
         * This method is used when switch button is used. If you click or drag switch button it activates nightmode.
         * Nightmode is nothing more than setting the colour background to black. If you click on that switch again, the background returns
         * to its original colour.
         *
         */

        swtch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (swtch.isChecked()) {
                    mConstraintLayout.setBackgroundColor(mConstraintLayout.getResources().getColor(R.color.backgroundColorNightMode));
                }
                else {
                    mConstraintLayout.setBackgroundColor(mConstraintLayout.getResources().getColor(R.color.backgroundColor));
                }
            }
        });

        rst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("my_text1",winsV.getText().toString());
        outState.putString("my_text2",losesV.getText().toString());
        outState.putString("my_text3",tiesV.getText().toString());

        outState.putInt("winss",wins);
        outState.putInt("losess",loses);
        outState.putInt("tiess",ties);

        outState.putInt("botTitle",botTitle.getVisibility());
        outState.putInt("youTitle",youTitle.getVisibility());
        outState.putInt("rock_img_player",rock_img_player.getVisibility());
        outState.putInt("paper_img_player",paper_img_player.getVisibility());
        outState.putInt("scissors_img_player",scissors_img_player.getVisibility());
        outState.putInt("rock_img_bot",rock_img_bot.getVisibility());
        outState.putInt("paper_img_bot",paper_img_bot.getVisibility());
        outState.putInt("scissors_img_bot",scissors_img_bot.getVisibility());
        outState.putInt("versus",versus.getVisibility());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        wins = savedInstanceState.getInt("winss");
        loses = savedInstanceState.getInt("losess");
        ties = savedInstanceState.getInt("tiess");

        winsV.setText(savedInstanceState.getString("my_text1"));
        losesV.setText(savedInstanceState.getString("my_text2"));
        tiesV.setText(savedInstanceState.getString("my_text3"));

        botTitle.setVisibility(savedInstanceState.getInt("botTitle"));
        youTitle.setVisibility(savedInstanceState.getInt("youTitle"));
        rock_img_player.setVisibility(savedInstanceState.getInt("rock_img_player"));
        paper_img_player.setVisibility(savedInstanceState.getInt("paper_img_player"));
        scissors_img_player.setVisibility(savedInstanceState.getInt("scissors_img_player"));
        rock_img_bot.setVisibility(savedInstanceState.getInt("rock_img_bot"));
        paper_img_bot.setVisibility(savedInstanceState.getInt("paper_img_bot"));
        scissors_img_bot.setVisibility(savedInstanceState.getInt("scissors_img_bot"));
        versus.setVisibility(savedInstanceState.getInt("versus"));



    }
}
