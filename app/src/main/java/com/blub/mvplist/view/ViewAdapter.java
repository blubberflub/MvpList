package com.blub.mvplist.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blub.mvplist.R;
import com.blub.mvplist.model.AnimalDto;

import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.AnimalViewHolder> {
    AnimalTouchListener mListener;
    private List<AnimalDto> mAnimalList;

    ViewAdapter(List<AnimalDto> animalList, AnimalTouchListener listener) {
        mAnimalList = animalList;
        mListener = listener;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animals
                , parent
                , false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AnimalViewHolder animalViewHolder, final int position) {
        animalViewHolder.animalName.setText(mAnimalList.get(position).getName());
        animalViewHolder.animal.setOnClickListener(
                view -> mListener.onItemClicked(mAnimalList.get(position), view));

    }

    @Override
    public int getItemCount() {
        return mAnimalList.size();
    }

    static class AnimalViewHolder extends RecyclerView.ViewHolder {
        LinearLayout animal;
        TextView animalName;

        AnimalViewHolder(@NonNull View itemView) {
            super(itemView);

            animal = itemView.findViewById(R.id.animal);
            animalName = itemView.findViewById(R.id.animal_name);
        }
    }

    interface AnimalTouchListener {

        void onItemClicked(AnimalDto animal, View view);
    }
}
