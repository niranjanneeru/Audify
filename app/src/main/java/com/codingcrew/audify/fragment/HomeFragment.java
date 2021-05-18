package com.codingcrew.audify.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codingcrew.audify.R;
import com.codingcrew.audify.adapter.AudioRecyclerViewAdapter;
import com.codingcrew.audify.adapter.CategoryRecyclerViewAdapter;
import com.codingcrew.audify.model.Audio;
import com.codingcrew.audify.model.Category;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ArrayList<Audio> mAudios;
    ArrayList<Category> categories;
    AudioRecyclerViewAdapter audioRecyclerViewAdapter;
    CategoryRecyclerViewAdapter categoryRecyclerViewAdapter;
    RecyclerView audioRecyclerView, categoryRecyclerView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        audioRecyclerView = view.findViewById(R.id.list_music_recycler_view);
        categoryRecyclerView = view.findViewById(R.id.category_recycler_view);


        mAudios = new ArrayList<>();
        categories = new ArrayList<>();
        mAudios.add(new Audio(1, 2.00f, "Imagine", "https:google.com", "Bad Liar", "https:google.com", 10, 10));
        mAudios.add(new Audio(1, 2.00f, "Imagine", "https:google.com", "Bad Liar", "https:google.com", 10, 10));
        categories.add(new Category(1, "Melody", "Melody"));
        categories.add(new Category(1, "Melody", "Melody"));

        audioRecyclerViewAdapter = new AudioRecyclerViewAdapter(this.getContext());
        categoryRecyclerViewAdapter = new CategoryRecyclerViewAdapter(this.getContext());

        audioRecyclerViewAdapter.setAudios(mAudios);
        categoryRecyclerViewAdapter.setCategories(categories);

        audioRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));

        categoryRecyclerView.setAdapter(categoryRecyclerViewAdapter);
        audioRecyclerView.setAdapter(audioRecyclerViewAdapter);


        return view;
    }
}