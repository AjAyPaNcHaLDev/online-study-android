package com.study.online.Fragment;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;
import com.study.online.CourseDetails;
import com.study.online.adapter.AdapterSnapGeneric;
import com.study.online.data.DataGenerator;
import com.study.online.helper.StartSnapHelper;
import com.study.online.model.Image;
import com.study.online.R;
import com.study.online.utils.Tools;

import com.study.online.MyPermission;
import java.util.ArrayList;
import java.util.List;


public class Home extends Fragment {
    private View parent_view;
    private ViewPager viewPager;
    private LinearLayout layout_dots;
    private AdapterImageSlider adapterImageSlider;
    private  AdapterSnapGeneric adapterSnapGeneric;
    private  AdapterSnapGeneric adapterSnapGeneric2;
    private Runnable runnable = null;
    private Handler handler = new Handler();
    private static int[] array_image_place = {
            R.drawable.dde_exams_nda_maths_course,
            R.drawable.shaurya_cds_crash_course,
            R.drawable.nda_course
    };

    Button watch_now;
    private static  String _id[]={"1","2","3"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_home, container, false);


        initComponent(view);
        initComponent2(view);
new MyPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE);
new MyPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE);

        LinearLayout openExplore=view.findViewById(R.id.openExplore);
        openExplore.setOnClickListener(views->{
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containerFrameLayout,new Explore()).commit();//    this is the home fragment by default

        });
        LinearLayout openExplore2=view.findViewById(R.id.openExplore2);
        openExplore2.setOnClickListener(views->{
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containerFrameLayout,new Explore()).commit();//    this is the home fragment by default

        });
 LinearLayout openExplore3=view.findViewById(R.id.openExplore3);
        openExplore3.setOnClickListener(views->{
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containerFrameLayout,new Explore()).commit();//    this is the home fragment by default

        });



        return view;
    }
//
    private void initComponent2(View view) {
  final ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progress);
        progressBar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_IN);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        RecyclerView recyclerViewRated = view.findViewById(R.id.recyclerViewRated);
        recyclerViewRated.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        // generate data
        List<Image> items = DataGenerator.getImageDate(getContext()).subList(0, 5);
        final List<Image> items2 = DataGenerator.getImageDate(getContext()).subList(0, 5);
//
//        recyclerView.setAdapter(new AdapterSnapGeneric(getContext(), items, R.layout.item_snap_full));
        adapterSnapGeneric=new AdapterSnapGeneric(getContext(),items,R.layout.item_snap_full);

        adapterSnapGeneric.setOnItemClickListener(new AdapterSnapGeneric.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Image obj, int position) {
                startActivity(new Intent(getActivity(), CourseDetails.class));

            }
        });
recyclerView.setAdapter(adapterSnapGeneric);
        progressBar.setMax(items.size());
        progressBar.setProgress(1);
        StartSnapHelper startSnapHelper = new StartSnapHelper();
        startSnapHelper.attachToRecyclerView(recyclerView);
        startSnapHelper.setSnapPositionListener(new StartSnapHelper.SnapPositionListener() {
            @Override
            public void position(View view, int position) {
                progressBar.setProgress(position + 1);
            }
        });

         adapterSnapGeneric2 = new AdapterSnapGeneric(getContext(), items2, R.layout.item_snap_full);

        adapterSnapGeneric2.setOnItemClickListener(new AdapterSnapGeneric.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Image obj, int position) {
                startActivity(new Intent(getActivity(), CourseDetails.class));

            }
        });

        recyclerViewRated.setAdapter(adapterSnapGeneric2);
        recyclerViewRated.setOnFlingListener(null);

    }
