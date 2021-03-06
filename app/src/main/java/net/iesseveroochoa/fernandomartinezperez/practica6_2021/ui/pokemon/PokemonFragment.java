package net.iesseveroochoa.fernandomartinezperez.practica6_2021.ui.pokemon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.*;

import net.iesseveroochoa.fernandomartinezperez.practica6_2021.R;

public class PokemonFragment extends Fragment {

    private PokemonViewModel pokemonViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        pokemonViewModel =
                new ViewModelProvider(this).get(PokemonViewModel.class);
        View root = inflater.inflate(R.layout.fragment_pokemon, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        pokemonViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}