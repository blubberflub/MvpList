package com.blub.mvplist.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.blub.mvplist.AnimalContract;
import com.blub.mvplist.AnimalPresenter;
import com.blub.mvplist.R;
import com.blub.mvplist.di.components.DaggerMainActivityComponent;
import com.blub.mvplist.di.modules.MainActivityModule;
import com.blub.mvplist.model.AnimalDto;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AnimalContract.View {

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private List<AnimalDto> animalList;
    private ViewAdapter adapter;

    @Inject
    AnimalPresenter animalPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        animalList = new ArrayList<>();

        adapter = new ViewAdapter(animalList, (animal, view) -> {
            Toast.makeText(this, animal.getSound(), Toast.LENGTH_SHORT).show();
        });

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        DaggerMainActivityComponent
                .builder()
                .mainActivityModule(new MainActivityModule(this))
                .build()
                .inject(this);

        animalPresenter.openedAnimalList();
    }

    @Override
    public void showAnimalList(List<AnimalDto> animalList) {
        progressBar.setVisibility(View.GONE);
        this.animalList.addAll(animalList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String message) {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