String array_title_place[]={
            "Mission NDA Mathematics Course",
        "Mission NDA Complete Course",
        "Shaurya 60 Days CDS Crash Course"
};

    String array_given_price[]={"₹ 3999","₹ 4999","₹ 5000"};
    String array_highest_price[]={"₹ 5999","₹ 7999","₹ 9000"};

    private void initComponent(View view) {
        layout_dots = (LinearLayout) view.findViewById(R.id.layout_dots);

        viewPager = (ViewPager) view.findViewById(R.id.pager);
        adapterImageSlider = new AdapterImageSlider(getActivity(), new ArrayList<Image>());

        final List<Image> items = new ArrayList<>();
        for (int i = 0; i < array_image_place.length; i++) {
            Image obj = new Image();
            obj.image = array_image_place[i];
            obj.id=_id[i];
            obj.imageDrw = getResources().getDrawable(obj.image);
            obj.title = array_title_place[i];
//            obj.brief = array_brief_place[i];
            obj.given_price = array_given_price[i];
            obj.highest_price = array_highest_price[i];
            items.add(obj);
        }
        adapterImageSlider.setItems(items);
        adapterImageSlider.setOnItemClickListener(new AdapterImageSlider.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Image obj) {

                startActivity(new Intent(getActivity(), CourseDetails.class));
            }
        });
        viewPager.setAdapter(adapterImageSlider);

        // displaying selected image first
        viewPager.setCurrentItem(0);
        addBottomDots(layout_dots, adapterImageSlider.getCount(), 0);
        ((TextView) view.findViewById(R.id.title)).setText(items.get(0).title);
        ((TextView) view.findViewById(R.id.given_price)).setText(items.get(0).given_price);
        ((TextView) view.findViewById(R.id.highest_price)).setText(items.get(0).highest_price);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int pos, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int pos) {

                ((TextView) view.findViewById(R.id.title)).setText(items.get(pos).title);
                ((TextView) view.findViewById(R.id.given_price)).setText(items.get(pos).given_price);
                ((TextView) view.findViewById(R.id.highest_price)).setText(items.get(pos).highest_price);
                addBottomDots(layout_dots, adapterImageSlider.getCount(), pos);

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }

        });


        startAutoSlider(adapterImageSlider.getCount());
    }

    private void addBottomDots(LinearLayout layout_dots, int size, int current) {
        ImageView[] dots = new ImageView[size];

        layout_dots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(getActivity());
            int width_height = 15;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(width_height, width_height));
            params.setMargins(10, 0, 10, 0);
            dots[i].setLayoutParams(params);
            dots[i].setImageResource(R.drawable.shape_circle_outline);
            dots[i].setColorFilter(ContextCompat.getColor(getActivity(), R.color.grey_40), PorterDuff.Mode.SRC_ATOP);
            layout_dots.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[current].setImageResource(R.drawable.shape_circle);
            dots[current].setColorFilter(ContextCompat.getColor(getActivity(), R.color.grey_40), PorterDuff.Mode.SRC_ATOP);
        }
    }

    private void startAutoSlider(final int count) {
        runnable = new Runnable() {
            @Override
            public void run() {
                int pos = viewPager.getCurrentItem();
                pos = pos + 1;
                if (pos >= count) pos = 0;
                viewPager.setCurrentItem(pos);
                handler.postDelayed(runnable, 3000);
            }
        };
        handler.postDelayed(runnable, 3000);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            getActivity().finish();
        } else {
            Toast.makeText(getActivity(), item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void Player(View view) {

        startActivity(new Intent(getContext(), CourseDetails.class));
    }


    private static class AdapterImageSlider extends PagerAdapter {

        private Activity act;
        private List<Image> items;

        private AdapterImageSlider.OnItemClickListener onItemClickListener;

        private interface OnItemClickListener {
            void onItemClick(View view, Image obj);
        }

        public void setOnItemClickListener(AdapterImageSlider.OnItemClickListener onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
        }

        // constructor
        private AdapterImageSlider(Activity activity, List<Image> items) {
            this.act = activity;
            this.items = items;
        }

        @Override
        public int getCount() {
            return this.items.size();
        }

        public Image getItem(int pos) {
            return items.get(pos);
        }

        public void setItems(List<Image> items) {
            this.items = items;
            notifyDataSetChanged();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((RelativeLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            final Image o = items.get(position);
            LayoutInflater inflater = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = inflater.inflate(R.layout.item_slider_image, container, false);

            ImageView image = (ImageView) v.findViewById(R.id.image);
            MaterialRippleLayout lyt_parent = (MaterialRippleLayout) v.findViewById(R.id.lyt_parent);
            Tools.displayImageOriginal(act, image, o.image);
            lyt_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(v, o);
                    }
                }
            });



            ((ViewPager) container).addView(v);

            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((RelativeLayout) object);

        }

    }

    @Override
    public void onDestroy() {
        if (runnable != null) handler.removeCallbacks(runnable);
        super.onDestroy();
    }
}