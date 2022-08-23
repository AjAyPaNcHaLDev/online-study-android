package com.dde.online.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.dde.online.R;
import com.dde.online.adapter.AdapterListExpand;
import com.dde.online.data.DataGenerator;
import com.dde.online.model.Social;
import com.dde.online.widget.LineItemDecoration;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class Curriculum extends Fragment {
    private View parent_view;
//    ListExpand CLASS IS USE HERE...
    private RecyclerView recyclerView;
    private AdapterListExpand mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_curriculum, container, false);
        initComponent(view);
        return view;
    }


    private void initComponent(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new LineItemDecoration(getContext(), LinearLayout.VERTICAL));
        recyclerView.setHasFixedSize(true);

        List<Social> items = DataGenerator.getSocialData(getContext());

        //set data and list adapter
        mAdapter = new AdapterListExpand(getContext(), items);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
//        mAdapter.setOnItemClickListener(new AdapterListExpand.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, Social obj, int position) {
//                Snackbar.make(parent_view, "Item " + obj.name + " clicked", Snackbar.LENGTH_SHORT).show();
//            }
//        });

    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_search_setting, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
//            finish();
        } else {
            Toast.makeText(getContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}