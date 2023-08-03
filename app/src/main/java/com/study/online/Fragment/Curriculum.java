package com.study.online.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.study.online.R;
import com.study.online.adapter.AdapterListExpand;
import com.study.online.data.DataGenerator;
import com.study.online.model.Social;
import com.study.online.widget.LineItemDecoration;

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