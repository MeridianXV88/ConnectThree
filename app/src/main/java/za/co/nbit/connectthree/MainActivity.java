package za.co.nbit.connectthree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView slot1, slot2, slot3, slot4, slot5, slot6, slot7, slot8, slot9;
    boolean turnToPlay;
    List player1 = new ArrayList();
    List player2 = new ArrayList();
    int imageViewClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Board startGame = new Board();
        startGame.resetBoard();

    }

    public class Board
    {
        public void resetBoard()
        {
            turnToPlay = true;
            slot1 = (ImageView) findViewById(R.id.imageSlot1);
            slot1.setImageResource(0);
            slot2 = (ImageView) findViewById(R.id.imageSlot2);
            slot2.setImageResource(0);
            slot3 = (ImageView) findViewById(R.id.imageSlot3);
            slot3.setImageResource(0);
            slot4 = (ImageView) findViewById(R.id.imageSlot4);
            slot4.setImageResource(0);
            slot5 = (ImageView) findViewById(R.id.imageSlot5);
            slot5.setImageResource(0);
            slot6 = (ImageView) findViewById(R.id.imageSlot6);
            slot6.setImageResource(0);
            slot7 = (ImageView) findViewById(R.id.imageSlot7);
            slot7.setImageResource(0);
            slot8 = (ImageView) findViewById(R.id.imageSlot8);
            slot8.setImageResource(0);
            slot9 = (ImageView) findViewById(R.id.imageSlot9);
            slot9.setImageResource(0);
        }
        public void winner()
        {
            player1.clear();
            player2.clear();
        }
    }

    public void showImage (View view)
    {
        imageViewClicked = view.getId();
        turn();
    }

    public int play()
    {
        if(imageViewClicked == R.id.imageSlot1)
        {
            return 1;
        }
        else if (imageViewClicked == R.id.imageSlot2)
        {
            return 2;
        }
        else if (imageViewClicked == R.id.imageSlot3)
        {
            return 3;
        }
        else if (imageViewClicked == R.id.imageSlot4)
        {
            return 4;
        }
        else if (imageViewClicked == R.id.imageSlot5)
        {
            return 5;
        }
        else if (imageViewClicked == R.id.imageSlot6)
        {
            return 6;
        }
        else if (imageViewClicked == R.id.imageSlot7)
        {
            return 7;
        }
        else if (imageViewClicked == R.id.imageSlot8)
        {
            return 8;
        }
        else
        {
            return 9;
        }
    }

    public void turn()
    {
        ImageView setImage = (ImageView)findViewById(imageViewClicked);
        if (turnToPlay == true)
        {
            player1.add(play());
            setImage.setImageResource(R.drawable.red);
            turnToPlay = false;
        }
        else
        {
            player2.add(play());
            setImage.setImageResource(R.drawable.yellow);
            turnToPlay = true;
        }
        if(win(player1) == true)
        {
            Toast.makeText(getApplicationContext(), "Player 1 Wins", Toast.LENGTH_SHORT).show();
            winner();
        }
        else if (win(player2) == true)
        {
            Toast.makeText(getApplicationContext(), "Player 2 Wins", Toast.LENGTH_SHORT).show();
            winner();
        }
    }

    public boolean win(List player)
    {

        if(player.contains(1) && player.contains(2) && player.contains(3))
        {
            return true;
        }
        else if (player.contains(4) && player.contains(5) && player.contains(6))
        {
            return true;
        }
        else if (player.contains(7) && player.contains(8) && player.contains(9))
        {
            return true;
        }
        else if (player.contains(1) && player.contains(4) && player.contains(7))
        {
            return true;
        }
        else if (player.contains(2) && player.contains(5) && player.contains(8))
        {
            return true;
        }
        else if (player.contains(3) && player.contains(6) && player.contains(9))
        {
            return true;
        }
        else if (player.contains(1) && player.contains(5) && player.contains(9))
        {
            return true;
        }
        else if (player.contains(3) && player.contains(5) && player.contains(7))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void winner()
    {
        Board newgame = new Board();
        newgame.resetBoard();
        newgame.winner();
    }
}
