package com.mobileapp.hw06;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mobileapp.hw06.databinding.FragmentGameBoardBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBoardFragment extends Fragment implements View.OnClickListener {
    private FragmentGameBoardBinding binding;
    private Button newGameButton;
    private List<List<Button>> gameBoard;
    private boolean[][] board = {{false, false, false}, {false, false, false}, {false, false, false}};
    private String color;
    private int numMoves;
//NavDirections action = GameBoardFragmentDirections.actionGameBoardFragmentToColorSetting(color);
//                Navigation.findNavController(view).navigate(action);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGameBoardBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        numMoves = 0;
        binding.numMovesTextView.setText(String.valueOf(numMoves));

        try {
            String message = GameBoardFragmentArgs.fromBundle(requireArguments()).getColor();
            color = new StringBuilder(message).toString();
        } catch (Exception e)
        {
            color = "Purple";
        }

        newGameButton = binding.newGameButton;
        setUpGameBoard();

        binding.newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_gameBoardFragment_to_colorSetting);
            }
        });

        return view;
    }

    @Override
    public void onClick(View v)
    {
        String btnId = getResources().getResourceEntryName(v.getId());
        int btnIdLength = btnId.length();
        int row = btnId.charAt(btnIdLength - 2) - 48;
        int col = btnId.charAt(btnIdLength - 1) - 48;
        numMoves++;

        board[row][col] = !(board[row][col]);
        // top
        if(row - 1 >= 0)
        {
            board[row-1][col] = !(board[row-1][col]);
        }
        // left
        if(col - 1 >= 0)
        {
            board[row][col-1] = !(board[row][col-1]);
        }
        // right
        if(col + 1 < gameBoard.get(0).size())
        {
            board[row][col+1] = !(board[row][col+1]);
        }
        // bottom
        if(row + 1 < gameBoard.get(0).size())
        {
            board[row+1][col] = !(board[row+1][col]);
        }
        // diag down
        if(row - 1 >= 0 && col - 1 >= 0)
        {
            board[row-1][col-1] = !(board[row-1][col-1]);
        }
        // diag up
        if(row + 1 < gameBoard.get(0).size() && col + 1 < gameBoard.get(0).size())
        {
            board[row+1][col+1] = !(board[row+1][col+1]);
        }

        binding.numMovesTextView.setText(String.valueOf(numMoves));

        updateBoard();
        if(gameWon()) {

        }
    }

    private void setUpGameBoard() {
        List<Button> row0 = new ArrayList<Button>();
        List<Button> row1 = new ArrayList<Button>();
        List<Button> row2 = new ArrayList<Button>();
        gameBoard = new ArrayList<List<Button>>();

        row0.add(binding.light00);
        row0.add(binding.light01);
        row0.add(binding.light02);
        row1.add(binding.light10);
        row1.add(binding.light11);
        row1.add(binding.light12);
        row2.add(binding.light20);
        row2.add(binding.light21);
        row2.add(binding.light22);
        gameBoard.add(row0);
        gameBoard.add(row1);
        gameBoard.add(row2);

        for(Integer i = 0; i < gameBoard.size(); i++) {
            for(Integer j = 0; j < gameBoard.get(i).size(); j++) {
                Button b = gameBoard.get(i).get(j);
                b.setOnClickListener(this);
            }
        }
        Random random = new Random();
        int numToTurnOn = random.nextInt(7) + 1;
        for(int i = 0; i < numToTurnOn; i++)
        {
            int btnNum = random.nextInt(8);
            int row = btnNum / 3;
            int col = btnNum % 3;
            board[row][col] = true;
        }
        updateBoard();
    }

    private boolean gameWon() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == true) {
                    return false;
                }
            }
        }
        return true;
    }

    private void updateBoard() {
        for(int i = 0; i < gameBoard.size(); i++) {
            for(int j = 0; j < gameBoard.get(i).size(); j++) {
                if(board[i][j] == false) {
                    gameBoard.get(i).get(j).setBackgroundColor(Color.DKGRAY);
                }
                else {
                    gameBoard.get(i).get(j).setBackgroundColor(Color.parseColor(color));
                }
            }
        }
    }
}