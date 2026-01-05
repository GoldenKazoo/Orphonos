package com.goldenkazoo.orphonos;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.goldenkazoo.orphonos.adapters.CategoryAdapter;
import com.goldenkazoo.orphonos.models.Category;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Category> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerCategories);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        categories = new ArrayList<>();
        categories.add(new Category("Salutations"));
        categories.add(new Category("Quotidien"));
        categories.add(new Category("Remerciements"));
        categories.add(new Category("Urgence"));
        categories.add(new Category("Questions"));

        CategoryAdapter adapter = new CategoryAdapter(categories, this);
        recyclerView.setAdapter(adapter);
    }
}
