package com.mobileapp.hw06;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mobileapp.hw06.databinding.FragmentGameBoardBinding;

import java.util.ArrayList;
import java.util.List;

public class GameBoardFragment extends Fragment implements View.OnClickListener {
    private FragmentGameBoardBinding binding;
    private Button newGameButton;
    private List<List<Button>> gameBoard;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGameBoardBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        newGameButton = binding.newGameButton;
        setUpGameBoard();

        return view;
    }

    @Override
    public void onClick(View v)
    {
        String btnId = getResources().getResourceEntryName(v.getId());
        int btnIdLength = btnId.length();
        int row = btnId.charAt(btnIdLength - 2) - 48;
        int col = btnId.charAt(btnIdLength - 1) - 48;
        
    }

    private void setUpGameBoard()
    {
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

        for(List<Button> row : gameBoard) {
            for(Button b : row) {
                b.setOnClickListener(this);
            }
        }

    }
}