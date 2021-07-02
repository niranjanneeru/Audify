package com.codingcrew.audify.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingcrew.audify.R;
import com.codingcrew.audify.components.ListSection;
import com.codingcrew.audify.model.Audio;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.widget.ListRecyclerConfiguration;
import com.facebook.litho.sections.widget.RecyclerCollectionComponent;
import com.facebook.litho.sections.widget.RecyclerConfiguration;
import com.facebook.yoga.YogaEdge;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SongsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SongsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SongsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SongsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SongsFragment newInstance(String param1, String param2) {
        SongsFragment fragment = new SongsFragment();
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

        ArrayList<Audio> mAudios;
        mAudios = new ArrayList<>();
        mAudios.add(new Audio(1, 2.00f, "Imagine", "https:google.com", "Bad Liar", "https:google.com", 10, 10));
        mAudios.add(new Audio(1, 2.00f, "Imagine", "https:google.com", "Bad Liar", "https:google.com", 10, 10));
        mAudios.add(new Audio(1, 2.00f, "Imagine", "https:google.com", "Bad Liar", "https:google.com", 10, 10));
        mAudios.add(new Audio(1, 2.00f, "Imagine", "https:google.com", "Bad Liar", "https:google.com", 10, 10));
        mAudios.add(new Audio(1, 2.00f, "Imagine", "https:google.com", "Bad Liar", "https:google.com", 10, 10));
        mAudios.add(new Audio(1, 2.00f, "Imagine", "https:google.com", "Bad Liar", "https:google.com", 10, 10));
        mAudios.add(new Audio(1, 2.00f, "Imagine", "https:google.com", "Bad Liar", "https:google.com", 10, 10));
        mAudios.add(new Audio(1, 2.00f, "Imagine", "https:google.com", "Bad Liar", "https:google.com", 10, 10));
        mAudios.add(new Audio(1, 2.00f, "Imagine", "https:google.com", "Bad Liar", "https:google.com", 10, 10));
        mAudios.add(new Audio(1, 2.00f, "Imagine", "https:google.com", "Bad Liar", "https:google.com", 10, 10));
        mAudios.add(new Audio(1, 2.00f, "Imagine", "https:google.com", "Bad Liar", "https:google.com", 10, 10));
        mAudios.add(new Audio(1, 2.00f, "Imagine", "https:google.com", "Bad Liar", "https:google.com", 10, 10));
        mAudios.add(new Audio(1, 2.00f, "Imagine", "https:google.com", "Bad Liar", "https:google.com", 10, 10));
        mAudios.add(new Audio(1, 2.00f, "Imagine", "https:google.com", "Bad Liar", "https:google.com", 10, 10));

        final ComponentContext c = new ComponentContext(getContext());
        final RecyclerConfiguration
                recyclerConfiguration =
                new ListRecyclerConfiguration(
                        LinearLayoutManager.HORIZONTAL, false /* reverse layout */);

        final Component component = RecyclerCollectionComponent.create(c)
                .disablePTR(true)
                .canMeasureRecycler(true)
                .recyclerConfiguration(new ListRecyclerConfiguration(LinearLayoutManager.VERTICAL, false))
                .section(ListSection.create(new SectionContext(c))
                        .audio(mAudios)
                        .build())
                .build();

        return LithoView.create(c, component);
    }
}